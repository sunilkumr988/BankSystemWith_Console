package Service;

import Domain.Account;

import java.util.List;

public interface BankService {
    String openAccount(String name,String email,String accountType);
    List<Account> listAccount();

    void Deposit(String accountNumber, Double amount, String note);
}
