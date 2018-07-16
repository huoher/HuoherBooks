package top.qiuchi.huoher.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiuchi.huoher.entity.User;
import top.qiuchi.huoher.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listuser(){
        return userMapper.findAllUser();
    }

    public int Login(User user){
        var re = userMapper.findUserByName(user.getUsername());
        if (re == null){
            System.out.println("user is null!!!");
            return 0;
        }else {
            if (user.getPassword().equals(re.getPassword())){
                    System.out.println(re);
                    return 1;
            }
            return 0;
        }
    }

    public int VeriUsername(User user){
        var re = userMapper.findUserByName(user.getUsername());
        if (re != null) {
            System.out.println("username is already exits!!!");
            return 1;
        }
            return 0;
    }

    public void registerUser(User user){
        if (user.getUsername().equals("")||user.getPassword().equals("")){
            System.out.println("registeruser fail");
            return;
        }

        if (VeriUsername(user) == 1){
            System.out.println("registeruser fail!!!");
            return;
        }
        userMapper.addUser(user);
        System.out.println("*************");
    }

    public int findUserid(User user){
        var re = userMapper.findUserByName(user.getUsername());
        if (re != null){
            System.out.println("###########################re is " + re.getUserid());
            return re.getUserid();
        }
        System.out.println("###########################re is null");
        return 0;
    }

    public void delUser(User user){
        System.out.println("User service + " + user);
        userMapper.delUser(user);
    }
}
