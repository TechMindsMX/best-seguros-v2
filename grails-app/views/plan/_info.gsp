<script id="plan-info-template" type="text/x-handlebars-template">
  <div class="row">
    <div class="col-lg-12">
    {{#each insuredSumsByCoveragePerInsured}}
      <table class="table table-bordered">
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
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>Rango Edad</th>
                    <th>Prima</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>{{showProperty ../rangeAgesByBeneficiary @index property='minAge'}} a
                        {{showProperty ../rangeAgesByBeneficiary @index property='maxAge'}}
                    </td>
                    <td>
                      {{showProperty ../insuranceCostsPerInsured @index property='insuranceCost'}}
                    </td>
                  </tr>
                </tbody>
              </table>
            </tr>
        </tbody>
      </table>
    {{/each}}
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
