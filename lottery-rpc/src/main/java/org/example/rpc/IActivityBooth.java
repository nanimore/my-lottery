package org.example.rpc;


import org.example.rpc.req.ActivityReq;
import org.example.rpc.res.ActivityRes;

/**

 *
 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);

}
