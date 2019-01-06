package straticiucmihai.ettistudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class SesiuneScreen extends Activity implements View.OnClickListener {

    private String[] name_exam ={"Cheese", "Pepperoni", "Black Olives","Cheese3", "Pepperoni3", "Black Olives3","Cheese4", "Pepperoni4", "Black Olives4"};
    private String[] data_examen = { "cat", "dog", "mouse","cat3", "dog3", "mouse3","cat4", "dog4", "mouse4"};
    private String[] ora_examen = {"bird", "fish", "cow","bird1", "fish1", "cow1" ,"bird2", "fish2", "cow2"};
    private String[] locul_examen ={"bird4", "fish4", "cow4","bird4", "fish4", "cow4" ,"bird4", "fish4", "cow4"};
    private String[] profesorul_examen={"Marcel Roman", "Alexandrescu Iolanda", "Black Olives","Alexandru Cel Mare ", "Pepperoni3", "Black Olives3","Cheese4", "Pepperoni4", "Black Olives4"};
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sesiune_screen);
        /*Initialize buttons */
        ImageButton logOut =(ImageButton) findViewById(R.id.logout_main);
        ImageButton home_button =(ImageButton) findViewById(R.id.home_button);
        logOut.setOnClickListener(this);
        home_button.setOnClickListener(this);
        /*List of payment*/
       ListView listView= (ListView)findViewById(R.id.list_exam);
        CustomAdapter customAdapter= new CustomAdapter();
        listView.setAdapter(customAdapter);


    }

    public void onClick(View sesiune_screen ) {
        switch (sesiune_screen.getId())
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
    class CustomAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return name_exam.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customsesiunescreen,null);
            TextView name =(TextView)view.findViewById(R.id.name);
            TextView date =(TextView)view.findViewById(R.id.date);
            TextView hour =(TextView)view.findViewById(R.id.hour);
            TextView place =(TextView)view.findViewById(R.id.place);
            TextView teacher =(TextView)view.findViewById(R.id.teacher);
            name.setText("Object:"+name_exam[i]);
            date.setText("Date:"+data_examen[i]);
            hour.setText("Hour:"+ora_examen[i]);
            place.setText("Place:"+locul_examen[i]);
            teacher.setText("Teacher:"+profesorul_examen[i]);
            return view;
        }
    }
}
