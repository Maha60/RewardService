package org.example.Repository;
import org.example.Model.Customer;
import org.example.Model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class TransactionRepository {

    private final Map<String, Customer> customerData = new HashMap<>();

    public TransactionRepository() {
        Customer customer = new Customer();
        customer.setCustomerId("CUST123");
        customer.setName("John Doe");

        List<Transaction> transactions = Arrays.asList(
                new Transaction("TXN1", "CUST123", LocalDate.of(2023, 3, 15), 120),
                new Transaction("TXN2", "CUST123", LocalDate.of(2023, 4, 10), 90),
                new Transaction("TXN3", "CUST123", LocalDate.of(2023, 5, 5), 150)
        );

        customer.setTransactions(transactions);
        customerData.put("CUST123", customer);
    }

    public Customer findCustomerById(String customerId) {
        return customerData.get(customerId);
    }
}

