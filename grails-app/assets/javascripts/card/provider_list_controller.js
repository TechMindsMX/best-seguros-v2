//= require card/cardProvider.js
//= require card/provider_list_view.js

var ProviderListController = (function(){

  var settings = {
    paymentMethodForm:'form[name=paymentMethodForm]',
    cardProviderSelector:'select[name=cardProvider]',
    cardNumberSelector:'input[name=cardNumber]'
  };

  var success = function(data){
    ProviderListView.render(data);
    initValidation();
  };

  var initValidation = function(){
    $(settings.paymentMethodForm).validate();
    $(settings.cardProviderSelector).rules("add","required");
    $(settings.cardNumberSelector).rules("add","required");
  };

  var failure = function(data){
    console.log("Error " + data);
  };

  var start = function(){
    CardProvider.list({url:'/payment/providers'}).then(success,failure);
  };

  return{
    start:start
  };

}());
