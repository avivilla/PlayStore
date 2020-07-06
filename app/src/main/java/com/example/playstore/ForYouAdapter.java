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

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.widget.LinearLayout.*;

public class ForYouAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {
    @NonNull
    private ArrayList<DataModel> dataModelArrayList;
    private ArrayList<CategoryModel> categoryModelArrayList;
    private  Context context;
    private final int TYPE_SHOW_CATEGORY = 0;
    private final int TYPE_SHOW_TOP=1;
    public ForYouAdapter(ArrayList<DataModel>dataModelArrayList,ArrayList<CategoryModel>categoryModelArrayList,Context context)
    {
        this.dataModelArrayList=dataModelArrayList;
        this.categoryModelArrayList=categoryModelArrayList;
        this.context=context;
    }
    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return TYPE_SHOW_TOP;
        } else {
            return TYPE_SHOW_CATEGORY;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_SHOW_TOP)
        {
            view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_card,parent,false);
            return new TopDataViewHolder(view);
        }
        else
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category_card,parent,false);
            return  new CategoryDataViewHolder(view);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_SHOW_CATEGORY)
        {
            ((CategoryDataViewHolder)holder).updateView(categoryModelArrayList.get(position-1));
        }
        else
        {
            ((TopDataViewHolder)holder).updateView(dataModelArrayList);
        }
    }



    @Override
    public int getItemCount() {
        return categoryModelArrayList.size()+1;
    }

   class TopDataViewHolder extends RecyclerView.ViewHolder{
       public TextView categoryNameView;
       public RecyclerView recyclerView;
       public LinearLayout linearLayout;
       public  RecyclerView.LayoutManager layoutManager;
       public TopDataViewHolder(@NonNull View itemView) {
           super(itemView);
           linearLayout = itemView.findViewById(R.id.row_category_linear_layout);
           categoryNameView = itemView.findViewById(R.id.row_category_card_top_chart);
           recyclerView = itemView.findViewById(R.id.app_recycle_view_top_chart_category);
           recyclerView.setHasFixedSize(true);
           layoutManager =new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
           recyclerView.setLayoutManager(layoutManager);
       }
       @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
       public void updateView(ArrayList<DataModel> dataModelArrayList)
       {
           categoryNameView.setVisibility(View.GONE);
           RecyclerView.LayoutParams params= (RecyclerView.LayoutParams)  linearLayout.getLayoutParams();
           params.height = (int) (getDeviceHeight()*0.35);
           RecyclerView.Adapter tAdapter = new ForYouTopCardAdapter(dataModelArrayList,context);
           recyclerView.setAdapter(tAdapter);
       }
   }
   class CategoryDataViewHolder extends  RecyclerView.ViewHolder{
       public TextView categoryNameView;
       public RecyclerView recyclerView;
       public LinearLayout linearLayout;

       public  RecyclerView.LayoutManager layoutManager;
       public CategoryDataViewHolder(View view) {
           super(view);
           linearLayout = view.findViewById(R.id.row_category_linear_layout);
           categoryNameView = view.findViewById(R.id.row_category_card_top_chart);
           recyclerView = view.findViewById(R.id.app_recycle_view_top_chart_category);
           recyclerView.setHasFixedSize(true);
           layoutManager =new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
           recyclerView.setLayoutManager(layoutManager);

       }
       @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
       public void updateView(CategoryModel category)
       {
           categoryNameView.setVisibility(View.GONE);
           RecyclerView.LayoutParams params= (  RecyclerView.LayoutParams)  linearLayout.getLayoutParams();
           params.height =(int) (getDeviceHeight() * 0.2);
           RecyclerView.Adapter tAdapter = new HorizontalCardAdapter(DataModel.getData(),R.layout.row_horizotal_card,context);
           recyclerView.setAdapter(tAdapter);
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
