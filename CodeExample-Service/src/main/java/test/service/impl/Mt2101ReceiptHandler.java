package test.service.impl;

import com.test.Receipt;
import org.apache.commons.lang3.StringUtils;
import test.service.IReceiptHandleChain;
import test.service.IReceiptHandler;

/**
 * @author zengsong
 * @date 2021/1/25 18:14
 */
public class Mt2101ReceiptHandler implements IReceiptHandler {
    @Override
    public void handleReceipt(Receipt receipt, IReceiptHandleChain handleChain) {
        if (StringUtils.equals("MT2101",receipt.getType())) {
            System.out.println("解析报文MT2101:" + receipt.getMessage());
        }
        //处理不了该回执就往下传递
        else {
            handleChain.handleReceipt(receipt);
        }
    }
}

