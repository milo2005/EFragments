package ezlife.movil.efragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ezlife.movil.efragments.fragments.ColorFragment;
import ezlife.movil.efragments.fragments.ListFragment;

public class SupportScreenActivity extends AppCompatActivity
        implements ListFragment.OnColorSelectedListener {

    ListFragment list;
    ColorFragment color;

    boolean phone, land, detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_screen);

        list =  new ListFragment();
        color =  new ColorFragment();

        phone =  getResources().getBoolean(R.bool.phone);
        land =  getResources().getBoolean(R.bool.land);

        putFragment(list, R.id.container1);

        if(land && !phone)
            putFragment(color, R.id.container2);



    }

    public void putFragment(Fragment fragment, int idContainer){

        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();
        ft.replace(idContainer, fragment);
        ft.commit();
    }

    @Override
    public void onColorSelected(int color) {

        this.color.setColor(color);
        if(phone || (!phone && !land)) {
            putFragment(this.color, R.id.container1);
            detail = true;
        }

    }

    @Override
    public void onBackPressed() {
        if(detail)
            putFragment(list, R.id.container1);
        else
            super.onBackPressed();
    }
}
