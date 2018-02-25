package cleancore.dev.cenock.com.core.presentation.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.List;

import cleancore.dev.cenock.com.core.R;

/**
 * Created by carlosenock.
 * <p>
 * The activity only will execute operations that affect the UI.
 */

public abstract class BaseActivity<BINDER extends ViewDataBinding> extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected BINDER binder;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuId(), menu);
        return true;
    }

    protected int getMenuId() {
        return R.menu.empty_menu;
    }

    /**
     * The onCreate base will init this view
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTransitionAnimations();
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, getLayoutId());
        injectDependencies();
        setupToolbar();
        initView();
    }

    protected abstract void initView();

    /**
     * Setup the object graph and inject the dependencies needed on this activity.
     */
    protected abstract void injectDependencies();
    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        unbindViews();
        super.onDestroy();
    }

    protected void setupToolbar() {
        setupToolbar(R.id.toolbar);
    }

    protected void setupToolbar(int toolbarId) {
        mToolbar = findViewById(toolbarId);
        try {
            setSupportActionBar(mToolbar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startActivity(Class activityClass) {
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    private void unbindViews() {
        if (binder != null)
            binder.unbind();
    }

    protected void setTransitionAnimations() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    protected List<Fragment> getFragmentStack() {
        return getSupportFragmentManager().getFragments();
    }

    public void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    protected void showUpButton(boolean show) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(show);
    }

    protected void hideActionBar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }
}
