package cn.mikulove.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label implements Serializable{

    @Id
    private String id;//标签的id
    private String labelname;//标签的名称
    private String state;//状态
    private Long count;//使用的数量
    private Long fans;//关注数
    private String recommend; //是否推荐

}
