package straticiucmihai.ettistudent;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class ShowPopUp  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_failed);

        /*width and height*/
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.2));
        //finish();
    }
}
