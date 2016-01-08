<%@ page import="com.bestseguros.PolicyStatus" %>

<g:if test="${!policy.product}">
  <div class="form-horizontal">
    <div class="form-group">
      <label class="col-lg-1 control-label" for="product">Productos</label>
      <div class="col-lg-5">
        <g:select class="form-control" from="${products}" name="product" noSelection="${['':'--Seleccionar--']}" optionKey="uuid" optionValue="name" ></g:select>
      </div>
      <div class="col-lg-3 productPlans">
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
  <div class="row">
    <div class="col-lg-12">
      <div class="portlet portlet-blue">
        <div class="portlet-heading">
          <div class="portlet-title">
            <h4>Información del producto</h4>
          </div>
          <div class="clearfix"></div>
        </div><!--ENDOF PORTLET HEADING -->

        <div class="portlet-body">
          <div class="row">
            <div class="col-lg-1">
              <label>Nombre</label>
            </div>
            <div class="col-lg-5">
              <span>${policy?.product?.name}</span>
            </div>
            <div class="col-lg-1">
              <label>Aseguradora</label>
            </div>
            <div class="col-lg-4">
              <span>${policy?.product?.insurance?.name}</span>
            </div>
          </div>

          <div class="row">
            <div class="col-lg-1">
              <label>Ramo</label>
            </div>
            <div class="col-lg-3">
              <span>${policy?.product?.trade?.name}</span>
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

        </div><!--ENDOF PORTLET-BODY -->
      </div><!--ENDOF PORTLET-DEFAULT-->
    </div>
  </div>

  <div class="row">
    <div class="col-lg-12">
      <div class="portlet portlet-blue">
        <div class="portlet-heading">
          <div class="portlet-title">
            <h4>Contratante</h4>
          </div>
          <div class="clearfix"></div>
        </div><!--ENDOF PORTLET HEADING -->

        <div class="portlet-body">
          <g:if test="${contractingParty.id}">
            <g:render template="/insured/show" model="[insured:contractingParty]"/>
          </g:if>
          <g:else>
            <g:render template="/insured/form" model="[insured:contractingParty,policy:policy]"/>
          </g:else>
        </div><!--ENDOF PORTLET-BODY -->
      </div>
    </div>
  </div>

  <g:if test="${contractingParty.id}">
    <div class="row-fluid">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Asegurados</h3>
        </div>
        <div class="panel-body">
          <div class="row" style="margin-bottom:20px;">
            <g:each var="insured" in="${insuredTypes}">
              <div class="panel-group" id="accordion${insured.key}" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                  <div class="panel-heading" role="tab" id="heading${insured.key}">
                    <h4 class="panel-title">
                      <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${insured.key}" aria-expanded="true" aria-controls="collapse${insured.key}">
                        ${insured.value}
                      </a>
                    </h4>
                  </div>
                  <div id="collapse${insured.key}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                      <g:each var="savedInsured" in="${insureds.savedInsureds[insured]}">
                        <g:render template="/insured/show" model="[insured:savedInsured]"/>
                      </g:each>

                      <g:if test="${insureds.unsavedInsureds[insured]}">
                        <!--TODO: Enviar los insureds desde el controller -->
                        <g:render template="/insured/form" model="[insured:insureds.unsavedInsureds[insured].first(),policy:policy]"/>
                      </g:if>
                    </div>
                  </div>
                </div>
              </div>
            </g:each>
          </div>
        </div>
      </div>
    </div>

    <g:form controller="policy" action="paymentMethod" id="${policy.id}">
      <button type="submit" class="btn btn-default pull-right">Agregar método de pago</button>
    </g:form>
  </g:if>

</g:else>
