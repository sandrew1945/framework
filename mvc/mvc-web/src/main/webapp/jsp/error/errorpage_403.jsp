<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>系统管理平台</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
<link href="<%=path %>/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<%=path %>/assets/global/css/error.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<%=path %>/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/style/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<%=path %>/style/themes/grey.css" rel="stylesheet" type="text/css"/>
<link href="<%=path %>/style/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-500-full-page">
<div class="row">
	<div class="col-md-12 page-500">
		<div class=" number">
			 403
		</div>
		<div class=" details">
			<h3>Oops! You don't have permission to access.</h3>
			<p>
				<br/>
				<a href="logout">
					<i class="fa fa-sign-out"></i> Exit system, Use the other account access. </a><br/><br/>
			</p>
		</div>
	</div>
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="<%=path %>/assets/global/plugins/respond.min.js"></script>
<script src="<%=path %>/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="<%=path %>/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<%=path %>/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="<%=path %>/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="<%=path %>/js/metronic.js" type="text/javascript"></script>
<script src="<%=path %>/js/layout.js" type="text/javascript"></script>
<script src="<%=path %>/assets/admin/layout2/scripts/demo.js" type="text/javascript"></script>
<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core components
Layout.init(); // init current layout
Demo.init(); // init demo features
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>