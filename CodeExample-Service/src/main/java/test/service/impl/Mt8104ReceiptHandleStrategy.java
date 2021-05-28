package test.service.impl;

import com.test.Receipt;
import test.service.IReceiptHandleStrategy;

public class Mt8104ReceiptHandleStrategy implements IReceiptHandleStrategy {
    @Override
    public void handleReceipt(Receipt receipt) {
         System.out.println("Mt8104ReceiptHandleStrategy...");
    }
}
