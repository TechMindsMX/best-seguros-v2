databaseChangeLog = {
  changeSet(author: "makingdevs (generated)", id: "1451501344802-2") {
    dropNotNullConstraint(columnDataType: "varchar(15)", columnName: "rfc", tableName: "insured")
  }
}
