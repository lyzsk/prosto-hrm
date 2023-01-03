package cn.sichu.company.controller;

import cn.sichu.common.api.Result;
import cn.sichu.company.service.CompanyService;
import cn.sichu.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/03
 **/
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 添加用户
     *
     * @param company company 对象
     * @return Result<Company></>
     */
    @PostMapping
    public Result<Company> add(@RequestBody Company company) {
        companyService.add(company);
        return Result.success(company, "添加用户成功!");
    }

    /**
     * 根据id查询企业
     *
     * @param id company id
     * @return Result<Company></>
     */
    @GetMapping("/{id}")
    public Result<Company> findById(@PathVariable(value = "id") String id) {
        Company company = companyService.findById(id);
        return Result.success(company, "查询成功!");
    }

    /**
     * 查询所有企业列表
     *
     * @return Result<List></>
     */
    @GetMapping
    public Result<List<Company>> findAll() {
        List<Company> list = companyService.findAll();
        return Result.success(list, "查询成功!");
    }

    /**
     * 根据id更新企业信息
     *
     * @param company company
     * @return Result<Object></>
     */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable String id, @RequestBody Company company) {
        company.setId(id);
        companyService.update(company);
        return Result.success(null, "更新企业信息成功!");
    }

    /**
     * 根据id删除企业
     *
     * @param id company id
     * @return Result<Object></>
     */
    public Result<Object> delete(@PathVariable String id) {
        companyService.deleteById(id);
        return Result.success(null, "删除企业信息成功!");
    }
}
