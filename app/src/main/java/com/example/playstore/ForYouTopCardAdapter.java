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

public class ForYouTopCardAdapter extends  RecyclerView.Adapter<ForYouTopCardAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataModelArrayList;
    private Context context;


    public ForYouTopCardAdapter(ArrayList<DataModel> dataModelArrayList,Context context)
    {
        this.context=context;
        this.dataModelArrayList=dataModelArrayList;
    }
    @NonNull
    @Override
    public ForYouTopCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_you_top_card,parent,false);
        ForYouTopCardAdapter.MyViewHolder myViewHolder = new ForYouTopCardAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = dataModelArrayList.get(position).dataName;
        String desc =dataModelArrayList.get(position).dataDesc;
        holder.descView.setText(desc);
        holder.nameView.setText(name);
        RecyclerView.LayoutParams params= ( RecyclerView.LayoutParams) holder.linearLayout.getLayoutParams();
        params.width = getDeviceWidth()*2/3;
    }


    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public TextView descView;
        public LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView=(TextView) itemView.findViewById(R.id.for_you_top_card_name);
            descView=(TextView)itemView.findViewById(R.id.for_you_top_card_desc);
            linearLayout = itemView.findViewById(R.id.row_for_you_top_card_linear1);
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
        int height = size.y;
        return  width;
    }
}
