<script id="plan-info-template" type="text/x-handlebars-template">
  <div class="row">
    <div class="col-lg-12">
      <div class="portlet portlet-default">
        {{#each insuredSumsByCoveragePerInsured}}
          <div class="portlet-heading">
            <div class="portlet-title">
              <h4>{{@key}}</h4>
            </div>
            <div class="clearfix"></div>
          </div>

          <div class="portlet-body">
            <div class="table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th colspan="2">
                    {{@key}}
                    </th>
                  </tr>
                  <tr>
                    <th>
                      Cobertura
                    </th>
                    <th>
                      Suma asegurada
                    </th>
                  </tr>
                </thead>

                <tbody>
                  {{#each this}}
                  <tr>
                    <td>{{coverage.name}}</td>
                    <td>{{insuredSum}}</td>
                  </tr>
                  {{/each}}
                  <tr>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Rango Edad</th>
                          <th>Prima</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>{{showProperty ../rangeAgesByBeneficiary @index property='minAge'}} a {{showProperty ../rangeAgesByBeneficiary @index property='maxAge'}}</td>
                          <td>{{showProperty ../insuranceCostsPerInsured @index property='insuranceCost'}}</td>
                        </tr>
                      </tbody>
                    </table>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        {{/each}}
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-12">
      <g:form controller="policy" action="addProduct" id="${policy.id}">
        <input type="hidden" name="plan" value="{{plan}}"/>
        <input type="hidden" name="product" value="{{product}}" />
        <button type="submit" class="btn btn-primary pull-right">Comenzar con la captura de los asegurados</button>
      </g:form>
    </div>
  </div>
</script>
