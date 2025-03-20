package LN;

public class ATM {
	private int balance;
	private int pin;
	
	public ATM(int balance, int pin) {
		this.balance=balance;
		this.pin=pin;
	}
	
	public void DisplayMenu() {
		System.out.println("1.Check Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Change Pin");
		System.out.println("5.Exit");
	}
	
	public void Deposit(int amount) {
		balance+=amount;
	}
	
	public void Withdraw(int amount) {
		if(balance<amount) {
			System.out.println("Insufficient Balance!");
			return;
		}
		balance-=amount;
	}
	
	public int Displaybalance() {
		return balance;
	}
	
	public boolean validatePin(int pin) {
		return this.pin==pin;
	}
	
	public void changePin(int newPin) {
		pin=newPin;
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM(1000,1234);
		System.out.println("Enter the pin:");
		int pin = Integer.parseInt(System.console().readLine()); 
		if(atm.validatePin(pin)) {
			int option=0;
			while(option!=5) {
				atm.DisplayMenu();
				option = Integer.parseInt(System.console().readLine());
				switch(option) {
				case 1:
					System.out.println("Balance:"+atm.Displaybalance());
					break;
				case 2:
						System.out.println("Enter amount to deposit:");
						int amount = Integer.parseInt(System.console().readLine());
						atm.Deposit(amount);
					break;
				case 3:
						System.out.println("Enter amout to withdraw:");
						amount = Integer.parseInt(System.console().readLine());
						atm.Withdraw(amount);
					break;
				case 4:
						System.out.println("Enter new pin:");
						int newpin =  Integer.parseInt(System.console().readLine());
						atm.changePin(newpin);
					break;
				case 5: 
						System.out.println("Thank You, Visit again!");
					break;
					default:
						System.out.println("Choose the right option!");
						break;
				}
			}
		}
		else {
			System.out.println("You have entered invalid pin!");
		}
	}
}
