package Service.impl;
import Domain.Account;
import Domain.Transaction;
import Domain.Type;
import Repository.AccountRepository;
import Repository.TransactionRepository;
import Service.BankService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository=new AccountRepository();
    private final TransactionRepository transactionRepository=new  TransactionRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId= UUID.randomUUID().toString();
        //CHANGE LATER=10+1=AC11;
        //String accountNumber=UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account a=new Account(accountNumber, customerId, (double) 0, accountType);
        //SAVE
        accountRepository.save(a);
        return accountNumber;
    }

    @Override
    public List<Account> listAccount() {
        return AccountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void Deposit(String accountNumber, Double amount, String note) {
        Account account=AccountRepository.findByNumber(accountNumber)
                .orElseThrow(()->new RuntimeException("Account Not Found"+ accountNumber));
        account.setBalance(account.getBalance() + amount);
        Transaction transaction=new Transaction(account.getAccountNumber(),amount,UUID.randomUUID().toString()
                ,note, LocalDateTime.now(), Type.DEPOSIT);
        transactionRepository.add(transaction);

    }

    private String getAccountNumber() {
        int size=accountRepository.findAll().size()+1;
        String accountNumber = String.format("AC%06d", size);
        return accountNumber;
    }
}
