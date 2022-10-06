package cn.sichu.hrms.service;

import cn.sichu.hrms.mapper.NationMapper;
import cn.sichu.hrms.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sichu
 * @date 2022/10/05
 **/
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
