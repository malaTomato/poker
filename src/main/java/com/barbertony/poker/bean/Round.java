package com.barbertony.poker.bean;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 牌局
 * @author xiongwu
 **/
@Data
public class Round {

    /**
     * 牌局数量
     */
    private static final ConcurrentMap<String, List<Poker>> pokers = new ConcurrentHashMap<>();

    private String roundCode;

}
