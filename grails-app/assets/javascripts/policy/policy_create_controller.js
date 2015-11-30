var PolicyCreateController = (function(){

  var settings = {
    insuranceSelector:'select[name=insurance]'
  };

  var updateProducts = function(){
    console.log("Updating products");
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
