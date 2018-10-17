package wyl.rxjava.com.rxjavahelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxJavaHelper rxJavaHelper = new RxJavaHelper();
        rxJavaHelper.handleWork(new RxJavaCallBack() {
            @Override
            public void handleWork() {
                //异线程
            }

            @Override
            public void handleComplete() {
                //主线程
            }

            @Override
            public void handleError() {
                //主线程
            }
        });
    }
}
