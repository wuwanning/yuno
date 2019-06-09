package cn.mikulove.dao;

import cn.mikulove.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2019/6/9.
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {
}
