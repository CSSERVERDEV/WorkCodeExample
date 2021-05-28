//import com.sengled.cloud.data.platform.model.po.DeviceOnlineHoursBean;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.stream.Collectors.toList;

/**
 * JavaListTest
 *
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2018/12/28 10:38
 **/
public class JavaListTest {
    private static short node=2;
    private static final short MASK_LOW_7_BIT = 0x7F;
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("2018-12-01");
        list1.add("2018-12-02");
        list1.add("2018-12-03");
        list1.add("2018-12-05");
        list1.add("2018-12-06");

//        List<DeviceOnlineHoursBean> list2 = new ArrayList<DeviceOnlineHoursBean>();
//        DeviceOnlineHoursBean deviceOnlineHoursBean1=new DeviceOnlineHoursBean();
//        deviceOnlineHoursBean1.setDate("2018-12-02");
//        deviceOnlineHoursBean1.setHours(1);
//        deviceOnlineHoursBean1.setTotal(Long.valueOf(20));
//        list2.add(deviceOnlineHoursBean1);
//        DeviceOnlineHoursBean deviceOnlineHoursBean2=new DeviceOnlineHoursBean();
//        deviceOnlineHoursBean2.setDate("2018-12-02");
//        deviceOnlineHoursBean2.setHours(2);
//        deviceOnlineHoursBean2.setTotal(Long.valueOf(50));
//        list2.add(deviceOnlineHoursBean2);
//        DeviceOnlineHoursBean deviceOnlineHoursBean3=new DeviceOnlineHoursBean();
//        deviceOnlineHoursBean3.setDate("2018-11-02");
//        deviceOnlineHoursBean3.setHours(2);
//        deviceOnlineHoursBean3.setTotal(Long.valueOf(50));
//        list2.add(deviceOnlineHoursBean3);
//        DeviceOnlineHoursBean deviceOnlineHoursBean4=new DeviceOnlineHoursBean();
//        deviceOnlineHoursBean4.setDate("2018-12-06");
//        deviceOnlineHoursBean4.setHours(1);
//        deviceOnlineHoursBean4.setTotal(Long.valueOf(50));
//        list2.add(deviceOnlineHoursBean4);
//        System.out.println(list2.contains("2018-12-02"));
//        list2.stream().filter(dviceOnlineHoursBean->list1.contains(dviceOnlineHoursBean.getDate())).collect(toList()).parallelStream().forEach(System.out :: println);
        // 交集
//        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);
//
//        // 差集 (list1 - list2)
//        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out :: println);
//
//        // 差集 (list2 - list1)
//        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
//        System.out.println("---差集 reduce2 (list2 - list1)---");
//        reduce2.parallelStream().forEach(System.out :: println);
//
//        // 并集
//        List<String> listAll = list1.parallelStream().collect(toList());
//        List<String> listAll2 = list2.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println("---并集 listAll---");
//        listAll.parallelStream().forEachOrdered(System.out :: println);
//
//        // 去重并集
//        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
//        System.out.println("---得到去重并集 listAllDistinct---");
//        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);
//
//        System.out.println("---原来的List1---");
//        list1.parallelStream().forEachOrdered(System.out :: println);
//        System.out.println("---原来的List2---");
//        list2.parallelStream().forEachOrdered(System.out :: println);

        //有序 可重复 连续内存 动态数值copy 扩展


        //set treeset 无序 不可重复

//        Vector<String> vector=new Vector();
//        vector.add("sdfsfsf");
//        vector.add("二维数组");

//            List<String> namesList=new ArrayList<>();
//        namesList.add("dssg");


//        CopyOnWriteArrayList<String> namessList=new CopyOnWriteArrayList<>();
//        namessList.add("dssg");
//            for (String name : namessList) {
//                if (name.equals("dssg")) {
//                    namessList.remove(name);
//                }
//            }

        System.out.println(MASK_LOW_7_BIT);
    }
}
