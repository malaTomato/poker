package com.barbertony.poker.factory;

import com.barbertony.poker.bean.Desk;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiongwu
 **/
public class DeskFactory {


    private static AtomicInteger no = new AtomicInteger();

    public static Desk getDesk(){
        Desk desk = new Desk();
        desk.setNo(no.getAndIncrement());
        return desk;
    }

}
