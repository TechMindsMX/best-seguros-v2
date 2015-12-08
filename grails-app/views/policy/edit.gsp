<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'policy.label', default: 'Policy')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
    <asset:javascript src="policy/policy_create_controller.js" />
  </head>
  <body>
    <div class="nav" role="navigation">
    </div>
    <div id="create-policy" class="content scaffold-create" role="main">
      <h1>Captura de Póliza</h1>
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
      <g:render template="/policy/form" model="[policy:policy]" />
    </div>
  </body>
</html>
