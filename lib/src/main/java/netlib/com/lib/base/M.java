package netlib.com.lib.base;


import netlib.com.lib.constract.UrlAddressService;
import netlib.com.lib.manager.RetrofitManager;


/**
 * <p>
 * 类描述 :网络请求model层的基类,其他界面网络请求的model直接继承即可
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/3 18:12
 * <p>
 * <p>
 */
public abstract class M {

    //retrofit请求数据的管理类
    protected RetrofitManager retrofitManager;
    protected UrlAddressService urlAddressService;

    /**
     * 初始化retrofit
     */
    public M() {
        retrofitManager = RetrofitManager.getRetrofitManager();
        urlAddressService = retrofitManager.getService();
    }

    /**
     * 判断当前的网络状况
     *
     * @return
     */
//    public boolean getNetWork() {
//        return NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
//    }

    /**
     * 如果是没有网弹吐司提示
     *
     * @param message
     */
//    public void showToast(String message) {
//        Toast.makeText(BaseApplication.getContext(), message, Toast.LENGTH_SHORT).show();
//    }


}
