public class Bank {
    float balance;
    float interest;
    float interest_rate;

    public Bank(float interest_rate){
        this.interest_rate=interest_rate;
    }

    public void interestcal(float balance) {
        this.balance=balance;
        interest = balance*interest_rate;
        System.out.println("Bank interest rate is "+interest_rate);
        System.out.println("Your Balance is "+balance);
        System.out.println("Your interest = " +interest);
        System.out.println(" ");
    }

}
