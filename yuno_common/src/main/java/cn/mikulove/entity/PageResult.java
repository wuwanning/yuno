package cn.mikulove.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/6/8.
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    private Long total;

    private List<T> rows;
}
