//= require policy/policy.js
//= require policy/policy_list_view.js

var PolicySearchController = (function(){

  var settings = {
    searchButton:'#searchButton',
    productSelect:'select[name=products]'
  };

  var success = function(data){
    PolicyListView.render(data);
  };

  var failure = function(data){
    console.log("Error "+data);
  };

  var findPolicies = function(event){
    event.preventDefault();
    Policy.list({url:$(this).parents('form').attr('action'),data:{product:$(settings.productSelect).val()}}).then(success,failure);
  };

  var bindEvents = function(){
    $("#applicationDiv").on("click",settings.searchButton,findPolicies);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());
