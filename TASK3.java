import java.util.Scanner;

//EXCEPTION TO CHECK FOR INSUFFICIENT BALANCE

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}

//BANK ACCOUNT CLASS

class BankAccount {
    long accno;
    String name;
    int balance;
}

//MAIN CLASS

public class TASK3 extends BankAccount{
    Scanner sc = new Scanner(System.in);
    
    //METHOD TO GET ACCOUNT DETAILS TO STORE IN BACKEND
    
    void getAccount(){
        System.out.println("Enter Account Number : ");
        accno = sc.nextLong();
        System.out.println("Enter Account Name : ");
        sc.next();
        name = sc.nextLine();
        System.out.println("Enter Account Balance : ");
        balance = sc.nextInt();
    }
    
    //METHOD TO DISPLAY ACCOUNT DETAILS IN INTERFACE
    
    void displayAccount(){
        System.out.println("ACC.No\t\tName\tBalance\n");
        System.out.format("%d\t%s\t%d\n",accno,name,balance);
    }
    
    //METHOD TO CHECK ACCOUNT NUMBER INPUT FROM USER
    
    void insertCard(){
        System.out.println("Enter Account Number : \n");
        long inpaccno = sc.nextLong();
        if(inpaccno == accno){
            System.out.println("Access Granted!!");
        }
        else{
            System.out.println("Access Denied!! Try Again");
        }
    }
    
    //METHOD TO DEPOSIT CASH IN ACCOUNT
    
    void deposit(){
        System.out.println("Enter the Amount to deposit : ");
        int dep = sc.nextInt();
        balance += dep;
        System.out.println("Cash Deposited!!");
        System.out.println("Current Balance : Rs."+balance);
    }
    
    //METHOD TO WITHDRAW CASH FROM ACCOUNT
    
    void withdraw(){
        System.out.println("Enter the Amount to withdraw : ");
        int wit = sc.nextInt();
        try{
        if(balance - wit < 0){
            throw new InsufficientBalanceException("Insufficient Balance!!");
        }
        else{
        balance -= wit;
        System.out.println("Cash Withdrawed!!");
        }
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Current Balance : Rs."+balance);
    }
    public static void main(String[] args) {
        int g = 0,ch;
        Scanner sc = new Scanner(System.in);
        //MAIN CLASS OBJECT
        TASK3 b = new TASK3();
        //BACKEND DATA COLLECTION
        System.out.println("***BACKEND***\n");
        b.getAccount();
        System.out.format("Menu\n1.Insert Card\n2.Withdraw\n3.Deposit\n4.display Account details\n");
        do{
            System.out.println("Enter Choice : ");
            ch = sc.nextInt();
            //SWITCH CASE FOR OPTION SELECTION
            switch(ch){
                case 1:
                b.insertCard();
                break;
                case 2:
                b.withdraw();                
                break;
                case 3:
                b.deposit();
                break;
                case 4:
                b.displayAccount();
                break;
                default : System.out.println("Invalid choice!!");
                break;
            }
            System.err.println("Do you want to continue(YES(1)/NO(0)): ");
            g = sc.nextInt();
        }while(g == 1);
    }
}
