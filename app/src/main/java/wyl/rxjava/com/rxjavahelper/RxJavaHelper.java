package wyl.rxjava.com.rxjavahelper;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import wyl.rxjava.com.rxjavahelper.RxJavaCommonCallback;

/**
 * RxJava操作帮助类，简化RxJava的书写方式
 */

public class RxJavaHelper {

    public void handleWork(final RxJavaCommonCallback rxJavaCommonCallback) {
        Observable.just("").observeOn(Schedulers.io()).map(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) throws Exception {
                if (rxJavaCommonCallback != null) {
                    rxJavaCommonCallback.handleWork();
                }
                return "";
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (rxJavaCommonCallback != null) {
                    rxJavaCommonCallback.showHandleDialog();
                }
            }

            @Override
            public void onNext(Object value) {
            }

            @Override
            public void onError(Throwable e) {
                if (rxJavaCommonCallback != null) {
                    rxJavaCommonCallback.handleError();
                }
            }

            @Override
            public void onComplete() {
                if (rxJavaCommonCallback != null) {
                    rxJavaCommonCallback.handleComplete();
                    rxJavaCommonCallback.dismissHandleDialog();
                }
            }
        });
    }

}
