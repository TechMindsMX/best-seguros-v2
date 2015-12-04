<div class="form-horizontal" action="save" >
  <g:if test="${!policy.product}">
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
  </g:if>
</div>
