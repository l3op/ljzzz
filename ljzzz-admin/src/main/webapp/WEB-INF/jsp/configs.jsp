<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>配置列表</title>
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
    
    <div class="container theme-showcas">
    	<div class="jumbotron">
	    <c:choose>
	    	<c:when test="${datatype == 'template'}">
	    		<div class="page-header">
        			<h2>活动配置模板</h2>
      			</div>
	    		
	    		<table class="table table-striped">
	    			<thead><tr><th>tid</th><th>描述</th><th>权限</th><th>操作</th></tr></thead>
	    			<tbody>
	    			<tr><td>1234</td><td>aaaaa</td><td>1,2,3</td><td><a href="#">修改</a></td></tr>
	    			<tr><td>1234</td><td>aaaaa</td><td>1,2,3</td><td><a href="#">修改</a></td></tr>
	    			<c:forEach items="${templates }" var="template">
	    				<tr><td>${template.tid }</td><td>${template.desc }</td><td>${template.privilegs }</td><td><a href="/manager/template/toTemplate?tid=${template.tid }">修改</a></td></tr>
	    			</c:forEach>
	    			</tbody>
	    		</table>
	    		
	    		<p><a href="/manager/template/toTemplate?tid=-1" class="btn btn-primary" role="button">新增 &raquo;</a></p>
	    	</c:when>
	    </c:choose>
	    </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>