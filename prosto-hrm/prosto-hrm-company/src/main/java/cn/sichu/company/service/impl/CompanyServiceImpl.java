package cn.sichu.company.service.impl;

import cn.sichu.common.utils.IdWorker;
import cn.sichu.company.dao.CompanyDao;
import cn.sichu.company.service.CompanyService;
import cn.sichu.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/03
 **/
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加用户
     * id varchar
     * audit_state varchar 审核状态, 0: 未审核, 1: 已审核
     * state tinyint 状态 默认值1, 0: 未激活, 1: 已激活
     *
     * @param company Company
     */
    @Override
    public void add(Company company) {
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setAuditState("0");
        company.setState(1);
        companyDao.save(company);
    }

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return Company
     */
    @Override
    public Company findById(String id) {
        return companyDao.findById(id).orElse(null);
    }

    /**
     * 查询用户列表
     *
     * @return List<Company></>
     */
    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    /**
     * 更新用户
     *
     * @param company Company
     */
    @Override
    public void update(Company company) {
        companyDao.save(company);
    }

    /**
     * 根据id删除用户
     *
     * @param id id
     */
    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }
}
