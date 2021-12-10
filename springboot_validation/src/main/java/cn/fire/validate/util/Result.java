package cn.fire.validate.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 16:59:31
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public static Result success(String message, Object data) {
        return new Result("0", message, data);
    }

    public static Result error(String message) {
        return new Result("1", message, null);
    }

}
