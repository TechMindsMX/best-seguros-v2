databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1449161810316-1") {
    createTable(tableName: "plan_insured_sum_per_coverage_per_insured") {
      column(name: "plan_insured_sums_by_coverage_per_insured_id", type: "BIGINT")

      column(name: "insured_sum_per_coverage_per_insured_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449161810316-2") {
    addForeignKeyConstraint(baseColumnNames: "plan_insured_sums_by_coverage_per_insured_id", baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_fu5kbn2sncthmo52oxfs5qvn0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449161810316-3") {
    addForeignKeyConstraint(baseColumnNames: "insured_sum_per_coverage_per_insured_id", baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_sc6bk80uk3dh6alj5vfk5elim", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "insured_sum_per_coverage_per_insured")
  }

  changeSet(author: "makingdevs (generated)", id: "1449161810316-4") {
    dropForeignKeyConstraint(baseTableName: "insured_sum_per_coverage_per_insured", constraintName: "FK_h7yfwn0jhbjkknf0bvh8ohucc")
  }

  changeSet(author: "makingdevs (generated)", id: "1449161810316-5") {
    dropColumn(columnName: "plan_id", tableName: "insured_sum_per_coverage_per_insured")
  }

}
