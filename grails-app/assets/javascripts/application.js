//= require third_party/jquery/dist/jquery.js
//= require third_party/bootstrap/dist/js/bootstrap.js
//= require third_party/handlebars/handlebars.js
//= require third_party/rsvp.js/rsvp.js
//= require handlebars/helper_controller.js
//= require home/home_controller.js

var App = (function(){

  var start = function(){
    HelperController.start();
    HomeController.start();
  };

  return{
    start:start
  };

}());

jQuery(function($){
  App.start();
});
