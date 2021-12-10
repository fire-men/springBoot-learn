package cn.fire.exception;

/**
 * @Author:zl
 * @Date:2020/12/22 08:09:49
 * @Userful:
 */
public class UserException extends RuntimeException {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UserException(String message) {
        super(message);
    }
}
