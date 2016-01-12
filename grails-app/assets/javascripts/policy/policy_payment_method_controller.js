//= require bank/bank_list_controller.js
//= require card/provider_list_controller.js

var PolicyPaymentMethodController = (function(){

  var settings = {
    paymentType:'#paymentType'
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

  var bindEvents = function(){
    $(settings.paymentType).on("change",showBanksOrProviders);
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
