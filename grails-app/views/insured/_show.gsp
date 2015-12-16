<div class="row list-group-item">
  <div class="col-lg-12">
    <div class="row">
      <div class="col-lg-1">
        <label>Nombre</label>
      </div>
      <div class="col-lg-4">
       ${insured?.name} ${insured.lastName} ${insured.motherLastName}
      </div>
      <div class="col-lg-3 text-left" >
        <label>Fecha de Nacimiento</label>
      </div>
      <div class="col-lg-3 text-left">
        ${formatDate(format:'dd/MM/yyyy',date:insured.birthDate)}
      </div>
    </div>

    <div class="row">
      <div class="col-lg-1">
        <label>Teléfono</label>
      </div>
      <div class="col-lg-3 text-left">
        ${insured?.phone}
      </div>
      <div class="col-lg-1">
        <label>RFC</label>
      </div>
      <div class="col-lg-3">
        ${insured?.rfc}
      </div>
      <div class="col-lg-1">
        <label>Correo</label>
      </div>
      <div class="col-lg-3">
        ${insured?.email}
      </div>
    </div>

    <div class="row">
      <div class="col-lg-1">
        <label>Dirección</label>
      </div>
      <div class="col-lg-3">
        ${insured?.address}
      </div>
    </div>
  </div>
</div>
