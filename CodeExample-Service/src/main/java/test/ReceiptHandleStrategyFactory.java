package test;

import org.apache.commons.lang3.StringUtils;
import test.service.IReceiptHandleStrategy;
import test.service.impl.Mt2101ReceiptHandleStrategy;
import test.service.impl.Mt8104ReceiptHandleStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 * @author zengsong
 * @date 2021/1/25 17:56
 */
public class ReceiptHandleStrategyFactory {

    private static Map<String,IReceiptHandleStrategy> receiptHandleStrategyMap;

    private ReceiptHandleStrategyFactory(){
        this.receiptHandleStrategyMap = new HashMap<>();
        this.receiptHandleStrategyMap.put("MT2101",new Mt2101ReceiptHandleStrategy());
        this.receiptHandleStrategyMap.put("MT8104",new Mt8104ReceiptHandleStrategy());
    }

    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
        return receiptHandleStrategyMap.get(receiptType);
    }
}
