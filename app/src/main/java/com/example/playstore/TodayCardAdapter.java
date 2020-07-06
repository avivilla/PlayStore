package com.example.playstore;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.Layout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodayCardAdapter extends RecyclerView.Adapter<TodayCardAdapter.MyViewHolder> {
    @NonNull
    private ArrayList<DataModel> dataModelArrayList;
    private Context context;

    public TodayCardAdapter(ArrayList<DataModel> dataModelArrayList,Context context)
    {
        this.dataModelArrayList=dataModelArrayList;
        this.context=context;
    }
    @Override
    public TodayCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View)  LayoutInflater.from(parent.getContext()).inflate(R.layout.row_today_card,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull TodayCardAdapter.MyViewHolder holder, int position) {
            final String dataName =  dataModelArrayList.get(position).dataName;
            final String dataDesc = dataModelArrayList.get(position).dataDesc;
            holder.dataNameView.setText(dataName);
            holder.dataDescView.setText(dataDesc);
           FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) holder.linearLayout.getLayoutParams();
            params.height = (int) (getDeviceHeight() * .5);
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView dataNameView;
        public TextView dataDescView;
        public LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dataNameView = itemView.findViewById(R.id.today_card_name);
            dataDescView = itemView.findViewById(R.id.today_card_desc);
            linearLayout = itemView.findViewById(R.id.row_today_card_linear1);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public int getDeviceHeight()
    {
        WindowManager windowManager = (WindowManager)    context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        try {
            display.getRealSize(size);
        } catch (NoSuchMethodError err) {
            display.getSize(size);
        }
        int width = size.x;
        int height = size.y;
        return  height;
    }
}
