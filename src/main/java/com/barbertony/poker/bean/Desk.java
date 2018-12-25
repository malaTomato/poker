package com.barbertony.poker.bean;

import lombok.Data;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author xiongwu
 **/
@Data
public class Desk {

    /**
     * 用户会话集合
     */
    private static final ConcurrentMap<String, Session> sessionMap = new ConcurrentHashMap<>();
    /**
     * 桌号
     */
    private Integer no;

    private Integer userSize;


    /**
     * 发送普通消息
     * @param message
     */
    public static void sendMessage(String message){

        sessionMap.forEach((k,v)->{
            try {
                v.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 发送牌面消息
     * @param pokers
     */
    public static void sendPokers(List<Poker> pokers){

        sessionMap.forEach((k,v)->{
            try {
                v.getBasicRemote().sendObject(pokers);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    public static void addUser(String code,Session session){
        sessionMap.put(code,session);
    }

    public static void removeUser(String code,Session session){
        sessionMap.remove(code);
    }
}
