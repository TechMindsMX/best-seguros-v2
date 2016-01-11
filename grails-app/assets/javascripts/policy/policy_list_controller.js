//= require insurance/insurance.js
//= require product/product.js
//= require policy/policy_search_view.js
//= require product/product_list_view.js
//= require policy/policy_search_controller.js

var PolicyListController = (function(){
  var settings = {
    insuranceListUrl:'#insuranceLink',
    productListUrl:'#productLink',
    insuranceSelect:'select[name=insurance]',
    productListDiv:'.productListDiv',
    productSelect:'select[name=products]',
    searchButton:'#searchButton'
  };

  var success = function(data){
    PolicySearchView.render(data);
  };

  var productListSuccess = function(data){
    ProductListView.render(data,settings.productListDiv);
    PolicySearchController.start();
  };

  var failure = function(data){
    console.log("Error: " + data);
  };

  var showProducts = function(){
    Product.list({url:$(settings.productListUrl).val(),data:{id:$(this).val()}}).then(productListSuccess,failure);
  };

  var showButton = function(){
    if($(this).val() != '')
      $(settings.searchButton).removeClass('hidden');
    else
      $(settings.searchButton).addClass('hidden');
  };

  var bindEvents = function(){
    $("#applicationDiv").on("change",settings.insuranceSelect,showProducts);
    $("#applicationDiv").on("change",settings.productSelect,showButton);
  }

  var start = function(){
    Insurance.list({url:$(settings.insuranceListUrl).val()}).then(success,failure);
    bindEvents();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyListController.start();
});
