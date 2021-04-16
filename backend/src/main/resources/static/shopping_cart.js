$(document).ready(function() {
	/*calculates number of items in shopping cart */
	updateTotal();
});

/*calculate total cost */
function updateTotal() {
	total = 0.0;
	
	$(".productSubtotal").each(function(index, element) {
		total = total + parseFloat(element.innerHTML);
	});
	
	$("#totalAmount").text(total);
}