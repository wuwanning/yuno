package cn.mikulove.entity;

import lombok.Data;

/**
 * Created by Administrator on 2019/5/30.
 */
@Data
public class Result {

    private boolean flag;

    private Integer code;

    private String messgage;

    private Object data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String messgage) {
        this.flag = flag;
        this.code = code;
        this.messgage = messgage;
    }

    public Result(boolean flag, Integer code, String messgage, Object data) {
        this.flag = flag;
        this.code = code;
        this.messgage = messgage;
        this.data = data;
    }
}
