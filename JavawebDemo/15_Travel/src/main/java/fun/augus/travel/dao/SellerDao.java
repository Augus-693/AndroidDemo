package fun.augus.travel.dao;

import fun.augus.travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Seller findById(int id);
}
