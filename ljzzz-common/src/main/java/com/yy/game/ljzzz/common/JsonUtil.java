package com.yy.game.ljzzz.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.type.JavaType;

public class JsonUtil {
	private static ObjectMapper mapper = new ObjectMapper(); // can reuse, share

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		
		try {
			String str = mapper.writeValueAsString(obj);
			return str;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T toObject(String content, Class<T> valueType) {
		if (null == content || "".equals(content)) {
			return null;
		}
		
		try {
			return mapper.readValue(content, valueType);
		} catch (Exception e) {
			/*
			 * 当返回的json字符串中的属性比Bean的多时
			 * 正常读取会报错
			 * 只能这样了
			 */
			Map<String, Object> result = toMapObject(content, HashMap.class, String.class, Object.class);
			return map2Object(result, valueType);
		}
	}
	
	public static <T> T map2Object(Map<String, Object> data, Class<T> valueType) {
		try {
			T object = valueType.newInstance();
			Field[] fields = valueType.getDeclaredFields();
			for(Field field : fields) {
				int modifier = field.getModifiers();
				if(Modifier.isFinal(modifier) || Modifier.isStatic(modifier)) {
					continue;
				}
				
				field.setAccessible(true);
				String fileName = field.getName();
				Object value = data.get(fileName);
				try {
					Class<?> type = field.getType();
					// 未考虑集合情况, type应该传元素类型
					Object value2 = JsonUtil.toObject(String.valueOf(value), type);
					field.set(object, value2);
				} catch(Exception ee) {
					field.set(object, value);
				}
			}
			return object;
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

	/**
	 * json转List
	 * 
	 * @param content
	 *            json数据
	 * @param valueType
	 *            泛型数据类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toListObject(String content, Class<T> valueType) {
		try {
			JavaType vType = SimpleType.construct(valueType);
			JavaType lType = CollectionType.construct(LinkedList.class, vType);
			return mapper.readValue(content, lType);
		} catch (Exception e) {
			// JSON中的数据属性与Bean不能一一对应时
			List<Map<String, Object>> maps = JsonUtil.toObject(content, List.class);
			List<T> result = new LinkedList<T>();
			for(Map<String, Object> map : maps) {
				T t = (T) map2Object(map, valueType);
				result.add(t);
			}
			
			return result;
		}
	}

	@SuppressWarnings("rawtypes")
	public static <K, V> Map<K, V> toMapObject(String content, Class<? extends Map> mapType,
			Class<K> keyType, Class<V> valueType) {
		try {
			JavaType kType = SimpleType.construct(keyType);
			JavaType vType = SimpleType.construct(valueType);
			JavaType mType = MapType.construct(mapType, kType, vType);
			return mapper.readValue(content, mType);
		} catch (Exception e) {
			throw new RuntimeException(content, e);
		}
	}

}
