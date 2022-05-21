package fun.augus.travel.service.impl;

import fun.augus.travel.dao.FavoriteDao;
import fun.augus.travel.dao.impl.FavoriteDaoImpl;
import fun.augus.travel.domain.Favorite;
import fun.augus.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
