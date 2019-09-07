package netlib.com.lib.transformer;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <p>
 * 类描述 :公共的交换器
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/4 17:48
 * <p>
 */
public class CommonTransformer<T> implements Observable.Transformer<Object,T> {
    @Override
    public Observable<T> call(Observable<Object> tObservable) {
        return tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(ErrorTransformer.<T>getInstance());
    }


}
