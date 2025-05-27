import org.example.Service.RewardsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceTest {


    private RewardsService rewardService;



    @Test
    void testCalculatePoints() {
        rewardService = new RewardsService();
        // Directly testing the reward calculation logic
        assertEquals(25, rewardService.CalculatePoints(75));  // 1x25
        assertEquals(0, rewardService.CalculatePoints(50));   // no points
        assertEquals(0, rewardService.CalculatePoints(30));   // no points
        assertEquals(250, rewardService.CalculatePoints(200)); // 2x100 + 1x50
      //  assertEquals("Transacion amount cannot be negative", rewardService.CalculatePoints(-120.00)); // 2x20 + 1x50
      //negative test case scenario commented as of now
    }




}

