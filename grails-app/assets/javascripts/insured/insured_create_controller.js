//= require third_party/pickadate/lib/picker.js
//= require third_party/pickadate/lib/picker.date.js
//= require third_party/pickadate/lib/picker.time.js
//= require third_party/pickadate/lib/translations/es_ES.js
//= require insured/insured_address_controller.js

var InsuredCreateController = (function(){

  var settings = {
    datePicker:'.datePicker'
  };

  var start = function(){
    InsuredAddressController.start();
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
