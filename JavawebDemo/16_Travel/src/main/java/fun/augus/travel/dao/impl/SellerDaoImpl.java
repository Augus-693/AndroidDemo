package fun.augus.travel.dao.impl;

import fun.augus.travel.dao.SellerDao;
import fun.augus.travel.domain.Seller;
import fun.augus.travel.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Summerday
 */
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findBySid(int sid) {

        String sql = "select * from tab_seller where sid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Seller.class), sid);

    }
}
