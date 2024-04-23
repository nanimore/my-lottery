package org.example.rpc.activity.booth.res;



import org.example.common.Result;
import org.example.rpc.activity.booth.dto.AwardDTO;

import java.io.Serializable;

/**
 * @description: 抽奖结果
*/
public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

}
