package Service.impl;

import Domain.Account;
import Repository.AccountRepository;
import Service.BankService;
import java.util.UUID;
public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository=new AccountRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId= UUID.randomUUID().toString();
        //CHANGE LATER=10+1=AC11;
        //String accountNumber=UUID.randomUUID().toString();
        int tem=accountRepository.findAll().size()+1;
        String accountNumber=String.format("AC%06D"+tem);

        Account a=new Account(accountNumber, customerId, (double) 0, accountType);
        //SAVE
        accountRepository.save(a);
        return accountNumber;
    }
}
