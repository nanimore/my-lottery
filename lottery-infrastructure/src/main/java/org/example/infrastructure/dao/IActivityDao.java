package org.example.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.activity.model.vo.AlterStateVO;
import org.example.infrastructure.po.Activity;




public interface IActivityDao extends BaseMapper<Activity> {


   Activity queryActivityById(Long activityId);

   int alterState(AlterStateVO alterStateVO);

}
