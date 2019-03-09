package com.silent.silentmilitary.controller;

import com.silent.silentmilitary.domain.Missile;
import com.silent.silentmilitary.services.MissileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MissileController
 * @Description: TODO
 * @date 2019-01-31  15:09
 */

@RestController
@RequestMapping("/missile")
public class MissileController {

    private  int count;

    @Autowired
    MissileService missileService;

    @RequestMapping("/test")
    public Missile testQuery(){
        return missileService.getMissileByName("东风-21");
    }
    @RequestMapping("/init")
    public String test(){
        missileService.initMissileService();
        count++;
        System.out.println("MissileController 私有字段count：" + count);
        return "hello";
    }
}
