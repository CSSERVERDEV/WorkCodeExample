package test;

import test.service.IReceiptHandler;
import test.service.impl.Mt2101ReceiptHandler;
import test.service.impl.Mt8104ReceiptHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理作
 * @author zengsong
 * @date 2021/1/2518:15
 */
public class ReceiptHandlerContainer {
    private ReceiptHandlerContainer(){}

    public static List<IReceiptHandler> getReceiptHandlerList(){
        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
        receiptHandlerList.add(new Mt2101ReceiptHandler());
        receiptHandlerList.add(new Mt8104ReceiptHandler());
        return receiptHandlerList;
    }
}
