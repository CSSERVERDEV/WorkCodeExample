package my.example.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengsong
 * @date 2021/4/6 10:50
 */
public class AbsteratService {
    public static void main(String[] agr0){
        List<Integer>  list=new ArrayList<>();

        list.add(1);

        list.add(2);
        for (int i=0;i<list.size();i++){
            list.remove(i);
        }
    }
}
