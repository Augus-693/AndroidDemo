package fun.augus.travel.dao;

import fun.augus.travel.domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
