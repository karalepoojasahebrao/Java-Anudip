package com.Interface.demo;

/*We have an abstract class BankAccount with a protected balance field, a constructor that initializes the balance with the initialBalance, and two abstract methods: deposit(double amount) and withdraw(double amount). 
 * There's also a concrete method getBalance() to retrieve the current balance.
 * We create a subclass SavingsAccount that extends BankAccount. This subclass has an additional private field interestRate and a constructor that sets both the initial balance and the interest rate.
 * The deposit(double amount) method checks if the deposit amount is positive, adds it to the balance, and applies interest using the applyInterest() method. 
 * The withdraw(double amount) method checks if the withdrawal amount is positive and if the balance is sufficient before subtracting the amount and applying interest.
 * In the SavingsAccount class, there's a private method applyInterest() that calculates and applies interest to the balance.
 * Another subclass, CurrentAccount, is created, also extending BankAccount. This subclass has a private field overdraftLimit and a constructor that sets both the initial balance and the overdraft limit. 
 * The deposit(double amount) method checks if the deposit amount is positive and adds it to the balance. 
 * The withdraw(double amount) method checks if the withdrawal amount is positive and if the balance plus the overdraft limit is sufficient before subtracting the amount.
 * The Main class is created with a main(String[] args) method where we perform operations with the created accounts:
 * We create a SavingsAccount object savingsAccount with an initial balance of $1000 and an interest rate of 5%.
 * We deposit $500 into the savingsAccount, resulting in a balance of $1500. Interest is applied, increasing the balance to $1575.
 * We withdraw $200 from the savingsAccount, resulting in a balance of $1375. Interest is applied again, increasing the balance to $1443.75.
 * The program prints "Savings Account Balance: $1443.75".
 * We create a CurrentAccount object currentAccount with an initial balance of $2000 and a $500 overdraft limit.
 * We deposit $1000 into the currentAccount, resulting in a balance of $3000.
 * We attempt to withdraw $2500, which is allowed because the balance plus the overdraft limit is greater than the withdrawal amount. The withdrawal succeeds, and the balance becomes -$500 (overdraft limit utilized).
 * The program prints "Current Account Balance: $-500.0".
 * */

//Abstract BankAccount class
abstract class BankAccount {
 protected double balance;

 public BankAccount(double initialBalance) {
     balance = initialBalance;
 }

 public abstract void deposit(double amount);

 public abstract void withdraw(double amount);

 public double getBalance() {
     return balance;
 }
}

//SavingsAccount subclass
class SavingsAccount extends BankAccount {
 private double interestRate;

 public SavingsAccount(double initialBalance, double interestRate) {
     super(initialBalance);
     this.interestRate = interestRate;
 }

 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         applyInterest();
     }
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         applyInterest();
     }
 }

 private void applyInterest() {
     balance += balance * interestRate;
 }
}

//CurrentAccount subclass
class CurrentAccount extends BankAccount {
 private double overdraftLimit;

 public CurrentAccount(double initialBalance, double overdraftLimit) {
     super(initialBalance);
     this.overdraftLimit = overdraftLimit;
 }

 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
     }
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && balance + overdraftLimit >= amount) {
         balance -= amount;
     }
 }
}

public class BankMain {
 public static void main(String[] args) {
     // Create a SavingsAccount with an initial balance of $1000 and 5% interest rate
     SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
     savingsAccount.deposit(500);
     savingsAccount.withdraw(200);
     System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());

     // Create a CurrentAccount with an initial balance of $2000 and a $500 overdraft limit
     CurrentAccount currentAccount = new CurrentAccount(2000, 500);
     currentAccount.deposit(1000);
     currentAccount.withdraw(2500);
     System.out.println("Current Account Balance: $" + currentAccount.getBalance());
 }
}

