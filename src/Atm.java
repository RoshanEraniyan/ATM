import java.util.*;
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String errorMessage)
    {
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception{
    public InvalidAmountException(String errorMessage)
    {
        super(errorMessage);
    }
}
class Atm {
    private double balance = 2000L;
    public double getBalance(){
        return balance;
    }
    public void setBalance(double bal)
    {
        this.balance=bal;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Current balance : "+balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough balance");
        } else if (amount <= 0) {
            throw new InvalidAmountException("Enter amount greater than zero rupees");
        } else {
            balance -= amount;
            System.out.println("Remaining Amount : "+balance);
        }
    }

}
class AtmMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ENTER");
            System.out.println("1.Balance Check");
            System.out.println("2.Deposit");
            System.out.println("3.Withdrawal");
            System.out.println("4.Exit");
            int option = scanner.nextInt();
            try {
                Atm a = new Atm();
                switch (option) {
                    case 1:
                        System.out.println("Balance : " + a.getBalance());
                        break;
                    case 2:
                        System.out.println("How much do you want to deposit ?");
                        double depo = scanner.nextInt();
                        System.out.println("Money Deposited: ");
                        a.deposit(depo);
                        break;
                    case 3:
                        System.out.println("How much do you want to withdraw ?");
                        double wd = scanner.nextInt();
                        System.out.println("Money Withdrawn: ");
                        a.withdraw(wd);
                        break;

                    case 4:
                        System.out.println("Thank you,process ended");
                        System.exit(0);
                    default:
                        System.out.println("Invalid");
                }
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            } catch (InvalidAmountException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}


