package org.example.domain.activity.model.aggregates;



import lombok.Data;
import org.example.domain.activity.model.vo.ActivityVO;
import org.example.domain.activity.model.vo.AwardVO;
import org.example.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @description: 活动配置聚合信息
*/
@Data
public class ActivityConfigRich {

    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }

}
