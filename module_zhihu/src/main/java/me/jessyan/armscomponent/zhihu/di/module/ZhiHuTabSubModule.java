package me.jessyan.armscomponent.zhihu.di.module;

import dagger.Binds;
import dagger.Module;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhiHuTabSubContract;
import me.jessyan.armscomponent.zhihu.mvp.model.ZhiHuTabSubModel;


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
@Module
public abstract class ZhiHuTabSubModule {

    @Binds
    abstract ZhiHuTabSubContract.Model bindZhiHuTabSubModel(ZhiHuTabSubModel model);
}