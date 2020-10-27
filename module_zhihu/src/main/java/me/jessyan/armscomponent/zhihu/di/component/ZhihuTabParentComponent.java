package me.jessyan.armscomponent.zhihu.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import me.jessyan.armscomponent.zhihu.di.module.ZhihuTabParentModule;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhihuTabParentContract;

import com.jess.arms.di.scope.FragmentScope;

import me.jessyan.armscomponent.zhihu.mvp.ui.fragment.ZhihuTabParentFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/27/2020 08:58
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = ZhihuTabParentModule.class, dependencies = AppComponent.class)
public interface ZhihuTabParentComponent {
    void inject(ZhihuTabParentFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ZhihuTabParentComponent.Builder view(ZhihuTabParentContract.View view);

        ZhihuTabParentComponent.Builder appComponent(AppComponent appComponent);

        ZhihuTabParentComponent build();
    }
}