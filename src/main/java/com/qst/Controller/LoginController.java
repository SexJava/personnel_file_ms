package com.qst.Controller;

import com.qst.Service.admService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 15:23
 */
@Controller
public class LoginController {
    @Resource
    private admService admService;

    @RequestMapping("/shouye")
    public String toshouye(){
        return "index";
    }
    @RequestMapping("/Login")
    @ResponseBody
    public String Login(String name,String pwd,int role){
        Object o = admService.tranforLogin(role, name, pwd);
        if (o == null){
            return "登录失败!";
        }
        else {
            return o.toString();
        }
    }
}
