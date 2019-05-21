package my.example;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * CommonRoomsBean
 *
 * @author zengsong
 * @version 1.0
 * @description TODO
 * @date 2019/5/7 10:32
 **/
public class CommonRoomsBean implements Serializable {

    private String date;

    private String name;

    private Long value;

    private BigDecimal doubleTest=new BigDecimal(0.00).setScale(2);

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public BigDecimal getDoubleTest() {
        return doubleTest;
    }

    public void setDoubleTest(BigDecimal doubleTest) {
        this.doubleTest = doubleTest;
    }
}
