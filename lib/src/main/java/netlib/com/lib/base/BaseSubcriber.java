package netlib.com.lib.base;






import netlib.com.lib.exception.ApiException;
import rx.Subscriber;

/**
 * <p>
 * 类描述 :自定义订阅者的基类,用于处理异常信息
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/4 14:29
 * <p>
 * <p>
 */
public abstract class BaseSubcriber<T> extends Subscriber<T> {
    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }


    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);

    /**
     * 取消请求
     */
//    protected abstract void cancelRequest();
}
