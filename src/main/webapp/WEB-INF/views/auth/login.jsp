<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Happy Land - Login</title>
  <%@ include file = "../common/head.jsp" %>
</head>
    <body class="bg-gradient-primary">

	  <div class="container">
	
	    <!-- Outer Row -->
	    <div class="row justify-content-center">
	
	      <div class="col-xl-10 col-lg-12 col-md-9">
	
	        <div class="card o-hidden border-0 shadow-lg my-5">
	          <div class="card-body p-0">
	            <!-- Nested Row within Card Body -->
	            <div class="row">
	              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
	              <div class="col-lg-6">
	                <div class="p-5">
	                  <div class="text-center">
	                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
	                  </div>
	                  <form:form class="user" action="/authenticateUser" modelAttribute="accountLogin" method="POST">
                  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<c:if test="${param.error != null}">
							<i class="failed">Sorry! You entered invalid
								username/password.</i>
						</c:if>
						<fieldset>
							<div class="form-group">
								<spring:bind path="username">
								  <form:input type="text" path="username" class="form-control form-control-user" placeholder="Enter user name"></form:input>
								</spring:bind>
		                    </div>
		                    <div class="form-group">
			                    <spring:bind path="password">
			                    	<form:input type="password" path="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password"></form:input>
								</spring:bind>
		                      
		                    </div>
		                    <div class="form-group">
		                      <div class="custom-control custom-checkbox small">
		                        <input type="checkbox" class="custom-control-input" id="customCheck">
		                        <label class="custom-control-label" for="customCheck">Remember Me</label>
		                      </div>
		                    </div>
						</fieldset>
	                    
	                    <input tabindex="3" class="btn btn-inverse large" type="submit"
										value="Login">
	                    <hr>
	                  </form:form>
	                  <hr>
	                  <div class="text-center">
	                    <a class="small" href="forgot-password.html">Forgot Password?</a>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	
	      </div>
	
	    </div>
	
	  </div>
</body>
</html>