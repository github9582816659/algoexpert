package com.algoexpert.practice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
@Slf4j
public class TwoSumService {

    // Takes O(n^2) time | O(1) space
    public String findTargetSolution1(Integer[] numbers, Integer targetNumber) {
        log.info("Service Solution1 --> Numbers & Target {} {}", numbers, targetNumber);
        for (int i = 0; i < numbers.length; i++) {
            Integer firstNo = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                Integer secondNo = numbers[j];
                if ((firstNo + secondNo) == targetNumber) {
                    if (!(firstNo == secondNo)) {
                        log.info("Two No are {} {}", firstNo, secondNo);
                        return "{" + firstNo + ", " + secondNo + "}";
                    }
                }
            }
        }
        return null;
    }

    // Takes O(n) time | O(n) space
    public String findTargetSolution2(Integer[] numbers, Integer targetNumber) {
        log.info("Service Solution2 --> Numbers & Target {} {}", numbers, targetNumber);
        HashMap<Integer, Boolean> map = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            int y = targetNumber - numbers[i];
            if (map.containsKey(y)) {
                log.info("No's are {} {}", numbers[i], y);
                return "{" + numbers[i] + ", " + y + "}";
            }
            map.put(numbers[i], true);
        }
        return null;
    }

    // Takes O(nlog(n)) time | O(1) space
    public String findTargetSolution3(Integer[] numbers, Integer targetNumber) {
        log.info("Service Solution3 --> Numbers & Target {} {}", numbers, targetNumber);
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == targetNumber) {
                log.info("No's are {} {}", numbers[left], numbers[right]);
                return "{" + numbers[left] + ", " + numbers[right] + "}";
            } else if (sum < targetNumber) {
                left += 1;
            } else if (sum > targetNumber) {
                right -= 1;
            }
        }
        return null;
    }
}
