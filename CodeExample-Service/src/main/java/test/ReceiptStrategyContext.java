package test;

import com.test.Receipt;
import test.service.IReceiptHandleStrategy;

/**
 * 策略上下文类(策略接口的持有者)
 * @author zengsong
 * @date 2021/1/25 17:55
 */
public class ReceiptStrategyContext {
    private IReceiptHandleStrategy receiptHandleStrategy;

    /**
     * 设置策略接口
     * @param receiptHandleStrategy
     */
    public void setReceiptHandleStrategy(IReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    public void handleReceipt(Receipt receipt){
        if (receiptHandleStrategy != null) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}
