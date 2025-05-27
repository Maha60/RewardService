package org.example.Model;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

     private String customerId;
     private String customerName;
     private LocalDate date;
     private double amount;

     public Transaction(String customerId, String customerName, LocalDate date, double amount) {
          this.date = date;
          this.customerId = customerId;
          this.customerName = customerName;
          this.amount = amount;
     }

     public String getCustomerId() {
          return customerId;
     }

     public String getCustomerName() {
          return customerName;
     }

     public LocalDate getDate() {
          return date;
     }

     public double getAmount() {
          return  amount;
     }
}
