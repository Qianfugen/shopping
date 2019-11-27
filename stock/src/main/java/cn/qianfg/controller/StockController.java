package cn.qianfg.controller;
/**
 * Stock控制层
 */

import cn.qianfg.service.StockService;
import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService ss;
    @Value("${server.port}")
    private int port;

    @ResponseBody
    @RequestMapping("/updateStockNumber")
    public  Map<String,Integer> updateStockNumber(@RequestParam("goodId") int goodId,@RequestParam("stockNumber") int stockNumber){
        System.out.println("当前调用的端口是:"+port+" goodId:"+goodId+" stockNumber:"+stockNumber);
        int flag=ss.updateStockNumber(goodId,stockNumber);
        Map<String,Integer> map= new HashMap<>();
        if(flag==1){
            map.put("status",200);
        }else{
            map.put("status",400);
        }

        return map;
    }
}
