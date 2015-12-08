databaseChangeLog = {

  changeSet(author: "egjimenezg (generated)", id: "1449591236256-2") {
    createTable(tableName: "insured_for_plan") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insured_for_planPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "insured", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "plan_id", type: "BIGINT") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "egjimenezg (generated)", id: "1449591236256-3") {
    addForeignKeyConstraint(baseColumnNames: "plan_id", baseTableName: "insured_for_plan", constraintName: "FK_stpbberlcmgd3dj5n0mnuoh8d", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "egjimenezg (generated)", id: "1449591236256-4") {
    dropForeignKeyConstraint(baseTableName: "plan_insureds", constraintName: "FK_sxrm89v0ddrokulqeslu7fc4s")
  }

  changeSet(author: "egjimenezg (generated)", id: "1449591236256-5") {
    dropTable(tableName: "plan_insureds")
  }

}
