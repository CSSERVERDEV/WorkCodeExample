package my.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 数据排序实例
 *
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2019/4/24 17:15
 **/
public class ListSortDemo {
    /*数据表有如下数据
        2018-10-20	bedroom	61286
2018-10-20	livingroom	51508
2018-10-20	others	50020
2018-10-20	other	47427
2018-10-20	kitchen	21261
2018-10-19	livingroom	51213
2018-10-19	bedroom	60874
2018-10-19	others	49399
2018-10-19	kitchen	21110
2018-10-19	other	47238

实现按数量排序倒序并且Others放最后
*/
    public static void main(String[] arg0){
        List<CommonRoomsBean> commonRoomsBeanList=new ArrayList<>();
        CommonRoomsBean cb1=new CommonRoomsBean();
        cb1.setName("kitchen");
        cb1.setValue((long)21261);
        commonRoomsBeanList.add(cb1);
        CommonRoomsBean cb2=new CommonRoomsBean();
        cb2.setName("others");
        cb2.setValue((long)50020);
        commonRoomsBeanList.add(cb2);
        CommonRoomsBean cb3=new CommonRoomsBean();
        cb3.setName("other");
        cb3.setValue((long)47427);
        commonRoomsBeanList.add(cb3);
        CommonRoomsBean cb4=new CommonRoomsBean();
        cb4.setName("bedroom");
        cb4.setValue((long)61286);
        commonRoomsBeanList.add(cb4);
        CommonRoomsBean cb5=new CommonRoomsBean();
        cb5.setName("livingroom");
        cb5.setValue((long)51508);
        commonRoomsBeanList.add(cb5);
        /**
         * Others放最后,
         * 然后按照value排序，倒序
         *
         * 如果指定的数与参数相等返回0。
         * 如果指定的数小于参数返回 -1。
         * 如果指定的数大于参数返回 1。
         */
        Collections.sort(commonRoomsBeanList, new Comparator<CommonRoomsBean>() {
            @Override
            public int compare(CommonRoomsBean u1, CommonRoomsBean u2) {
                if ("others".equals(u1.getName())) {
                    return 1;
                } else {
                    return u2.getValue().compareTo(u1.getValue());
                }
            }
        });
        System.out.println(commonRoomsBeanList);
        //输出数据,并没有实现Others放最后的排序,动态数据的情况下,两个数据比较大于1的有多个，显然会有多个1
        //重定义compare比较值
        //在输出数据时对others的数据做单独处理,把数据放到每天的最后面

        BigDecimal num1=new BigDecimal(245586);
        BigDecimal num2=new BigDecimal(369285);
//        BigDecimal num3=new BigDecimal();


//        DecimalFormat df=new DecimalFormat(numString);
//        return new BigDecimal(df.format(a).toString());
        CommonRoomsBean commonRoomsBean=new CommonRoomsBean();

        commonRoomsBean.setDoubleTest(new BigDecimal(((float) 212739 / 364307)).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(commonRoomsBean.getDoubleTest());



        DecimalFormat df = new DecimalFormat("###.##");
        BigDecimal b1 = new BigDecimal(((float) 212739 / 364307));
        BigDecimal b2 = new BigDecimal("128.00");
        System.out.println("小数格式化：" + df.format(b1));
        System.out.println("整数格式化：" + df.format(b2));

    }
}
