package cn.qianfg.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Stock {
    private Integer id;     //ID
    private Integer goodId; //商品ID
    private Integer stockNumber;    //商品库存量
    private String stockLoc;    //商品地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getStockLoc() {
        return stockLoc;
    }

    public void setStockLoc(String stockLoc) {
        this.stockLoc = stockLoc;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", stockNumber=" + stockNumber +
                ", stockLoc='" + stockLoc + '\'' +
                '}';
    }
}
