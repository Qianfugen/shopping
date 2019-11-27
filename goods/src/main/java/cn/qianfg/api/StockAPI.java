package cn.qianfg.api;

import cn.qianfg.api.fallback.StockAPIFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="stock-server",fallback = StockAPIFallback.class)
public interface StockAPI {
    @RequestMapping("/stock/updateStockNumber")
    public Map<String,Integer> updateStockNumber(@RequestParam("goodId") int goodId, @RequestParam("stockNumber") int stockNumber);
}
