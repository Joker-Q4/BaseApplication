package com.joker.fake.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gyf.immersionbar.ImmersionBar;

/**
 * @author Joker
 * @since 2021/03/02
 */
public abstract class BaseFragment extends DataBindingFragment {

    protected final String TAG = getClass().getSimpleName();

    public void hideSoftInput() {
        final Window window = mActivity.getWindow();
        View view = window.getCurrentFocus();
        if (view == null) {
            View decorView = window.getDecorView();
            View focusView = decorView.findViewWithTag("keyboardTagView");
            if (focusView == null) {
                view = new EditText(window.getContext());
                view.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(view, 0, 0);
            } else {
                view = focusView;
            }
            view.requestFocus();
        }
        InputMethodManager imm =
                (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void startActivity(Class<?> clazz){
        startActivity(new Intent(getContext(), clazz));
    }

    @Override
    public void onStop() {
        super.onStop();
        ImmersionBar.destroy(this);
    }
}
