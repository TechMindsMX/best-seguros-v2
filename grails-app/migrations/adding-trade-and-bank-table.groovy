databaseChangeLog = {

  changeSet(author: "egjimenezg (generated)", id: "1448379296555-1") {
    createTable(tableName: "bank") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "bankPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "code", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(250)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "egjimenezg (generated)", id: "1448379296555-5") {
    createTable(tableName: "trade") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "tradePK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

}
