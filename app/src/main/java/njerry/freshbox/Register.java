package njerry.freshbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Register extends AppCompatActivity {

    private EditText namefield;
    private EditText emailfield;
    private EditText mobilefield;
    private EditText usernamefield;
    private EditText passwordfield;
    private TextView merrorField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        namefield= (EditText)findViewById(R.id.name);
        emailfield= (EditText) findViewById(R.id.email);
        mobilefield= (EditText) findViewById(R.id.mobile);
        usernamefield=(EditText)findViewById(R.id.register_username);
        passwordfield=(EditText)findViewById(R.id.register_password);
        merrorField= (TextView) findViewById(R.id.error_messages);
    }

    public void register(final View v){

        //checking if user fields are not blank
        if(usernamefield.getText().length() == 0 || emailfield.getText().length() == 0 || passwordfield.getText().length() ==0)
        /*|| mobilefield.getText().length() == 0 || namefield.getText().length() == 0 || passwordfield.getText().length() ==0)*/
        return;

        v.setEnabled(false);
        ParseUser user = new ParseUser();
        user.setUsername(usernamefield.getText().toString());
        user.setPassword(passwordfield.getText().toString());
        //user.setEmail(String.(emailfield));

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(Register.this, Category.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    switch (e.getCode()) {
                        case ParseException.USERNAME_TAKEN:
                            merrorField.setText("Sorry, this username has already been taken.");
                            break;
                        case ParseException.USERNAME_MISSING:
                            merrorField.setText("Sorry, you must supply a username to register.");
                            break;
                        case ParseException.PASSWORD_MISSING:
                            merrorField.setText("Sorry, you must supply a password to register.");
                            break;
                        default:
                            merrorField.setText(e.getLocalizedMessage());
                    }
                    v.setEnabled(true);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
