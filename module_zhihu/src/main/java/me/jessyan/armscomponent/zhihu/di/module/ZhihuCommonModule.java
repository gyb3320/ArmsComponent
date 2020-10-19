package me.jessyan.armscomponent.zhihu.di.module;

import dagger.Binds;
import dagger.Module;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhihuCommonContract;
import me.jessyan.armscomponent.zhihu.mvp.model.ZhihuCommonModel;


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
@Module
public abstract class ZhihuCommonModule {

    @Binds
    abstract ZhihuCommonContract.Model bindZhihuCommonModel(ZhihuCommonModel model);
}