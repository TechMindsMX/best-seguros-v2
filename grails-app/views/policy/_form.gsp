<g:form class="form-horizontal" action="save" >
  <div class="form-group">
    <label class="col-lg-2 control-label" for="product">Productos</label>
    <div class="col-lg-5">
      <g:select class="form-control" from="${products}" name="product" optionKey="uuid" optionValue="name" ></g:select>
    </div>
    <div class="col-lg-5 productPlans">
      
    </div>  
  </div>
  
  <fieldset class="buttons">
    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
  </fieldset>

  <script id="products-select-template" type="text/x-handlebars-template">
    <label class="col-lg-2 control-label" for="product">Productos</label>
    <div class="col-lg-5">
      <select class="form-control">
        {{#each this}}
        <option value="{{id}}">{{name}}</option>
        {{/each}}
      </select>
    </div>
    <div class="col-lg-5 productPlans">
      
    </div>
  </script>
  
  <script id="plans-select-template" type="text/x-handlebars-template">
    <div class="row">
      <label class="col-lg-2 control-label" for="plan">Planes</label>
      <div class="col-lg-10">
        <select class="form-control" name="plan">
          {{#each this}}
          <option value="{{id}}">{{name}}</option>
          {{/each}}
        </select>
      </div>
    </div>
  </script>

</g:form>
