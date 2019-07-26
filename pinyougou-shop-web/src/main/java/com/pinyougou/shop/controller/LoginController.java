package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController <br/>
 * Description: <br/>
 * date: 2019-04-25 20:58<br/>
 *
 * @author liuzhuangzhuang<br />
 */
@RestController
@RequestMapping("/shopLogin")
public class LoginController {


    @RequestMapping("/getShopLoginName")
    public Map getShopLoginName(){

        String shopLoginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("shopLoginName",shopLoginName);

        return map;


    }

}
