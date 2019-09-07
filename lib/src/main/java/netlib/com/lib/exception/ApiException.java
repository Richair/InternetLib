package netlib.com.lib.exception;

/**
 * <p>
 * 类描述 :手机Exception的统一处理类
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/4 16:17
 * <p>
 * <p>
 */
public class ApiException extends RuntimeException {
    public String message;

    public ApiException(Throwable throwable) {
        super(throwable);
    }
}
