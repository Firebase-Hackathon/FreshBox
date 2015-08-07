package njerry.freshbox;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseQueryAdapter;

import njerry.freshbox.Getterssetters.extras;


public class ExtrasMain extends ListActivity {

    private ParseQueryAdapter<extras> mainAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setClickable(true);

        mainAdapter = new ParseQueryAdapter<extras>(this,extras.class);
        mainAdapter.setTextKey("Name");
        mainAdapter.setImageKey("Image");



        // Default view is all meals
        setListAdapter(mainAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_extras, menu);
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
