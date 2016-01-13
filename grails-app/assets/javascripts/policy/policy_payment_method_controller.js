//= require bank/bank_list_controller.js
//= require card/provider_list_controller.js

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

  var validatePaymentMethod = function(event){
    event.preventDefault();
  }

  var bindEvents = function(){
    $(settings.paymentType).on("change",showBanksOrProviders);
    $(settings.paymentMethodForm).on("submit",validatePaymentMethod);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyPaymentMethodController.start();
});
