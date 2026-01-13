package app;
import Service.BankService;
import Service.impl.BankServiceImpl;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Console Bank");
        BankService bankService=new  BankServiceImpl();
        boolean running=true;
        while (running){
            Scanner sc=new Scanner(System.in);
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Account Statement
                6) List Account
                7) Search Account by Customer Name
                0) Exist
                """);
            System.out.print("CHOOSE: ");
            String choice=sc.nextLine().trim();
            System.out.print("Choose:- "+choice);
            switch (choice){
                case "1"-> openAccount(sc, bankService);
                case "2"->deposite(sc);
                case "3"->withdraw(sc);
                case "4"->transfer(sc);
                case "5"->accountStatement(sc);
                case "6"->listAccount(sc);
                case "7"->searchAccount(sc);
                case "0"->running=false;
            }

        }

    }

    private static void openAccount(Scanner sc,BankService bankService) {
        System.out.println("Customer Name: ");
        String name=sc.nextLine().trim();
        System.out.println("Customer Email: ");
        String email=sc.nextLine().trim();
        System.out.println("Account Type (SAVING/CURRENT): ");
        String accountType=sc.nextLine().trim();
        System.out.println("Initial Deposit (optional,blank for 0): ");
        String amountStr=sc.nextLine().trim();
        Double initial= Double.valueOf(amountStr);
        bankService.openAccount(name,email,accountType);

    }

    private static void deposite(Scanner sc) {
    }

    private static void withdraw(Scanner sc) {
    }

    private static void transfer(Scanner sc) {
    }

    private static void accountStatement(Scanner sc) {
    }

    private static void listAccount(Scanner sc) {
    }

    private static void searchAccount(Scanner sc) {
    }
}
