<script id="policy-list-template" type="text/x-handlebars-template">
  {{#if policies}}
  <table class="table table-striped table-bordered table-hover ">
    <thead>
      <tr>
        <th>No.</th>
        <th>Producto</th>
        <th>Plan</th>
        <th>Status</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      {{#each policies}}
      <tr class="even">
        <td>{{id}}</td>
        <td>{{product.name}}</td>
        <td>{{plan.name}}</td>
        <td>
          <span class="badge {{labelType status}}">
            {{status}}
          </span>
        </td>
        <td>
          {{#showEditButton status}}
            <button type="button">Editar</button>
          {{else}}
            <button type="button">Ver póliza</button>
          {{/showEditButton}}
        </td>
      </tr>
      {{/each}}
    </tbody>
  </table>
  {{else}}
  <p>No hay nada</p>
  {{/if}}
</script>
