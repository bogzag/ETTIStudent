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

public class PaymentSituation extends Activity implements View.OnClickListener {
   /*  int nr_instante=5;
    IDpayment[] array ;*/
   private String[] toppings = {"Cheese", "Pepperoni", "Black Olives","Cheese3", "Pepperoni3", "Black Olives3","Cheese4", "Pepperoni4", "Black Olives4"};
    private String[] elements = { "cat", "dog", "mouse","cat3", "dog3", "mouse3","cat4", "dog4", "mouse4" };
    private String[] elements2 =  { "bird", "fish", "cow","bird1", "fish1", "cow1" ,"bird2", "fish2", "cow2"  };
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_screen);
        /*Initialize buttons */
        ImageButton logOut =(ImageButton) findViewById(R.id.logout_main);
        ImageButton home_button =(ImageButton) findViewById(R.id.home_button);
        logOut.setOnClickListener(this);
        home_button.setOnClickListener(this);
        /*List of payment*/
        ListView listView= (ListView)findViewById(R.id.list);
        CustomAdapter customAdapter= new CustomAdapter();
        listView.setAdapter(customAdapter);


    }

    @Override
    public void onClick(View payment_screen) {
        switch (payment_screen.getId())
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
            return elements.length;
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
            view = getLayoutInflater().inflate(R.layout.custompaymentscreen,null);
            TextView text1 =(TextView)view.findViewById(R.id.text1);
            TextView text2 =(TextView)view.findViewById(R.id.text2);
            TextView text3 =(TextView)view.findViewById(R.id.text3);
            text1.setText("Type:"+toppings[i]);
            text2.setText("Money:"+elements[i]);
            text3.setText("Date:"+elements2[i]);
            return view;
        }
    }

}

