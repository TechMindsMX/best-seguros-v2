//= require third_party/accounting.js/accounting.js

var HelperController = (function(){

  var policyStatusLabelClass = {
    creada:'blue',
    finalizada:'green'
  };

  var initHelpers = function(){
    Handlebars.registerHelper('showProperty',function(object,field,options){
      return object[field][options.hash.property];
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

    Handlebars.registerHelper('currencyFormatForProperty',function(object,field,options){
      return accounting.formatMoney(object[field][options.hash.property]);
    });

    Handlebars.registerHelper('currencyFormat',function(context,options){
      return accounting.formatMoney(context);
    });
  };

  var start = function(){
    initHelpers();
  };

  return{
    start:start
  };

}());
