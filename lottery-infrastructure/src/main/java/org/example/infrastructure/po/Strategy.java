package org.example.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 策略配置
 */
@TableName(value = "strategy")
@Data
public class Strategy {

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
     *策略描述
     */
    private String strategyDesc;
    /**
     *策略方式「1:单项概率、2:总体概率」
     */
    private int strategyMode;
    /**
     *发放奖品方式「1:即时、2:定时[含活动结束]、3:人工」
     */
    private int grantType;
    /**
     * 发放奖品时间
     */
    private Date grantDate;
    /**
     * 扩展信息
     */
    private String extInfo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
