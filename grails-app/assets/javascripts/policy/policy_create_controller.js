//= require product/product.js

var PolicyCreateController = (function(){

  var settings = {
    insuranceSelector:'select[name=insurance]'
  };

  var producListSuccess = function(data){

  };
  
  var failure = function(data){
    console.log("Error " + data);
  }

  var updateProducts = function(){
    Product.list({url:'/products',data:{id:$(this).val()}}).then(producListSuccess,failure);
  };

  var bindEvents = function(){
    $(settings.insuranceSelector).on("change",updateProducts);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyCreateController.start();
});
