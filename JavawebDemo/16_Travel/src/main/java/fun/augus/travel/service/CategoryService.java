package fun.augus.travel.service;

import fun.augus.travel.domain.Category;

import java.util.List;

/**
 * @author Summerday
 */
public interface CategoryService {
    /**
     * 查询所有
     * @return
     */
    List<Category> findAll();

}
