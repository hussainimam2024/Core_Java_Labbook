package org.example.Labbook2.Abstract_Q5;

import org.example.Labbook2.Account_Q1;

abstract class Account_abstract {
    static abstract class Account_Person1 {
        private String name;
        private float age;
        private int accNumber;
        private long balance;
        private String accHolder;
        private static int accCounter = 9876;

        abstract void withdraws(float amount);

        public Account_Person1(String name, float age, long balance) {
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

        @Override
        public String toString() {
            return "Account_Person{" +"name='" + name + '\'' + ", age=" + age + ", accNumber=" + accNumber + ", balance=" + balance + '}';
        }
    }
    static class Account_Person2 extends Account_Person1 {

        public Account_Person2(String name, float age, long balance) {
            super(name, age, balance);
        }

        @Override
        public void withdraws(float amount) {
            long currentBalance = getBalance();
            if (currentBalance - amount >= 500) {
                setBalance(currentBalance - (long) amount);
                System.out.println(amount + " INR withdrawn from " + getName() + "'s account.");
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        }
    }

    public static void main(String[] args) {
        Account_Person1 smith = new Account_Person2("Smith", 20, 2000);
        Account_Person1 kathy = new Account_Person2("Kathy", 23, 3000);
        kathy.withdraws(2000);
        System.out.println("Updated Account Details:");
        System.out.println(smith);
        System.out.println(kathy);
        System.out.println("Smith's balance: " + smith.getBalance() + " INR");
        System.out.println("Kathy's balance: " + kathy.getBalance() + " INR");
    }

}
