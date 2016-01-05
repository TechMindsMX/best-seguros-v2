var Insurance = {
  name:'',

  create:function(data){
    return $.extend({},this,data);
  },
  
  deserialize:function(data){
    var _self = Insurance.create({});

    Object.keys(_self).forEach(function(key){
      if(typeof _self[key] !== 'function'){
        _self[key] = data.insurance[key];
      }
    });
  
    return _self;
  },

  list:function(params){
    return new RSVP.Promise(function(resolve,reject){
      $.ajax({
        url:params.url,
        type:'GET',
        datatype:'json',
        contentType:'application/json; charset=utf8'
      })
      .done(function(response){
        var model = {insurances:[]};

        response.forEach(function(item){
          model.insurances.push(Insurance.deserialize({insurance:item}));           
        });

        resolve(model);
      })
      .fail(function(response){
        reject(response);
      }); 
    });
  }

}
