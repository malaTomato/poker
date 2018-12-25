package com.barbertony.poker.service;

import com.barbertony.poker.bean.Desk;
import com.barbertony.poker.bean.User;
import com.barbertony.poker.factory.DeskFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author xiongwu
 **/
@Service
public class UserService {

    private ConcurrentSkipListSet<Desk> desks = new ConcurrentSkipListSet();

    private void createUser(String username){

        User user = new User();
        user.setCode(UUID.fromString("username").toString());
        Desk desk = joinDesk();
        

    }

    /**
     * 桌上人数小于3个即可加入,否则创建一个新的牌桌
     * @return desk
     */
    private Desk joinDesk(){
        Desk desk = null;
        if(desks.size() == 0){
            desk = DeskFactory.getDesk();
            desks.add(desk);
            return desk;
        }
        Optional<Desk> optional = desks.stream().filter(v -> v.getUserSize() < 3).findFirst();
        if(optional.isPresent()){
            return optional.get();
        } else {
            desk = DeskFactory.getDesk();
            desks.add(desk);
            return desk;
        }
    }
}
