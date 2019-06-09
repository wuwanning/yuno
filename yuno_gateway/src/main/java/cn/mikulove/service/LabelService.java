package cn.mikulove.service;

import cn.mikulove.dao.LabelDao;
import cn.mikulove.pojo.Label;
import cn.mikulove.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }


    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void update(Label label) {
        //save方法有id就更新,没id就保存
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

}
