package com.silent.silentmilitary.services;

import com.silent.silentmilitary.dao.MissileDto;
import com.silent.silentmilitary.domain.Missile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MissileService
 * @Description: TODO
 * @date 2019-01-31  15:02
 */

@Service
public class MissileService {

    @Autowired
    private MissileDto missileService;

    public Missile getMissileByName(String name){
        Missile m = missileService.findMissileByName("东风-21");
        System.out.println(m.getCountry());
        return  m;
    }


    @Transactional
    public void   initMissileService(){
        missileService.insertMissile("东风-21","中国");
        missileService.insertMissile("东风-26","中国");
    }

}
