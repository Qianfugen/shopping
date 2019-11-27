package cn.qianfg.service.impl;

import cn.qianfg.dao.StockDao;
import cn.qianfg.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao sd;

    @Override
    public int updateStockNumber(int goodId, int stockNumber) {
        Map<String, Integer> map = new HashMap<>();
        map.put("goodId", goodId);
        map.put("stockNumber", stockNumber);
        int flag = sd.updateStockNumber(map);
        return flag;
    }
}
