<%@ page import="com.bestseguros.InsuredType" %>

<g:form controller="insured" action="save" class="form-horizontal">
  <div class="row">
    <h1>Registrar ${insured.insuredType.value}</h1>
  </div>

  <g:hasErrors bean="${insured}">
    <g:eachError bean="${insured}">
      <div class="alert alert-danger">
        <g:message error="${it}"/>
      </div>
    </g:eachError>
  </g:hasErrors>

  <f:field bean="insured" property="name" wrapper="form" label="${message(code:"insured.name")}" />
  <f:field bean="insured" property="lastName" wrapper="form" label="${message(code:"insured.lastName")}"/>
  <f:field bean="insured" property="motherLastName" wrapper="form" label="${message(code:"insured.motherLastName")}"/>
  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Fecha de Nacimiento</label>
    <div class="col-sm-5">
      <input type="text" class="col-sm-9 form-control datePicker" id="birthDate" name="insured.birthDate" value="${formatDate(format:'dd/MM/yyyy',date:insured.birthDate)}"/>
    </div>
  </div>
  <f:field bean="insured" property="phone" wrapper="form" label="${message(code:"insured.phone")}" maxlength="10" />
  <f:field bean="insured" property="rfc" wrapper="form" label="${message(code:"insured.rfc")}" maxlength="13" />
  <f:field bean="insured" property="email" wrapper="form" label="${message(code:"insured.email")}" />
  <f:field bean="insured" property="cp"  wrapper="form" label="${message(code:"insured.cp")}" />
  <f:field bean="insured" property="address" wrapper="form" label="${message(code:"insured.address")}" />
  <f:field bean="insured" property="country" wrapper="form" label="${message(code:"insured.country")}"/>
  <f:field bean="insured" property="state" wrapper="form" label="${message(code:"insured.state")}"/>
  <f:field bean="insured" property="town" wrapper="form" label="${message(code:"insured.town")}"/>
  <f:field bean="insured" property="colony" wrapper="form" label="${message(code:"insured.colony")}"/>
  <f:field bean="insured" property="city" wrapper="form" label="${message(code:"insured.city")}" />

  <g:if test="${insured.insuredType == InsuredType.CONTRACTING_PARTY}">
    <div class="form-group">
      <div class="col-sm-3 text-right">
        <label for="principal">Titular</label>
      </div>

      <div class="col-sm-5">
        <g:checkBox name="principal" checked="${principal}"  />
      </div>
    </div>
  </g:if>

  <input type="hidden" name="insured.insuredType" value="${insured.insuredType.key}"/>
  <input type="hidden" name="policy" value="${policy.id}"/>
  <button type="submit" class="btn btn-default pull-right">Registrar</button>
</g:form>
