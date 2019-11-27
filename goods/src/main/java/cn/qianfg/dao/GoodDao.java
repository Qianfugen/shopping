package cn.qianfg.dao;
/**
 * 商品Dao层接口
 */

import cn.qianfg.pojo.Good;

import java.util.List;


public interface GoodDao {
    /**
     * 查询商品
     *
     * @return 返回商品列表
     */
    public List<Good> queryGood();
}
