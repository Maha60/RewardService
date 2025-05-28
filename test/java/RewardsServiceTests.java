

import org.example.Model.Customer;
import org.example.Model.Transaction;
import org.example.Repository.TransactionRepository;


import org.example.RewardApiApplication;
import org.example.Service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = RewardApiApplication.class)

public class RewardsServiceTests {

    @Autowired
    private RewardsService rewardsService;

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setup() {
        Customer customer = new Customer();
        customer.setCustomerId("CUST123");
        customer.setName("John Doe");
        customer.setTransactions(Arrays.asList(
                new Transaction("TXN1", "CUST123", LocalDate.of(2023, 3, 15), 120),
                new Transaction("TXN2", "CUST123", LocalDate.of(2023, 4, 10), 90),
                new Transaction("TXN3", "CUST123", LocalDate.of(2023, 5, 5), 150)
        ));
        transactionRepository.findCustomerById("CUST123");
    }

    @Test
    public void testCalculateMonthlyRewards() {
        assertEquals(90, rewardsService.calculateMonthlyRewards("CUST123").get("MARCH"));
        assertEquals(40, rewardsService.calculateMonthlyRewards("CUST123").get("APRIL"));
        assertEquals(150, rewardsService.calculateMonthlyRewards("CUST123").get("MAY")); // fixed
    }

    @Test
    public void testCalculateTotalRewards() {
        assertEquals(280, rewardsService.calculateTotalRewards("CUST123")); // fixed
    }

}
