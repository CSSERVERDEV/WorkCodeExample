package test.service.impl;

import com.test.Receipt;
import org.apache.commons.lang3.StringUtils;
import test.service.IReceiptHandleChain;
import test.service.IReceiptHandler;

public class Mt8104ReceiptHandler implements IReceiptHandler {

    @Override
    public void handleReceipt(Receipt receipt, IReceiptHandleChain handleChain) {
        if (StringUtils.equals("MT8104",receipt.getType())) {
            System.out.println("解析报文MT8104:" + receipt.getMessage());
        }
        //处理不了该回执就往下传递
        else {
            handleChain.handleReceipt(receipt);
        }
    }
}
