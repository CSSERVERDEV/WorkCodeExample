package test.service;

import com.test.Receipt;

/**
 * @author zengsong
 * @date 2021/1/25 18:10
 */
public interface IReceiptHandler {
    void handleReceipt(Receipt receipt, IReceiptHandleChain handleChain);
}
