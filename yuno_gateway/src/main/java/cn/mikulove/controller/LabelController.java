package cn.mikulove.controller;

import cn.mikulove.entity.PageResult;
import cn.mikulove.entity.Result;
import cn.mikulove.entity.StatusCode;
import cn.mikulove.pojo.Label;
import cn.mikulove.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@RestController
@CrossOrigin
@RequestMapping("label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 方法名: findAll
     * 方法描述: 查询所有的标签
     * 修改日期: 2019/1/6 15:20
     * @param
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功!",labelService.findAll());
    }

    /**
     * 方法名: findById
     * 方法描述: 根据id查询标签
     * 修改日期: 2019/1/6 15:20
     * @param labelId
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        return new Result(true, StatusCode.OK, "查询成功!",labelService.findById(labelId));
    }

    /**
     * 方法名: save
     * 方法描述: 保存标签
     * 修改日期: 2019/1/6 15:23
     * @param label
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        Result r = new Result();
        return new Result(true, StatusCode.OK, "保存成功!");
    }

    /**
     * 方法名: update
     * 方法描述: 根据标签的id,修改标签
     * 修改日期: 2019/1/6 15:26
     * @param labelId
     * @param label
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功!");
    }

    /**
     * 方法名: deleteById
     * 方法描述: 根据标签的id,删除标签
     * 修改日期: 2019/1/6 15:27
     * @param labelId
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功!");
    }

    /**
     * 方法名: findSearch
     * 方法描述: 条件分页查询
     * 修改日期: 2019/1/7 19:46
     * @param label
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> list=  labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 方法名: pageQuery
     * 方法描述: 分页条件查询
     * 修改日期: 2019/1/9 20:00
     * @param label
     * @param page
     * @param size
     * @return entity.Result
     * @author taohongchao
     * @throws
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label , @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Label> pageDate=  labelService.pageQuery(label,page,size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageDate.getTotalElements(),pageDate.getContent()));
    }


}
