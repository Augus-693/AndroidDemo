package fun.augus.service.impl;

import fun.augus.dao.ProvinceDao;
import fun.augus.dao.impl.ProvinceDaoImpl;
import fun.augus.domain.Province;
import fun.augus.jedis.util.JedisPoolUtils;
import fun.augus.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.service.impl
 * @FileName: ProvinceServiceImpl
 * @date 2021年11月29日 16:31
 * @version: 1.0
 */


public class ProvinceServiceImpl implements ProvinceService {

    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //先从redis中查询数据
        //获取redis客户端
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //判断 province_json 数据是否为null
        if (province_json == null || province_json.length() == 0) {
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库");
            //从数据库查询
            List<Province> ps = dao.findAll();
            //将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json数据存入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存");
        }
        return province_json;
    }
}
