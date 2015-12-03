var HelperController = (function(){

  var initHelpers = function(){
    Handlebars.registerHelper('showProperty',function(obj,field,options){
      return obj[field][options.hash.property];
    });
  };

  var start = function(){
    initHelpers();
  };

  return{
    start:start
  };

}());
