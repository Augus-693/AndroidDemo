package fun.augus.travel.dao.impl;

import fun.augus.travel.dao.RouteImgDao;
import fun.augus.travel.domain.RouteImg;
import fun.augus.travel.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Summerday
 */
public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return template.query(sql,new BeanPropertyRowMapper<>(RouteImg.class),rid);
    }
}
