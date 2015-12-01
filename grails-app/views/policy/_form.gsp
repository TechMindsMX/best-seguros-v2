<g:form class="form-horizontal" action="save" >
  <div class="form-group">
    <label class="col-lg-2 control-label" for="product">Aseguradora</label>
    <div class="col-lg-5">
      <g:select class="form-control" from="${insurances}" name="insurance" optionKey="id" optionValue="name" ></g:select>
    </div>
  </div>
  <div class="form-group products">

  </div>
  <fieldset class="buttons">
    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
  </fieldset>

  <script id="products-select-template" type="text/x-handlebars-template">
    <label class="col-lg-2 control-label" for="product">Productos</label>
    <div class="col-lg-5">
      <select class="form-control" name="product">
        {{#each this}}
        <option value="{{id}}">{{name}}</option>
        {{/each}}
      </select>
    </div>
  </script>

</g:form>
