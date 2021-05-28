import java.math.BigDecimal;
import java.util.Arrays;

/**
 * TYreysghgh
 *
 * @author zengsong
 * @version 1.0
 * @description TODO
 * @date 2018/11/29 14:33
 **/
public class TYreysghgh {
    public static void main(String[] agr0){
//        BigDecimal onLightsOccupy = new BigDecimal(0.00);
//        System.out.println(onLightsOccupy);
//        BigDecimal hubPerBulbsOccupy = new BigDecimal(0);
//        if(Double.parseDouble("-1")!=0){
//            hubPerBulbsOccupy = new BigDecimal(Double.parseDouble("3587") / Double.parseDouble("4567")).setScale(2, BigDecimal.ROUND_HALF_UP);
//        }
//        System.out.println(hubPerBulbsOccupy);
        System.out.println(findOfet(new int[]{1,2,5,8,9},4));
    }
    public static int findOfet(int[] data,int k){
        Arrays.sort(data);
        return data[data.length-k];
    }
}
