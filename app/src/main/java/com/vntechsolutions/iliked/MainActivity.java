package com.vntechsolutions.iliked;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottmNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){

        bottmNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        fragmentManager = getSupportFragmentManager();
        bottmNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changeFragment(new HomeActivity());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            int id = item.getItemId();
            switch (id){
                case R.id.action_index:
                    fragment = new HomeActivity();
                    break;
                case R.id.action_event:
                    fragment = new EventActivity();
                    break;
                case R.id.action_study:
                    fragment = new HomeActivity();
                    break;
                case R.id.action_menu_more:
                    fragment = new EventActivity();
                    break;
            }
            Log.d( TAG , String.valueOf(id));
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.view_page, fragment).commit();
            return true;
        }
    };
    private void changeFragment(Fragment fm){
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.view_page, fm);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
