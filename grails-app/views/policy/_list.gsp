{{#if policies}}
<table class="table table-striped table-bordered table-hover ">
  <thead>
    <tr>
      <th>No.</th>
      <th>Producto</th>
      <th>Plan</th>
      <th>Status</th>
    </tr>
  </thead>
  <tbody>
    {{#each policies}}
    <tr class="even">
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    {{/each}}
  </tbody>
</table>
{{else}}
<p>No hay nada</p>
{{/if}}

