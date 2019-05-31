package cn.mikulove.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by miku on 2019/5/30.
 */
@Data
@ToString(of = {"username","age"})
@AllArgsConstructor
public class SysUser {

    private String username;

    private String password;

    private Integer age;

}
