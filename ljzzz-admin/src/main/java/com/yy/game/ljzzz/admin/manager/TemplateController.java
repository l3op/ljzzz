package com.yy.game.ljzzz.admin.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.game.ljzzz.common.ActivityUtil;
import com.yy.game.ljzzz.dao.ActivityTemplateDao;
import com.yy.game.ljzzz.dao.TemplateMetaDao;
import com.yy.game.ljzzz.model.conf.ActivityTemplate;
import com.yy.game.ljzzz.model.conf.TemplateMeta;

/**
 * 订制活动
 */
@Controller
@RequestMapping("/manager/template")
public class TemplateController {
	
	private static final String TEMPLATE_PAGE = "template";
	private static final String TEMPLATE_LIST_PAGE = "configs";
	
	@Autowired
	private ActivityTemplateDao activityTemplateDao;
	@Autowired
	private TemplateMetaDao templateMetaDao;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/toManager")
	public String toManager(ModelMap model) {
		List<ActivityTemplate> templates = activityTemplateDao.list();
		model.put("templates", templates);
		model.put("datatype", "template");
		return TEMPLATE_LIST_PAGE;
	}
	
	@RequestMapping("/toTemplate")
	public String toTemplate(int tid, ModelMap model) {
		ActivityTemplate template = activityTemplateDao.get(tid);
		// TODO:增加角色列表供其选择
		model.put("privilegs", null);
		if(null == template) {
			// add
			model.put("op", "add");
		} else {
			// update
			model.put("op", "update");
			model.put("template", template);
			String[] metas = template.getMetas().split(",");
			List<TemplateMeta> metaList = new ArrayList<TemplateMeta>();
			for(String meta : metas) {
				if(StringUtils.isNotBlank(meta)) {
					continue;
				}
				
				metaList.add(templateMetaDao.get(Integer.valueOf(meta)));
			}
			model.put("metaList", metaList);
		}
		
		return TEMPLATE_PAGE;
	}
	
	@RequestMapping("/addTemplate")
	public String addTemplate(ActivityTemplate template, ModelMap model) {
		boolean add = activityTemplateDao.add(template);
		if(!add) {
			model.put("error", "新增模板信息失败");
			return TEMPLATE_PAGE;
		}
		
		return TEMPLATE_PAGE;
	}
	
	@RequestMapping("/updateTemplate")
	public String updateTemplate(ActivityTemplate template, ModelMap model) {
		boolean update = activityTemplateDao.update(template);
		if(!update) {
			model.put("error", "更新模板信息失败");
			return TEMPLATE_PAGE;
		}
		
		return TEMPLATE_PAGE;
	}
	
	/**
	 * 使用Ajax来提交 
	 * @param meta
	 * @param tid
	 * @param model
	 * @return
	 */
	@RequestMapping("/addMeta")
	public String addMeta(int tid, TemplateMeta meta, ModelMap model) {
		ActivityTemplate template = activityTemplateDao.get(tid);
		if(null == template) {
			model.put("error", "请先保存模板");
			return TEMPLATE_PAGE;
		}
		
		// 分配mid
		boolean addMeta = templateMetaDao.add(meta);
		if(addMeta) {
			model.put("error", "新增模板元信息失败");
			return TEMPLATE_PAGE;
		}
		
		String metas = template.getMetas();
		metas = metas + "," + meta.getMid();
		boolean update = activityTemplateDao.update(template);
		if(!update) {
			//
			model.put("error", "添加元信息失败");
		}
		return TEMPLATE_PAGE;
	}
	
	@RequestMapping("/updateMeta")
	public String updateMeta(TemplateMeta meta, ModelMap model) {
		if(meta.getMid() <= 0) {
			model.put("error", "我擦,还没保存就要更新,赶紧检查代码");
			return TEMPLATE_PAGE;
		}
		
		boolean update = templateMetaDao.update(meta);
		if(!update) {
			model.put("error", "更新模板元信息失败");
			return TEMPLATE_PAGE;
		}
		
		return TEMPLATE_PAGE;
	}
	
	@RequestMapping("/delMeta")
	public String delMeta(int tid, TemplateMeta meta, ModelMap model) {
		ActivityTemplate template = activityTemplateDao.get(tid);
		if(null == template) {
			model.put("error", "请先保存模板");
			return TEMPLATE_PAGE;
		}
		
		if(meta.getMid() <= 0) {
			model.put("error", "我擦,还没保存就要删除,赶紧检查代码");
			return TEMPLATE_PAGE;
		}
		
		boolean del = templateMetaDao.delete(meta.getMid(), "", null);
		if(!del) {
			model.put("error", "删除模板元信息失败");
			return TEMPLATE_PAGE;
		} 
		
		String metas = ActivityUtil.remove(template.getMetas(), meta.getMid()+"");
		template.setMetas(metas);
		boolean update = activityTemplateDao.update(template);
		if(!update) {
			model.put("error", "更新模板信息失败");
			return TEMPLATE_PAGE;
		}
		
		return TEMPLATE_PAGE;
	}
}
