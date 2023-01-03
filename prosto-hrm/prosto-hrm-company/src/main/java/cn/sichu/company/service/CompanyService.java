package cn.sichu.company.service;

import cn.sichu.domain.company.Company;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/03
 **/
public interface CompanyService {
    /**
     * 添加用户
     *
     * @param company Company
     */
    void add(Company company);

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return Company
     */
    Company findById(String id);

    /**
     * 查询用户列表
     *
     * @return List<Company></>
     */
    List<Company> findAll();

    /**
     * 更新用户
     *
     * @param company Company
     */
    void update(Company company);

    /**
     * 根据id删除用户
     *
     * @param id id
     */
    void deleteById(String id);
}
