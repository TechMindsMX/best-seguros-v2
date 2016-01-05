//= require insurance/insurance.js

var PolicyListController = (function(){
  var settings = {
    insuranceListUrl:'#insuranceLink'
  };
  
  var success = function(data){
    console.log(data); 
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
