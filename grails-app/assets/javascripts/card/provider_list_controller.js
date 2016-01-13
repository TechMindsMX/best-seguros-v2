//= require card/cardProvider.js
//= require card/provider_list_view.js

var ProviderListController = (function(){

  var success = function(data){
    ProviderListView.render(data);
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
