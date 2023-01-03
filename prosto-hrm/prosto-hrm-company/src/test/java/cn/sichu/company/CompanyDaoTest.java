package cn.sichu.company;

import cn.sichu.company.dao.CompanyDao;
import cn.sichu.domain.company.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author sichu
 * @date 2023/01/03
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CompanyDaoTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void test() {
        Company company1 = companyDao.findById("1").orElse(null);
        Company company2 = companyDao.findById("2").orElse(null);
        System.out.println(company1);
        System.out.println(company2);
    }
}
