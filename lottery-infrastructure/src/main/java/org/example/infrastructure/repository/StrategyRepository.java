package org.example.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.domain.strategy.model.aggregates.StrategyRich;
import org.example.domain.strategy.model.vo.AwardBriefVO;
import org.example.domain.strategy.model.vo.StrategyBriefVO;
import org.example.domain.strategy.model.vo.StrategyDetailBriefVO;
import org.example.domain.strategy.respository.IStrategyRepository;
import org.example.infrastructure.dao.IAwardDao;
import org.example.infrastructure.dao.IStrategyDao;
import org.example.infrastructure.dao.IStrategyDetailDao;
import org.example.infrastructure.po.Award;
import org.example.infrastructure.po.Strategy;
import org.example.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        QueryWrapper<Strategy> strategyQueryWrapper = new QueryWrapper<>();
        strategyQueryWrapper.eq("strategyId", strategyId);
        Strategy strategy = strategyDao.selectOne(strategyQueryWrapper);
        QueryWrapper<StrategyDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("strategyId", strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.selectList(queryWrapper);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy,strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOs = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetails) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOs.add(strategyDetailBriefVO);
        }

        StrategyRich strategyRich = new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOs);
        return strategyRich;
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        QueryWrapper<Award> qw = new QueryWrapper<>();
        qw.eq("award_id", awardId);
        Award award = awardDao.selectOne(qw);
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        BeanUtils.copyProperties(award, awardBriefVO);

        return awardBriefVO;
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {

        QueryWrapper<StrategyDetail> qw = new QueryWrapper<>();
        qw.eq("strategyId", strategyId).le("awardSurplusCount",0);
        List<StrategyDetail> strategyDetails = strategyDetailDao.selectList(qw);

        List<String> awards = strategyDetails.stream().map(StrategyDetail::getAwardId).collect(Collectors.toList());
        return awards;
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId(awardId);

        int count = strategyDetailDao.deductStock(strategyDetail);
        return count == 1;
    }


}
