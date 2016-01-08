databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1449079480297-1") {
    createTable(tableName: "bank") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "bankPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(250)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-2") {
    createTable(tableName: "benefit") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "benefitPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-3") {
    createTable(tableName: "coverage") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "coveragePK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-4") {
    createTable(tableName: "insurance") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insurancePK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(150)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-5") {
    createTable(tableName: "insurance_cost_per_insured") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insurance_cost_per_insuredPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "insurance_cost", type: "DOUBLE precision") {
        constraints(nullable: "false")
      }

      column(name: "insured", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-6") {
    createTable(tableName: "insured") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insuredPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "address", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "birth_date", type: "datetime") {
        constraints(nullable: "false")
      }

      column(name: "city", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "colony", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "country", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "cp", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "email", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "insured_type", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "last_name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "mother_last_name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "phone", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "rfc", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "state", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "town", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-7") {
    createTable(tableName: "insured_sum_per_coverage_per_insured") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "insured_sum_per_coverage_per_insuredPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "coverage_id", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "insured", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "insured_sum", type: "DOUBLE precision") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-8") {
    createTable(tableName: "plan") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "planPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-9") {
    createTable(tableName: "plan_benefit") {
      column(name: "plan_benefits_id", type: "BIGINT")

      column(name: "benefit_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-10") {
    createTable(tableName: "plan_coverage") {
      column(name: "plan_coverages_id", type: "BIGINT")

      column(name: "coverage_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-11") {
    createTable(tableName: "plan_insured_sum_per_coverage_per_insured") {
      column(name: "plan_insured_sums_by_coverage_per_insured_id", type: "BIGINT")

      column(name: "insured_sum_per_coverage_per_insured_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-12") {
    createTable(tableName: "plan_insureds") {
      column(name: "plan_id", type: "BIGINT")

      column(name: "insured_type", type: "VARCHAR(255)")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-13") {
    createTable(tableName: "policy") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "policyPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "plan_id", type: "BIGINT")

      column(name: "policy_status", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "product_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-14") {
    createTable(tableName: "policy_insured") {
      column(name: "policy_insureds_id", type: "BIGINT")

      column(name: "insured_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-15") {
    createTable(tableName: "product") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "productPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "coin", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "country", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "insurance_id", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "iva", type: "BOOLEAN") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "periodicity", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "sponsor_id", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "trade_id", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "uuid", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-16") {
    createTable(tableName: "product_insurance_cost_per_insured") {
      column(name: "product_insurance_costs_per_insured_id", type: "BIGINT")

      column(name: "insurance_cost_per_insured_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-17") {
    createTable(tableName: "product_plan") {
      column(name: "product_plans_id", type: "BIGINT")

      column(name: "plan_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-18") {
    createTable(tableName: "product_range_age_by_beneficiary") {
      column(name: "product_ranges_age_by_beneficiary_id", type: "BIGINT")

      column(name: "range_age_by_beneficiary_id", type: "BIGINT")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-19") {
    createTable(tableName: "range_age_by_beneficiary") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "range_age_by_beneficiaryPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "insured_type", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "max_age", type: "INT") {
        constraints(nullable: "false")
      }

      column(name: "min_age", type: "INT") {
        constraints(nullable: "false")
      }

      column(name: "renewal", type: "INT") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-20") {
    createTable(tableName: "sponsor") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "sponsorPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "name", type: "VARCHAR(150)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-21") {
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

  changeSet(author: "makingdevs (generated)", id: "1449079480297-22") {
    addForeignKeyConstraint(baseColumnNames: "trade_id", baseTableName: "product", constraintName: "FK_16qgpbw0jhig7vaci1jwfu0xn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "trade")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-23") {
    addForeignKeyConstraint(baseColumnNames: "plan_benefits_id", baseTableName: "plan_benefit", constraintName: "FK_2e5ryh6ptpyqh5cv8huetypf7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-24") {
    addForeignKeyConstraint(baseColumnNames: "plan_id", baseTableName: "policy", constraintName: "FK_79mvrgwaeskye5c6qcsdlku0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-25") {
    addForeignKeyConstraint(baseColumnNames: "product_ranges_age_by_beneficiary_id", baseTableName: "product_range_age_by_beneficiary", constraintName: "FK_a97u730lbi560fexogksmo3m3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-26") {
    addForeignKeyConstraint(baseColumnNames: "benefit_id", baseTableName: "plan_benefit", constraintName: "FK_a9jp2xy4x1hoohyu0x8vuyt0t", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "benefit")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-27") {
    addForeignKeyConstraint(baseColumnNames: "plan_id", baseTableName: "product_plan", constraintName: "FK_aufv9aco9nchrawodisuhtbt5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-28") {
    addForeignKeyConstraint(baseColumnNames: "range_age_by_beneficiary_id", baseTableName: "product_range_age_by_beneficiary", constraintName: "FK_axdxfpqck0ljjynnn9nne3k19", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "range_age_by_beneficiary")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-29") {
    addForeignKeyConstraint(baseColumnNames: "insurance_id", baseTableName: "product", constraintName: "FK_c6gym2lyede1qeumkvg6c8sw2", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "insurance")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-30") {
    addForeignKeyConstraint(baseColumnNames: "plan_coverages_id", baseTableName: "plan_coverage", constraintName: "FK_e17hbw56fhb6v9ftce0qqxlil", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-31") {
    addForeignKeyConstraint(baseColumnNames: "sponsor_id", baseTableName: "product", constraintName: "FK_eiv3f2u61etxt2wgrisfutwo6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sponsor")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-32") {
    addForeignKeyConstraint(baseColumnNames: "plan_insured_sums_by_coverage_per_insured_id", baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_fu5kbn2sncthmo52oxfs5qvn0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-33") {
    addForeignKeyConstraint(baseColumnNames: "policy_insureds_id", baseTableName: "policy_insured", constraintName: "FK_ieqcsqmosx519hlhotq1qgxl4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "policy")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-34") {
    addForeignKeyConstraint(baseColumnNames: "product_insurance_costs_per_insured_id", baseTableName: "product_insurance_cost_per_insured", constraintName: "FK_lv2n37warnnqcm29it163wfou", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-35") {
    addForeignKeyConstraint(baseColumnNames: "insured_id", baseTableName: "policy_insured", constraintName: "FK_mivimobdieralfeahrb39abc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "insured")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-36") {
    addForeignKeyConstraint(baseColumnNames: "coverage_id", baseTableName: "plan_coverage", constraintName: "FK_pgik1vxt93oxu7anmgtgrrnup", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "coverage")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-37") {
    addForeignKeyConstraint(baseColumnNames: "insurance_cost_per_insured_id", baseTableName: "product_insurance_cost_per_insured", constraintName: "FK_pigcywwqtcpn6y2muxw7v3bp3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "insurance_cost_per_insured")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-38") {
    addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "policy", constraintName: "FK_q5m0pqjegvsig85t19ajqgjtb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-39") {
    addForeignKeyConstraint(baseColumnNames: "coverage_id", baseTableName: "insured_sum_per_coverage_per_insured", constraintName: "FK_r8ak7bjresgidttk1yonig6og", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "coverage")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-40") {
    addForeignKeyConstraint(baseColumnNames: "insured_sum_per_coverage_per_insured_id", baseTableName: "plan_insured_sum_per_coverage_per_insured", constraintName: "FK_sc6bk80uk3dh6alj5vfk5elim", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "insured_sum_per_coverage_per_insured")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-41") {
    addForeignKeyConstraint(baseColumnNames: "plan_id", baseTableName: "plan_insureds", constraintName: "FK_sxrm89v0ddrokulqeslu7fc4s", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "plan")
  }

  changeSet(author: "makingdevs (generated)", id: "1449079480297-42") {
    addForeignKeyConstraint(baseColumnNames: "product_plans_id", baseTableName: "product_plan", constraintName: "FK_t3nrkjr6q47l3n2d39t7188wh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
  }

  include file: 'updating-product-and-cost-per-insured-relations.groovy'
  include file: 'removing-relation-in-insured-sums-per-coverage.groovy'
  include file: 'adding-maximum-insureds-number.groovy'
  include file: 'updating-plan-insureds-relation.groovy'
  include file: 'removing-maximum-number.groovy'
  include file: 'adding-dates-to-domain-classes.groovy'
  include file: 'deleting-periodicity.groovy'
  include file: 'updating-rfc-constraint.groovy'
  include file: 'adding-uuid-to-the-policy.groovy'
    include file: 'adding-payment-method.groovy'
}
