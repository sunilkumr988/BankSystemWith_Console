package Repository;
import Domain.Account;
import Service.impl.BankServiceImpl;

import java.util.*;

public class AccountRepository {
    static Map<String, Account> accountByNumber=new HashMap<>();

    public static Optional<Account> findByNumber(String accountNumber) {
        return Optional.ofNullable(accountByNumber.get(accountNumber));

    }

    public void save(Account account){
        accountByNumber.put(account.getAccountNumber(),account);
    }
    public static List<Account> findAll() {
        return new ArrayList<>(accountByNumber.values());
    }
}
