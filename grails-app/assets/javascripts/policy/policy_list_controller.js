//= require insurance/insurance.js
//= require policy/policy_search_view.js

var PolicyListController = (function(){
  var settings = {
    insuranceListUrl:'#insuranceLink'
  };
  
  var success = function(data){
    PolicySearchView.render(data); 
  };
  
  var failure = function(data){
    console.log("Error! " + data);
  };

  var start = function(){
    Insurance.list({url:$(settings.insuranceListUrl).val()}).then(success,failure);
  };
  
  return{
    start:start
  };

}());
