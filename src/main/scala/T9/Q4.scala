package T9

object Q4 {
  class Account(accNo: String, initialBalance: Double) {
    var balance: Double = initialBalance;
    var accountNo: String = accNo;

    def getBalance(): Double = balance;
    def getAccountNo(): String = accountNo;

    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount should be a positive value");
      balance += amount;
      println(s"You deposited $amount Rupees to $accountNo account");
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdraw amount should be a positive value");
      if (amount <= balance) {
        balance -= amount;
        println(s"You withdrew $amount Rupees from $accountNo account");
      } else {
        println("Your account does not have enough money");
      }
    }

    def transfer(amount: Double, transferAccount: Account): Unit = {
      require(amount > 0, "Transfer amount should be a positive value");
      if (amount <= balance) {
        balance -= amount;
        transferAccount.deposit(amount);
        println(s"You transferred $amount Rupees from $accountNo account to ${transferAccount.getAccountNo()} account");
      } else {
        println("Your account does not have enough money");
      }
    }

    def applyInterest(): Unit = {
      if (balance > 0) {
        balance += balance * 0.05;
      } else {
        balance += balance * 0.1;
      }
    }

    override def toString: String = s"Account No: $accountNo, Balance: $balance"
  }

  class Bank {
    var accountList: List[Account] = List();

    def addAccount(account: Account): Unit = {
      accountList = account :: accountList;
    }

    def negativeBalanceAccount(): List[Account] = {
      accountList.filter(_.getBalance() < 0);
    }

    def sumOfAllAccounts(): Double = {
      accountList.map(_.getBalance()).sum;
    }

    def applyInterestToAllAccounts(): Unit = {
      accountList.foreach(_.applyInterest());
    }
  }

  def main(args: Array[String]): Unit = {
    val bank = new Bank();

    val account1 = new Account("acc1", 1000);
    val account2 = new Account("acc2", -500);
    val account3 = new Account("acc3", 200);

    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);

    val negativeBalanceAccounts = bank.negativeBalanceAccount();
    println("Negative balance Accounts:");
    negativeBalanceAccounts.foreach(account => println(account));

    val totalBalance = bank.sumOfAllAccounts();
    println(s"Total balance of all accounts: $totalBalance");
  }
}
