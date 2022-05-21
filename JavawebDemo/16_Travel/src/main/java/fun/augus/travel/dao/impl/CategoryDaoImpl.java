package fun.augus.travel.dao.impl;

import fun.augus.travel.dao.CategoryDao;
import fun.augus.travel.domain.Category;
import fun.augus.travel.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author Summerday
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        List<Category> list = Collections.emptyList();
        try{
            String sql = "select * from tab_category";
            list = template.query(sql,new BeanPropertyRowMapper<>(Category.class));
        }catch (Exception e){
        }
        return list;
    }
}
