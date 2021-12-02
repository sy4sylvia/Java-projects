import java.util.Formatter;

public class Account {
    private static int account_count;
    private double balance;
    private int id;

    public Account() {
        balance = 2000;
        this.id = account_count;
        account_count++;
    }
    public Account(double startingBalance) {
        this();
        this.balance = startingBalance;
    }

    public boolean withdraw(double amount) {
        if(this.balance - amount < 0) { return false; }
        else {
            this.balance -= amount;
            return true;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
