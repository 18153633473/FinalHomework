package com.example.asus.finalhomework;

public class RateItem {
    private int id;
    private String dateName;
    private String dateDate;
    private String dateType;

    public RateItem(){
        super();
        dateName="";
        dateDate="";
        dateType="";
    }
    public RateItem(String dateName, String dateDate ,String dateType){
        super();
        this.dateName=dateName;
        this.dateDate=dateDate;
        this.dateType=dateType;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getdateName(){
        return dateName;
    }
    public void setdateName(String dateName){
        this.dateName=dateName;
    }
    public String getdateDate(){
        return dateDate;
    }
    public void setdateDate(String dateDate){
        this.dateDate=dateDate;
    }
    public String getDateType(){
        return dateType;
    }
    public void setDateType(String dateType){
        this.dateType=dateType;
    }
}

