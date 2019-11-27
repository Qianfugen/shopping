package cn.qianfg.controller;

import cn.qianfg.pojo.Good;
import cn.qianfg.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//导入IOC容器
@Controller
//指定路径
@RequestMapping("/good")
public class GoodController {
    //调用服务层
    @Autowired
    private GoodService gs;


    //查询所有商品,json格式返回,使用@ResponseBody注解
    @ResponseBody
    @RequestMapping("/queryGood")
    public ModelAndView queryGood() {
        ModelAndView mv = new ModelAndView();
        List<Good> goods = gs.queryGood();
        mv.addObject("goods", goods);
        mv.setViewName("goodList");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/buyGood")
    public ModelAndView buyGood(int id) {
        ModelAndView mv = new ModelAndView();
        Map<String, Integer> map = gs.buyGood(id);
        System.out.println(map);
        if (map != null) {
            if (map.get("status") == 200) {
                System.out.println("库存减10......");
                mv.setViewName("success");
            } else {
                System.out.println("库存不足......");
                mv.setViewName("fail");
            }
        } else {
            System.out.println("备用程序执行结束......");
            mv.setViewName("fail");
        }
        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login(HttpSession session) {
        session.setAttribute("userName", "qianfg");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:http://localhost:8088/gateway/good/queryGood");
        return mv;
    }
}
