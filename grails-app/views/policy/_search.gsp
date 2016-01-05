<div class="row">
  <div class="col-lg-12">
    <div class="page-title">
      <h1>Búsqueda de Pólizas</h1>
    </div>
  </div>
</div>
    
<div class="row">
  <div class="col-lg-12">
    <div class="portlet portlet-default">
      <div class="portlet-body">
        <div class="row">
          <div class="col-lg-6 form-horizontal">
            <div class="form-group">
              <label for="insurance" class="col-lg-3 control-label">Aseguradora</label>
              <div class="col-lg-9">
                <select name="insurance" class="form-control">
                  <option value>--Seleccionar--</option>
                  {{#each insurances}}
                  <option value="{{id}}">{{name}}</option> 
                  {{/each}}
                </select> 
              </div>
            </div> <!--ENDOF FORM-GROUP -->
          </div>  
        </div>
      </div>
    </div>
  </div><!--ENDOF ROW COL-LG-12 -->
</div><!--ENDOF ROW-->
