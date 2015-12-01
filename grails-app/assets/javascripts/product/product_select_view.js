var ProductSelectView = (function(){
  var settings = {
    productsSelectTemplate:'#products-select-template',
    productsFormGroup:'div.products'
  }; 

  var render = function(data){
    var source = $(settings.productsSelectTemplate).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.productsFormGroup).html(html);
  }; 

  return{
    render:render
  };

}());
