package com.liguo.reservoirmanagement.pojo;

import lombok.Data;

/**
 * @author nongChaTea
 * @date 2022/5/15 20:16
 */
@Data
public class AjaxResult {
    private String code;
    private String message;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
