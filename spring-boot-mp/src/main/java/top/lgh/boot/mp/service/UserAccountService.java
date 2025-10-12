package top.lgh.boot.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lgh.boot.mp.entity.UserAccount;

import java.util.List;

public interface UserAccountService extends IService<UserAccount> {

    /**
     * 创建单个用户（自动加密密码）
     *
     * @param user 要创建的用户对象
     * @return 创建成功返回 true，否则返回 false
     */
    boolean createUser(UserAccount user);

    /**
     * 批量创建用户（自动加密密码）
     *
     * @param users 要创建的用户列表
     * @return 批量创建成功返回 true，否则返回 false
     */
    boolean createUsers(List<UserAccount> users);
}