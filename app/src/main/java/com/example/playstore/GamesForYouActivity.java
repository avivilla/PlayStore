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

public class GamesForYouActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter  tAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerViewTop;
    private  RecyclerView.Adapter  tAdapterTop;
    private  RecyclerView.LayoutManager layoutManagerTop;
    private Button topChartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_for_you);

        ////////////////////// Button Activity ////////////////////

        topChartBtn =findViewById(R.id.top_chart_button);
        topChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesForYouActivity.this,GamesTopChartActivity.class);
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
                                Intent intent1 = new Intent(GamesForYouActivity.this,TodayActivity.class);
                                startActivity(intent1);
                                break;
                            case R.id.action_games:
                                break;
                            case R.id.action_apps:
                                Intent intent2 = new Intent(GamesForYouActivity.this,AppActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        return false;
                    }
                }
        );

        /////////////////////////////////////   Bottom Navigation codes ends here   //////////////////////////////////////////

        //////////////////////////////////// Top Recycler View codes start here   ////////////////////////////

        recyclerViewTop = findViewById(R.id.app_recycle_view_for_you);
        recyclerViewTop.setHasFixedSize(true);
        layoutManagerTop =new LinearLayoutManager(this);
        recyclerViewTop.setLayoutManager(layoutManagerTop);
        tAdapterTop = new ForYouAdapter(DataModel.getData(),CategoryModel.getCategoryList(),this);
        recyclerViewTop.setAdapter(tAdapterTop);
//
//        //////////////////////////////////// Recycler View codes start here   ////////////////////////////
//
//        recyclerView = findViewById(R.id.app_recycle_view_for_you);
//        recyclerView.setHasFixedSize(true);
//        layoutManager =new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        tAdapter = new CategoryClassAdapter(CategoryModel.getCategoryList(),this,false);
//        recyclerView.setAdapter(tAdapter);
//
//        ////////////////////////////////   Recycler View codes ends here         ////////////////////////////////////

    }
}
