package netlib.com.lib.base;

import android.app.Application;
import android.content.Context;

import com.hjq.toast.ToastUtils;

/**
 * <p>
 * 类描述 :
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2019/9/3 23:36
 * <p>
 */
public class BaseApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        ToastUtils.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
