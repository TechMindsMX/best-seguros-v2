//= require address/address.js

var InsuredAddressController = (function(){

  var settings = {
    cp:'.cp',
    url:'#sepomexUrl'
  };

  var currentForm = null;

  var showAddressInfo = function(){
    if($(this).val() !== ''){
      currentForm = $(this).parents("form");
      Address.get({url:$(settings.url).val()+$(this).val()}).then(success,failure);
    }
  }

  var success = function(data){
    currentForm.find(".colony").val(data.dAsenta[0]);
    currentForm.find(".town").val(data.dMnpio);
    currentForm.find(".state").val(data.dEstado);
    currentForm.find(".city").val(data.dCiudad);
  };

  var failure = function(data){
    console.log(data);
  };

  var bindEvents = function(){
    $(settings.cp).on("blur",showAddressInfo);
  };

  var start = function(){
    bindEvents();
  };

  return{
    start:start
  };

}());
