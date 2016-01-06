<script id="search-policy-template" type="text/x-handlebars-template">
<div class="row">
  <div class="col-lg-12">
    <div class="page-title">
      <h1>Búsqueda de Pólizas</h1>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-lg-12">
    <div class="portlet portlet-default">
      <div class="portlet-body">
        <g:form controller="policy" action="index">
        <div class="row">
          <div class="col-lg-6 form-horizontal">
            <div class="form-group">
              <label for="insurance" class="col-lg-3 control-label">Aseguradora</label>
              <div class="col-lg-9">
                <select name="insurance" class="form-control">
                  <option value>--Seleccionar--</option>
                  {{#each insurances}}
                  <option value="{{id}}">{{name}}</option>
                  {{/each}}
                </select>
                <input type="hidden" id="productLink" value="${createLink(controller:'product',action:'index')}" />
              </div>
            </div> <!--ENDOF FORM-GROUP -->
          </div> <!--ENDOF DIV.FORM-HORIZONTAL -->

          <div class="col-lg-5 productListDiv form-horizontal">
          </div>

          <div class="col-lg-1">
            <button class="btn btn-blue btn-square pull-right hidden" id="searchButton">
              <i class="fa fa-search"></i>
              Buscar
            </button>
          </div>
        </div>
        </g:form>

      </div>
    </div>
  </div><!--ENDOF ROW COL-LG-12 -->
</div><!--ENDOF ROW-->
</script>
