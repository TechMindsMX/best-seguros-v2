<div class="form-group">
  <label for="name" class="col-sm-4 control-label">${label}</label>

  <div class="col-sm-8">
    <input type="text" class="form-control ${property}" id="${property}" name="${bean.class.simpleName[0].toLowerCase()}${bean.class.simpleName[1..-1]}.${property}"
     maxlength="${maxlength ?: 100}" value="${value}" ${required ? "required" : ""} autocomplete="off"/>
  </div>
</div>
