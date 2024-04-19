package org.example.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.activity.model.vo.AlterStateVO;
import org.example.infrastructure.po.Activity;

import java.util.List;


@Mapper
public interface IActivityDao extends BaseMapper<Activity> {


   Activity queryActivityById(Long activityId);

   int alterState(AlterStateVO alterStateVO);

   /**
    * 扣减活动库存
    * @param activityId 活动ID
    * @return 更新数量
    */
   int subtractionActivityStock(Long activityId);


   /**
    * 扫描待处理的活动列表，状态为：通过、活动中
    *
    * @param id ID
    * @return 待处理的活动集合
    */
   List<Activity> scanToDoActivityList(Long id);

}
