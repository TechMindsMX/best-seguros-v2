<script id="policy-list-template" type="text/x-handlebars-template">
  {{#if policies}}
  <div class="table-responsive">
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
            <a href="${createLink(controller:'policy',action:'edit')}/{{id}}" class="btn btn-default btn-square">
            {{#showEditButton status}}
              Editar
            {{else}}
              Ver póliza
            {{/showEditButton}}
            </a>
          </td>
        </tr>
        {{/each}}
      </tbody>
    </table>
  </div>
  {{else}}
  <div class="alert alert-warning">
    <strong>No se encontraron pólizas para este producto.</strong>
  </div>
  {{/if}}
</script>
