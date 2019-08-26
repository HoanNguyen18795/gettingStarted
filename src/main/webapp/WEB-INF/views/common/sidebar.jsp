<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

  <!-- Sidebar - Brand -->
  <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
    <div class="sidebar-brand-icon rotate-n-15">
      <i class="fas fa-laugh-wink"></i>
    </div>
    <div class="sidebar-brand-text mx-3">Happy Land Admin </div>
  </a>

  <!-- Divider -->
  <hr class="sidebar-divider my-0">

  <!-- Nav Item - Dashboard -->
  <li class="nav-item active">
    <a class="nav-link" href="index.html">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Dashboard</span></a>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider">

  <!-- Heading -->
  <div class="sidebar-heading">
    Device list
  </div>

  <!-- Nav Item - Create a new account for admon users only -->
  <security:authorize access="hasRole('ROLE_ADMIN')">
   <li class="nav-item">
     <a class="nav-link collapsed" href="/showAdminRegistration">
       <i class="fas fa-fw fa-cog"></i>
       <span>Create an account</span>
     </a>
   </li>
  </security:authorize>
  <!-- Nav Item - Utilities Collapse Menu -->
  <c:forEach items="${outdoorList}" var="outdoor">
    <li class="nav-item">
    	<c:if test="${not empty outdoor.indoorList}">
	    	<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#${outdoor.name}${outdoor.id}" aria-expanded="true" aria-controls="collapseUtilities">
		      		<i class="fas fa-fw fa-wrench"></i>
		      		<span>${outdoor.name}</span>
		    </a>
		</c:if>
		<c:if test="${empty outdoor.indoorList}">
	    	<a class="nav-link collapsed" href="#" aria-expanded="true" aria-controls="collapseUtilities">
		      		<i class="fas fa-fw fa-wrench"></i>
		      		<span>${outdoor.name}</span>
		    </a>
		</c:if>
	    <c:if test="${not empty outdoor.indoorList}">
    	<div id="${outdoor.name}${outdoor.id}" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
	      	<div class="bg-white py-2 collapse-inner rounded">
	      		<c:forEach items="${outdoor.indoorList}" var="indoor">
		        	<a class="collapse-item" href="#" onclick="showIndoorDetail(${indoor.id})">${indoor.name}</a>
<%-- 		        	<button class="collapse-item" onclick="showIndoorDetail(value)" value="${indoor.id}">${indoor.name}</button> --%>
<%-- 		        	<input type="hidden" value="${indoor.id}" id="${indoor.name}${indoor.id}"/> --%>
		        </c:forEach>
      		</div>
    	</div>
    	</c:if>
  	</li>
  </c:forEach>

  <!-- Divider -->
  <hr class="sidebar-divider d-none d-md-block">

  <!-- Sidebar Toggler (Sidebar) -->
  <div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
  </div>

</ul>