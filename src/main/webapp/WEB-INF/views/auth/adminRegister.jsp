<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<%@ include file = "../common/commonAdminHead.jsp" %>
</head>
    <body>		
	    <div class="card o-hidden border-0 shadow-lg my-5">
	      <div class="card-body p-0">
	        <!-- Nested Row within Card Body -->
	        <div class="row">
	          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
	          <div class="col-lg-7">
	            <div class="p-5">
	              <div class="text-center">
	                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
	              </div>
	              <form:form method="POST" modelAttribute="accountForm" action="/adminRegistration" class="user">
	              	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                <div class="form-group row">
		                 <spring:bind path="name">
			                  <div class="col-sm-6 mb-3 mb-sm-0">
			                  	<form:input type="text" path="name" placeholder="Username" autofocus="true" class="form-control form-control-user" required="required"></form:input>
			                  	<form:errors path="name"></form:errors>
			                  </div>
		                  </spring:bind>
		                </div>
		                <div class="form-group row">
		                	<spring:bind path="registPassword">
			                  <div class="col-sm-6 mb-3 mb-sm-0">
			                    <form:input type="password" path="registPassword" placeholder="Password"  class="form-control form-control-user" required="required"></form:input>
								<form:errors path="registPassword"></form:errors>
			                  </div>
		                  	</spring:bind>
		                </div>
		                <div class="form-group row">
		                	<div class="col-sm-6">
		                    	<form:input type="password" path="repeatRegistPassword" class="form-control form-control-user" placeholder="Repeat Password" required="required"></form:input>
		                    	<form:errors path="registPassword"></form:errors>
		                  	</div>
		                </div>
		                <div class="form-group row">
		                	<div class="col-sm-8 form-check">
		                  		<form:checkbox class="form-check-input" path="isAdmin" value="true" id="isAdminCheckBox"/>
		                  		<label class="form-check-label" for="isAdminCheckBox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Is Admin </label>
		                  	</div>
		                </div>
		                <input class="btn btn-inverse large" type="submit" value="Create account">
	              </form:form>
	              <hr>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
    </body>
</html>