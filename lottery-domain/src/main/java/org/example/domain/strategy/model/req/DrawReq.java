package org.example.domain.strategy.model.req;

import lombok.Data;

@Data
public class DrawReq {



    private String uId;
    private Long strategyId;
    /**
     * 防重ID
     */
    private String uuid;

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }

    public DrawReq() {

    }
    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }
}
