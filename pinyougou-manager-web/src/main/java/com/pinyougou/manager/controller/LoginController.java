package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController <br/>
 * Description: <br/>
 * date: 2019-04-24 20:20<br/>
 *
 * @author liuzhuangzhuang<br />
 */


@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("getLoginUserName")
    public Map getLoginUserName(){
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName",loginName);
        return map;

    }


}
