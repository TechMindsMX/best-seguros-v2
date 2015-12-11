<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
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

      th.header{
        text-align:center;
        background-color:#848484 !important;
      }

      table.bordered{
        border: #000000 solid 1px;
      }
    </style>
  </head>
  <body>
    <div class="row-fluid">
      <div class="col-print-5">
        <p>Imagen</p>
      </div>
      <div class="col-print-7">
        <div class="row-fluid" >
          <h5>PÓLIZA DE SEGUROS DE</h5>
        </div>
        <div class="row-fluid">
          <table class="table bordered">
            <tr>
              <th colspan="2" class="header" style="text-align:center;">
                Contratante
              </th>
            </tr>
            <tr>
              <td>
                <strong>Nombre:</strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.name}
              </td>
            </tr>
            <tr>
              <td>
                <strong>Calle y número:</strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.address}
              </td>
            </tr>
            <tr>
              <td>
                <strong>
                  Colonia:
                </strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.colony}
              </td>
            </tr>
            <tr>
              <td>
                <strong>Delegación o municipio</strong>
              </td>
              <td>
                XXXXXXXXXXXXXXXXXXXXX
              </td>
            </tr>
            <tr>
              <td>
                <strong>
                  Entidad federativa
                </strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.state}
              </td>
            </tr>
            <tr>
              <td>
                <strong>
                  C.P.
                </strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.cp}
              </td>
            </tr>
            <tr>
              <td>
                <strong>R.F.C.</strong>
              </td>
              <td>
                ${policyDetail?.contractingParty?.rfc}
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>

    <div class="row-fluid">
      <p>Pan-American México, Compañia de Seguros, S.A. de C.V., en adelante la "Compañia", de conformidad con el presente contacto,
      sus alcances y limitaciones, pagará la indemnización que proceda si es que ocurre alguno de los siguientes eventos amparados
      siempre que la póliza correspondiente se encuentre vigente al momento de ocurrir el Evento.</p>
    </div>


    <div class="row-fluid">
      <div class="col-print-6">
        <table class="table bordered">
          <thead>
            <tr>
              <th colspan="2" class="header">
                Datos de la Póliza
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <strong>No. Póliza</strong>
              </td>
              <td>
                ${policyDetail?.policyNumber}
              </td>
            </tr>
            <tr></tr>
          </tbody>
        </table>
      </div>

      <div class="col-print-6">

      </div>
    </div>

  </body>
</html>
