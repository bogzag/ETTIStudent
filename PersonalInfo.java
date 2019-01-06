package straticiucmihai.ettistudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class PersonalInfo extends Activity implements View.OnClickListener {
    /*User information */
    String Name = " Straticiuc Mihai ";
    String pi_nr_matricol = "19846412984423";
    String actual_year ="Anul 2";
    String level_of_study = " Licenta";
    String groupe = "5214";
    String specialization = "TST Engleza";
    String type_payment = "Taxa";

    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinfo_screen);
        /*Initialize buttons */
        ImageButton logOut =(ImageButton) findViewById(R.id.logout_main);
        ImageButton home_button =(ImageButton) findViewById(R.id.home_button);
        logOut.setOnClickListener(this);
        home_button.setOnClickListener(this);
        /*Set the text */
        TextView name_ly =(TextView)findViewById(R.id.pi_name);
        name_ly.setText(Name);

        TextView nr_mat_ly = findViewById(R.id.pi_nrmatri);
        nr_mat_ly.setText("Numar matricola:"+pi_nr_matricol);

        TextView current_year_ly =(TextView)findViewById(R.id.pi_actual_year);
        current_year_ly.setText("Actual Year:"+actual_year);

        TextView lvl_study_ly =(TextView)findViewById(R.id.pi_lvl_study);
        lvl_study_ly.setText("Level of Study:"+level_of_study);

        TextView grupely_ly =(TextView)findViewById(R.id.pi_group);
        grupely_ly.setText("Your grope:"+groupe);

        TextView specializare_ly =(TextView)findViewById(R.id.pi_spec);
        specializare_ly.setText("Specialization:"+specialization);

        TextView pay_ly =(TextView)findViewById(R.id.pi_payment);
        pay_ly.setText("Type of funding:"+type_payment);

    }
    @Override
    public void onClick(View personalinfo_screen) {
        switch (personalinfo_screen.getId())
        {
            case R.id.logout_main:
                    startActivity(new Intent(this, LoginActivity.class));

                    finish();
                    break;
            case R.id.home_button:
                startActivity(new Intent(this,HomeScreen.class));
                finish();
                break;
        }
    }
}

