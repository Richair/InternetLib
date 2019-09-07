package netlib.com.lib.base;

/**
 * <p>
 * 类描述 : view的基类,其他View继承它即可,如果有需要再添加当前界面需要的方法
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/3 14:50
 * <p>
 * <p>
 */
public interface BaseView {

    /**
     * 加载前,用于显示加载动画
     */
    void loadingBefore();

    /**
     * 加载完成,用于关闭加载动画
     */
    void loadingComplete();

    /**
     * 请求数据错误
     */
    void loadingError(String errorMessage);

    void  LogBackIn();

}
