package cn.qianfg.controller;

import cn.qianfg.api.StockAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/hystrix")
public class HystrixController {
    @Autowired
    private StockAPI stockAPI;

    @RequestMapping("/updateStockNumber")
    public Map<String,Integer> updateStockNumber(@RequestParam("goodId") int goodId, @RequestParam("stockNumber") int stockNumber){
        return stockAPI.updateStockNumber(goodId,stockNumber);
    }
}
