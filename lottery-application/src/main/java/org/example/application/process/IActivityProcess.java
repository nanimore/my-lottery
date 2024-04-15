package org.example.application.process;


import org.example.application.process.req.DrawProcessReq;
import org.example.application.process.res.DrawProcessResult;

/**
 * @description: 活动抽奖流程编排接口
*/
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

}
