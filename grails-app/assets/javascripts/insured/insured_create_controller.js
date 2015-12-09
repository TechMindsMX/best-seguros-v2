//= require third_party/pickadate/lib/picker.js
//= require third_party/pickadate/lib/picker.date.js
//= require third_party/pickadate/lib/translations/es_ES.js

var InsuredCreateController = (function(){

  var settings = {
    datePicker:'.datePicker'
  };

  var start = function(){
    $(settings.datePicker).pickadate({
      selectYears: true,
      selectMonths: true,
      selectYears: 110,
      format:'dd/mm/yyyy',
      formatSubmit:'dd/mm/yyyy',
      max: true,
      today: false,
      clear: false,
      close: 'Cerrar'});
  };

  return{
    start:start
  };

}());

jQuery(function($){
  InsuredCreateController.start();
});
