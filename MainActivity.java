package onesentencenews.com.toolbar;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView tvClose = findViewById(R.id.tv_close);
        mToolbar = findViewById(R.id.tb_tool);

        mLayout = findViewById(R.id.dl_layout);
        mToggle = new ActionBarDrawerToggle(this, mLayout, mToolbar, R.string.drawer_open, R.string
                .drawer_close);
        mToggle.syncState();
        mLayout.setDrawerListener(mToggle);
        mToolbar.setTitle("toolbar");

        setSupportActionBar(mToolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case android.R.id.home:
                        mLayout.closeDrawer(Gravity.LEFT);
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_setting:
                        Toast.makeText(MainActivity.this, "action_setting", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                    break;
                }
                return true;
            }
        });
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

}
