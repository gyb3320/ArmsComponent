package me.jessyan.armscomponent.zhihu.mvp.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import me.jessyan.armscomponent.zhihu.R;
import me.jessyan.armscomponent.zhihu.R2;
import me.jessyan.armscomponent.zhihu.mvp.ui.fragment.ZhiHuTabSubFragment;
import me.jessyan.armscomponent.zhihu.mvp.ui.fragment.ZhihuTabParentFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/26/2020 15:50
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class ZhihuTabActivity extends BaseActivity {

    @BindView(R2.id.public_toolbar)
    Toolbar publicToolbar;
    @BindView(R2.id.tabSliding)
    SlidingTabLayout tabSliding;
    @BindView(R2.id.viewPage)
    ViewPager viewPage;

    String[] tabTitles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};
    String[] tabIds = new String[]{"1", "1", "1", "1", "1"};
    ArrayList<Fragment> fragmentList = new ArrayList<>();

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.zhihu_activity_zhihu_tab; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        publicToolbar.setTitle("Tab页面");

        for (int i = 0; i < tabTitles.length; i++) {
            ZhihuTabParentFragment zhihuTabParentFragment = ZhihuTabParentFragment.newInstance();
            fragmentList.add(zhihuTabParentFragment);
        }
        tabSliding.setViewPager(viewPage, tabTitles, this, fragmentList);
    }
}
