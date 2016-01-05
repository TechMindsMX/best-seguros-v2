var PolicySearchView = (function(){
  
  var settings = {
    template:'#search-policy-template',
    searchPolicyDiv:'#applicationDiv'
  }; 

  var render = function(data){
    var source = $(settings.template).html();
    var template = Handlebars.compile(source);
    var html = template(data); 
    $(settings.searchPolicyDiv).html(html);
  }
  
  return{
    render:render
  };

}());
