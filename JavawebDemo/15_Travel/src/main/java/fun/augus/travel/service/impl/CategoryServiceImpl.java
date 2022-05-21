package fun.augus.travel.service.impl;

import fun.augus.travel.dao.CategoryDao;
import fun.augus.travel.dao.impl.CategoryDaoImpl;
import fun.augus.travel.domain.Category;
import fun.augus.travel.service.CategoryService;
import fun.augus.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.从redis中查询
        //1.1获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.2可使用sortedset排序查询
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        //1.3查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        //2.判断查询的集合是否为空
        List<Category> CategoryList = new ArrayList<Category>();
        if (categorys == null || categorys.size() == 0) {
            //3.如果为空,需要从数据库查询,在将数据存入redis
            //3.1 从数据库查询
            CategoryList = categoryDao.findAll();
            //3.2 将集合数据存储到redis中的 category的key
            for (int i = 0; i < CategoryList.size(); i++) {

                jedis.zadd("category", CategoryList.get(i).getCid(), CategoryList.get(i).getCname());
            }
        } else {
            //4.如果不为空,将set的数据存入list
            CategoryList = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                CategoryList.add(category);

            }
        }


        return CategoryList;
    }
}
