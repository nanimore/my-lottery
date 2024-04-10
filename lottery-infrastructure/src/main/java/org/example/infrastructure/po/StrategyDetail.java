package org.example.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 策略明细
 * @TableName strategy_detail
 */
@TableName(value ="strategy_detail")
@Data
public class StrategyDetail implements Serializable {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品描述
     */
    private String awardDesc;

    /**
     * 奖品库存
     */
    private Integer awardCount;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StrategyDetail other = (StrategyDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStrategyId() == null ? other.getStrategyId() == null : this.getStrategyId().equals(other.getStrategyId()))
            && (this.getAwardId() == null ? other.getAwardId() == null : this.getAwardId().equals(other.getAwardId()))
            && (this.getAwardDesc() == null ? other.getAwardDesc() == null : this.getAwardDesc().equals(other.getAwardDesc()))
            && (this.getAwardCount() == null ? other.getAwardCount() == null : this.getAwardCount().equals(other.getAwardCount()))
            && (this.getAwardSurplusCount() == null ? other.getAwardSurplusCount() == null : this.getAwardSurplusCount().equals(other.getAwardSurplusCount()))
            && (this.getAwardRate() == null ? other.getAwardRate() == null : this.getAwardRate().equals(other.getAwardRate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStrategyId() == null) ? 0 : getStrategyId().hashCode());
        result = prime * result + ((getAwardId() == null) ? 0 : getAwardId().hashCode());
        result = prime * result + ((getAwardDesc() == null) ? 0 : getAwardDesc().hashCode());
        result = prime * result + ((getAwardCount() == null) ? 0 : getAwardCount().hashCode());
        result = prime * result + ((getAwardSurplusCount() == null) ? 0 : getAwardSurplusCount().hashCode());
        result = prime * result + ((getAwardRate() == null) ? 0 : getAwardRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", strategyId=").append(strategyId);
        sb.append(", awardId=").append(awardId);
        sb.append(", awardDesc=").append(awardDesc);
        sb.append(", awardCount=").append(awardCount);
        sb.append(", awardSurplusCount=").append(awardSurplusCount);
        sb.append(", awardRate=").append(awardRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}