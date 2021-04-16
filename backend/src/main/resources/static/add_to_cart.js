$(document).ready(function() {
	/*select button by id */
	$("submit").on("click", function(e) {
		addToCart();
	});
});

function addToCart() {
	/*read quantity */
	quantity = $("#quantity" + textbook_id).val();
	
	/*contract url to webservice */
	url = contextPath + "cart/add/" + textbook_id + "/" + quantity;
	
	/*call to server */
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