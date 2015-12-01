var Product = {
  uuid:'',
  name:'',
  
  create: function(data){
    return $.extend({},this,data);
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
        resolve(response);
      })
      .fail(function(response){
        reject(response);
      });
    });
  }    
   
};
