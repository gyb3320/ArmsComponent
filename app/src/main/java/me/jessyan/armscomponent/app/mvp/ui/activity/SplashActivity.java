/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.armscomponent.app.mvp.ui.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import me.jessyan.armscomponent.app.R;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import timber.log.Timber;

/**
 * ================================================
 * Created by JessYan on 18/04/2018 17:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@Route(path = RouterHub.APP_SPLASHACTIVITY)
public class SplashActivity extends BaseActivity {
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        //这里需要注意，因为从当前模块的某个页面跳转到不同模块的某个页面，并关闭当前模块的页面时，
                        // 需要在NavigationCallback的监听事件里，添加关闭逻辑，否则会容易造成先关闭当前页面，后执行跳转，造成程序闪退
                        ARouter.getInstance().build(RouterHub.APP_MAINACTIVITY).navigation(SplashActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                //路由目标被发现时调用
                                Timber.tag("gyb").d("onFound - postcard.toString():" + postcard.toString());
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                //路由目标被丢失时调用
                                Timber.tag("gyb").d("onLost - postcard.toString():" + postcard.toString());
                                finish();
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                //路由到达目标后调用
                                Timber.tag("gyb").d("onArrival - postcard.toString():" + postcard.toString());
                                finish();
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                //路由目标被拦截时调用
                                Timber.tag("gyb").d("onInterrupt - postcard.toString():" + postcard.toString());
                                finish();
                            }
                        });
                    }
                });
    }
}
