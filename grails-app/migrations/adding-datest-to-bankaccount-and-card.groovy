databaseChangeLog = {

  changeSet(author: "makingdevs (generated)", id: "1452800319774-1") {
    addColumn(tableName: "bank_account") {
      column(name: "date_created", type: "datetime") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452800319774-2") {
    addColumn(tableName: "card") {
      column(name: "date_created", type: "datetime") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452800319774-3") {
    addColumn(tableName: "bank_account") {
      column(name: "last_updated", type: "datetime") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452800319774-4") {
    addColumn(tableName: "card") {
      column(name: "last_updated", type: "datetime") {
        constraints(nullable: "false")
      }
    }
  }

  changeSet(author: "makingdevs (generated)", id: "1452800319774-5") {
    addColumn(tableName: "card") {
      column(name: "periodicity", type: "varchar(255)") {
        constraints(nullable: "false")
      }
    }
  }
}
