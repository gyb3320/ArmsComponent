package me.jessyan.armscomponent.zhihu.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;
import me.jessyan.armscomponent.zhihu.di.module.ZhihuCommonModule;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhihuCommonContract;
import me.jessyan.armscomponent.zhihu.mvp.ui.activity.ZhihuCommonActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/19/2020 10:47
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = ZhihuCommonModule.class, dependencies = AppComponent.class)
public interface ZhihuCommonComponent {
    void inject(ZhihuCommonActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ZhihuCommonComponent.Builder view(ZhihuCommonContract.View view);

        ZhihuCommonComponent.Builder appComponent(AppComponent appComponent);

        ZhihuCommonComponent build();
    }
}