package cn.sichu.hrms.service;

import cn.sichu.hrms.mapper.PoliticsstatusMapper;
import cn.sichu.hrms.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sichu
 * @date 2022/10/05
 **/
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }

}
