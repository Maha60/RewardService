package org.example.Controller;


import org.example.Service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping("/{customerId}")
    public Map<String, Integer> getMonthlyRewards(@PathVariable String customerId) {
        return rewardsService.calculateMonthlyRewards(customerId);
    }

    @GetMapping("/{customerId}/total")
    public int getTotalRewards(@PathVariable String customerId) {
        return rewardsService.calculateTotalRewards(customerId);
    }
}
