package cn.qianfg.api.fallback;


import cn.qianfg.api.StockAPI;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StockAPIFallback implements StockAPI {
    @Override
    public Map<String, Integer> updateStockNumber(int goodId, int stockNumber) {
        System.out.println("库存服务炸了呀.......");
        System.out.println("备用程序开启...");
        System.out.println("程序员赶快去抢救呀......");

        return null;
    }
}
