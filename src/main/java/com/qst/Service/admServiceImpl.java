package com.qst.Service;

import com.qst.Mapper.admMapper;
import com.qst.Mapper.userMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 15:12
 */
@Service
public class admServiceImpl implements admService {
    @Resource
    private admMapper admMapper;
    @Resource
    private userMapper userMapper;


    @Override
    @Transactional
    public Object tranforLogin(int role, String name, String pwd) {
        //根据role的值判断登录用户为管理员还是普通用户
        if (role == 1){
           return admMapper.admLogin(name,pwd);
        }
        else if (role == 0){
            return userMapper.userLogin(name,pwd);

        }
        else {
            return null;
        }
    }

    @Override
    public int tranforAddUser(int role, String name, String pwd) {

        if (role == 1){
           return admMapper.admAdd(name,pwd,role);
        }
        else if (role == 0){
            return userMapper.userAdd(name,pwd,role);
        }else {
            return 0;
        }
    }
}
