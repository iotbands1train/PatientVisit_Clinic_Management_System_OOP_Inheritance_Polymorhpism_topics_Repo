package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The Funds class represents the financial information of a person,
 * including bank ID, salary, and current balance.
 */
public class Funds {
    private Long bankID;
    private Float salary;
    private Float currentBalance;

    /**
     * Default constructor for Funds class.
     * Initializes bank ID, salary, and current balance with random values.
     */
    public Funds() {
        super();
        this.bankID = Math.abs(MyRandomPersonData.random(955_111_111, 956_999_999));
        this.salary = (float) Math.abs(MyRandomPersonData.random(55_000, 175_000));
        this.currentBalance = (float) Math.abs(MyRandomPersonData.random(0_001, 1_244));
    }

    /**
     * Parameterized constructor for Funds class.
     *
     * @param bankID         The bank ID associated with the funds.
     * @param salary         The salary associated with the funds.
     * @param currentBalance The current balance associated with the funds.
     */
    public Funds(Long bankID, Float salary, Float currentBalance) {
        super();
        this.bankID = bankID;
        this.salary = salary;
        this.currentBalance = currentBalance;
    }

    /**
     * Get the bank ID.
     *
     * @return The bank ID.
     */
    public Long getBankID() {
        return bankID;
    }

    /**
     * Set the bank ID.
     *
     * @param bankID The bank ID to set.
     */
    public void setBankID(Long bankID) {
        this.bankID = bankID;
    }

    /**
     * Get the salary.
     *
     * @return The salary.
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * Set the salary.
     *
     * @param salary The salary to set.
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }

    /**
     * Get the current balance.
     *
     * @return The current balance.
     */
    public Float getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Set the current balance.
     *
     * @param currentBalance The current balance to set.
     */
    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Format a given float value into currency format.
     *
     * @param c The float value to format.
     * @return The formatted currency string.
     */
    public String currencies(Float c) {
        String x = "";
        x = String.format("$ %.2f", c);
        if (c > 999)
            x = String.format("$%,.2f", Float.parseFloat(x));
        System.out.println(x);
        return x;
    }

    /**
     * Get the formatted current balance in currency format.
     *
     * @return The formatted current balance.
     */
    public String showCurrentBalance() {
        String x = "";
        x = String.format("$ %.2f", currentBalance);
        if (currentBalance > 999)
            x = String.format("$ %,.2f", currentBalance);
        return x;
    }

    /**
     * Get the formatted salary in currency format (private method).
     *
     * @return The formatted salary.
     */
    private String showSalary() {
        return String.format("$ %,.2f", salary);
    }

    /**
     * Convert the Funds object to a string representation.
     *
     * @return The string representation of Funds.
     */
    @Override
    public String toString() {
        return "Funds [bankID = (" + bankID + "), salary = (" + showSalary() + "), currentBalance = (" + showCurrentBalance() + ")]";
    }
}
