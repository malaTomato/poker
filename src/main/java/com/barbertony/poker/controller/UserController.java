package com.barbertony.poker.controller;

import com.barbertony.poker.bean.User;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xiongwu
 **/
@Component
@ServerEndpoint(value = "/websocket")
public class UserController {


    /**
     * 创建用户session,
     * @param session
     */
    @OnOpen
    public void openSession(Session session) {




    }

    /**
     * 消息发送
     * @param username
     * @param message
     */
    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {

    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        try {
            session.close();
        } catch (IOException e) {
        }
    }
}
