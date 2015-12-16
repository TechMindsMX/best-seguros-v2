<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style>
      .col-print-1 {width:8%;  float:left;}
      .col-print-2 {width:16%; float:left;}
      .col-print-3 {width:25%; float:left;}
      .col-print-4 {width:33%; float:left;}
      .col-print-5 {width:42%; float:left;}
      .col-print-6 {width:50%; float:left;}
      .col-print-7 {width:58%; float:left;}
      .col-print-8 {width:66%; float:left;}
      .col-print-9 {width:75%; float:left;}
      .col-print-10{width:83%; float:left;}
      .col-print-11{width:92%; float:left;}
      .col-print-12{width:100%; float:left;}

      .row{
        margin-left:0px !important;
        margin-right:0px !important;
      }

      div.header{
        background: #A4A4A4 !important;
        text-align:center;
        padding: 5px 0px 0px 0px !important;
        border: solid 1px #000000 !important;
      }

      div.right{
        margin-left:10px;
      }

      div.labelDiv{
        padding-left:5px !important;
      }

      div.body{
        border-style: solid;
        border-width: 0px 1px 1px 1px !important;
      }

      span.dataLabel{
        padding-left:5px;
        font-weight: bold;
      }

      span.leftSpan{
        padding-left:5px;
      }

      body{
        font-family: Arial !important;
        font-size:12px !important;
        -fs-pdf-font-encoding: UTF-8 !important;
      }

      @page {  margin: 0.2in; }
    </style>
    <link rel="stylesheet" href="${grailsApplication.config.grails.serverUrl}/assets/third_party/bootstrap/dist/css/bootstrap.css?compile=false" />
  </head>
  <body>
    <div class="row">
      <div class="col-print-5">
        <img src="${grailsApplication.config.grails.serverUrl}/assets/pan_american.png" height="110" width="300"/>
      </div>
      <div class="col-print-6">
        <div class="row-fluid" >
          <h5>PÓLIZA DE SEGUROS DE ${policyDetail?.productName?.toUpperCase()}</h5>
        </div>

        <div class="row">
          <div class="col-print-12 header"><b>Contratante</b></div>
        </div>
        <div class="row">
          <div class="col-print-12 body">
            <div class="col-print-6">
              <span class="dataLabel">Nombre:</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.name}</div>

            <div class="col-print-6">
              <span class="dataLabel">Calle y número:</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.address}</div>

            <div class="col-print-6">
              <span class="dataLabel">Colonia:</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.colony}</div>

            <div class="col-print-6">
              <span class="dataLabel">Delegación o municipio</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.town}</div>

            <div class="col-print-6">
              <span class="dataLabel">Entidad federativa</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.state}</div>

            <div class="col-print-6">
              <span class="dataLabel">C.P.</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.cp}</div>

            <div class="col-print-6">
              <span class="dataLabel">R.F.C.</span>
            </div>
            <div class="col-print-6 text-left">${policyDetail?.contractingParty?.rfc}</div>

          </div>
        </div>

      </div>
    </div>

    <div class="row">
      <div class="col-print-11">
        <p>Pan-American México, Compañia de Seguros, S.A. de C.V., en adelante la "Compañia", de conformidad con el presente contacto,
      sus alcances y limitaciones, pagará la indemnización que proceda si es que ocurre alguno de los siguientes eventos amparados
      siempre que la póliza correspondiente se encuentre vigente al momento de ocurrir el Evento.</p>
      </div>
    </div>


    <div class="row">
      <div class="col-print-5">
        <div class="row">
          <div class="col-print-12 header"><b>Datos de la Póliza</b></div>
        </div>
        <div class="row">
          <div class="col-print-12 body">
            <div class="col-print-6">
              <span class="dataLabel">No. de Póliza</span>
            </div>
            <div class="col-print-6">${policyDetail?.policyNumber}</div>

            <div class="col-print-6">
              <span class="dataLabel">Fecha de Emisión:</span>
            </div>
            <div class="col-print-6">
              <g:formatDate format="dd/MM/yyyy" date="${policyDetail?.dateCreated}"/>
            </div>

            <div class="col-print-6">
              <span class="dataLabel">Forma de Pago:</span>
            </div>
            <div class="col-print-6">${policyDetail?.periodicity}</div>

            <div class="col-print-6">
              <span class="dataLabel">Moneda:</span>
            </div>
            <div class="col-print-6">${policyDetail?.coin}</div>
          </div>
        </div>
      </div><!--ENDOF FIRST-COLUMN -->


      <div class="col-print-6 right">
        <div class="row">
          <div class="col-print-12 header"><b>Datos de Control</b></div>
        </div>

        <div class="row">
          <div class="col-print-12 body">
            <div class="col-print-6">
              <span class="dataLabel">Producto</span>
            </div>
            <div class="col-print-6">${policyDetail?.productName}</div>
          </div>
        </div>
      </div>

    </div>

    <div class="row" style="margin-top:10px;">
      <div class="col-print-11">
        <div class="row header">
          <div class="col-print-4">
            <b>BENEFICIOS</b>
          </div>

          <div class="col-print-2">
            <b>SUMA ASEGURADA</b>
          </div>

          <div class="col-print-2">
            <b>DEDUCIBLE</b>
          </div>

          <div class="col-print-2">
            <b>PERIODO DE ESPERA</b>
          </div>

          <div class="col-print-2">
            <b>LÍMITE DE COBERTURA</b>
          </div>
        </div>

        <div class="row body">
          <g:each var="benefit" in="${policyDetail.benefits}">
            <div class="col-print-4 labelDiv" >
              <b>${benefit.coverage.name} para dependiente ${benefit.insured.value}.</b>
            </div>
            <div class="col-print-2 text-center">
              <b><g:formatNumber number="${benefit.insuredSum}" type="currency" /></b>
            </div>
            <div class="col-print-2 text-center">
              No Aplica
            </div>
           <div class="col-print-2 text-center">
              -
            </div>
           <div class="col-print-2 text-center">
              -
            </div>

          </g:each>
        </div>

      </div>
    </div>

    <div class="row">
      <div class="col-print-11">
        <div class="row header">
          <div class="col-print-12"><b>Asegurados</b></div>
        </div>

        <div class="row header">
          <div class="col-print-6"><b>Nombre</b></div>
          <div class="col-print-3"><b>Parentesco</b></div>
          <div class="col-print-3"><b>Fecha de Nacimiento</b></div>
        </div>

        <div class="row body">
          <g:each var="insured" in="${policyDetail.insureds}">
            <div class="col-print-6">
              <span class="leftSpan">${insured?.name} ${insured?.lastName} ${insured?.motherLastName}</span>
            </div>
            <div class="col-print-3 text-center">${insured?.insuredType.value} </div>
            <div class="col-print-3 text-center">
              <g:formatDate format="dd/MM/yyyy" date="${insured?.birthDate}"/>
            </div>
          </g:each>
        </div>

        <div class="row header">
          <div class="col-print-6">
            <p></p>
          </div>
          <div class="col-print-6">
            <div class="row">
              <div class="col-print-8 text-right">Prima neta anual</div>
              <div class="col-print-4 text-right">
                <g:formatNumber number="${policyDetail?.monthlyInsuranceCost * 12}" type="currency" />
              </div>
            </div>
            <div class="row">
              <div class="col-print-8 text-right">Prima mensual a pagar</div>
              <div class="col-print-4 text-right">
                <g:formatNumber number="${policyDetail?.monthlyInsuranceCost}" type="currency" />
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <div class="row">
      <div class="col-print-11 text-justify">
        <p>Si el contenido de esta Póliza o sus modificaciones no concordaren con la oferta, el Contratante podrá pedir la rectificación correspondiente dentro de los treinta días que sigan al día en que reciba la Póliza. Transcurrido este plazo se considerarán aceptadas las estipulaciones de la Póliza o de sus modificaciones</p>
      </div>
    </div>

    <div class="row">
      <div class="col-print-11 text-center">
        <div class="row">
          <div class="col-print-12">
            <b>México, D.F. a</b>
          </div>
        </div>

        <div class="row" style="margin-top:80px;">
          <div class="col-print-5">
            <p></p>
          </div>
          <div class="col-print-7">
            <hr style="border-top: 1px solid #000 !important;"></hr>
            <p>Pan-American México, Compañía de Seguros, S.A. de C.V.</p>
          </div>
        </div>
      </div>
    </div>


    <div class="row">
      <div class="col-print-11 text-justify">
        <p>Para atención al asegurado: Centro de Contacto D.F. [*] en un horario de [*].
Para acceso a la unidad especializada de la compañía: Centro de Contacto D.F. (52 55) 50472504 y larga distancia sin costo: 01800 212 5598 de lunes a jueves de 9:00 a 17:00 horas y viernes de 9:00 a 14:00 horas, correo electrónico: une@palig.com
Y en nuestras oficinas ubicadas en Av. Paseo de la Reforma 412, Suite 1501, Col. Juárez, C.P. 06600, México D.F.  de lunes a viernes de 9 a 17 horas.
El detalle de los beneficios, sus limitaciones y exclusiones se pueden consultar en las condiciones generales disponibles en nuestra  página web. : www.palig.com/mexico</p>
      </div>
    </div>

  </body>
</html>
