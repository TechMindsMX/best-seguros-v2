databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1449092096827-1") {
    addColumn(tableName: "insured_sum_per_coverage_per_insured") {
      column(name: "plan_id", type: "bigint") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-2") {
    addColumn(tableName: "plan") {
      column(name: "product_id", type: "bigint") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-3") {
    addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "plan", constraintName: "FK_b25xldn383p4en85bmeonj0oq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-4") {
    addForeignKeyConstraint(baseColumnNames: "plan_id", baseTableName: "insured_sum_per_coverage_per_insured", constraintName: "FK_h7yfwn0jhbjkknf0bvh8ohucc", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-5") {
    dropForeignKeyConstraint(baseTableName: "product_plan", constraintName: "FK_aufv9aco9nchrawodisuhtbt5")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-6") {
    dropForeignKeyConstraint(baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_fu5kbn2sncthmo52oxfs5qvn0")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-7") {
    dropForeignKeyConstraint(baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_sc6bk80uk3dh6alj5vfk5elim")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-8") {
    dropForeignKeyConstraint(baseTableName: "product_plan", constraintName: "FK_t3nrkjr6q47l3n2d39t7188wh")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-9") {
    dropTable(tableName: "plan_insured_sum_per_coverage_per_insured")
  }

  changeSet(author: "makingdevs (generated)", id: "1449092096827-10") {
    dropTable(tableName: "product_plan")
  }
}
