var Product = {
  id:'',
  name:'',
  
  create: function(data){
    return $.extend({},this,data);
  },

  deserialize:function(data){
    var _self = Product.create({});

    Object.keys(_self).forEach(function(key){
      if(typeof _self[key] != 'function'){
        _self[key] = data.product[key];
      }
    });
    
    return _self;
  },

  list: function(params){
    return new RSVP.Promise(function(resolve,reject){
      $.ajax({
        url:params.url,
        type:'GET',
        data:params.data,
        datatype:'json',
        contentType:'application/json; charset=utf-8'
      })
      .done(function(response){
        var model = { products:[] };

        response.forEach(function(item){
          model.products.push(Product.deserialize({product:item}));
        });

        resolve(model);
      })
      .fail(function(response){
        reject(response);
      });
    });
  }    
   
};
