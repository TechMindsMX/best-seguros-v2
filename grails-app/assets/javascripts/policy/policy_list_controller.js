//= require insurance/insurance.js
//= require product/product.js
//= require policy/policy_search_view.js
//= require product/product_list_view.js

var PolicyListController = (function(){
  var settings = {
    insuranceListUrl:'#insuranceLink',
    productListUrl:'#productLink',
    insuranceSelect:'select[name=insurance]',
    productListDiv:'.productListDiv'
  };

  var success = function(data){
    PolicySearchView.render(data);
  };

  var showProducts = function(){
    Product.list({url:$(settings.productListUrl).val(),data:{id:$(this).val()}}).then(productListSuccess,failure);
  }

  var productListSuccess = function(data){
    ProductListView.render(data,settings.productListDiv);
  };

  var failure = function(data){
    console.log("Error: " + data);
  };

  var bindEvents = function(){
    $("#applicationDiv").on("change",settings.insuranceSelect,showProducts);
  }

  var start = function(){
    Insurance.list({url:$(settings.insuranceListUrl).val()}).then(success,failure);
    bindEvents();
  };

  return{
    start:start
  };

}());
