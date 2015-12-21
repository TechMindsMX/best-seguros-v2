<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'policy.label', default: 'Policy')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
    <asset:javascript src="policy/policy_create_controller.js" />
    <asset:javascript src="insured/insured_create_controller.js" />
    <asset:stylesheet src="third_party/pickadate/lib/themes/default.css" />
    <asset:stylesheet src="third_party/pickadate/lib/themes/default.date.css" />
  </head>
  <body>
    <div class="row">
      <div class="col-lg-12">
        <div class="page-title">
          <h1>Captura de Póliza</h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12">

      </div>
    </div>

    <div id="create-policy" class="content scaffold-create" role="main">
      <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${this.policy}">
      <ul class="errors" role="alert">
        <g:eachError bean="${this.policy}" var="error">
          <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
        </g:eachError>
      </ul>
      </g:hasErrors>
      <input type="hidden" id="sepomexUrl" name="sepomexUrl" value="${sepomexUrl}" />
      <g:render template="/policy/form" />
    </div>
  </body>
</html>
