<script id="provider-list-template" type="text/x-handlebars-template">
  <div class="col-lg-2">
    <label for="provider" class="control-label">Proveedor</label>
  </div>
  <div class="col-lg-2">
    <select name="cardProvider" class="form-control">
      <option value>--Seleccionar</option>
      {{#each cardProviders}}
        <option value="{{key}}">{{value}}</option>
      {{/each}}
    </select>
  </div>
</script>
