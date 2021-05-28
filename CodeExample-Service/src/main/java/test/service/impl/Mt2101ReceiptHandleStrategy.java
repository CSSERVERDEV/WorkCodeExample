package test.service.impl;

import com.test.Receipt;
import test.service.IReceiptHandleStrategy;

/**
 * @author zengsong
 * @date 2021/1/25 17:50
 */
public class Mt2101ReceiptHandleStrategy implements IReceiptHandleStrategy {
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("Mt2101ReceiptHandleStrategy...");
    }
}
