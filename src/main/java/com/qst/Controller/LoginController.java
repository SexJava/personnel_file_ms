package com.qst.Controller;

import com.qst.Bean.admInfo;
import com.qst.Bean.userInfo;
import com.qst.Service.admService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    //@ResponseBody
    public String Login(String name, String pwd, int role, Model model,HttpSession session){
        Object o = admService.tranforLogin(role, name, pwd);
        if (o == null){
            return "登录失败!";
        }
        else {

            //判断登录用户角色
            if (role == 1){
                //如果为管理员将登录正确返回的用Object对象强转成adm对象
                admInfo admInfo = (admInfo) o;
                session.setAttribute("admInfo",admInfo);
                model.addAttribute("admInfo",admInfo);


                return "admMain";
            }else if(role == 0){
                userInfo userInfo = (userInfo) o;
                session.setAttribute("userInfo",userInfo);
                model.addAttribute("userInfo",userInfo);
                return "userMain";
            }else {
                return null;
            }

        }
    }
}
