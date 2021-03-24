var MenuItems = document.getElementById("MenuItems");
            
MenuItems.style.maxHeight = "0px";

function menutoggle(){
    if(MenuItems.style.maxHeight == "0px"){
        MenuItems.style.maxHeight = "200px";
    }
    else{
        MenuItems.style.maxHeight = "0px";
    }
}

var removeCartItemButtons = document.getElementsByClassName("removeButton")
console.log(removeCartItemButtons)
for(var i = 0; i < removeCartItemButtons.length; i++){
    var button = removeCartItemButtons[i]
    button.addEventListener("click", function(event){
        var buttonClicked = event.target
        buttonClicked.parentElement.parentElement.parentElement.parentElement.remove()
        updateCartTotal()
    })
}

function updateCartTotal(){
    var cartInfoContainer = document.getElementsByClassName("cart")[0]
    var cartInfos = cartInfoContainer.getElementsByClassName("cartInfo")
    for(var i = 0; i < cartInfos.length; i++){
        var cartInfo = cartInfos[i]
        var priceElement = cartInfo.getElementsByClassName('price')[0]
        var quantityElement = cartInfo.getElementsByClassName('quantity')[0]
        console.log(priceElement, quantityElement)
    }
}