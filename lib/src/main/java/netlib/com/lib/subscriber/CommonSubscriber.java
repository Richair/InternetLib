package netlib.com.lib.subscriber;


import netlib.com.lib.base.BaseApplication;
import netlib.com.lib.base.BaseSubcriber;
import netlib.com.lib.base.BaseView;
import netlib.com.lib.exception.ApiException;
import netlib.com.lib.utils.NetworkUtil;

/**
 * <p>
 * 类描述 : 自定义订阅者的公共类,当在model中发起请求时,子类继承即可
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/4 16:47
 * <p>
 * <p>
 */
public abstract class CommonSubscriber<T, V extends BaseView> extends BaseSubcriber<T> {
    private V view;


    /**
     * @param v View 当前界面的view类
     */
    public CommonSubscriber(V v) {
        this.view = v;
    }

    @Override
    public void onStart() {
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            if (null!=view){
                view.loadingBefore();
            }

        }

    }

    @Override
    public void onCompleted() {
        view.loadingComplete();
        if (null!=view){
            view = null;
        }

    }

    @Override
    protected void onError(ApiException e) {
        if (null!=view){
            view.loadingComplete();
            view.loadingError(e.message);
        }

    }
}
