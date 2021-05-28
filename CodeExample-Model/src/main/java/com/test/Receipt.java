package com.test;

import lombok.Data;

/**
 * @author zengsong
 * @date 2021/1/25 17:45
 */
@Data
public class Receipt {

    /**
     * 回执信息
     */
    String message;

    /**
     * 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999`)
     */
    String type;

}
