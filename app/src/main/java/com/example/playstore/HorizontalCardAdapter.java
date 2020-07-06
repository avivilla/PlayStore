package com.example.playstore;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalCardAdapter extends RecyclerView.Adapter<HorizontalCardAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataModelArrayList;
    private int layoutFile;
    private Context context;
    public HorizontalCardAdapter(ArrayList<DataModel> dataModelArrayList,int layoutFile,Context context)
    {
        this.layoutFile = layoutFile;
        this.dataModelArrayList=dataModelArrayList;
        this.context=context;

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(layoutFile,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.updateView(dataModelArrayList.get(position).dataName, Integer.toString(dataModelArrayList.get(position).dataSize)+" MB",getDeviceWidth());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public TextView sizeView;
        public LinearLayout linearLayout;
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView=(TextView) itemView.findViewById(R.id.horizontal_card_name);
            sizeView=(TextView)itemView.findViewById(R.id.horizontal_card_size);
            linearLayout =(LinearLayout)itemView.findViewById(R.id.row_horizotal_card_linear_layout1);


        }
        public  void updateView(String name,String size,int deviceWidth)
        {

           sizeView.setText(size);
           nameView.setText(name);
           if(linearLayout !=null) {
               RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) linearLayout.getLayoutParams();
               params.width = (int) (deviceWidth * 2/7);
           }

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public int getDeviceWidth()
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
//        int height = size.y;
        return  width;
    }
}
