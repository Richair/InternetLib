package netlib.com.lib.base;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * <p>
 * 类描述 : P层的基类,其他P类直接继承即可
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/3 17:34
 * <p>
 * <p>
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> implements Presenter {
    private WeakReference<V> viewWeakReference;
    private WeakReference<M> modelWeakReference;
    protected M model;
    protected Context context;

    @Override
    public void attach(BaseView baseView) {
        context = BaseApplication.getContext();
        viewWeakReference = new WeakReference(baseView);
        model = getModel();
        modelWeakReference = new WeakReference(model);
    }

    @Override
    public void deAttach() {
        if (viewWeakReference != null) {
            viewWeakReference.clear();
            viewWeakReference = null;
        }
        if (modelWeakReference != null) {
            modelWeakReference.clear();
            modelWeakReference = null;
        }

        context = null;
    }

    protected abstract M getModel();


    public V getView() {
        if (viewWeakReference != null) {
            return viewWeakReference.get();
        }
        return null;
    }


}
