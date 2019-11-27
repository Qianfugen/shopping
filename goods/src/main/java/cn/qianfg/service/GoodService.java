package cn.qianfg.service;
/**
 * 商品Service层接口
 */

import cn.qianfg.pojo.Good;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GoodService {
    /**
     * 查询所有商品
     *
     * @return
     */
    public List<Good> queryGood();


    public Map<String, Integer> buyGood(int goodId);
}
