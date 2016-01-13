var ProviderListView = (function(){

  var settings = {
    template:'#provider-list-template',
    providerListView:'.bankOrCardList'
  };

  var render = function(data){
    var source = $(settings.template).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.providerListView).html(html);
  };

  return {
    render: render
  };

}());
