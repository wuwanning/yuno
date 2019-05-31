package entity;

import cn.mikulove.entity.SysUser;

/**
 * Created by miku on 2019/5/31.
 */
public class UserTest {

    public static void main(String[] args) {
        SysUser user = new SysUser("admin","pass1234",14);
        System.out.println(user);

    }

}
