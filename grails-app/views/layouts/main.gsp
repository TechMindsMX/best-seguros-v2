<!doctype html>
<html lang="en" class="no-js">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
  </head>
  <body>
    <nav class="navbar-top" role="navigation">
      <!-- begin BRAND HEADING -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".sidebar-collapse">
          <i class="fa fa-bars"></i>
        </button>
        <div class="navbar-brand image">
          <img src="${asset.assetPath(src:'best_seguros.png')}" alt=""/>
        </div>
      </div>

      <div class="nav-top">
        <ul class="nav navbar-left">
          <li class="tooltip-sidebar-toggle">
          <a href="#" id="sidebar-toggle" data-toggle="tooltip" data-placement="right" title="Sidebar Toggle">
            <i class="fa fa-bars"></i>
          </a>
          </li>
          <!-- You may add more widgets here using <li> -->
        </ul>
      </div> <!--ENDOF NAV-TOP -->

    </nav>

    <nav class="navbar-side" role="navigation">
      <div class="navbar-collapse sidebar-collapse collapse">
        <ul id="side" class="nav navbar-nav side-nav">
          <li>
            <g:link controller="policy" action="create">
              <i class=" fa fa-sticky-note"></i> Nueva Póliza
            </g:link>
          </li>
          <li>
            <a href="#" id="searchPolicy">
              <i class="fa fa-list-alt"></i> Buscar pólizas
            </a>
            <input type="hidden" id="insuranceLink" value="${createLink(controller:'insurance',action:'index')}" />
          </li>
        </ul>
      </div>
    </nav> <!--ENDOF NAVBAR-SIDE -->

    <div id="page-wrapper">
      <div class="page-content page-content-ease-in">
        <div class="row">
          <div class="col-lg-12">
            <g:layoutBody/>
          </div>
        </div>
      </div>
    </div><!-- ENDOF PAGE-WRAPPER -->

    <div class="footer" role="contentinfo"></div>
    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
  </body>
</html>
