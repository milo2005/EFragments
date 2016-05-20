package ezlife.movil.efragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ezlife.movil.efragments.adapters.PagerAdapter;
import ezlife.movil.efragments.fragments.ColorFragment;
import ezlife.movil.efragments.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnColorSelectedListener{

    ViewPager pager;
    PagerAdapter adapter;

    Toolbar toolbar;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabs = (TabLayout) findViewById(R.id.tabs);

        pager = (ViewPager) findViewById(R.id.pager);
        List<Fragment> data = new ArrayList<>();

        ColorFragment azul = new ColorFragment();
        azul.setColor(ColorFragment.COLOR_AZUL);

        ColorFragment verde =  new ColorFragment();
        verde.setColor(ColorFragment.COLOR_VERDE);

        ColorFragment rojo = new ColorFragment();
        rojo.setColor(ColorFragment.COLOR_ROJO);

        ListFragment list = new ListFragment();

        data.add(azul);
        data.add(verde);
        data.add(rojo);
        data.add(list);

        adapter = new PagerAdapter(getSupportFragmentManager(),data);
        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);

    }

    @Override
    public void onColorSelected(int color) {
        Toast.makeText(this, "Color :"+color, Toast.LENGTH_SHORT).show();
    }
}
