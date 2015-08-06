package njerry.freshbox;

import com.bowyer.app.fabtoolbar.FabToolbar;
import com.parse.ParseUser;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageView;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {


    @InjectView(R.id.fabtoolbar)
    FabToolbar mFabToolbar;
    @InjectView(R.id.fab)
    FloatingActionButton mFab;

    @InjectView(R.id.categories)
    ImageView mIcCall;
    @InjectView(R.id.extras)
    ImageView mIcEmail;
    @InjectView(R.id.order)
    ImageView mIcForum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mFabToolbar.setFab(mFab);
    }



    public void categories (View v){

        Intent intent = new Intent(getBaseContext(), Categories.class);
        startActivity(intent);
    }


    @OnClick(R.id.fab)
    void onFabClick() {
        mFabToolbar.expandFab();
    }

    @OnClick(R.id.categories)
    void onClickCall() {
        iconAnim(mIcCall);
    }

    @OnClick(R.id.extras)
    void onClickEmail() {
        iconAnim(mIcEmail);
    }

    @OnClick(R.id.order)
    void onClickForum() {
        iconAnim(mIcForum);
    }

    private void iconAnim(View icon) {
        Animator iconAnim = ObjectAnimator.ofPropertyValuesHolder(
                icon,
                PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f, 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f, 1f));
        iconAnim.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                ParseUser.logOut();
                Intent intent = new Intent(this, login.class);
                startActivity(intent);
                finish();
                return true;
        }
        return false;
    }


}