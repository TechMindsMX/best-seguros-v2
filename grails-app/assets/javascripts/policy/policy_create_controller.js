//= require product/product.js
//= require plan/plan.js
//= require plan/plan_select_view.js
//= require plan/plan_info_view.js

var PolicyCreateController = (function(){

  var settings = {
    productSelector:'select[name=product]',
    planSelect:'select[name=plan]',
    productsListDiv:'div.productPlans',
  };

  var planListSuccess = function(data){
    PlanSelectView.render(data);
  }

  var planInfoSuccess = function(data){
    PlanInfoView.render(data);
  }

  var failure = function(data){
    console.log("Error " + data);
  }

  var updatePlans = function(){
    Plan.list({url:'/plans',data:{id:$(this).val()}}).then(planListSuccess,failure);
  };

  var showPlanInfo = function(){
    Plan.get({url:'/plans/'+$(this).val()}).then(planInfoSuccess,failure);
  }

  var bindEvents = function(){
    $(settings.productSelector).on("change",updatePlans);
    $(settings.productsListDiv).on("change",settings.planSelect,showPlanInfo);
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
