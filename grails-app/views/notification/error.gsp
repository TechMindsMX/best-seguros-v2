<%@ page contentType="text/html"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Información de la póliza</title>
  <style type="text/css">
    table{
      border: solid 1px;
    }

    table th{
      background:#585858 !important;
    }
  </style>
</head>
<body>
  <div class="container">
    <h3>Hubo un error al procesar la póliza con la siguiente información.</h3>

    <table style="border:solid 1px;">
      <thead>
        <tr style="background:#F2F2F2;">
          <td><strong>Tipo de asegurado</strong></td>
          <td><strong>Nombre</strong></td>
          <td><strong>Apellido Materno</strong></td>
          <td><strong>Apellido Paterno</strong></td>
          <td><strong>Fecha de Nacimiento</strong></td>
          <td><strong>Teléfono</strong></td>
          <td><strong>RFC</strong></td>
          <td><strong>Correo</strong></td>
          <td><strong>Dirección</strong></td>
        </tr>
      </thead>
      <tbody>
        <g:each var="insured" in="${insureds}">
        <tr>
          <td>${insured?.insuredType?.value ?: "SIN VALOR"}</td>
          <td>${insured?.name ?: "SIN VALOR"}</td>
          <td>${insured?.lastName ?: "SIN VALOR"}</td>
          <td>${insured?.motherLastName ?: "SIN VALOR"}</td>
          <td><g:formatDate format="yyyy-MM-dd" date="${insured?.birthDate}" /></td>
          <td>${insured?.phone ?: "SIN VALOR"}</td>
          <td>${insured?.rfc ?: "SIN VALOR"}</td>
          <td>${insured?.email ?: "SIN VALOR"}</td>
          <td>${insured?.address ?: "SIN VALOR"}</td>
        </tr>
        </g:each>
      </tbody>
    </table>
  </div>
</body>
</html>
