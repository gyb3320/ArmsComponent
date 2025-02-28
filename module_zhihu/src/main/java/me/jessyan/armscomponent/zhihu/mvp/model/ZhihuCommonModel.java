package me.jessyan.armscomponent.zhihu.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.jessyan.armscomponent.zhihu.mvp.contract.ZhihuCommonContract;
import me.jessyan.armscomponent.zhihu.mvp.model.api.service.ZhihuService;
import me.jessyan.armscomponent.zhihu.mvp.model.entity.ZhihuDetailBean;


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
public class ZhihuCommonModel extends BaseModel implements ZhihuCommonContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ZhihuCommonModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<ZhihuDetailBean> getDetailInfo(int id) {
        return mRepositoryManager.obtainRetrofitService(ZhihuService.class).getDetailInfo(id);
    }
}