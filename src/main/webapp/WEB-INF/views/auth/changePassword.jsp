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
	                <h1 class="h4 text-gray-900 mb-4">Change Password</h1>
	              </div>
	              <form:form method="POST" modelAttribute="accountForm" action="/doChangePassword" class="user">
	              	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                <div class="form-group row">
		                	<spring:bind path="oldPassword">
			                  <div class="col-sm-6 mb-3 mb-sm-0">
			                    <form:input type="password" path="oldPassword" placeholder="Old Password"  class="form-control form-control-user" required="required"></form:input>
								<form:errors class="text-danger" path="oldPassword"></form:errors>
			                  </div>
		                  	</spring:bind>
		                </div>
		                <div class="form-group row">
		               	 <spring:bind path="newPassword">
			                	<div class="col-sm-6">
			                    	<form:input type="password" path="newPassword" class="form-control form-control-user" placeholder="New Password" required="required"></form:input>
			                    	<form:errors class="text-danger" path="newPassword"></form:errors>
			                  	</div>
		                  	</spring:bind>
		                </div>
		                <div class="form-group row">
		               			 <spring:bind path="repeatNewPassword">
				                	<div class="col-sm-6">
				                    	<form:input type="password" path="repeatNewPassword" class="form-control form-control-user" placeholder="Repeat New Password" required="required"></form:input>
				                    	<form:errors class="text-danger" path="newPassword"></form:errors>
				                  	</div>
			                  	</spring:bind>
		                </div>
		                <div class="form-group row">
			                <div class="col-sm-3">
			                 	<input class="btn btn-primary" type="submit" value="Change password">
			                 </div>
			                 <div class="col-sm-1">
			                 	<a href="/" class="btn btn-default">Cancel</a>
			                 </div>
		                </div>
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