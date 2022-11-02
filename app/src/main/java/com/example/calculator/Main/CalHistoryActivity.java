package com.example.calculator.Main;

import android.app.Activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.calculator.R;

public class CalHistoryActivity extends Activity implements View.OnClickListener {
    private ListView lvCalc;
    private Button back;    //返回
    private Button clean;  //清楚历史记录
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_history);
        lvCalc=(ListView) findViewById(R.id.LV_Calc);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clean = findViewById(R.id.clean);
        clean.setOnClickListener(this);
        showCalchistory();
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {//选择按钮id
            case R.id.clean:
                SqliteManage.getInstance(this).delteItem(CalcHisrory.TableName,null,null);
                showCalchistory();
                break;
        }
    }
    private void showCalchistory(){
        List<HashMap<String,Object>> data=new ArrayList<HashMap<String,Object>>();
        SqliteManage.QueryResult result = SqliteManage.getInstance(this).query(CalcHisrory.TableName, null, null);
        List<String> historys =new ArrayList<String>();
        while (result.cursor.moveToNext()) {
            historys.add(result.cursor.getString(result.cursor.getColumnIndex(CalcHisrory.calcValueName)));
        }
        if(historys!=null && historys.size()>0){
            for(String one : historys){
                HashMap<String,Object> item=new HashMap<String, Object>();
                item.put("item_calc",one);
                data.add(item);
            }
        }
        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.cal_history_item,
                new String[]{"item_calc"},new int[]{R.id.item_calc});

        lvCalc.setAdapter(adapter);
    }

    public void back(View view){
        this.finish();
    }
}
