package org.example.Service;


import org.example.Exception.CustomerNotFoundException;
import org.example.Model.Customer;
import org.example.Model.Transaction;
import org.example.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RewardsService {

    private final TransactionRepository transactionRepository;

    public RewardsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Map<String, Integer> calculateMonthlyRewards(String customerId) {
        Customer customer = transactionRepository.findCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }

        Map<String, Integer> monthlyRewards = new HashMap<>();
        for (Transaction transaction : customer.getTransactions()) {
            String month = transaction.getDate().getMonth().toString();
            int points = calculatePoints(transaction.getAmount());
            monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + points);
        }

        return monthlyRewards;
    }

    public int calculateTotalRewards(String customerId) {
        return calculateMonthlyRewards(customerId).values().stream().mapToInt(Integer::intValue).sum();
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }
}
