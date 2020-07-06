package com.example.playstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter  tAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    private TextView dateView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        //////////////////////set the date ////////////////////
        dateView = findViewById(R.id.current_date);
        dateView.setText(getDate());
        ////////////////////////////////////////////////////////////////

        //////////////////////////  Bottom Navigation codes starts here  //////////////////////////////

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.action_today:
                                break;
                            case R.id.action_games:
                                Intent intent1 = new Intent(TodayActivity.this,GamesTopChartActivity.class);
                                startActivity(intent1);
                                break;
                            case R.id.action_apps:
                                Intent intent2 = new Intent(TodayActivity.this,AppActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        return false;
                    }
                }
        );

        /////////////////////////////////////   Bottom Navigation codes ends here   //////////////////////////////////////////


        //////////////////////////////////// Recycler View codes start here   ////////////////////////////

        recyclerView = findViewById(R.id.today_recycle_view);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tAdapter = new TodayCardAdapter(DataModel.getData(),this);
        recyclerView.setAdapter(tAdapter);

        ////////////////////////////////   Recycler View codes ends here         ////////////////////////////////////

    }

    private String getDate()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String monthList[] = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String monthName = monthList[calendar.get(Calendar.MONTH)];
        SimpleDateFormat df= new SimpleDateFormat("EEEE");
        String dayOfWeek= df.format(date);
        String dateOfMonth = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        return dayOfWeek+" "+dateOfMonth+" "+monthName.toUpperCase();


    }
}
