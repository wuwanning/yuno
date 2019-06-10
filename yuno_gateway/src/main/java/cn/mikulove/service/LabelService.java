package cn.mikulove.service;

import cn.mikulove.dao.LabelDao;
import cn.mikulove.pojo.Label;
import cn.mikulove.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    /**
     * 方法名: findSearch
     * 方法描述: 分页查询标签的数据
     * 修改日期: 2019/1/7 18:49
     * @param label
     * @return java.util.List<com.tensquare.base.pojo.Label>
     * @author taohongchao
     * @throws
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 方法名: toPredicate
             * 方法描述:  jpa的条件查询
             * 修改日期: 2019/1/7 19:20
             * @param root 根对象,要把条件封装到哪个对象中
             * @param query 封装查询的关键字. 比如group by order by
             * @param cb 封装条件对象 如果直接返回null,表示不封装任何的条件
             * @return javax.persistence.criteria.Predicate
             * @author taohongchao
             * @throws
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //存放一个集合, 用于存储所有的条件
                ArrayList<Predicate> list = new ArrayList<>();

                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    // 根据标签的名称,模糊查询
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    //等值查询标签的状态
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                //创建一个数组, 作为最终的返回值的条件
                Predicate[] parr = new Predicate[list.size()];

                //把list转为数组
                list.toArray(parr);
                //返回所有的条件
                return cb.and(parr);
            }
        });
    }



    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageAble = new PageRequest(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 方法名: toPredicate
             * 方法描述:  jpa的条件查询
             * 修改日期: 2019/1/7 19:20
             * @param root 根对象,要把条件封装到哪个对象中
             * @param query 封装查询的关键字. 比如group by order by
             * @param cb 封装条件对象 如果直接返回null,表示不封装任何的条件
             * @return javax.persistence.criteria.Predicate
             * @author taohongchao
             * @throws
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //存放一个集合, 用于存储所有的条件
                ArrayList<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    // 根据标签的名称,模糊查询
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    //等值查询标签的状态
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                //创建一个数组, 作为最终的返回值的条件
                Predicate[] parr = new Predicate[list.size()];

                //把list转为数组
                list.toArray(parr);
                //返回所有的条件
                return cb.and(parr);
            }
        },pageAble);
    }

}
