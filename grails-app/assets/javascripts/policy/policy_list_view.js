var PolicyListView = (function(){

  var settings = {
    policyListTemplate:'#policy-list-template',
    policyListDiv:'.resultsDiv'
  };

  var render = function(data){
    var source = $(settings.policyListTemplate).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.policyListDiv).html(html);
  };

  return{
    render:render
  };

}());
