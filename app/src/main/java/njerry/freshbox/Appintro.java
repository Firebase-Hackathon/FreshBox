package njerry.freshbox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class Appintro extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance("FreshBox", "Want to cook an exotic meal, but don't know where to start?", R.drawable.slide3, R.color.material_deep_teal_500));
        addSlide(AppIntroFragment.newInstance("FreshBox", "We're here to help!\nJust scroll through the recipes...", R.drawable.slide2, R.color.material_deep_teal_500));
        addSlide(AppIntroFragment.newInstance("FreshBox", "Order your meal, and we deliver the ingredients right to your doorstep!", R.drawable.slide1, R.color.material_deep_teal_500));


        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        showSkipButton(true);
        showDoneButton(true);

        setVibrate(true);
        setVibrateIntensity(40);
    }

    private void loadRegister(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed() {
        loadRegister();
    }

    @Override
    public void onDonePressed() {
        loadRegister();
    }

    public void getStarted(View v) {
        loadRegister();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appintro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
