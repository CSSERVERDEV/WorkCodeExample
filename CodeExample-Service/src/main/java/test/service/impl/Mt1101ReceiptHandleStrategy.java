package test.service.impl;

import com.test.Receipt;
import test.service.IReceiptHandleStrategy;

public class Mt1101ReceiptHandleStrategy implements IReceiptHandleStrategy {
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("Mt1101ReceiptHandleStrategy...");
    }
}
