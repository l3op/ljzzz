<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>定制活动模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<jsp:include page="include/head.jsp" >
  		<jsp:param name="select" value="template" /> 
  	</jsp:include>
    
    <br/>
    <div class="container theme-showcas">
    	<div class="jumbotron">
   	 		<c:choose>
   	 			<c:when test="${op == 'add'}">
   	 				<form class="form-horizontal" role="form" action="/manager/template/addTemplate">
					  	<div class="form-group">
				      		<label for="template_desc" class="col-sm-2 control-label">模板描述</label>
			      			<div class="col-sm-10">
			            		<input type="text" name="desc" class="form-control" id="template_desc" placeholder="模板描述">
			          		</div>
				      	</div>
			        	<div class="form-group">
			          		<label for="templatePrivilegs" class="col-sm-2 control-label">权限</label>
			          		<div class="col-sm-10">
			            		<input type="text" class="form-control" id="templatePrivilegs" placeholder="权限">
			          		</div>
			        	</div>
			        	
			        	<div class="form-group">
			          		<div class="col-sm-offset-2 col-sm-10">
			            		<button type="submit" class="btn btn-default">新增模板</button>
			          		</div>
			        	</div>
					</form>
 				</c:when>
   	 			
   	 			<c:otherwise>
   	 				<form class="form-horizontal" role="form" action="/manager/template/updateTemplate">
					  	<div class="form-group">
				      		<label for="template_desc" class="col-sm-2 control-label">模板描述</label>
			      			<div class="col-sm-10">
			            		<input type="text" name="desc" class="form-control" id="template_desc" placeholder="模板描述">
			          		</div>
				      	</div>
			        	<div class="form-group">
			          		<label for="templatePrivilegs" class="col-sm-2 control-label">权限</label>
			          		<div class="col-sm-10">
			            		<input type="text" class="form-control" id="templatePrivilegs" placeholder="权限">
			          		</div>
			        	</div>
			        	
			        	<div class="form-group">
			          		<div class="col-sm-offset-2 col-sm-10">
			            		<button type="submit" class="btn btn-default">更新模板</button>
			          		</div>
			        	</div>
					</form>
   	 			</c:otherwise>
   	 		</c:choose>
   	 		
   	 		<h2 id="tables-bordered">配置元信息</h2>
   	 		<table class="table table-striped table-hover">
 				<thead><tr><th>mid</th><th>key</th><th>类型</th><th>描述</th><th>默认值</th><th>操作</th></tr></thead>
    			<tbody>
    			<tr><td>1234</td><td>aaaaa</td><td>整型</td><td>XXXX</td><td>0</td><td><button data-toggle="modal" data-target="#updateTemplateMeta" class="btn btn-primary">修改</button></td></tr>
    			<tr><td>1235</td><td>aaaab</td><td>整型</td><td>XXXX</td><td>0</td><td><button data-toggle="modal" data-target="#updateTemplateMeta" class="btn btn-primary">修改</button></td></tr>
    			<c:forEach items="${metaList }" var="meta">
    				<tr><td>${meta.mid }</td><td>${meta.key }</td><td>${meta.type }</td><td>${meta.description }</td><td>${meta.defaultValue }</td><td><a href="#updateTemplateMeta">修改</a>&nbsp;<a href="/manager/template/delMeta?mid=${meta.mid }">删除</a></td></tr>
    			</c:forEach>
    			</tbody>
			</table>
   	 		<p><button data-toggle="modal" class="btn btn-primary" data-target="#addTemplateMeta">新增 &raquo;</button ></p>
   	 		</div>
   	 		
   	 		<div id="addTemplateMeta" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   	 			<div class="modal-dialog">
        			<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">×</button>
							<h4>添加模板元信息</h4>
						</div>
						<div class="modal-body">
							<form name="form" action="/manager/template/addMeta" method="post" class="form-horizontal">
								<p>
									<label class="col-sm-2 control-label">key名</label>
									<div class="controls">
										<input type="text" name="key" class="form-control" style="width:50%"/>
									</div>
								</p>
								<p>
									<label class="col-sm-2 control-label">类型</label>
									<div class="controls">
										<select name="type" class="form-control" style="width:30%">
											<option value="INT">整型</option>
											<option value="STRING">字符串</option>
											<option value="DATE">日期</option>
										</select>
									</div>
								</p>
								<p>
									<label class="col-sm-2 control-label">描述</label>
									<div class="controls">
										<input type="text" name="description" class="form-control" style="width:80%"/>
									</div>
								</p>
								<p>
								<label class="col-sm-2 control-label">默认值</label>
								<div class="controls">
									<input type="text" name="defaultValue" class="form-control" style="width:50%"/>
								</div>
								</p>
								<div class="form-actions">
									<button type="submit" class="btn btn-primary">添加</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<div id="updateTemplateMeta" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
        			<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">×</button>
							<h4>更新模板元信息</h4>
						</div>
						<div class="modal-body">
							<form name="form" action="/manager/template/updateMeta" method="post" class="form-horizontal">
								<p>
									<input type="hidden" name="mid" value="${meta.mid }" />
									<label class="col-sm-2 control-label">key名</label>
									<div class="controls">
										<input type="text" name="key" class="form-control" style="width:50%"/>
									</div>
								</p>
								<p>
									<label class="col-sm-2 control-label">类型</label>
									<div class="controls">
										<select name="type" class="form-control" style="width:30%">
											<option value="INT">整型</option>
											<option value="STRING">字符串</option>
											<option value="DATE">日期</option>
										</select>
									</div>
								</p>
								<p>
									<label class="col-sm-2 control-label">描述</label>
									<div class="controls">
										<input type="text" name="description" class="form-control" style="width:80%"/>
									</div>
								</p>
								<p>
									<label class="col-sm-2 control-label">默认值</label>
									<div class="controls">
										<input type="text" name="defaultValue" class="form-control" style="width:50%"/>
									</div>
								</p>
								<div class="form-actions">
									<button type="submit" class="btn btn-primary">更新</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>