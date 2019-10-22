package com.qst.Controller;


import com.qst.Bean.comInfo;
import com.qst.Bean.userInfo;
import com.qst.Mapper.comMapper;
import com.qst.Mapper.userMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/22 - 22:06
 */
@Controller
@RequestMapping("/user")
public class userController {
    @Resource
    private userMapper userMapper;
    @Resource
    private comMapper comMapper;


    //跳转到普通用户主页面
    @RequestMapping("/toUserMain")
    public String toUserMain(){
        return "userMain";
    }
    //查看个人信息
    @RequestMapping("/findUserInfoById")
    public String  findUserInfoById(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        userInfo userInfo = (userInfo) session.getAttribute("userInfo");
        userInfo user = userMapper.findUserById(userInfo.getUserId());
        model.addAttribute("user",user);
        return "/userInfoM/selectUserInfo";
    }
    //查看招聘信息
    @RequestMapping("/findComInfo")
    public String findComInfo(Model model){
        List<comInfo> comInfo = comMapper.findAllComInfo();
        model.addAttribute("comInfo",comInfo);
        return "/rencaiInfoM/findComInfo";
    }



    @RequestMapping("/rencaiAdd")
    @ResponseBody
    public String rencaiAdd(Integer comId,Integer userId,String userName){
        int i = userMapper.rencaiAdd(comId,userId, userName);
        if (i == 1){
            return "简历投递成功";
        }
        return "投递失败";
    }
}
