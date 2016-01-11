<script id="product-list-template" type="text/x-handlebars-template">
  <div class="form-group">
    <label for="product" class="col-lg-2 control-label">Producto</label>
    <div class="col-lg-10">
      <select name="products" class="form-control">
        <option value>--Seleccionar--</option>
        {{#each products}}
          <option value="{{id}}">{{name}}</option>
        {{/each}}
      </select>
    </div>
  </div>
</script>
