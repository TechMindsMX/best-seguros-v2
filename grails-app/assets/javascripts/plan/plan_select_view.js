var PlanSelectView = (function(){
  
  var settings = {
    planSelectTemplate:'#plans-select-template',
    planFormGroup:'div.productPlans' 
  };

  var render = function(data){
    var source = $(settings.planSelectTemplate).html();
    console.log(source);
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.planFormGroup).html(html);
  };

  return{
    render:render
  };

}());
