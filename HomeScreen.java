package straticiucmihai.ettistudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {
    public static Activity HomeScr;
      ImageButton button_pr_info,button_payment,button_sesiune,button_disciplines,button_feedback,button_grades;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeScr=this;
        button_pr_info = (ImageButton) findViewById(R.id.personal_info);
        button_pr_info.setOnClickListener(this);
        button_payment = (ImageButton) findViewById(R.id.plati);
        button_payment.setOnClickListener(this);
        button_sesiune = findViewById(R.id.sesiune);
        button_sesiune.setOnClickListener(this);
       /* button_disciplines=findViewById(R.id.discipline);
        button_disciplines.setOnClickListener(this);*/
        button_feedback=findViewById(R.id.feedback);
        button_feedback.setOnClickListener(this);
       /* button_grades=findViewById(R.id.situatie_scolara);
        button_grades.setOnClickListener(this);
        logout_main = (ImageButton) findViewById(R.id.logout_main);
        logout_main.setOnClickListener(this);
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(this);
    */}


    @Override
    public void onClick(View activity_main) {
        switch (activity_main.getId())
        {
            case R.id.personal_info:
                startActivity(new Intent(this,PersonalInfo.class));
                break;
            case R.id.plati:
                startActivity(new Intent(this,PaymentSituation.class));
                break;
            case R.id.sesiune:
                startActivity(new Intent(this,SesiuneScreen.class));
                break;
            /*case R.id.situatie_scolara:
                startActivity(new Intent(this,SituatieScolaraScreen.class));
                break;
            case R.id.discipline:
                startActivity(new Intent(this,DisciplineScreen.class));
                break;*/
            case R.id.feedback:
                startActivity(new Intent(this,FeedBackScreen.class));
                break;
            default:

                break;
        }
    }



}
