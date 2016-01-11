var BankListView = (function(){

  var settings = {
    template:'#bank-template',
    bankListDiv:'.bankOrCardList'
  };

  var render = function(data){
    var source = $(settings.template).html();
    var template = Handlebars.compile(source);
    var html = template(data);
    $(settings.bankListDiv).html(html);
  };

  return{
    render: render
  };

}());
