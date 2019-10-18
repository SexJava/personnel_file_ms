package com.qst.Service;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 15:12
 */
public interface admService {
    Object tranforLogin(int role, String name, String pwd);
    int tranforAddUser(int role, String name, String pwd);
}
