databaseChangeLog = {

  changeSet(author: "egjimenezg (generated)", id: "1448312098453-1") {
    createTable(tableName: "insurance") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insurancePK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "code", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "contact", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "country", type: "VARCHAR(150)") {
        constraints(nullable: "false")
      }

      column(name: "fiscal_address", type: "VARCHAR(150)") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(150)") {
        constraints(nullable: "false")
      }

      column(name: "phone", type: "VARCHAR(20)") {
        constraints(nullable: "false")
      }

      column(name: "rfc", type: "VARCHAR(50)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "egjimenezg (generated)", id: "1448312098453-2") {
    addUniqueConstraint(columnNames: "rfc", constraintName: "UC_INSURANCERFC_COL", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "insurance")
  }
}
