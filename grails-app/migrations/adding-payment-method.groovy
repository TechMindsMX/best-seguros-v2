databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1452276858076-1") {
    createTable(tableName: "bank_account") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "bank_accountPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "account_number", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "bank_id", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "payment_type", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "periodicity", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452276858076-2") {
    createTable(tableName: "card") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "cardPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "card_number", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "card_provider", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "payment_type", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452276858076-3") {
    createTable(tableName: "payment") {
      column(autoIncrement: "true", name: "id", type: "BIGINT") {
        constraints(primaryKey: "true", primaryKeyName: "paymentPK")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "payment_method_ref", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "type", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452276858076-4") {
    addColumn(tableName: "policy") {
      column(name: "payment_id", type: "bigint")
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452276858076-5") {
    addForeignKeyConstraint(baseColumnNames: "bank_id", baseTableName: "bank_account", constraintName: "FK_1beuure46p9prb5c5fi27nbt6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "bank")
  }

  changeSet(author: "makingdevs (generated)", id: "1452276858076-6") {
    addForeignKeyConstraint(baseColumnNames: "payment_id", baseTableName: "policy", constraintName: "FK_ecj75ky47yixpw0d1vhemnygm", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "payment")
  }

}
