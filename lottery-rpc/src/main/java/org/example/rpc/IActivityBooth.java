package org.example.rpc;


import org.example.rpc.req.ActivityReq;
import org.example.rpc.req.DrawReq;
import org.example.rpc.req.QuantificationDrawReq;
import org.example.rpc.res.ActivityRes;
import org.example.rpc.res.DrawRes;

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
