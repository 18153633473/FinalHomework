package com.example.asus.finalhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends Activity implements AdapterView.OnItemClickListener  {
    ArrayList<HashMap<String, Object>> listItem;
    ListView list;
    SimpleAdapter listItemAdapter;

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
    int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listItem = new ArrayList<HashMap<String, Object>>();
        for (i = 0; i < 6; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", ImageList[i]);// 图像资源的ID
            map.put("ItemTitle", TextList[i]);
            map.put("LastImage", Label[i]);
            map.put("background", Background[i]);
            listItem.add(map);
            //listItemAdapter.notifyDataSetChanged();
            Log.i("onclick", "onclick");

        }

        listItemAdapter = new SimpleAdapter(this, listItem, R.layout.item_listview_demo,
                new String[]{"ItemImage", "ItemTitle", "LastImage", "background"},
                new int[]{R.id.ItemImage, R.id.ItemTitle, R.id.last, R.id.imageView});

        list = (ListView) findViewById(R.id.ListView01);
        list.setAdapter(listItemAdapter);
        list.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i("onItemClick:","hello"+position);
        Intent rateCalc = new Intent(this, add.class);
        rateCalc.putExtra("type", position);
        startActivity(rateCalc);
        /*传参
        rateCalc.putExtra("title", titleStr);
        rateCalc.putExtra("rate", Float.parseFloat(detailStr));
        */
    }


    // 添加点击
       /* list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                setTitle("点击第" + arg2 + "个项目");
                if (arg2 == 3) {
                    ListActivity.this.finish();
                }
            }
        });*/

/*

*/
    public void onClick(View btn) {
        if (btn.getId() == R.id.imageView) {
            Log.i("onclick","onclick");
            Intent rateCalc = new Intent(this, add.class);
            rateCalc.putExtra("type", 5);
            startActivity(rateCalc);
        }
        if (btn.getId() == R.id.imageView2) {
            Log.i("onclick","menu");
            Intent rateCalc = new Intent(this, menu.class);
            startActivity(rateCalc);

        }

    }
        /*
    public void onClick(View btn){
        if (btn.getId()==R.id.btn1){
            i=1;

        }
        ListView list = (ListView) findViewById(R.id.ListView01);

        // 生成动态数组，加入数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();



        // 生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,// 数据源
                R.layout.item_listview_demo,// ListItem的XML实现
                // 动态数组与ImageItem对应的子项
                new String[] { "ItemImage", "ItemTitle", "LastImage" },
                // ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.last });

        // 添加并且显示
        list.setAdapter(listItemAdapter);



    }
    */
}
