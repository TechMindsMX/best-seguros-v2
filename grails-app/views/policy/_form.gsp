<g:if test="${!policy.product}">
  <div class="form-horizontal">
    <div class="form-group">
      <label class="col-lg-2 control-label" for="product">Productos</label>
      <div class="col-lg-5">
        <g:select class="form-control" from="${products}" name="product" noSelection="${['':'--Seleccionar--']}" optionKey="uuid" optionValue="name" ></g:select>
      </div>
      <div class="col-lg-5 productPlans">
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-12 planInfo">
      </div>
      <g:render template="/plan/info" model="[policy:policy]"/>
    </div>

    <fieldset class="buttons">
    </fieldset>

    <script id="plans-select-template" type="text/x-handlebars-template">
      <div class="row">
        <label class="col-lg-2 control-label" for="plan">Planes</label>
        <div class="col-lg-10">
          <select class="form-control" name="plan">
            <option value="">--Seleccionar--</option>
            {{#each this}}
            <option value="{{id}}">{{name}}</option>
            {{/each}}
          </select>
        </div>
      </div>
    </script>
  </div>
</g:if>
<g:else>
  <div class="row-fluid">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">Información del producto</h3>
      </div>
      <div class="panel-body">
        <div class="row">
          <div class="col-lg-1">
            <label>Nombre</label>
          </div>
          <div class="col-lg-3">
            <span>
              ${policy?.product?.name}
            </span>
          </div>
          <div class="col-lg-2">
            <label>Aseguradora</label>
          </div>
          <div class="col-lg-4">
            <span>
              ${policy?.product?.insurance?.name}
            </span>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-1">
            <label>Ramo</label>
          </div>
          <div class="col-lg-3">
            <span>
              ${policy?.product?.trade?.name}
            </span>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-1">
            <label>Plan</label>
          </div>
          <div class="col-lg-3">
            ${policy?.plan?.name}
          </div>
        </div>

      </div>
    </div>
  </div>
</g:else>

