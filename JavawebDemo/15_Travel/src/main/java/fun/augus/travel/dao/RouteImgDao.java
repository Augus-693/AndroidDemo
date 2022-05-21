package fun.augus.travel.dao;

import fun.augus.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
