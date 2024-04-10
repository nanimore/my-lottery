package org.example.domain.strategy.service.draw;

import org.example.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.example.domain.strategy.service.algorithm.impl.DefaultRateRandomDrawAlgorithm;
import org.example.domain.strategy.service.algorithm.impl.SingleRateRandomDrawAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DrawConfig {

    @Resource
    private DefaultRateRandomDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private SingleRateRandomDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new HashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }
}
