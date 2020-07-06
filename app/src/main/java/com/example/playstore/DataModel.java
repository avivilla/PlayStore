package com.example.playstore;

import java.util.ArrayList;

public class DataModel {
    public String dataName;
    public String dataDesc;
    public String dataType;
    public int dataSize;

    public DataModel(String dataName,String dataDesc,String dataType,int dataSize)
    {
        this.dataDesc=dataDesc;
        this.dataName=dataName;
        this.dataSize=dataSize;
        this.dataType=dataType;
    }

    public static ArrayList<DataModel> getData()
    {
        ArrayList<DataModel> arrayList= new ArrayList<DataModel>();
        for(int i=0; i< DataArray.dataNameArray.length;i++)
        {
            arrayList.add(new DataModel(DataArray.dataNameArray[i],DataArray.dataDescArray[i],DataArray.dataTypeArray[i],DataArray.dataSizeArray[i]));
        }
        return arrayList;

    }
}
class DataArray{
    final static String dataNameArray[] = new String[]{"Road Rash","Color POP", "AMTV","Sweet Text","Slide Show Maker","Baby Snaps","PUBG","COD 5","Subway Surfs","Candy Crush"};
    final static String dataDescArray[] = new String[]{"Racing Game","Add Color effects","Add Music to Video","Story Maker & GIF","Make Slide Show","Photo Editor","Players Unknown Battleground","Call of Duty 5","Run Away","Crush to score"};
    final  static String dataTypeArray[] = new String[]{"GAME","APP","APP","APP","APP","APP","GAME","GAME","GAME","GAME"};
    final static  int dataSizeArray[]= new int[]{5,6,7,3,7,15,9,15,12,7};

}
