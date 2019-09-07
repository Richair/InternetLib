package netlib.com.lib.base;

/**
 * <p>
 * 类描述 : 网络请求数据回调
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/10/18 16:29
 * <p>
 * <p>
 */
public interface NetWorkInterface<T> {
    /**
     * 请求成功
     * @param t 网络请求成功后的数据
     */
    void getDateSuccess(T t);

    /**
     * 请求失败
     * @param errorMsg 网络请求失败的原因
     */
    void getDateError(String errorMsg);

    void logBackIn();
}
