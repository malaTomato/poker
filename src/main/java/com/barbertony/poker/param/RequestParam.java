package com.barbertony.poker.param;

import lombok.Data;

/**
 * @author xiongwu
 **/
@Data
public class RequestParam {
    private String action;
    private String userCode;
    private String deskCode;
    private String roundCode;
}
