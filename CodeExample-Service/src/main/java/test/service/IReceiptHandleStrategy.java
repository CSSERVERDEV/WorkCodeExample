package test.service;

import com.test.Receipt;

/**
 * 回执处理策略接口
 * @author zengsong
 * @date 2021/1/25 17:48
 */
public interface IReceiptHandleStrategy {
    void handleReceipt(Receipt receipt);
}
