<div id="top-bar" class="container">
	<div class="row">
		<div class="span4">
			<form method="POST" class="search_form">
				<input type="text" class="input-block-level search-query"
					Placeholder="eg. T-sirt">
			</form>
		</div>
		<div class="span8">
			<div class="account pull-right">
				<ul class="user-menu">
					<li><a href="#">My Account</a></li>
					<li><a href="cart.html">Your Cart</a></li>
					<li><a href="checkout.html">Checkout</a></li>
					<c:if test="${isLogedin != null}">
						<li> <a href="#" id="logoutBtn">Logout</a></li>
						<form:form method="POST" action="/logout" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form:form>
					</c:if>
					<c:if test="${isLogedin == null}">
						<li><a href="auth">Login</a></li>
					</c:if>					
				</ul>
			</div>
		</div>
	</div>
</div>