//= require bank/bank_list_controller.js
//= require card/provider_list_controller.js
//= require third_party/jquery-validation/dist/jquery.validate.js

var PolicyPaymentMethodController = (function(){

  var settings = {
    paymentType:'#paymentType',
    paymentMethodForm:'form[name=paymentMethodForm]'
  };

  var paymentTypes = {
    cards:['DEBIT_CARD','CREDIT_CARD'],
    bankAccounts:['CHECK','REFERENCED_DEPOSIT']
  }

  var showBanksOrProviders = function(){
    if(paymentTypes.cards.indexOf($(this).val()) >= 0)
      ProviderListController.start();
    else if(paymentTypes.bankAccounts.indexOf($(this).val()) >= 0)
      BankListController.start();
  };

  var initValidation = function(){
    $(settings.paymentMethodForm).validate({
      rules:{
        paymentType:"required"
      }
    });
  };

  var validatePaymentMethod = function(event){
    event.preventDefault();
    console.log("Payment Method");
  }

  var bindEvents = function(){
    $(settings.paymentType).on("change",showBanksOrProviders);
    //$(settings.paymentMethodForm).on("submit",validatePaymentMethod);
  };

  var start = function(){
    bindEvents();
    initValidation();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyPaymentMethodController.start();
});
