//= require address/address.js

var InsuredAddressController = (function(){
  
  var settings = {
    colony:'#colony',
    town:'#town',
    city:'#city',
    state:'#state',
    cp:'#cp',
    url:'#sepomexUrl'
  };

  var showAddressInfo = function(){
    Address.get({url:$(settings.url).val()+$(settings.cp).val()}).then(success,failure);
  }

  var success = function(data){
    console.log(data);
    $(settings.colony).val(data.dAsenta[0]); 
    $(settings.town).val(data.dMnpio);
    $(settings.state).val(data.dEstado);
    $(settings.city).val(data.dCiudad); 
  };

  var failure = function(data){

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
