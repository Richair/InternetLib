package netlib.com.lib.base;

/**
 * <p>
 * 类描述 :Presenter 的接口,主要是处理 解绑防止View一直被持有,导致内存溢出的问题
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/3 17:39
 * <p>
 * <p>
 */
public interface Presenter<V extends BaseView> {

    void attach(V v);

    void deAttach();


}
