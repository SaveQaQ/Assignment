package BankAccount;

public class BankAccount{
	//instance variable
	private String accountName;
	private double balance;
	private double withdrawalFee;
	private double annualInterestRate;
	private static int numberOfID=1000000;
	private int ID;
	boolean isOverDrawn;
	
	//constructors
	public BankAccount(String accountName, double balance,double withdrawalFee,double annualInterestRate) {
		this(accountName,balance);
		this.withdrawalFee=withdrawalFee;
		this.annualInterestRate=annualInterestRate;
	}
	
	public BankAccount(String accountName, double balance) {
		this(accountName);
		this.balance=balance;
	}
	
	public BankAccount(String accountName) {
		this.accountName=accountName;
		this.ID=numberOfID;
		numberOfID++;
	}

	//accessors
	public String getAccountName() {
		if (accountName.length()<10) {
		return this.accountName;
	}
		else {
		return accountName.substring(0,20);
	}
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getWithdrawalFee() {
		return this.withdrawalFee;
	}
	
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public int getAccountID() {
		return ID;
	}
	
	public boolean isOverDrawn() {
		if (balance<=0) {
			isOverDrawn=true;
			return isOverDrawn;
		}
		else {
			isOverDrawn=false;
			return isOverDrawn;
		}
	}
	
	public static int getNextAccountID() {
		return numberOfID;
	}
	
	public static int getNumberOfID() {
		return numberOfID;
	}
	
	//mutators
	public void setWithdrawalFee(double setWithdrawalFee) {
		this.withdrawalFee=setWithdrawalFee;
	}
	
	public void setAnnualInterestRate(double setAnnualInterestRate) {
		this.annualInterestRate=setAnnualInterestRate;
	}
	
	public void addAnnualInterest() {
		if (isOverDrawn==false && balance>=0) {
			this.balance=balance+annualInterestRate*balance/100;
	}
		else {
			this.balance=balance*1;
		}
	}
	
	public void deposit(double deposit) {
		this.balance=balance+deposit;
	}
	
	public void withdraw(double withdraw) {
		this.balance=balance-withdraw-withdrawalFee;
	}
	
	public String toString() {
	    if (balance<0) {
	    	return String.format("BankAccount: name = '%s'; balance = ($%.2f)",accountName,Math.abs(balance));
	    }
		else {
			return String.format("BankAccount: name = '%s'; balance = $%.2f",accountName,balance);
	}
	}
}