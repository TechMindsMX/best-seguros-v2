//= require policy/policy_list_controller.js

var HomeController = (function(){

  var selectors = {
    sidebar_toggle:'#sidebar-toggle',
    navbar_side:'.navbar-side',
    page_wrapper:'#page-wrapper',
    searchPolicyLink:'#searchPolicy'    
  };

  var toggleDiv = function(){
    $(selectors.navbar_side).toggleClass("collapsed");
    $(selectors.page_wrapper).toggleClass("collapsed");
  };

  var getSearchContent = function(event){
    event.preventDefault();
    PolicyListController.start();
  }; 

  var bindEvents = function(){
    $(selectors.sidebar_toggle).on('click',toggleDiv);
    $(selectors.searchPolicyLink).on('click',getSearchContent);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());
