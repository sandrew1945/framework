<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String isAuthenticate = (String)request.getAttribute("isAuthenticate");
	System.out.println("isAuthenticate ================ " + isAuthenticate);
	String noRole = (String)request.getAttribute("noRole");
	Subject subject = SecurityUtils.getSubject();
	if(null != subject && subject.isAuthenticated())
	{
		subject.logout();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>长春市科技企业数据库</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
	<c:import url="/common/jsp_head_lib.jsp"/>
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="<%=path %>/style/login.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL SCRIPTS -->
	<link rel="shortcut icon" href="<%=path %>/images/ico/favicon.ico"/>
	
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=path %>/js/login/demo.js" type="text/javascript"></script>
	<script src="<%=path %>/js/login/login.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	
	<script type="text/javascript">
		if (($("body").size()+1)>=2){
			window.top.location="${pageContext.request.contextPath}"; 
		}
		window.history.forward(1);
	</script>
</head>
<!-- BEGIN BODY -->
	<body class="login">
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		<div class="menu-toggler sidebar-toggler">
		</div>
		<!-- END SIDEBAR TOGGLER BUTTON -->
		<!-- BEGIN LOGO -->
		<div class="logo">
			<a href="index.html">
			<img src="<%=path %>/images/logo-big-white.png" style="height: 30px;" alt=""/>
			</a>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN LOGIN -->
		<div class="content">
			<!-- BEGIN LOGIN FORM -->
			<form class="login-form" id="fm" method="post" action="login">
				<div class="form-title">
					<span class="form-title">欢迎.</span>
					<span class="form-subtitle">请登录.</span>
				</div>
				<div class="alert alert-warning display-hide">
					<button class="close" data-close="alert"></button>
					<span> 请输入用户名及密码. </span>
				</div>
				<div class="alert alert-danger <%if(!"false".equals(isAuthenticate)) {%>display-hide<%} %>">
					<button class="close" data-close="alert"></button>
					<span>用户名或密码不正确,请重新输入</span>
				</div>
				<div class="alert alert-danger <%if(!"ture".equals(noRole)) {%>display-hide<%} %>">
					<button class="close" data-close="alert"></button>
					<span>没有系统权限,请使用其他用户重新登录</span>
				</div>
				<div class="form-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
					<label class="control-label visible-ie8 visible-ie9">账号</label>
					<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="账号" name="userCode"/>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary btn-block uppercase">登 &nbsp;&nbsp;&nbsp;&nbsp;录</button>
				</div>
				<!-- 删除 Remember me 和  forget-password
				<div class="form-actions">
					
					<div class="pull-left">
						<label class="rememberme check">
						<input type="checkbox" name="remember" value="1"/>Remember me </label>
					</div>
					
					<div class="pull-right forget-password-block">
						<a href="javascript:;" id="forget-password" class="forget-password">Forgot Password?</a>
					</div>
				</div>
				 -->
				<div class="create-account">
					<p>
						<a href="javascript:;" id="register-btn">注册新用户</a>
					</p>
				</div>
			</form>
			<!-- END LOGIN FORM -->
			<!-- BEGIN FORGOT PASSWORD FORM -->
			<form class="forget-form" action="index.html" method="post">
				<div class="form-title">
					<span class="form-title">Forget Password ?</span>
					<span class="form-subtitle">Enter your e-mail to reset it.</span>
				</div>
				<div class="form-group">
					<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email"/>
				</div>
				<div class="form-actions">
					<button type="button" id="back-btn" class="btn btn-default">Back</button>
					<button type="submit" class="btn btn-primary uppercase pull-right">Submit</button>
				</div>
			</form>
			<!-- END FORGOT PASSWORD FORM -->
			<!-- BEGIN REGISTRATION FORM -->
			<form class="register-form" action="index.html" method="post">
				<div class="form-title">
					<span class="form-title">注册</span>
				</div>
				<p class="hint">
					 请填写如下信息:
				</p>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">公司名称</label>
					<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="公司名称" id="companyName" name="companyName"/>
				</div>
				<div class="form-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
					<label class="control-label visible-ie8 visible-ie9">所属行政区</label>
					<div class="" id="regionDiv"><script type="text/javascript">getSelect('region','region','2006','',true,'form-control placeholder-no-fix','','regionDiv');</script></div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">注册用户名</label>
					<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="注册用户名" id="userCode" name="userCode"/>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password"/>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9">重复密码</label>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="重复密码" id="rpassword" name="rpassword"/>
				</div>
				<div class="form-group margin-top-20 margin-bottom-20">
					<label class="check">
					<input type="checkbox" name="tnc"/>
					<span class="loginblue-font">我已阅读并同意 </span>
					<a class="loginblue-link" data-target="#userServiceAgreement" data-toggle="modal">《用户服务协议》</a>
					</label>
					<div id="register_tnc_error">
					</div>
				</div>
				<div class="form-actions">
					<button type="button" id="register-back-btn" class="btn btn-default">返回</button>
					<button type="submit" id="register-submit-btn" class="btn btn-primary uppercase pull-right">注册</button>
				</div>
			</form>
			<!-- END REGISTRATION FORM -->
		</div>
		<div class="copyright">
			 Copyright&copy; ccst.gov.cn,All Rights Reserved&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;推荐浏览器：IE9及以上、Firefox、Chrome.
		</div>
		
	</body>
	
	
<!-- END BODY -->

	<div id="userServiceAgreement" class="modal container fade" tabindex="-1" data-replace="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			<h4 class="modal-title">用户服务协议</h4>
		</div>
		<div class="modal-body">
		<div class="scroller" style="height:500px" data-always-visible="1" data-rail-visible="1" data-rail-color="default" data-handle-color="blue">
			<p>欢迎您注册成为本网站的用户！请仔细阅读下面的协议，只有接受协议才能继续进行注册。一经注册，您需要遵守本协议或修改后的本协议的所有条款，本网站已经或将来可能发布的各类规则为本协议不可分割的一部分，与本协议具有同等法律效力。本网站有权根据业务需要酌情修订本协议，并以网站公示的方式进行公告，不再单独通知您。如果您不同意其中的任何条款或者任何修订，请您立刻停止使用服务。如您在协议修订后继续使用本网站的服务，则将视为您已接受经修订的协议条款，当您与本网站发生争议时，应以最新的服务协议为准。本网站有权利通过包括但不限于删除已发布信息，终止账户，屏蔽IP地址、关键字、联系方式，或法律诉讼等方式执行本用户协议。</p>
			<p>&nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1. 注册和登录 本网站所提供的服务（以下简称&ldquo;本服务&rdquo;）仅供能够根据相关法律订立具有法律约束力的合约的个人或公司使用。在您完成注册程序或以其他本网站允许的方式实际使用服务时，您应当是具备完全民事权利能力和与所从事的民事行为相适应的行为能力的自然人、法人或其他组织。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 企业或机构注册时，需要填写企业或机构全称、组织机构代码、注册地址等信息。注册用户必须保证注册信息真实有效，本网站没有义务对用户注册信息进行核实 由于注册信息错误导致的一切后果均由用户承担。如有合理理由怀疑您提供的信息错误、不实、过时或不完整的，本网站有权向您发出询问及/或要求改正的通知，</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 并有权直接做出删除相应资料的处理， 直至中止、终止对您提供部分或全部服务。本网站对此不承担任何责任，您将承担因此产生的任何直接或间接损失及不利后果。 本服务不会提供给被暂时或永久中止资格的本网站用户，并有权追究其使用本网站服务的一切法律责任。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 在注册过程中，您将选择用户注册名和密码。您须自行负责对您的用户注册名和密码保密，且须对您在用户注册名和密码下发生的所有活动承担责任。您同意：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （a）如发现任何人未经授权使用您的用户注册名或密码，或发生违反保密规定的任何其他情况，您会立即通知本网站，要求本网站暂停提供相关服务，但本网站就停止提供服务之前已经产生的后果不承担任何责任及费用；</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （b）确保您在每个上网时段结束时，以正确步骤离开网站。本网站不能也不会对因您未能遵守本款规定而发生的任何损失或损毁负责。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2. 本网站使用规范</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 在使用本网站服务过程中，您承诺遵守以下约定：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （a）在使用本服务过程中实施的所有行为均遵守国家法律、法规等规范性文件及本网站各项规则的规定和要求，不违背社会公共利益或公共道德，不损害他人的合法权益，不违反本协议及相关规则。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （b）对您发布或者上传于本网站的所有信息均享有完整的知识产权，或已经得到相关权利人的合法授权，并保证该信息不侵犯到任何第三人的合法权益。 不发布国家禁止销售的或限制销售的产品或服务信息（除非取得合法且足够的许可），不发布涉嫌侵犯他人知识产权或其它合法权益的产品或服务信息，不发布违背社会公共利益或公共道德或本网站认为不适合在本网站上销售的产品或服务信息，不发布其它涉嫌违法或违反本协议及各类规则的信息。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （c）在与其他用户进行业务对接或服务产品交易的过程中，遵守诚实信用原则，不采取不正当竞争行为，不扰乱对接或交易的正常秩序，不从事与对接或交易无关的行为。 不以虚构或歪曲事实的方式不当评价其他用户，不采取不正当方式制造或提高自身的信用度，不采取不正当方式制造或提高（降低）其他用户的信用度；</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （d）不使用任何装置、软件或例行程序干预或试图干预本网站的正常运作。您不得采取任何将导致不合理的庞大数据负载加诸本网站网络设备的行动。 您了解并同意：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （a）本网站有权对您是否违反上述承诺做出单方认定，并根据单方认定结果适用规则予以处理或终止向您提供服务，且无须征得您的同意或提前通知予您。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （b）经国家行政或司法机关的生效法律文书确认您存在违法或侵权行为，或者本网站根据自身的判断，认为您的行为涉嫌违反本协议和/或规则的条款或涉嫌违反法律法规的规定的，则本网站有权在网上公示您的该等涉嫌违法或违约行为及本网站已对您采取的措施。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （c）对于您在本网站发布的涉嫌违法或涉嫌侵犯他人合法权利或违反本协议和/或规则的信息，本网站有权不经通知您即予以删除，且按照协议的规定要求您承担法律责任。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （d）对于您在本网站上实施的行为，包括您未在本网站上实施但已经对本网站及其用户产生影响的行为，本网站有权单方认定您行为的性质及是否构成对本协议和/或规则的违反，并据此要求您承担法律责任。您应自行保存与您行为有关的全部证据，并应对无法提供充要证据而承担的不利后果。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （e）对于您的行为对任意第三方造成损害的，您均应当以自己的名义独立承担所有的法律责任，并应确保科服网免于因此产生损失或增加费用。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （f）如您涉嫌违反有关法律、法规、规章或者本协议及/或本网站规则之规定，使本网站遭受任何损失，或受到任何第三方的索赔，或受到任何行政管理部门的处罚，您应当赔偿本网站因此造成的损失及（或）发生的费用，包括合理的律师费用。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3. 隐私保护</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本网站向您保证不对外公开您的注册资料及您在使用本网站服务时存储在本网站的非公开内容，但下列情况除外：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （a）事先获得您的明确授权的；</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （b）根据有关的法律法规要求，我们必须提供的；</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （c）按照相关政府主管部门或司法部门的要求，我们必须提供的；</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （d）您先行违反本协议内容导致本网站或第三方或者社会公共利益受损或者受到威胁的，我们有权向相关当事人提供您的相关信息。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 您知悉并认可：本网站可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本网站同等的保护用户隐私的责任，则本网站有权将用户的注册资料等提供给该第三方。另外，在不透露单个用户隐私资料的前提下，本网站有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4. 免责条款</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 您了解：本网站上用户自行发布或由网络其他站点转载的信息，可能存在风险和瑕疵。 本网站仅作为您获取产品或服务信息、物色交易对象、就产品和/或服务的交易进行协商及开展交易的场所，但本网站无法控制交易所涉及的产品或服务的真实性、准确性、安全或合法性，以及交易或对接各方履行其在贸易协议中各项义务的能力。本网站没有义务对所有用户的信息数据、产品或服务信息、交易或对接行为以及相关的其它事项进行事先审查，也没有义务保证、监督用户提供的服务过程或服务质量。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 您应自行谨慎判断确定相关信息的真实性、合法性和有效性，并自行承担因此产生的责任与损失。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 不论在何种情况下，本网站均不对由于信息网络正常的设备维护，信息网络连接故障，电脑、通讯或其他系统的故障，电力故障，罢工，劳动争议，暴乱，起义，骚乱，生产力或生产资料不足，火灾，洪水，风暴，爆炸，战争，政府行为，司法行政机关的命令或第三方的不作为而造成的不能服务或延迟服务承担责任。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本网站对任何在本网站发布信息或使用信息所带来的风险不承担任何责任。访问和使用本网站的用户应自行判断相关信息的准确性、完整性和合法性，并同意自行承担访问和使用相关信息可能出现的全部风险。对您使用本网站或者与本网站相关的任何内容、服务或其它链接至本网站的站点、内容均不作直接、间接、法定、约定的保证。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 无论在任何原因下（包括但不限于疏忽原因），对您或任何人通过使用本网站上的信息或由本网站链接的信息，或其他与本网站链接的网站信息所导致的损失或损害（包括直接、间接、特别或后果性的损失或损害，例如收入或利润之损失，电脑系统之损坏或数据丢失等后果），责任均由使用者自行承担（包括但不限于疏忽责任）。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本用户服务协议的解释权归本网站所有。如果其中有任何条款与国家的有关法律相抵触，则以国家法律的明文规定为准。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 因本协议产生争议的，以本网站所在地法院为管辖法院。</p>
		</div>
		</div>
	</div>

</html>
<script type="text/javascript">
jQuery(document).ready(function() {     
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	Login.init();
	Demo.init();
	});
</script>