<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file = "common/commonAdminHead.jsp" %>
</head>
   <body>		
	<!-- Page Wrapper -->
	  <div id="wrapper">
		<!-- Sidebar -->
		<%@ include file = "common/sidebar.jsp" %>
	    <!-- End of Sidebar -->
	
	    <!-- Content Wrapper -->
	    <div id="content-wrapper" class="d-flex flex-column">
	
	      <!-- Main Content -->
	      <div id="content">
		  <!-- Topbar -->
	       <%@ include file = "common/topbar.jsp" %>
		  <!-- End of Topbar -->
	        <!-- Begin Page Content -->
	        <div class="container-fluid">
					<body>
						<form action="/action_page.php" class="was-validated">
							<div class="form-group">
								<label for="uname"><spring:message code="product.code"
										text="default" /></label> <input type="text" class="form-control"
									id="uname" placeholder="Enter username" name="uname" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd"><spring:message code="product.name"
										text="default" /></label> <input type="password" class="form-control"
									id="pwd" placeholder="Enter password" name="pswd" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd"><spring:message code="product.price"
										text="default" /></label> <input type="password" class="form-control"
									id="pwd" placeholder="Enter password" name="pswd" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd"><spring:message
										code="product.description" text="default" /></label> <input
									type="password" class="form-control" id="pwd"
									placeholder="Enter password" name="pswd" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd"><spring:message code="product.sizeList"
										text="default" /></label>
								<table id="table_id" class="table table-striped table-bordered"
									style="width: 100%">
									<thead>
										<tr>
											<th><spring:message code="product.sizeList.size"
													text="default" /></th>
											<th><spring:message code="product.sizeList.quantity"
													text="default" /></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
							<button type="submit" class="btn btn-primary">
								<spring:message code="common.save" text="default" />
							</button>
						</form>
					</body>
				</div>
	      <!-- End of Main Content -->
	
	      <!-- Footer -->
	      <footer class="sticky-footer bg-white">
	        <div class="container my-auto">
	          <div class="copyright text-center my-auto">
	            <span>Copyright &copy; Your Website 2019</span>
	          </div>
	        </div>
	      </footer>
	      <!-- End of Footer -->
	
	    </div>
	    <!-- End of Content Wrapper -->
	
	  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
   <%@ include file = "common/logoutModal.jsp" %>
  <!-- End of Logout Modal-->
  <%@ include file = "common/adminHead.jsp" %>
   </body>
</html>