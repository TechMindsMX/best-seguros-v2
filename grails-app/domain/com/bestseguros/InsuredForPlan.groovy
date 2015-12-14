package com.bestseguros

class InsuredForPlan {
  
  InsuredType insured;

  Date dateCreated
  Date lastUpdated
  
  static belongsTo = [plan:Plan]

  static constraints = {
  }

}
