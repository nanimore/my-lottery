package org.example.domain.activity.model.req;


import lombok.Data;
import org.example.domain.activity.model.aggregates.ActivityConfigRich;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @description: 活动配置请求对象
 */
@Data
public class ActivityConfigReq {

    /** 活动ID */
    private Long activityId;

    /** 活动配置信息 */
    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }


}
