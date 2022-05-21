package fun.augus.travel.dao;

import fun.augus.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 根据cid查询总记录数
     */
    int findTotalCount(int cid,String rname);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    List<Route> findByPage(int cid, int start, int pageSize,String rname);

    /**
     * 根据id查询一个
     * @param cid
     * @return
     */
    Route findOne(int cid);
}
