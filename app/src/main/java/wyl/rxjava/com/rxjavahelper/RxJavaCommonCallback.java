package wyl.rxjava.com.rxjavahelper;

/**
 * RxJava的通用回调 主要是显示对话框，执行代码，完成回调主线程，消失对话框
 */

public interface RxJavaCommonCallback {

    void showHandleDialog();

    void handleWork();

    void handleComplete();

    void handleError();

    void dismissHandleDialog();
}
