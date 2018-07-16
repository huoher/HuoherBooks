package top.qiuchi.huoher.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qiuchi.huoher.entity.Admin;
import top.qiuchi.huoher.mapper.AdminMapper;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public int adminLogin(Admin admin){
        var re = adminMapper.getadminbyname(admin.getAdminname());
        if (re != null){
            if (re.getAdminpassword().equals(admin.getAdminpassword())){
                return 1;
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }
}
