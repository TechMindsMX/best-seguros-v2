var Insurance = {
  name:'',

  create:function(data){
    $.extend({},this,data);
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
        resolve(response);
      })
      .fail(function(response){
        reject(response);
      }); 
    });
  }

}
