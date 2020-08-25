package cn.tedu.service;

import cn.tedu.pojo.User;

public interface UserService {
    User getUser(Integer id);
    void addScore(Integer id, Integer score);
}
