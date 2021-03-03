package com.joker.fake.location.adapter;

import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.joker.fake.base.BaseActivity;
import com.joker.fake.base.BaseFragment;
import com.joker.fake.utils.ValidationUtil;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BindingAdapter;

/**
 * @author Joker
 * @since 2021/03/03
 */
public class CommonAdapter {

    @BindingAdapter(value = {"immersiveA", "immersiveF"})
    public static void setToolBarTitle(Toolbar toolbar, BaseActivity baseActivity, BaseFragment baseFragment){
        if(baseActivity != null){
            ImmersionBar.with(baseActivity)
                    .keyboardEnable(false)
                    .titleBar(toolbar)
                    .init();
        }else if(baseFragment != null){
            ImmersionBar.with(baseFragment)
                    .keyboardEnable(false)
                    .titleBar(toolbar)
                    .init();
        }
    }
}
