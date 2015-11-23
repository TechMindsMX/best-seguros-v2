databaseChangeLog = {

  changeSet(author: "egjimenezg (generated)", id: "1448321560897-3") {
    createTable(tableName: "coverage") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "coveragePK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "code", type: "VARCHAR(255)")

        column(name: "name", type: "VARCHAR(255)")
    }
  }

  changeSet(author: "egjimenezg (generated)", id: "1448321560897-4") {
    createTable(tableName: "sponsor") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "sponsorPK")
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

      column(name: "rfc", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "egjimenezg (generated)", id: "1448321560897-5") {
    addUniqueConstraint(columnNames: "rfc", constraintName: "UC_SPONSORRFC_COL", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "sponsor")
  }
}
