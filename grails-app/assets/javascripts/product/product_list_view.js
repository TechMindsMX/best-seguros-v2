var ProductListView = (function(){

  var settings= {
    productListTemplate:'#product-list-template'
  };

  var render = function(data,divToRender){
    var source = $(settings.productListTemplate).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(divToRender).html(html);
  };

  return{
    render:render
  };

}());
