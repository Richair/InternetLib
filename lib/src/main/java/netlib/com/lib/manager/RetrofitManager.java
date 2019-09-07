package netlib.com.lib.manager;


import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import netlib.com.lib.constract.UrlAddressService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 * 类描述 : Retrofit管理类
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2019/1/3 15:56
 * <p>
 * <p>
 */
public class RetrofitManager {
    //地址
    public static final String BASE_PHONENUMINFO_URL = UrlAddressService.BASE_URL;
    //长缓存有效期为7天
//    public static final int CACHE_STALE_LONG = 60 * 60 * 24 * 7;

    /**
     * 单独创建一个OkHttpClient
     */
    private static OkHttpClient mOkHttpClient;

    /**
     * Url地址
     */
    private final UrlAddressService urlAddressService;

    /**
     * RetrofitManager 单例
     *
     * @return RetrofitManager
     */
    public static RetrofitManager getRetrofitManager() {
        return RetrofitManagerSinglet.retrofitManager;
    }

    /**
     * 静态内部类
     */
    private static class RetrofitManagerSinglet {
        private static final RetrofitManager retrofitManager = new RetrofitManager();
    }

    public UrlAddressService getService() {
        return urlAddressService;
    }

    private RetrofitManager() {
        initOkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_PHONENUMINFO_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        urlAddressService = retrofit.create(UrlAddressService.class);
    }

    /**
     * 注释掉的部分勿删勿动 用于数据拦截,打印log日志等信息,开发模式下方便查看数据
     */
    private void initOkHttpClient() {
        // 指定缓存路径,缓存大小100Mb
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {
                    // 指定缓存路径,缓存大小100Mb
//                    Cache cache = new Cache(new File(BaseApplication.context.getCacheDir(), "HttpCache"),
//                            1024 * 1024 * 100);


                    mOkHttpClient = new OkHttpClient.Builder()
                            // 指定缓存路径,缓存大小100Mb
//                            .cache(cache)
//                            .addInterceptor(mRewriteCacheControlInterceptor)
//                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)    // socket timeout
                            .build();

                }
            }
        }
    }

//    // 云端响应头拦截器，用来配置缓存策略
//    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            if (!NetUtil.isNetworkConnected()) {
//                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
//            }
//            Response originalResponse = chain.proceed(request);
//            if (NetUtil.isNetworkConnected()) {
//                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//                String cacheControl = request.cacheControl().toString();
//                return originalResponse.newBuilder().header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma").build();
//            } else {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG)
//                        .removeHeader("Pragma").build();
//            }
//        }
//    };

}
