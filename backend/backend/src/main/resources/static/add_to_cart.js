$(document).ready(function() {
	$("buttonAdd2Cart").on("click", function(e) {
		addToCart();
	});
});

function addToCart() {
	quantity = $("#quantity" + textbook_id).val();
	
	url = contextPath + "cart/add/" + textbook_id + "/" + quantity;
	
	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(crsfHeaderName, crsfValue);
		}
	}).done(function(response) {
		$("#modalTitle").text("Shopping Cart");
		$("#modalBody").text(response);
		$("#modalBody").modal();
	}) .fail(function() {
		$("#modalTitle").text("Shopping Cart");
		$("#modalBody").text("Error while adding product to shopping cart.");
		$("#modalBody").modal();
	});
}