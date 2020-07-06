package com.example.playstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {
    private RecyclerView recyclerViewHorizontal;
    private  RecyclerView.Adapter  myAdapterHorizontal;
    private  RecyclerView.LayoutManager layoutManagerHorizontal;
    private RecyclerView recyclerViewGrid;
    private  RecyclerView.Adapter  myAdapterGrid;
    private  RecyclerView.LayoutManager layoutManagerGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        //////////////////////////  Bottom Navigation codes starts here  //////////////////////////////

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.action_today:
                                Intent intent1 = new Intent(AppActivity.this,TodayActivity.class);
                                startActivity(intent1);
                                break;
                            case R.id.action_games:
                                Intent intent2 = new Intent(AppActivity.this,GamesTopChartActivity.class);
                                startActivity(intent2);
                                break;
                            case R.id.action_apps:

                                break;
                        }
                        return false;
                    }
                }
        );

        /////////////////////////////////////   Bottom Navigation codes ends here   //////////////////////////////////////////

        //////////////////////////////////// Horizontal Recycler View codes start here   ////////////////////////////

        recyclerViewHorizontal = findViewById(R.id.app_recycle_view_horizontal);
        recyclerViewHorizontal.setHasFixedSize(true);
        layoutManagerHorizontal =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(layoutManagerHorizontal);
        myAdapterHorizontal = new HorizontalCardAdapter(DataModel.getData(),R.layout.row_horizotal_card,this);
        recyclerViewHorizontal.setAdapter(myAdapterHorizontal);

        //////////////////////////////// Horizontal   Recycler View codes ends here         ////////////////////////////////////

        //////////////////////////////////// Grid Recycler View codes start here   ////////////////////////////

        recyclerViewGrid = findViewById(R.id.app_recycle_view_grid);
        recyclerViewGrid.setHasFixedSize(true);
        layoutManagerGrid=new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false);
        recyclerViewGrid.setLayoutManager(layoutManagerGrid);
        myAdapterGrid = new HorizontalCardAdapter(DataModel.getData(),R.layout.row_horizontal_grid_card,this);
        recyclerViewGrid.setAdapter(myAdapterGrid);

        //////////////////////////////// Grid   Recycler View codes ends here         ////////////////////////////////////


    }


}
