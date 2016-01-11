databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1452114864370-2") {
    addColumn(tableName: "policy") {
      column(name: "uuid", type: "varchar(255)") {
        constraints(nullable: "false")
      }
    }
  }

}
