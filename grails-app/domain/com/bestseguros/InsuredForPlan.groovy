package com.bestseguros

class InsuredForPlan {
  
  InsuredType insured;
  
  static belongsTo = [plan:Plan]

  static constraints = {
  }

}
