package arch.project.arch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class TopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener{

    SharedPreferences pref;
    TextView name;
    TextView prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(arch.project.arch.R.layout.activity_top);

        //下のオプション
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(arch.project.arch.R.id.nav_total).setChecked(true);
        //初期設定
        fragmentTransaction(new TotalFragment());

        // headerに名前とprofを表示
        pref =getSharedPreferences("設定したもの", Context.MODE_PRIVATE);
    }

        private void fragmentTransaction(Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(arch.project.arch.R.id.container,fragment).commit();
        }


    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId ()){
            case  arch.project.arch.R.id.nav_total:
                //　遷移
                fragmentTransaction(new TotalFragment());
                return true;
            case arch.project.arch.R.id.nav_shop:
                fragmentTransaction(new ShopFragment());
                return true;
            case arch.project.arch.R.id.nav_company:
                fragmentTransaction(new CompanyFragment());
                return true;
        }
        return false;
    }

}