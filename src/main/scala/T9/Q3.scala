package T9

import java.time.temporal.TemporalAmount

object Q3 {
  class Account(accNo:String, InitialBalance :Double){
    var balance:Double= InitialBalance;
    var accountNo: String =accNo;

    def getBalance(): Double = {
      balance;
    }

    def getaccNo(): String = {
      accountNo;
    }

    def Deposit(amount :Double): Unit = {
      require(amount>0,"Deposit amount should be positive value");
      balance+=amount;
      println(s"You Deposit $amount of Rupees to $accNo account");
    }

    def Withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdraw amount should be positive value");
      if(amount<=balance){
        balance -= amount;
        println(s"You Withdrawal $amount of Rupees from $accNo account");
      }else{
        println("Your account has not enough money");
      }
    }

    def Transfer(amount: Double, transferAccount :Account): Unit = {
      require(amount > 0, "Withdraw amount should be positive value");
      if (amount <= balance) {
        balance -= amount;
        transferAccount.Deposit(amount);
        println(s"You Transfer $amount of Rupees from $accNo account to ${transferAccount.getaccNo()} account");
      } else {
        println("Your account has not enough money");
      }
    }
  }

  def main(args:Array[String]): Unit = {
    val account1=new Account("1234",2000);
    val account2=new Account("4321",3000);

    account1.Deposit(8000);
    println(s"Balance of ${account1.getaccNo()} :" +account1.getBalance()+"\n");

    account1.Withdraw(2000);
    println(s"Balance of ${account1.getaccNo()} :" +account1.getBalance()+"\n");

    account1.Transfer(3000,account2);
    println(s"Balance of ${account1.getaccNo()} :" +account1.getBalance());
    println(s"Balance of ${account2.getaccNo()} :" +account2.getBalance());
  }

}
