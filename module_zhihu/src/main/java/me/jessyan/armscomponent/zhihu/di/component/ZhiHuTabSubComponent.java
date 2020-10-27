package me.jessyan.armscomponent.zhihu.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Component;
import me.jessyan.armscomponent.zhihu.di.module.ZhiHuTabSubModule;
import me.jessyan.armscomponent.zhihu.di.module.ZhihuHomeModule;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhiHuTabSubContract;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhihuHomeContract;
import me.jessyan.armscomponent.zhihu.mvp.ui.fragment.ZhiHuTabSubFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/26/2020 17:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = {ZhiHuTabSubModule.class, ZhihuHomeModule.class}, dependencies = AppComponent.class)
public interface ZhiHuTabSubComponent {
    void inject(ZhiHuTabSubFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ZhiHuTabSubComponent.Builder view(ZhiHuTabSubContract.View view);
        @BindsInstance
        ZhiHuTabSubComponent.Builder view2(ZhihuHomeContract.View view);

        ZhiHuTabSubComponent.Builder appComponent(AppComponent appComponent);

        ZhiHuTabSubComponent build();
    }
}