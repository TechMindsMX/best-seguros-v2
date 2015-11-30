<g:form class="form-horizontal" action="save" >
  <div class="form-group">
    <label class="col-lg-2 control-label" for="product">Aseguradora</label>
    <div class="col-lg-5">
      <g:select class="form-control" from="${insurances}" name="product" optionKey="id" optionValue="name" ></g:select>
    </div>
  </div>

  <fieldset class="buttons">
    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
  </fieldset>
</g:form>
