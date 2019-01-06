package straticiucmihai.ettistudent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import org.jetbrains.annotations.Nullable;

 public class FeedBackScreen extends AppCompatActivity implements View.OnClickListener {
     EditText message;
    protected  void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedbackscreen);
        ImageButton logOut =(ImageButton) findViewById(R.id.logout_main);
        ImageButton home_button =(ImageButton) findViewById(R.id.home_button);
        ImageButton send_email = (ImageButton) findViewById(R.id.send_to);
        logOut.setOnClickListener(this);
        home_button.setOnClickListener(this);
        send_email.setOnClickListener(this);
        message= findViewById(R.id.enterFeedBack);
    }
    @Override
    public void onClick(View feedbackscreen)
    {
        switch (feedbackscreen.getId())
        {
            case R.id.logout_main:
                startActivity(new Intent(this, LoginActivity.class));

                finish();
                break;
            case R.id.home_button:
                startActivity(new Intent(this,HomeScreen.class));
                finish();
                break;
            case R.id.send_to:
                String input_message = message.getText().toString();
                Intent emailSend = new Intent(Intent.ACTION_SEND);
                emailSend.putExtra(Intent.EXTRA_EMAIL,new String[]{"leonte.gruia@gmail.com"});
                emailSend.putExtra(Intent.EXTRA_SUBJECT,"Problem report android app");
                emailSend.putExtra(Intent.EXTRA_TEXT,input_message);
                emailSend.setType("message/rfc822");
                startActivity(Intent.createChooser(emailSend, "Send mail..."));
                message.setText("");
            break;
        }
    }
}
