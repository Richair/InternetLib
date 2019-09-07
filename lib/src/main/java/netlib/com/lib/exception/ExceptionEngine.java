package netlib.com.lib.exception;


import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.HttpException;

/**
 * <p>
 * 类描述 : 网络请求异常类
 * <p>
 * 作者 : anyucai
 * <p>
 * 创建时间 : 2018/4/4 16:34
 * <p>
 * <p>
 */
public class ExceptionEngine {
    //对应HTTP的状态码
    private static final int FAIL = 400;
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e);
            switch (httpException.code()) {
                case FAIL:
                    ex.message = "网路连接失败,请稍后再试!";
                    break;
                case UNAUTHORIZED:
                    ex.message = "身份验证失败!";
                    break;
                case FORBIDDEN:
                    ex.message = "服务器拒绝请求!";
                    break;
                case NOT_FOUND:
                    ex.message = "服务器访问失败,请稍后再试!";
                    break;
                case REQUEST_TIMEOUT:
                    ex.message = "网络请求超时,请稍后再试!";
                    break;
                case INTERNAL_SERVER_ERROR:
                    ex.message = "参数错误";
                    break;
                case BAD_GATEWAY:
                    ex.message = "服务器响应异常,请稍后再试!";
                    break;
                case SERVICE_UNAVAILABLE:
                    ex.message = "服务器维护中,请稍后再试!";
                    break;
                case GATEWAY_TIMEOUT:
                    ex.message = "服务器响应超时,请稍后再试!";
                    break;
            }
            return ex;
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof ConnectTimeoutException) {
            ex = new ApiException(e);
            ex.message = "连接失败";  //均视为网络错误
            return ex;
        } else if (e instanceof JSONException || e instanceof ParseException) {
            ex = new ApiException(e);
            ex.message = "解析错误";            //均视为解析错误
            return ex;
        } else if (e instanceof JsonParseException) {
            ex = new ApiException(e);
            ex.message = "Json错误";            //均视为解析错误
            return ex;
        } else if (e instanceof UnknownHostException) {
            ex = new ApiException(e);
            ex.message = "网络异常,请检查网络是否连接!";
            return ex;
        } else {
            ex = new ApiException(e);
            ex.message = "未知错误";
            return ex;
        }
    }
}