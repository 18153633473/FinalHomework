package com.example.asus.finalhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void menuClick(View btn){
        if (btn.getId()==R.id.menull1){
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            finish();
            rateCalc.putExtra("menu", "0");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menull2){
            finish();
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            rateCalc.putExtra("menu", "1");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menull3){
            finish();
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            rateCalc.putExtra("menu", "2");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menull4){
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            rateCalc.putExtra("menu", "3");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menull5){
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            rateCalc.putExtra("menu", "4");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menull6){
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, classify.class);
            rateCalc.putExtra("menu", "5");
            startActivity(rateCalc);
        }else if (btn.getId()==R.id.menubtn){
            Intent intent=new Intent();
            Intent rateCalc = new Intent(this, Mylist.class);
            startActivity(rateCalc);
        }
    }
}
