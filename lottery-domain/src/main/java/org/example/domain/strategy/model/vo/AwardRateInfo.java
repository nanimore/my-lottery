package org.example.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardRateInfo {
    // 奖品ID
    private String awardId;

    // 中奖概率
    private BigDecimal awardRate;
}
