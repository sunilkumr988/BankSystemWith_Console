package Repository;

import Domain.Account;
import Service.impl.BankServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AccountRepository {
    Map<String, Account> accountByNumber=new HashMap<>();
    public void save(Account account){
        accountByNumber.put(account.getAccountNumber(),account);
    }
    public List<Account> findAll() {
        return new ArrayList<>(accountByNumber.values());
    }
}
