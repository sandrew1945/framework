<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>角色管理</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="MobileOptimized" content="320">
</head>
<body onload="">
<!-- BEGIN PAGE HEADER-->
 <div class="row">
	<div class="col-md-12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title">
			<span class="icon-svg2 icon-pad"></span> 
			角色管理 - 新增
		</h3>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div> 
<!-- BEGIN PAGE CONTENT-->    
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN VALIDATION STATES-->
		<h3 class="form-section"></h3>
			<div class="portlet-body form">
				<!-- BEGIN FORM-->
				<form action="#" id="fm" class="form-horizontal form-horizontal" name="addUser" method="post" enctype="multipart/form-data">
					<div class="form-body">
						<div class="alert alert-danger display-hide" id="formErr">
							<button class="close" data-close="alert"></button>表单填写错误,请重新填写.
						</div>
						<div class="row">
							<div class="col-md-10">
								<div class="form-group">
									<label class="control-label col-md-3">角色代码<span class="required">*</span></label>
									<div class="col-md-9"><!-- id="pulsate-regular"添加脉动 -->
										<div class="input-group">                                       
											<input type="text" class="form-control" id="roleCode" name="roleCode" placeholder="请输入正确角色代码" maxlength="20"/>
											<span class="input-group-addon">
												<i class="fa fa-dedent"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">角色名称<span class="required">*</span></label>
									<div class="col-md-9">
										<div class="input-group">                                       
											<input type="text" class="form-control" id="roleName" name="roleName" placeholder="请输入正确角色名称" maxlength="20"/>
											<span class="input-group-addon">
												<i class="fa fa-dedent"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">角色类型<span class="required">*</span></label>
										<div class="col-md-9" id="roleTypeDiv">
										<script type="text/javascript">getSelect('roleType','roleType','2012','',true,'form-control','','roleTypeDiv');
										</script>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">状态<span class="required">*</span></label>
										<div class="col-md-9" id="statusDiv">
										<script type="text/javascript">getSelect('roleStatus','roleStatus','1001','',true,'form-control','','statusDiv');
										</script>
									</div>
								</div>
								<div class="form-group">
								<label class="control-label col-md-2"></label>
								<div class="col-md-10">
									<div class="input-icon right">                                       
										<button type="button" class="btn red btn-block " onclick="mySubmit()">
										<i class="fa fa-save"></i>&nbsp;&nbsp;保存
										</button>
									</div>
								</div>
							 	</div>
							 	<div class="form-group">
								<label class="control-label col-md-2"></label>
								<div class="col-md-10">
									<div class="input-icon right">                                       
										<!-- <a class="btn dark btn-block ajaxify" href="UserMain.action" id="btn_back" >返      回</a> -->
										<a class="btn blue btn-block ajaxify" href="rolemanager/rolemanagerPre" id="btn_back" >
											<i class="fa fa-reply "></i>&nbsp;&nbsp;返      回
										</a>
									</div>
								</div>
							 	</div>
							</div>
						</div>	
					</div>
				</form>
				<!-- END FORM-->
			</div>
		<!-- END VALIDATION STATES-->
	</div>
</div>
</body>
</html>
<script type="text/javascript">
var formOption = {
   		formId : "fm",
   		formRoles : {
			   			roleCode: {
			                required: true
			            },
			            roleName: {
			                required: true
			            },
			            roleType: {
			            	required: true
			            },
			            roleStatus: {
			                required: true
			            }
   					},
   		formMessages: { 
   						roleCode: {
			                required: "角色代码必须填写"
			            },
			            roleName: {
			                required: "角色名称必须填写"
			            },
			            roleType: {
			            	required: "请选择角色类型"
			            },
			            roleStatus: {
			            	required: "请选择状态"
			            }
   					},
   		formCallBack: {
   					url:  "rolemanager/createRole",	// 验证通过调用的后台连接
   					type: "POST",  
   					dataType: "json", 
   					success: function(ajaxResult)
   					{
   						// altConfirm(alt_param);							// 处理成功的回调
   						AjaxAnyWhere.handleResult(ajaxResult, handleSuccess);
   						
   					},
   					error: function(data)
   					{
   						bootbox.alert("添加角色失败");							// 处理失败的回调
   						return;
   					}
   		}
   		
   }
 
 // 处理成功回调方法
 var handleSuccess = function ()
 {
	Metronic.loadContentData("rolemanager/rolemanagerPre");
 }

	
jQuery(document).ready(function() {
	CommonFormVaildate.init(formOption);
});

function mySubmit(){
	 $("#fm").submit();
}
</script>
