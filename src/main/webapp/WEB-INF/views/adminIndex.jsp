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
				<table id="table_id" class="display">
					<thead>
						<tr>
							<th>DAY</th>
							<th>COST / DAY</th>
							<th>POWER CONSUMTION / DAY</th>
							<th>TIME IN USE / DAY</th>
							<th>STATUS</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
	        <!-- /.container-fluid -->
	
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