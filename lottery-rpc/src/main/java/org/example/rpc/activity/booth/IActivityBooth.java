package org.example.rpc.activity.booth;


import org.example.rpc.activity.booth.req.ActivityReq;
import org.example.rpc.activity.booth.res.ActivityRes;

/**

 *
 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 */
public interface IActivityBooth {

    /**
     * RPC测试
     * @param req
     * @return
     */

    ActivityRes queryActivityById(ActivityReq req);

}
