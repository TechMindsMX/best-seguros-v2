databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1449527177819-1") {
    addColumn(tableName: "plan") {
      column(name: "maximum_insureds_number", type: "integer") {
        constraints(nullable: "false")
      }
    }
  }
}
