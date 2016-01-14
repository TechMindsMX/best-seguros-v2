<%@ page import="com.bestseguros.InsuredType" %>
<h4>Registrar ${insured.insuredType.value}</h4>

<g:form controller="insured" action="save">
  <g:hasErrors bean="${insured}">
    <g:eachError bean="${insured}">
      <div class="alert alert-danger">
        <g:message error="${it}"/>
      </div>
    </g:eachError>
  </g:hasErrors>

  <div class="row">
    <div class="col-lg-4">
      <f:field bean="insured" property="name" wrapper="form" label="${message(code:"insured.name")}" />
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="lastName" wrapper="form" label="${message(code:"insured.lastName")}"/>
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="motherLastName" wrapper="form" label="${message(code:"insured.motherLastName")}"/>
    </div>
  </div>

  <div class="row form-row">
    <div class="col-lg-4" >
      <div class="form-group">
        <label for="name" class="col-sm-5 col-md-4 col-lg-4 control-label">Fecha de Nacimiento</label>
        <div class="col-sm-7 col-md-8 col-lg-8">
          <input type="text" class="form-control datePicker" id="birthDate" name="insured.birthDate" value="${formatDate(format:'dd/MM/yyyy',date:insured.birthDate)}"/>
        </div>
      </div>
    </div>

    <div class="col-lg-4">
      <f:field bean="insured" property="rfc" wrapper="form" label="${message(code:"insured.rfc")}" maxlength="13" />
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="phone" wrapper="form" label="${message(code:"insured.phone")}" maxlength="10" />
    </div>
  </div>

  <div class="row form-row">
    <div class="col-lg-4">
      <f:field bean="insured" property="email" wrapper="form" label="${message(code:"insured.email")}" />
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="cp"  wrapper="form" label="${message(code:"insured.cp")}" />
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="address" wrapper="form" label="${message(code:"insured.address")}" />
    </div>
  </div>


  <div class="row form-row">
    <div class="col-lg-4">
      <f:field bean="insured" property="country" wrapper="form" label="${message(code:"insured.country")}"/>
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="state" wrapper="form" label="${message(code:"insured.state")}"/>
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="town" wrapper="form" label="${message(code:"insured.town")}"/>
    </div>
  </div>

  <div class="row form-row">
    <div class="col-lg-4">
      <f:field bean="insured" property="colony" wrapper="form" label="${message(code:"insured.colony")}"/>
    </div>
    <div class="col-lg-4">
      <f:field bean="insured" property="city" wrapper="form" label="${message(code:"insured.city")}" />
    </div>
  </div>

  <g:if test="${insured.insuredType == InsuredType.CONTRACTING_PARTY}">
    <div class="row form-row">
      <div class="col-lg-4">
        <div class="form-group">
          <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 text-left" ><g:checkBox name="principal" checked="${principal}"  /></div>
          <label class="control-label col-sm-8 col-md-8 col-lg-8 col-xs-8">Registrar como titular</label>

        </div>
      </div>
    </div>
  </g:if>

  <input type="hidden" name="insured.insuredType" value="${insured.insuredType.key}"/>
  <input type="hidden" name="policy" value="${policy.id}"/>
  <div class="row">
    <div class="col-lg-12">
      <button type="submit" class="btn btn-default pull-right">Registrar</button>
    </div>
  </div>

</g:form>
