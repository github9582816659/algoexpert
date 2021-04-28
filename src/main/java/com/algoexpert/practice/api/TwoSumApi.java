package com.algoexpert.practice.api;

import com.algoexpert.practice.model.TwoSum;
import com.algoexpert.practice.service.TwoSumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two-sum")
@Slf4j
public class TwoSumApi {

    private final TwoSumService twoSumService;

    public TwoSumApi(TwoSumService twoSumService) {
        this.twoSumService = twoSumService;
    }

    @PostMapping("/solution1")
    public String twoSum(@RequestBody TwoSum twoSum) {
        log.info("API --> Numbers & Target {} {}", twoSum.getNumbers(), twoSum.getTargetNumber());
        Integer []nums = new Integer[twoSum.getNumbers().size()];
        Integer[] numbers = twoSum.getNumbers().toArray(nums);
        return twoSumService.findTargetSolution1(numbers, twoSum.getTargetNumber());
    }

    @PostMapping("/solution2")
    public String twoSum2(@RequestBody TwoSum twoSum) {
        log.info("API --> Numbers & Target {} {}", twoSum.getNumbers(), twoSum.getTargetNumber());
        Integer []nums = new Integer[twoSum.getNumbers().size()];
        Integer[] numbers = twoSum.getNumbers().toArray(nums);
        return twoSumService.findTargetSolution2(numbers, twoSum.getTargetNumber());
    }

    @PostMapping("/solution3")
    public String twoSum3(@RequestBody TwoSum twoSum) {
        log.info("API --> Numbers & Target {} {}", twoSum.getNumbers(), twoSum.getTargetNumber());
        Integer []nums = new Integer[twoSum.getNumbers().size()];
        Integer[] numbers = twoSum.getNumbers().toArray(nums);
        return twoSumService.findTargetSolution3(numbers, twoSum.getTargetNumber());
    }
}
