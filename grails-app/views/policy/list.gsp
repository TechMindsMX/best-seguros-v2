<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="layout" content="main" />

  <title>Búsqueda de Póliza</title>
  <asset:javascript src="policy/policy_list_controller.js" />
</head>
<body>
  <div class="row">
    <div class="col-lg-12" id="applicationDiv">
    </div>
  </div>

  <input type="hidden" id="insuranceLink" value="${createLink(controller:'insurance',action:'index')}" />
  <g:render template="/policy/search" />
  <g:render template="/product/list" />
</body>
</html>
