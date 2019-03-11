package com.silent.silentmilitary.minidobbo.service;

import com.silent.silentmilitary.minidobbo.entity.InfoUser;

import java.util.List;
import java.util.Map;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: InfoUserService
 * @Description: TODO
 * @date 2019-02-23  21:55
 */

public interface InfoUserService {

    List<InfoUser> insertInfoUser(InfoUser infoUser);

    InfoUser getInfoUserById(String id);

    void deleteInfoUserById(String id);

    String getNameById(String id);

    Map<String,InfoUser> getAllUser();

}
