package org.example.Controller;


import org.example.Model.CustomerReward;
import org.example.Model.Transaction;
import org.example.Service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping
    public List<CustomerReward> getRewards() {
        return rewardsService.calculateRewards();
    }



}
