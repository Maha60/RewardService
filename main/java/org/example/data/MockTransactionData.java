package org.example.data;

import org.example.Model.Transaction;

import java.time.LocalDate;
import java.util.List;

public class MockTransactionData {
    public static List<Transaction> getTransactions() {
        return List.of(
                new Transaction("C001", "Alice", LocalDate.of(2025, 3, 15), 120),
                new Transaction("C001", "Alice", LocalDate.of(2025, 3, 20), 75),
                new Transaction("C001", "Alice", LocalDate.of(2025, 4, 10), 200),
                new Transaction("C002", "Bob", LocalDate.of(2025, 3, 5), 50),
                new Transaction("C002", "Bob", LocalDate.of(2025, 4, 25), 110),
                new Transaction("C002", "Bob", LocalDate.of(2025, 5, 5), 130),
                new Transaction("C003", "Charlie", LocalDate.of(2025, 5, 15), 45)
        );
    }
}
