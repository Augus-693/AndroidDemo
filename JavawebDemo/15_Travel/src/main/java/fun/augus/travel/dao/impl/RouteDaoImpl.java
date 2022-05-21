package fun.augus.travel.dao.impl;

import fun.augus.travel.dao.RouteDao;
import fun.augus.travel.domain.Route;
import fun.augus.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
        //String sql = "select count(*) from tab_route where cid = ?";
        //1.定义sql模板
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        //2.判断参数是否有值
        if(cid != 0){
            sb.append( " and cid = ? ");

            params.add(cid);//添加？对应的值
        }

        if(rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");

            params.add("%" + rname + "%");
        }

        sql = sb.toString();


        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize,String rname) {
        //String sql = "select * from tab_route where cid = ? limit ? , ?";
        //定义sql模板
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List parms = new ArrayList();//条件
        //判断参数是否有值
        if (cid == 0) {
            sb.append(" and cid = ? ");
            parms.add(cid);
        }
        if (rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");
            parms.add("%" + rname + "%");
        }
        sb.append(" limit ? , ? ");//分页条件

        parms.add(start);
        parms.add(pageSize);

        sql = sb.toString();
        System.out.println("分页的sql:"+sql);
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),parms.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}