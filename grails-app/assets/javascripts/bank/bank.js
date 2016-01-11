var Bank = {
  name:'',

  create: function(data){
    return $.extend({},this,data);
  },

  deserialize:function(data){
    var _self = Bank.create({});

    Object.keys(_self).forEach(function(key){
      if(typeof _self[key] != 'function'){
        _self[key] = data.bank[key];
      }
    });

    return _self;
  },

  list:function(params){
    return new RSVP.Promise(function(resolve,reject){
      url:params.url,
      type:'GET',
      datatype:'json',
      contentType:'application/json; charset=utf8'
    })
    .done(function(response){
      var model = {banks:[]};

      response.forEach(function(item){
        model.banks.push(Bank.deserialize({bank:item}));
      });

      resolve(model);
    })
    .fail(function(response){
      reject(response);
    });
  }

}
