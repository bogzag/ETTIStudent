/**
 * A login screen that offers login via username/password.
 */
package straticiucmihai.ettistudent;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;


/**
 * Enum that defines the type of user
 */
enum User_Type{
    Test_user,
    Valid_user,
    Unknown_user
}

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static String Testuser = "Mihai";
    private static String Testpassword = "prost";
    User_Type type_user;
    EditText enterUsername , enterPassword;
    Button loginButton;
    private String User ;
    private String Password ;
    private  String temp ;
    String []  Temp134 =new String[50];
    /*File*/
    String Filename = "Userstest5.txt";
    String [] UsernameFile  = new String[50];
    String [] PasswordFile  = new String[50];
    boolean m_UserFile_present;






    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        enterUsername = (EditText) findViewById(R.id.enterUsername);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        type_user = CheckUser();
        if(Check_internet_connection())
        {
            Toast.makeText(this,"Internet connection present ",Toast.LENGTH_LONG).show();
            try {
                Read_from_file();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else

        {
            Toast.makeText(this,"No Internet connection use local stored data ",Toast.LENGTH_LONG).show();
            try {
                Read_from_file();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View login_screen) {
        switch (login_screen.getId())
        {
            case R.id.loginButton:
                if(CheckUser()== User_Type.Test_user) {
                    startActivity(new Intent(this, HomeScreen.class));
                    finish();
                                }
                else{
                    startActivity(new Intent( this ,ShowPopUp.class));
                    }
                 break;
        }
    }
    private User_Type CheckUser ()
    {
            User = (String) enterUsername.getText().toString();
            Password = (String) enterPassword.getText().toString();
            enterUsername.setText("");
            enterPassword.setText("");
            if(User.equals(Testuser) && Password.equals(Testpassword))
            {
              return User_Type.Test_user;
            }
            else return User_Type.Unknown_user;
    }
    /*Is used always in case of internet connection present  load- before */
    private void Read_from_file () throws IOException {
        FileInputStream file = null;
        try {
            file= openFileInput(Filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(file == null)
          {
              try {
                  m_UserFile_present=false;
                  FileOutputStream fileOutputStream = openFileOutput(Filename,MODE_PRIVATE);
                  String temp = "Mihai@prost@Student@nr1@Student2@nre3@Student4@password4";
                  fileOutputStream.write(temp.getBytes());
                  fileOutputStream.close();
                  Toast.makeText(this,"File was created with the text :*****" + temp+"****" + getFilesDir()+"/"+Filename,Toast.LENGTH_LONG).show();
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          else
          {
              m_UserFile_present=true;
              InputStreamReader stream_input = new InputStreamReader(file);
              BufferedReader bufferedReader = new BufferedReader(stream_input);
              temp=bufferedReader.readLine();
              split_temp();
              Toast.makeText(this,"File was opened succesful "+getFilesDir()+"/"+Filename ,Toast.LENGTH_LONG).show();
          }
    }
    /*Is used only in case that  internet connection is valid  and first time connection     */
    private void Write_in_file ()
    {

    }

    private boolean Check_internet_connection ()
    {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
      return connected;
    }
    private void split_temp()
    {
        String[] temp_split=temp.split("@");
        Temp134 = temp.split("@");
        int temp_count=0;
        for(int i=0 ; i<temp_split.length;i+=2)
        {
            UsernameFile[temp_count] =temp_split[i];
            //PasswordFile[i] =temp_split[i];
            temp_count++;
        }
         temp_count=0;
        for(int i=1 ; i<temp_split.length;i+=2)
        {
            //UsernameFile[i] =temp_split[i];
            PasswordFile[temp_count] =temp_split[i];
            temp_count++;
        }
    }
}



