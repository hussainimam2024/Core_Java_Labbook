package org.example.Labbook2;

public class Account_Q1 {
    static class Account_Person {
        private String name;
        private float age;
        private int accNumber;
        private long balance;
        private String accHolder;
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

        public String getAccHolder() {
            return accHolder;
        }

        public void setAccHolder(String accHolder) {
            this.accHolder = accHolder;
        }

        public void deposit(long amount) {
            // Use getter and setter for balance update
            long currentBalance = getBalance();
            setBalance(currentBalance + amount);
            System.out.println(amount + " INR deposited to " + name + "'s account.");
        }

        public void withdraw(long amount) {
            // Use getter to retrieve balance and setter to update it
            long currentBalance = getBalance();
            if (currentBalance - amount >= 500) {
                setBalance(currentBalance - amount);
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

    public static void main(String[] args) {
        Account_Person smith = new Account_Person("Smith", 20, 2000);
        Account_Person kathy = new Account_Person("Kathy", 23, 3000);

        smith.deposit(2000);
        kathy.withdraw(2000);

        System.out.println("Updated Account Details:");
        System.out.println(smith);
        System.out.println(kathy);
        System.out.println("Smith's balance: " + smith.getBalance() + " INR");
        System.out.println("Kathy's balance: " + kathy.getBalance() + " INR");
    }
}
