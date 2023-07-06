public class Bank {
     float deposit;
     float interest;
     float interest_rate;


    public Bank(float interest_rate){
        this.interest_rate=interest_rate;
    }


    public void interestcal(float deposit) {
        this.deposit=deposit;
        interest = deposit*interest_rate;
        System.out.println("Bank interest rate is "+interest_rate);
        System.out.println("Your Balance is "+deposit);
        System.out.println("Your interest = " +interest);
        System.out.println("  ");
    }


}