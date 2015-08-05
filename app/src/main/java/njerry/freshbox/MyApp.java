package njerry.freshbox;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by njerry on 8/5/15.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "njUSHg0PQUz0chQtiwk7FDf5feEYFNrB5vSyZHF7", "sUlVnxyERlobrOQN86pAc1RGfqUDQd6L2G7FMxWn");
    }
}
