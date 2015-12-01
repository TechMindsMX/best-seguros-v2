//= require product/product.js
//= require plan/plan.js
//= require product/product_select_view.js
//= require plan/plan_select_view.js

var PolicyCreateController = (function(){

  var settings = {
    insuranceSelector:'select[name=insurance]',
    productSelector:'select[name=product]',
    productsListDiv:'div.form-group.products'
  };

  var producListSuccess = function(data){
    ProductSelectView.render(data); 
  };

  var planListSuccess = function(data){
    PlanSelectView.render(data);
  }
  
  var failure = function(data){
    console.log("Error " + data);
  }

  var updateProducts = function(){
    Product.list({url:'/products',data:{id:$(this).val()}}).then(producListSuccess,failure);
  };

  var updatePlans = function(){
    Plan.list({url:'/plans',data:{id:$(this).val()}}).then(planListSuccess,failure);
  };

  var bindEvents = function(){
    $(settings.insuranceSelector).on("change",updateProducts);
    $(settings.productsListDiv).on("click",settings.productSelector,updatePlans);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  PolicyCreateController.start();
});
