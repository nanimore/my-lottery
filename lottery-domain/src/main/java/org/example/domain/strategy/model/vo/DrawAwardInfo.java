package org.example.domain.strategy.model.vo;


public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private Long rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(Long rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}
