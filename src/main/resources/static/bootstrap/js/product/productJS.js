$( document ).ready(function() {
	$('#addToCartBtn').click( function () {
		let num = $('#addToCart').val();
		let id = $('#productId').val();
		$.ajax({
		     type: "GET",
		     url: "/product/addToCart",
		     data: { quantity: num, productId: id } // parameters
		}) 
			.done(function( msg ) {
				alert( "Data Saved: " + msg );
			});
	});
	
});