var PolicyPaymentMethodController = (function(){

  var settings = {
    paymentType:'#paymentType'
  };

  var start = function(){
    bindEvents();
  };

  var showBanksOrProviders = function(){

  };

  var bindEvents = function(){
    $(settings.paymentType).on("change",showBanksOrProviders);
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyPaymentMethodController.start();
});
