databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1453132170321-1") {
    addColumn(tableName: "policy") {
      column(name: "file_name", type: "varchar(255)") {
        constraints(nullable: "false")
      }
    }
  }

}
