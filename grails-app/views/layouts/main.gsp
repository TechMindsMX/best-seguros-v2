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
          <i class="fa fa-bars"></i> Menu
        </button>
        <div class="navbar-brand">
          <a href="index.html"></a>
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
            <a class="active" href="#">
              <i class="fa fa-dashboard"></i> Dashboard
            </a>
          </li>

          <li class="panel">
            <a href="javascript:;" data-parent="#side" data-toggle="collapse" class="accordion-toggle" data-target="#pages">
              <i class="fa fa-files-o"></i> Pages <i class="fa fa-caret-down"></i>
            </a>
          </li>

        </ul>
      </div>
    </nav>

    <g:layoutBody/>
    <div class="footer" role="contentinfo"></div>
    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
  </body>
</html>
