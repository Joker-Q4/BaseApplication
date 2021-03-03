package com.joker.fake.location.ui.activities.main;

import android.view.View;

import com.joker.fake.base.BaseActivity;
import com.joker.fake.base.DataBindingConfig;
import com.joker.fake.location.BR;
import com.joker.fake.location.R;
import com.joker.fake.location.bean.ToolBar;
import com.joker.fake.location.ui.activities.main.view_model.MainActivityViewModel;

/**
 * @author Joker
 * @since 2021/03/03
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void initViewModel() {
        mainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.mmv, mainActivityViewModel)
                .addBindingParam(BR.main, MainActivity.this)
                .addBindingParam(BR.toolBar, new ToolBar(null,
                        "主活动", null));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tb_left){
            finish();
        }
    }
}
