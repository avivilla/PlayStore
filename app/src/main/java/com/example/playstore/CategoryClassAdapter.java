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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryClassAdapter extends RecyclerView.Adapter<CategoryClassAdapter.MyViewHolder> {
    @NonNull
    private ArrayList<CategoryModel> categoryModelArrayList;
    private Context context;
    private  boolean showCategory;
    public CategoryClassAdapter(ArrayList<CategoryModel>categoryModelArrayList,Context context,boolean showCategory)
    {
        this.categoryModelArrayList=categoryModelArrayList;
        this.showCategory = showCategory;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_card,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return  myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(showCategory)
        {
            holder.categoryNameView.setText(categoryModelArrayList.get(position).category);
            RecyclerView.LayoutParams params= ( RecyclerView.LayoutParams) holder.linearLayout.getLayoutParams();
            params.height =(int) (getDeviceHeight() * 7 / 30);
        }


        RecyclerView.Adapter tAdapter = new HorizontalCardAdapter(DataModel.getData(),R.layout.row_horizotal_card,this.context);
        holder.recyclerView.setAdapter(tAdapter);

    }

    @Override
    public int getItemCount() {
        return categoryModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryNameView;
        public RecyclerView recyclerView;
        public LinearLayout linearLayout;

        public  RecyclerView.LayoutManager layoutManager;
        public MyViewHolder(View view) {
            super(view);
            linearLayout = view.findViewById(R.id.row_category_linear_layout);
            categoryNameView = view.findViewById(R.id.row_category_card_top_chart);
            recyclerView = view.findViewById(R.id.app_recycle_view_top_chart_category);
            recyclerView.setHasFixedSize(true);
            layoutManager =new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(layoutManager);

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
