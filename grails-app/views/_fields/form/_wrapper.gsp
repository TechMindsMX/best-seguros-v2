<div class="form-group">
  <label for="name" class="col-sm-3 control-label">${label}</label>
  <div class="col-sm-5">
    <input type="text" class="col-sm-9 form-control" id="${label}" name="${bean.class.simpleName[0].toLowerCase()}${bean.class.simpleName[1..-1]}.${property}" maxlength="100" value="${value}" />
  </div>
</div>
