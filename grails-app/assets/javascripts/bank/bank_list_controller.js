//= require bank/bank.js
//= require bank/bank_list_view.js

var BankListController = (function(){

  var successBankList = function(data){
    BankListView.render(data);
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
