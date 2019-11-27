package cn.qianfg.service.impl;

import cn.qianfg.api.StockAPI;
import cn.qianfg.dao.GoodDao;
import cn.qianfg.pojo.Good;
import cn.qianfg.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao gd;     //商品接口
    @Autowired
    private StockAPI stockAPI;
    /**
     * 查询所有商品
     *
     * @return
     */
    @Override
    public List<Good> queryGood() {
        return gd.queryGood();
    }

    @Override
    public Map<String, Integer> buyGood(int goodId) {
        System.out.println("开始购买商品......");
        Map<String,Integer> map=stockAPI.updateStockNumber(goodId,10);
        return map;
    }
}
