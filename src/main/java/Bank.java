/**
 * Implement a bank class.
 * <p>
 * In this lab we will model a bank. We have two classes: Bank and BankAccount. You should finish
 * both classes, by fixing checkstyle errors, defining constructors, getters and setters, and
 * accessing private variables.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
public class Bank {

    /** The name of the bank. */
    private String bankName;

    /**
     * Declares a new bank under the default name: "Illini Bank".
     */
    public Bank() {
        bankName = "Illini Bank";
    }

    /**
     * @return the bank name
     */
    public String getName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     *
     * @param name the name to set
     */
    public void setName(final String name) {
        bankName = name;
    }

    /**
     * Withdraw money from an account.
     * <p>
     * Subtracts the amount of money from bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to withdraw money from.
     * @param amount to withdraw (double)
     * @return boolean
     */
    public boolean withdrawMoney(final BankAccount bankAccount, final double amount) {
        if (bankAccount.getBalance() < amount) {
            return false;
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            return true;
        }
    }

    /**
     * Deposit money in an account.
     * <p>
     * Adds the amount of money to bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to deposit money to.
     * @param amount to deposit
     * @return boolean
     */
    public boolean depositMoney(final BankAccount bankAccount, final double amount) {
        // If for some godawful reason this is true something is very wrong.
        if (Double.MAX_VALUE - bankAccount.getBalance() < amount) {
            return false;
        } else {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            return true;
        }
    }

    /**
     * Transfer money from one account to another.
     * <p>
     * Transfer the amount of money from one back account to another. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param source bank account to transfer money from.
     * @param destination bank account to transfer money to.
     * @param amount to transfer
     * @return boolean
     */
    public boolean transferMoney(final BankAccount source, final BankAccount destination,
            final double amount) {
        if (withdrawMoney(source, amount)) {
            if (depositMoney(destination, amount)) {
                return true;
            } else {
                depositMoney(source, amount);
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Change back account owner name.
     *
     * @param bankAccount to change
     * @param name new name to set
     */
    public void changeOwnerName(final BankAccount bankAccount, final String name) {
        bankAccount.setName(name);
    }

    /** the total number of bank accounts. */
    private static int totalAccounts = 0;

    /**
     * Uses static variable to get number of bank accounts opened.
     *
     * @return the total number of accounts
     */
    public static int getNumberOfAccounts() {
        return totalAccounts;
    }

    /**
     * Main method for testing.
     *
     * @param unused unused input arguments
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused) {
        Bank bank = new Bank();
        System.out.println("Welcome to " + bank.bankName);
        System.out.println("We are excited to have you banking with us!\n\n");

        // Create Bank Accounts
        BankAccount account1 = new BankAccount("John Doe", BankAccount.BankAccountType.CHECKINGS);
        totalAccounts++;
        System.out.println("Bank account for John Doe created");

        BankAccount account2 = new BankAccount("Jony Ive", BankAccount.BankAccountType.STUDENT);
        totalAccounts++;
        System.out.println("Bank account for Johy Ive created\n\n");

        // Deposit money to both accounts and print new balance
        bank.depositMoney(account1, 1000.0);
        System.out.println("account1: " + account1.getBalance());
        bank.depositMoney(account2, 5000.0);
        System.out.println("account2: " + account2.getBalance());

        // Withdraw money from Account 2 and print new balance
        bank.withdrawMoney(account2, 200.0);
        System.out.println("account2: " + account2.getBalance());

        // Transfer money from Account 2 to Account 1 and print new balances
        bank.transferMoney(account2, account1, 350.0);
        System.out.println("account2: " + account2.getBalance());
        System.out.println("account1: " + account1.getBalance());

        // Print number of accounts
        System.out.print("Number of active accounts at " + bank.bankName + " are ");
        System.out.println(Bank.totalAccounts);
    }
}
