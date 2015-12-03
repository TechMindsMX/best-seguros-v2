<script id="plan-info-template" type="text/x-handlebars-template">
  {{#each insuredSumsByCoveragePerInsured}}
    <table>
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
            <table>
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
</script>
