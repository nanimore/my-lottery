package org.example.domain.strategy.model.req;

import lombok.Data;

@Data
public class DrawReq {

    public DrawReq() {

    }
    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    private String uId;
    private Long strategyId;
}
