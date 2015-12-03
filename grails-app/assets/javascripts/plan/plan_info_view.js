var PlanInfoView = (function(){

  var settings = {
    planInfoTemplate:'#plan-info-template',
    planInfoRenderDiv:'div.planInfo'
  };

  var render = function(data){
    var source = $(settings.planInfoTemplate).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.planInfoRenderDiv).html(html);
  };

  return{
    render:render
  };

}());
