package com.qst.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.Bean.*;
import com.qst.Mapper.*;
import com.qst.Service.admService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 14:57
 */
@Controller
@RequestMapping("/adm")
public class admController {

    @Resource
    private admService admService;

    @Resource
    private userMapper userMapper;

    @Resource
    private comMapper comMapper;

    @Resource
    private trainMapper trainMapper;

    @Resource
    private fileMapper fileMapper;


    @Resource
    private insMapper insMapper;
    //页面跳转到主页面
    @RequestMapping("/toAdmMain")
    public String toAdmMain(){
        return "admMain";
    }
    //页面跳转到用户信息管理模块
    @RequestMapping("/toUserInfoM")
    public String toUserInfoM(){
        return "/userInfoM/userInfoM";
    }
    //页面跳转到招聘管理模块
    @RequestMapping("/toComInfoM")
    public String toComInfoM(){
        return "/comInfoM/comInfoM";
    }
    //页面跳转到培训管理模块
    @RequestMapping("/toTrainInfoM")
    public String toTrainInfoM(){
        return "/trainInfoM/trainInfoM";
    }
    //页面跳转到薪资管理模块
    @RequestMapping("/toUserSalM")
    public String toUserSalM(){
        return "/userSalM/userSalM";
    }
    //页面跳转到合同管理模块
    @RequestMapping("/toFileInfoM")
    public String toFileInfoM(){
        return "/fileInfoM/fileInfoM";
    }

    //页面跳转到社保管理模块
    @RequestMapping("/toInsInfoM")
    public String toInsInfoM(){
        return "/insInfoM/insInfoM";
    }
    //页面跳转到添加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/userInfoM/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(int role, String name , String pwd, Model model){
        int i = admService.tranforAddUser(role, name, pwd);
        if (i == 1){
            model.addAttribute("name",name);
            return "/userInfoM/addSuccess";
        }else{
            return "添加失败";
        }


    }
    //分页查询所有普通用户
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"userId");
        List<userInfo> list = userMapper.findAll();
        PageInfo<userInfo> pageInfo = new PageInfo<>(list);

        model.addAttribute("pageInfo",pageInfo);
        return "/userInfoM/findAllUser";
    }

    //跳转到修改普通用户信息页面

    @RequestMapping("/toEditUserById")
    public String toEditUserById(Integer userId,Model model){
        userInfo user = userMapper.findUserById(userId);
        model.addAttribute("user",user);
        return "/userInfoM/editUser";
    }
    //修改普通用户信息
    @RequestMapping("/editUser")
    public String editUser(userInfo userInfo){
        int i = userMapper.updateUser(userInfo.getUserId(),userInfo.getUserName(),userInfo.getUserPwd());
        if (i == 1 ){
            return "redirect:/adm/findAll";
        }
        return "/userInfoM/updateError";
    }
    //删除普通用户信息
    @RequestMapping("/delUser")
    public String delUser(Integer userId){
        int i = userMapper.delUser(userId);
        if (i == 1){
            return "redirect:/adm/findAll";
        }
        return "/userInfoM/deleteError";

    }
    //跳转到添加招聘信息页面
    @RequestMapping("/toAddComInfo")
    public String toAddComInfo(){
        return "/comInfoM/addComInfo";
    }
    //添加招聘公司信息
    @RequestMapping("/addComInfo")
    public String addComInfo(comInfo comInfo){
        int i = comMapper.addComInfo(comInfo.getComName());
        if (i==1){
            return "redirect:/adm/findAllComInfo";
        }
        return "/comInfoM/addComInfoError";

    }
    //分页查看所有招聘信息

    @RequestMapping("/findAllComInfo")
    public String findAllComInfo(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"comId");
        List<comInfo> list = comMapper.findAllComInfo();
        PageInfo<comInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/comInfoM/findAllComInfo";
    }

    //跳转到分页查询所有培训计划
    @RequestMapping("/findAllTrainInfo")
    public String findAllTrainInfo(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                 @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"trainId");
        List<trainInfo> list = trainMapper.findAllTrainInfo();
        PageInfo<trainInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/trainInfoM/findAllTrainInfo";
    }
    //页面跳转到培训计划添加页面
    @RequestMapping("/toAddTrainInfo")
    public String toAddTrainInfo(){
        return "/trainInfoM/addTrainInfo";
    }

    //添加培训计划
    @RequestMapping("/addTrainInfo")
    public String addTrainInfo(trainInfo trainInfo){
        int i = trainMapper.addTrainInfo(trainInfo.getTrainName());
        if (i == 1){
            return "redirect:/adm/findAllTrainInfo";
        }
        return "addTrainInfoError";
    }

    //分页查询薪资列表
    @RequestMapping("/findAllUserSal")
    public String findAllUserSal(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                          @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"userId");
        List<userInfo> list = userMapper.findAll();
        PageInfo<userInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/userSalM/findAllUserSal";
    }

    //跳转到薪资修改页面
    @RequestMapping("/toEditUserSalById")
    public String toEditUserSalById(Integer userId,Model model){
        userInfo user = userMapper.findUserById(userId);
        model.addAttribute("user",user);
        return "/userSalM/editUserSal";
    }

    //修改用户薪资信息
    @RequestMapping("/editUserSal")
    public String editUserSal(userInfo userInfo){
        int i = userMapper.updateUserSal(userInfo.getUserId(),userInfo.getUserSal());
        if (i == 1 ){
            return "redirect:/adm/findAllUserSal";
        }
        return "/userInfoM/updateError";
    }

    //分页查询所有用户合同信息
    @RequestMapping("/findAllFileInfo")
    public String findAllFileInfo(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                 @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"fileId");
        List<fileInfo> list = fileMapper.findAllFileInfo();
        PageInfo<fileInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/fileInfoM/findAllFileInfo";
    }
    //跳转到合同附件添加页面
    @RequestMapping("/toAddFileInfo")
    public String toAddFileInfo(){
        return "/fileInfoM/addFileInfo";
    }
    //添加合同附件信息
    @RequestMapping(value = "/addFileInfo" ,method = RequestMethod.POST)
    public String addFileInfo(HttpServletRequest request, @RequestParam("laodongFile") MultipartFile laodongFile,@RequestParam("peixunFile") MultipartFile peixunFile,@RequestParam("baomiFile") MultipartFile baomiFile , Model model,Integer userId,String userName){
        String LaodongFile = System.currentTimeMillis()+laodongFile.getOriginalFilename();
        String PeixunFile = System.currentTimeMillis()+peixunFile.getOriginalFilename();
        String BaomiFile = System.currentTimeMillis()+baomiFile.getOriginalFilename();

        //准备一个上传路径
        String filePath1 = request.getServletContext().getRealPath("")+"fileUpload"+"/"+ LaodongFile;
        String filePath2 = request.getServletContext().getRealPath("")+"fileUpload"+"/"+ PeixunFile;
        String filePath3 = request.getServletContext().getRealPath("")+"fileUpload"+"/"+ BaomiFile;
        File f1 = new File(filePath1);
        File f2 = new File(filePath2);
        File f3 = new File(filePath3);
        f1.getParentFile().mkdirs();
        f2.getParentFile().mkdirs();
        f3.getParentFile().mkdirs();
        fileMapper.addFileInfo(userId,LaodongFile,PeixunFile,BaomiFile);
        try {
            laodongFile.transferTo(f1);
            peixunFile.transferTo(f2);
            baomiFile.transferTo(f3);

//            model.addAttribute("LaodongFile",LaodongFile);
//            model.addAttribute("PeixunFile",PeixunFile);
//            model.addAttribute("BaomiFile",BaomiFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }

        return "redirect:/adm/findAllFileInfo";
    }
    //跳转到合同附件修改页面
    @RequestMapping("/toUpdateFileInfo")
    public String toUpdateFileInfo(Integer fileId, Integer userId, String userName, Model model){
        model.addAttribute("fileId",fileId);
        model.addAttribute("userId",userId);
        model.addAttribute("userName",userName);

        return "/fileInfoM/updateFileInfo";
    }

    //更改合同附件信息
    @RequestMapping(value = "/updateFileInfo" ,method = RequestMethod.POST)
    public String updateFileInfo(HttpServletRequest request, @RequestParam("laodongFile") MultipartFile laodongFile,@RequestParam("peixunFile") MultipartFile peixunFile,@RequestParam("baomiFile") MultipartFile baomiFile , Model model,Integer fileId){
        String LaodongFile = System.currentTimeMillis()+laodongFile.getOriginalFilename();
        String PeixunFile = System.currentTimeMillis()+peixunFile.getOriginalFilename();
        String BaomiFile = System.currentTimeMillis()+baomiFile.getOriginalFilename();
        System.out.println(fileId);
        //准备一个上传路径
        String filePath1 = request.getServletContext().getRealPath("")+"fileUpload"+"\\"+ LaodongFile;
        String filePath2 = request.getServletContext().getRealPath("")+"fileUpload"+"\\"+ PeixunFile;
        String filePath3 = request.getServletContext().getRealPath("")+"fileUpload"+"\\"+ BaomiFile;
        System.out.println(filePath1);
        File f1 = new File(filePath1);
        File f2 = new File(filePath2);
        File f3 = new File(filePath3);
        f1.getParentFile().mkdirs();
        f2.getParentFile().mkdirs();
        f3.getParentFile().mkdirs();
        fileMapper.updateFileInfo(fileId,LaodongFile,PeixunFile,BaomiFile);
        try {
            laodongFile.transferTo(f1);
            peixunFile.transferTo(f2);
            baomiFile.transferTo(f3);

//            model.addAttribute("LaodongFile",LaodongFile);
//            model.addAttribute("PeixunFile",PeixunFile);
//            model.addAttribute("BaomiFile",BaomiFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }

        return "redirect:/adm/findAllFileInfo";
    }
    //跳转到员工合同查询页面
    @RequestMapping("/tofindUserFileInfo")
    public  String tofindUserFileInfo(){
        return "/fileInfoM/findUserFileInfo";
    }
    //员工合同查询
    @RequestMapping("/findUserFileInfo")
    private String findUserFileInfo(Integer userId,Model model){
        fileInfo userFileInfo = fileMapper.findUserFileInfo(userId);
        model.addAttribute("userFileInfo",userFileInfo);
        return "/fileInfoM/showFindUserFileInfo";
    }

    //跳转到添加保险类别页面
    @RequestMapping("/toAddInsInfo")
    public String toAddInsInfo(){
        return "/insInfoM/addInsInfo";
    }
    //查看保险类别
    @RequestMapping("/findAllInsInfo")
    public String findAllInsInfo(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                  @RequestParam(value = "size",defaultValue = "6")int size){
        PageHelper.startPage(start,size,"insId");
        List<insInfo> list = insMapper.findAllInsInfo();
        PageInfo<insInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/insInfoM/findAllInsInfo";
    }
    //添加保险类别
    @RequestMapping("/addInsInfo")
    public String addInsInfo(Integer insId,String insName,Double insPrice){
        int i = insMapper.addInsInfo(insId, insName,insPrice);

        return "redirect:/adm/findAllInsInfo";

    }
//    //跳转到用户投保页面
//    @RequestMapping("/toAddInsForUser")
//    public String toAddInsForUser(Integer insId,String insName,Model model){
//        model.addAttribute("insId",insId);
//        model.addAttribute("insName",insName);
//
//        return "/insInfoM/addInsForUser";
//    }
    //跳转到查找投保人页面
    @RequestMapping("/toFindInsForUser")
    public String toInsForUser(){
        return "/insInfoM/findInsForUser";
    }
    //查找被投保人
    @RequestMapping("/findInsForUser")
    public String findInsForUser(Integer userId,Model model){
        userInfo user = userMapper.findUserById(userId);
        model.addAttribute("user",user);
        return "/insInfoM/InsForUserPage";
    }
    //跳转到投保页面
    @RequestMapping("/toAddInsForUser")
    public String toAddInsForUser(Integer userId , Model model){
        userInfo user = userMapper.findUserById(userId);
        model.addAttribute("user",user);

        return "/InsInfoM/InsForUser";
    }
    //添加投保
    @RequestMapping("/InsForUser")
    public String InsForUser(Integer userId,Integer insId,Model model){
        System.out.println(userId);
        System.out.println(insId);
        int i = insMapper.InsForUser(userId, insId);
        System.out.println(i);
        List<userInfo> all = userMapper.findAll();
        insInfo insInfoById = insMapper.findInsInfoById(insId);
        model.addAttribute("all",all);
        model.addAttribute("insInfoById",insInfoById.getInsPrice());
        return "/insInfoM/userAndSalPage";
    }

}
