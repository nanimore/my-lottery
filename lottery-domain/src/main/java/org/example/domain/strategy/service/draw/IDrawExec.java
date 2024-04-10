package org.example.domain.strategy.service.draw;


import org.example.domain.strategy.model.req.DrawReq;
import org.example.domain.strategy.model.res.DrawResult;

public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);

}
