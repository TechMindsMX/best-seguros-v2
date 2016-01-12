<script id="bank-template" type="text/x-handlebars-template">
  <div class="col-lg-2">
    <label for="bank" class="control-label">Banco</label>
  </div>
  <div class="col-lg-2">
    <select name="bank" class="form-control">
      <option value>--Seleccionar</option>
      {{#each banks}}
        <option value="{{id}}">{{name}}</option>
      {{/each}}
    </select>
  </div>
</script>
