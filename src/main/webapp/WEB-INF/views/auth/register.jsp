<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<%@ include file = "../common/head.jsp" %>
</head>
    <body>		
		<%@ include file = "../common/header.jsp" %>
		<div id="wrapper" class="container">
			<%@ include file = "../common/navigator.jsp" %>		
			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
				<h4><span>Login or Regsiter</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
						<form:form action="/authenticateUser" modelAttribute="accountLogin"
							method="POST">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<c:if test="${param.error != null}">
								<i class="failed">Sorry! You entered invalid
									username/password.</i>
							</c:if>
							<fieldset>
								<div class="control-group">
									<label class="control-label">Username</label>
									<spring:bind path="username">
										<div class="controls">
											<form:input type="text" path="username"
												placeholder="Enter your username" autofocus="true"
												class="input-xlarge"></form:input>
										</div>
									</spring:bind>
								</div>
								<div class="control-group">
									<label class="control-label">Password</label>
									<spring:bind path="password">
										<div class="controls">
											<form:input type="password" path="password"
												placeholder="Enter your password" class="input-xlarge"></form:input>
										</div>
									</spring:bind>
								</div>
								<div class="control-group">
									<input tabindex="3" class="btn btn-inverse large" type="submit"
										value="Sign into your account">
									<hr>
									<p class="reset">
										Recover your <a tabindex="4" href="#"
											title="Recover your username or password">username or
											password</a>
									</p>
								</div>
							</fieldset>
						</form:form>
			</div>
					<div class="span7">					
						<h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
						<form:form method="POST" modelAttribute="accountForm" action="/registration" class="form-stacked">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<fieldset>
								<div class="control-group">
									<label class="control-label">Username</label>
									<spring:bind path="name">
										<div class="controls">
											<form:input type="text" path="name" placeholder="Username" autofocus="true"></form:input>
											<form:errors path="name"></form:errors>
										</div>									
									</spring:bind>
								</div>
								<div class="control-group">
									<label class="control-label">Email address:</label>
									<spring:bind path="registEmail">
										<div class="controls">
											<form:input type="text" path="registEmail" placeholder="Enter your email" class="input-large"/>
											<form:errors path="registEmail"></form:errors>
										</div>
									</spring:bind>
								</div>
								<div class="control-group">
									<label class="control-label">Password:</label>
									<spring:bind path="registPassword">
									<div class="controls">									      
          								<form:input type="password" path="registPassword" placeholder="Password"></form:input>
										<form:errors path="registPassword"></form:errors>
									</div>
									</spring:bind>
								</div>							                            
								<div class="control-group">
									<p>Now that we know who you are. I'm not a mistake! In a comic, you know how you can tell who the arch-villain's going to be?</p>
								</div>
								<hr>
								<div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Create your account"></div>
							</fieldset>
						</form:form>					
					</div>				
				</div>
			</section>			
			<%@ include file = "../common/footer.jsp" %>
		</div>
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
    </body>
</html>