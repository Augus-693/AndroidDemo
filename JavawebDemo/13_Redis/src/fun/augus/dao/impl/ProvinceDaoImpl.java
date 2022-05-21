package fun.augus.dao.impl;

import fun.augus.dao.ProvinceDao;
import fun.augus.domain.Province;
import fun.augus.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.dao.impl
 * @FileName: ProvinceDaoImpl
 * @date 2021年11月29日 16:30
 * @version: 1.0
 */


public class ProvinceDaoImpl implements ProvinceDao {

    //声明成员变量 JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //定义SQL
        String sql = "select * from province";
        //执行SQL
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
