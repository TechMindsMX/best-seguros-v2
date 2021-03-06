<%@page import="com.bestseguros.Periodicity" %>
<%@page import="com.bestseguros.PaymentType" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="layout" content="main" />
  <title>Método de pago</title>
  <asset:javascript src="policy/policy_payment_method_controller.js" />
</head>
<body>
  <div class="row">
    <div class="col-lg-12">
      <div class="page-title">
        <h1>Método de Pago</h1>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-lg-12">
      <div class="portlet portlet-default">
        <div class="portlet-body">
          <g:form class="form-horizontal" controller="policy" action="addPaymentMethod" name="paymentMethodForm" >
            <div class="form-group">
              <div class="col-lg-2">
                <label for="periodicity" class="control-label">Periodicidad</label>
              </div>
              <div class="col-lg-2">
                <g:select id="periodicity" name="periodicity" from="${Periodicity.values()}" optionKey="key" optionValue="value" class="form-control" />
              </div>
            </div>

            <div class="form-group">
              <div class="col-lg-2">
                <label for="paymentType" class="control-label">Medio de pago</label>
              </div>
              <div class="col-lg-2">
                <g:select id="paymentType" name="paymentType" from="${PaymentType.values()}" optionKey="key" optionValue="value" class="form-control" noSelection="['':'--Seleccionar--']"/>
              </div>
            </div>

            <input type="hidden" name="policy" value="${policy.id}" />

            <div class="form-group bankOrCardList">
            </div>

            <div class="form-group">
              <div class="col-lg-12">
                <button class="btn btn-primary pull-right">Guardar y Finalizar</button>
              </div>
            </div>
          </g:form>
        </div>
      </div>
    </div>
  </div>

  <g:render template="/bank/list" />
  <g:render template="/provider/list" />

</body>
</html>
