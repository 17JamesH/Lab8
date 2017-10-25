/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 8.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
public class BankAccount {

    /**
     * Different possible bank account types.
     */
    public enum BankAccountType {
        /** Checking account, for spending. */
        CHECKINGS,
        /** Savings account, for saving money. */
        SAVINGS,
        /** Student account, for student use. */
        STUDENT,
        /** Workplace account, for work related use. */
        WORKPLACE
    }

    /** The bank account number. Does not change once initialized. */
    private int accountNumber;

    /** The bank account type. Does not change once initialized. */
    private BankAccountType accountType;

    /** The bank account balance. */
    private double accountBalance;

    /** The name of the owner of the account. */
    private String ownerName;

    /** The interest rate of the bank account. */
    private double interestRate;

    /** The interested earned in the bank account. Cannot be manually modified. */
    private double interestEarned;

    /**
     * Initializes a new BankAccount. Assigns a name and account category based on input, and
     * assigns a random integer as the bank account number. Remaining values are all initialized to
     * 0.
     *
     * @param name The name of the bank account owner
     * @param accountCategory The type of bank account
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        ownerName = name;
        accountType = accountCategory;
        accountBalance = 0;
        accountNumber = (int) (Math.random() * Integer.MAX_VALUE);
        interestEarned = 0;
        interestRate = 0;
    }

    /**
     * Returns the bank account number.
     *
     * @return the bank account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the bank account type.
     *
     * @return the bank account type
     */
    public BankAccountType getType() {
        return accountType;
    }

    /**
     * Returns the current balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return accountBalance;
    }

    /**
     * Changes the balance to a new input balance.
     *
     * @param newBalance the new balance
     */
    public void setBalance(final double newBalance) {
        accountBalance = newBalance;
    }

    /**
     * Returns the owner's name.
     *
     * @return the owner's name
     */
    public String getName() {
        return ownerName;
    }

    /**
     * Sets the name to a new name.
     *
     * @param newName the new name
     */
    public void setName(final String newName) {
        ownerName = newName;
    }

    /**
     * Returns the interest rate.
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Changes the interest rate to a new interest.
     *
     * @param newInterest the new interest rate
     */
    public void setInterestRate(final double newInterest) {
        interestRate = newInterest;
    }

    /**
     * Returns the total interest earned.
     *
     * @return the interest earned
     */
    public double getInterestEarned() {
        return interestEarned;
    }
}
