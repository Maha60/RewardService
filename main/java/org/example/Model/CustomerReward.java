package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class CustomerReward {

    private String customerId;
    private String customerName;
    private List<MonthlyReward> monthlyRewards;
    private int totalPoints;


    public CustomerReward( String customerId, String customerName, List<MonthlyReward> monthlyRewards,int totalPoints) {
        this.monthlyRewards = monthlyRewards;
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPoints = totalPoints;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<MonthlyReward> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(List<MonthlyReward> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
