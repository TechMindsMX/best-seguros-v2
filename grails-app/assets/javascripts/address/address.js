var Address = {
  dMnpio:'',
  dCiudad:'',
  dCodigo:'',
  dEstado:'',
  dAsenta:null,

  create: function(data){
    return $.extend({},this,data);
  }, 
  
  deserialize: function(data){
    var _self = Address.create({});

    Object.keys(_self).forEach(function(key){
      if(typeof _self[key] !== 'function'){
        _self[key] = data.address[key];
      }
    });

    return _self;
  },

  get: function(params){
    return new RSVP.Promise(function(resolve,reject){
      $.ajax({
        url:params.url,
        datatype:'json',
        crossDomain: true
      })
      .done(function(response){
        var address = Address.deserialize({address:response});
        resolve(address); 
      })
      .fail(function(response){
        reject(response);
      });
    });
  }

}
