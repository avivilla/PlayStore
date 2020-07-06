package com.example.playstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GamesTopChartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter  tAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    private Button forYouBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_top_chart);

        ////////////////////// Button Activity ////////////////////

        forYouBtn =findViewById(R.id.for_you_button);
        forYouBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesTopChartActivity.this,GamesForYouActivity.class);
                startActivity(intent);
            }
        });
        ///////////////////////////////////////////////////////////////////

        //////////////////////////  Bottom Navigation codes starts here  //////////////////////////////

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.action_today:
                                Intent intent1 = new Intent(GamesTopChartActivity.this,TodayActivity.class);
                                startActivity(intent1);
                                break;
                            case R.id.action_games:
                                break;
                            case R.id.action_apps:
                                Intent intent2 = new Intent(GamesTopChartActivity.this,AppActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        return false;
                    }
                }
        );

        /////////////////////////////////////   Bottom Navigation codes ends here   //////////////////////////////////////////

        //////////////////////////////////// Recycler View codes start here   ////////////////////////////

        recyclerView = findViewById(R.id.app_recycle_view_top_chart);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tAdapter = new CategoryClassAdapter(CategoryModel.getCategoryList(),this,true);
        recyclerView.setAdapter(tAdapter);

        ////////////////////////////////   Recycler View codes ends here         ////////////////////////////////////

    }
}
