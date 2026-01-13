package Domain;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String accountNumber;
    private Type type;
    private Double amount;
    private LocalDateTime timestamp;
    private String note;

    public Transaction(String id, String accountNumber, Type type, Double amount, LocalDateTime timestamp, String note) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.note = note;
    }
}
