package netlib.com.lib.transformer;



import netlib.com.lib.exception.ExceptionEngine;
import rx.Observable;
import rx.functions.Func1;


/**
 * <p>
 * 类描述 : 网络连接错误的交换器
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/10/11 14:44
 * <p>
 * <p>
 */
public class ErrorTransformer<T> implements Observable.Transformer<Object, T> {

    private static ErrorTransformer errorTransformer = null;

    @Override
    public Observable<T> call(Observable<Object> responseObservable) {

        return (Observable<T>) responseObservable.onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });

    }

    /**
     * @return 线程安全, 双层校验
     */
    public static <T> ErrorTransformer<T> getInstance() {
        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer<>();
                }
            }
        }
        return errorTransformer;
    }
}
