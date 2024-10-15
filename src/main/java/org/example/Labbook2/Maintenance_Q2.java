package org.example.Labbook2;

public class Maintenance_Q2 {
    static class Account_Person {
        private String name;
        private float age;
        private int accNumber;
        private long balance;
        private static int accCounter = 1000;

        public Account_Person(String name, float age, long balance) {
            this.name = name;
            this.age = age;
            this.accNumber = accCounter++;
            this.balance = balance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getAge() {
            return age;
        }

        public void setAge(float age) {
            this.age = age;
        }

        public int getAccNumber() {
            return accNumber;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public void deposit(long amount) {
            setBalance(getBalance() + amount);
            System.out.println(amount + " INR deposited to " + name + "'s account.");
        }
        public void withdraw(long amount) {
            if (getBalance() - amount >= 500) {
                setBalance(getBalance() - amount);
                System.out.println(amount + " INR withdrawn from " + name + "'s account.");
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        }
        @Override
        public String toString() {
            return "Account_Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", accNumber=" + accNumber +
                    ", balance=" + balance +
                    '}';
        }
    }
    static class SavingsAccount extends Account_Person {
        private final long minimumBalance = 1000;

        public SavingsAccount(String name, float age, long balance) {
            super(name, age, balance);
        }
        @Override
        public void withdraw(long amount) {
            if (getBalance() - amount >= minimumBalance) {
                setBalance(getBalance() - amount);
                System.out.println(amount + " INR withdrawn from Savings account.");
            } else {
                System.out.println("Insufficient balance. Minimum balance of " + minimumBalance + " INR must be maintained.");
            }
        }
    }
    static class CurrentAccount extends Account_Person {
        private long overdraftLimit = 5000;

        public CurrentAccount(String name, float age, long balance) {
            super(name, age, balance);
        }

        @Override
        public void withdraw(long amount) {
            if (getBalance() - amount >= -overdraftLimit) {
                setBalance(getBalance() - amount);
                System.out.println(amount + " INR withdrawn from Current account.");
            } else {
                System.out.println("Overdraft limit of " + overdraftLimit + " INR reached. Cannot withdraw.");
            }
        }
    }

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount("Smith", 20, 2000);
        savings.deposit(1000);
        savings.withdraw(1500);
        System.out.println("Savings Account Balance: " + savings.getBalance() + " INR");

        CurrentAccount current = new CurrentAccount("Kathy", 23, 3000);
        current.deposit(2000);
        current.withdraw(7000); // Test overdraft
        System.out.println("Current Account Balance: " + current.getBalance() + " INR");
    }
}
