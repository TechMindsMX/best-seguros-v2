<form class="form-horizontal">
  <f:field bean="insured" property="name" wrapper="form" />
  <f:field bean="insured" property="lastName" wrapper="form" />
  <f:field bean="insured" property="motherLastName" wrapper="form" />
  <div class="form-group">
    <label for="name" class="col-sm-3 control-label">Fecha de Nacimiento</label>
    <div class="col-sm-5">
      <input type="text" class="col-sm-9 form-control" id="birthDate" name="birthDate" />
    </div>
  </div>
  <f:field bean="insured" property="phone" wrapper="form" label="${message(code:"insured.phone")}" />
  <f:field bean="insured" property="rfc" wrapper="form" label="${message(code:"insured.rfc")}" />
  <f:field bean="insured" property="email" wrapper="form" label="${message(code:"insured.email")}" />
  <f:field bean="insured" property="address" wrapper="form" label="${message(code:"insured.address")}" />
  <f:field bean="insured" property="country" wrapper="form" label="${message(code:"insured.country")}"/>
  <f:field bean="insured" property="state" wrapper="form" label="${message(code:"insured.state")}"/>
  <f:field bean="insured" property="town" wrapper="form" label="${message(code:"insured.town")}"/>
  <f:field bean="insured" property="colony" wrapper="form" />
  <f:field bean="insured" property="cp" wrapper="form" />
  <f:field bean="insured" property="city" wrapper="form" />
  <f:field bean="insured" property="city" wrapper="form" />
</form>