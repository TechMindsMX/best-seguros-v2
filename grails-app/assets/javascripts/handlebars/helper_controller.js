var HelperController = (function(){

  var policyStatusLabelClass = {
    creada:'blue',
    finalizada:'green'
  };

  var initHelpers = function(){
    Handlebars.registerHelper('showProperty',function(obj,field,options){
      return obj[field][options.hash.property];
    });

    Handlebars.registerHelper('labelType',function(object){
      var status = Handlebars.escapeExpression(object);

      return new Handlebars.SafeString(
        policyStatusLabelClass[status.toLowerCase()]
      );
    });

    Handlebars.registerHelper('showEditButton',function(conditional,options){
      if(conditional== 'Creada')
        return options.fn(this);
      else
        return options.inverse(this);
    });
  };

  var start = function(){
    initHelpers();
  };

  return{
    start:start
  };

}());
