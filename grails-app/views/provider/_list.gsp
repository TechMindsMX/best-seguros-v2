<script id="provider-list-template" type="text/x-handlebars-template">
  <div class="col-lg-2">
    <label for="provider" class="control-label">Proveedor</label>
  </div>
  <div class="col-lg-2">
    <select name="cardProvider" class="form-control">
      <option value>--Seleccionar</option>
      {{#each cardProviders}}
        <option value="{{id}}">{{value}}</option>
      {{/each}}
    </select>
  </div>

  <div class="col-lg-7">
    <div class="row">
      <div class="col-lg-2">
        <label for="cardNumber" class="control-label">Número de Tarjeta</label>
      </div>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="cardNumber" maxlength="16" />
      </div>
    </div>
  </div>
</script>
