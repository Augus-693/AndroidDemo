package fun.augus.travel.dao;

import fun.augus.travel.domain.Category;

import java.util.List;

/**
 * @author Summerday
 */
public interface CategoryDao {

    /**
     * 查询所有
     * @return
     */
    List<Category> findAll();
}
