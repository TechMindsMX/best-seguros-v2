//= require bank/bank.js
//= require bank/bank_list_view.js

var BankListController = (function(){

  var settings = {
    paymentMethodForm:'form[name=paymentMethodForm]',
    bankSelector:'select[name=bank]',
    accountNumber:'input[name=accountNumber]'
  };

  var addValidations = function(){
    $(settings.paymentMethodForm).validate();
    $(settings.bankSelector).rules("add","required");
    $(settings.accountNumber).rules("add","required");
  };

  var successBankList = function(data){
    BankListView.render(data);
    addValidations();
  };

  var failureBankList = function(data){
    console.log("Error " + data);
  };

  var start = function(){
    Bank.list({url:'/banks/'}).then(successBankList,failureBankList);
  };

  return {
    start: start
  };

}());
