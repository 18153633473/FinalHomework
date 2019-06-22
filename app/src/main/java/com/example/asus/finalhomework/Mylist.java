package com.example.asus.finalhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Mylist extends Activity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{

    ListView list;
    SimpleAdapter listItemAdapter;
    final ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
    private static final int[] ImageList = new int[]{
            R.drawable.heart, R.drawable.kaoshi, R.drawable.cake,
            R.drawable.jieri, R.drawable.ic_local_airport,R.drawable.home};
    private static final int[] Background = new int[]{
            R.drawable.bgp1, R.drawable.bgp2,
            R.drawable.bgp3, R.drawable.bgp4, R.drawable.bgp5,R.drawable.bgp6};
    private static final int[] Label = new int[]{
            R.drawable.label1, R.drawable.label2, R.drawable.label3,
            R.drawable.label5, R.drawable.label4, R.drawable.label6};
    private static final String[] TextList = new String[]{"纪念日", "考试", "生日",
            "节假日", "旅行","自定义"};
    String res;
    String standardDate;
    int newposition;
    caculater caculate;


    private UsualDialogger dialog2 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);


        DBManager manager = new DBManager(this);

        listItemAdapter = new SimpleAdapter(this, listItem, R.layout.item_listview_demo,
                new String[]{"ItemImage", "ItemTitle", "LastImage", "background","ItemDate","ItemResult"},
                new int[]{R.id.ItemImage, R.id.ItemTitle, R.id.last, R.id.imageView,R.id.datetext2,R.id.tian});
        for(RateItem item : manager.listAll()) {

            try {
                caculate=new caculater(item.getdateDate());
                //Log.i("bitch","是否调用"+standardDate);
                res=caculate.getResultDate();
                standardDate=caculate.getStandardDate();
            } catch (ParseException e) {
                //Log.i("bitch","ParseException"+standardDate);
                e.printStackTrace();

            }
            int a = Integer.parseInt(item.getDateType());
            String newid=Integer.toString(item.getId());
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", ImageList[a]);
            map.put("ItemTitle", item.getdateName());
            map.put("ItemDate",standardDate);
            Log.i("bitch","????"+standardDate);
            map.put("ItemResult",res);
            Log.i("bitch","??"+res);
            map.put("LastImage", Label[a]);
            map.put("background", Background[a]);
            map.put("id",newid);
            listItem.add(map);
            //listItemAdapter.notifyDataSetChanged();
        }

        if (listItem.size()==0){
            showUsualDialog1();
        }

        list = (ListView) findViewById(R.id.mylistlv);
        list.setAdapter(listItemAdapter);
        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        //Intent rateCalc = new Intent(this, Mylist.class);
        //startActivity(rateCalc);
    }
    public void flush(View view) {
        finish();
        Intent intent = new Intent(this, Mylist.class);
        startActivity(intent);
        Log.i("onItemClick:","flush");
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        newposition=position;
        showUsualDialog();
        return false;
    }
    public void showUsualDialog() {
        Map<String,String> mapitem = (Map<String,String>) list.getItemAtPosition(newposition);
        String id1 = mapitem.get("id");
        String msg = mapitem.get("ItemTitle");
        dialog2 = UsualDialogger.Builder(this)
                .setTitle("WARNING")
                .setMessage("确认要删除日期"+msg+"吗？")
                .setOnConfirmClickListener("确定", view -> {
                    Toast.makeText(Mylist.this, "确定", Toast.LENGTH_SHORT).show();

                    Log.i("onItemClick:","nihao"+id1);
                    DBManager manager = new DBManager(this);
                    manager.delete(id1);
                    //listItemAdapter.notifyDataSetChanged();
                    flush(view);
                })
                .setOnCancelClickListener("取消", view -> {
                    Toast.makeText(Mylist.this, "取消", Toast.LENGTH_SHORT).show();
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                })
                .build()
                .shown();
    }
    public void showUsualDialog1() {
        dialog2 = UsualDialogger.Builder(this)
                .setTitle("WARNING")
                .setMessage("无此类日期卡，是否去主页添加")
                .setOnConfirmClickListener("确定", view -> {
                    Toast.makeText(Mylist.this, "确定", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ListActivity.class);
                    startActivity(intent);
                    //listItemAdapter.notifyDataSetChanged();

                })
                .setOnCancelClickListener("取消", view -> {
                    Toast.makeText(Mylist.this, "取消", Toast.LENGTH_SHORT).show();
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                })
                .build()
                .shown();
    }
    public void onClick(View btn) {
        if (btn.getId() == R.id.imaghome) {
            Log.i("onclick","onclick");
            finish();
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }
        if (btn.getId() == R.id.imageView) {
            Log.i("onclick","menu");
            finish();
            Intent rateCalc = new Intent(this, add.class);
            startActivity(rateCalc);

        }

    }


}



