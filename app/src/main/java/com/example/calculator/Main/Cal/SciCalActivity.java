package com.example.calculator.Main.Cal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.calculator.Core.Calculate;
import com.example.calculator.Core.Complex;
import com.example.calculator.Main.CalHistoryActivity;
import com.example.calculator.Main.CalcHisrory;
import com.example.calculator.Main.Convert.ConvertLengthActivity;
import com.example.calculator.Main.MainActivity;
import com.example.calculator.Main.SqliteManage;
import com.example.calculator.R;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class SciCalActivity extends Activity implements OnClickListener,OnMenuItemClickListener{
    //实数复数标识符
    private int flag = 1; //默认实数为1.复数为-1
    //结果
    private TextView result_front;
    private TextView result_end;
    //按钮0-9
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    //运算符
    private  Button plus;   // 加号+
    private  Button sub;    // 减号-
    private  Button multi;  // 乘号×
    private  Button divide; // 除号÷
    private  Button point;  // 小数点.
    private  Button equal;  // 等于=
    private  Button clean;  // 清空
    private  Button delete; // 删除
    private  Button settings; //设置
    private  Button cal_choose; //计算器选择
    private  Button convert;  //换算器
    private  Button log;    //log
    private  Button ln;     //ln
    private  Button sin;    //sin
    private  Button cos;    //cos
    private  Button tan;    //tan
    private  Button pi;     //pi常数
    private  Button e;      //e常数
    private  Button factorial;//阶乘
    private  Button i;      //复数i
    private  Button left;   //左括号
    private  Button right;  //右括号
    private  Button sqrt;   //乘方
    private  Button double_zero;//00
    private  Button evo;    //开方

    private RadioGroup rg;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_cal);
        initView();
    }

    private void initView() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        divide = findViewById(R.id.divide);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);
        clean = findViewById(R.id.clean);
        delete = findViewById(R.id.delete);
        log = findViewById(R.id.btn_log);
        ln  = findViewById(R.id.btn_ln);
        sin = findViewById(R.id.btn_sin);
        cos = findViewById(R.id.btn_cos);
        tan = findViewById(R.id.btn_tan);
        pi = findViewById(R.id.btn_pi);
        e = findViewById(R.id.btn_e);
        factorial = findViewById(R.id.btn_factorial);
        i = findViewById(R.id.btn_i);
        left = findViewById(R.id.btn_left);
        right = findViewById(R.id.btn_right);
        sqrt = findViewById(R.id.btn_sqrt);
        evo = findViewById(R.id.btn_evo);
        double_zero = findViewById(R.id.double_zero);

        result_front = findViewById(R.id.result_front);
        result_end = findViewById(R.id.result_end);

        settings = (Button)findViewById(R.id.btn_settings);
        cal_choose = findViewById(R.id.btn_main_choose);
        convert = findViewById(R.id.btn_convert_choose);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        plus.setOnClickListener(this);
        sub.setOnClickListener(this);
        multi.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        clean.setOnClickListener(this);
        delete.setOnClickListener(this);
        log.setOnClickListener(this);
        ln.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        e.setOnClickListener(this);
        i.setOnClickListener(this);
        pi.setOnClickListener(this);
        factorial.setOnClickListener(this);
        evo.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        double_zero.setOnClickListener(this);

        settings.setOnClickListener(this);
        cal_choose.setOnClickListener(this);
        convert.setOnClickListener(this);
        enabledButton(flag);
        rg = (RadioGroup) findViewById(R.id.RadioGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton r = (RadioButton) findViewById(checkedId);
                String base_text = r.getText().toString();
                if("计算实数".equals(base_text)){
                    flag = 1;
                    enabledButton(flag);
                }
                else{
                    flag = -1;
                    enabledButton(flag);
                }
                result_front.setText("");
            }
        });
    }
    @Override
    public void onClick(View view){
        //获取文本内容
        String input = result_front.getText().toString();
        switch (view.getId()){//选择按钮id
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.double_zero:
            case R.id.btn_i:
            case R.id.btn_e:
            case R.id.btn_pi:
                if(input.length()>0 && input.charAt(input.length()-1) == '=') {
                    result_front.setText(((Button) view).getText());
                    result_end.setText("");
                }
                else
                    result_front.setText(input + ((Button)view).getText());
                break;
            case R.id.point:
                if (input.isEmpty() || input.substring(input.length() - 1).equals(" "))
                    return;//如果最后是空格，无响应
                else
                    result_front.setText(input + '.');
                break;
            //加减乘除，运算符前后都是空格

            case R.id.sub:
                if(flag == 1){
                    if(input.isEmpty())
                        result_front.setText("-");
                    else{
                        int last_index = input.length()-1;
                        if (Character.isDigit(input.charAt(last_index)))
                            result_front.setText(input + " " +((Button)view).getText() + " " );
                        else
                            result_front.setText(input + "-");
                    }
                }
                else{
                    if(input.isEmpty())
                        result_front.setText("-");
                    else{
                        int last_index = input.length()-1;
                        if (input.charAt(last_index) != 'i')
                            result_front.setText(input +((Button)view).getText());
                        else
                            result_front.setText(input +" " +  "-" + " ");
                    }
                }
                break;
            case R.id.plus:
                if(flag == -1){
                    if(input.isEmpty())
                        result_front.setText("+");
                    else{
                        int last_index = input.length()-1;
                        if (input.charAt(last_index) != 'i')
                            result_front.setText(input +((Button)view).getText());
                        else
                            result_front.setText(input +" " +  "+" + " ");
                    }
                }
                else
                    result_front.setText(input + " " + ((Button)view).getText() + " ");
                break;
            case R.id.multi:
            case R.id.divide:
            case R.id.btn_sqrt:
            case R.id.btn_evo:
            case R.id.btn_cos:
            case R.id.btn_sin:
            case R.id.btn_tan:
            case R.id.btn_left:
            case R.id.btn_right:
            case R.id.btn_log:
            case R.id.btn_ln:
            case R.id.btn_factorial:
                result_front.setText(input + " " + ((Button)view).getText() + " ");
                break;
            case R.id.clean://清除输入框
                result_front.setText("");
                result_end.setText("");
                break;
            case R.id.delete://从后往前删除字符
                if(!input.isEmpty())
                    result_front.setText(input.substring(0, input.length() - 1));
                result_end.setText("");
                break;
            case R.id.equal://计算运算结果
                try {
                    Calculate cal = new Calculate();
                    Complex com = new Complex();
                    String ans = "";
                    if(flag == 1)
                        ans = cal.evaluateExpression(result_front.getText().toString());
                    else
                        ans = com.CalComplex(result_front.getText().toString());
                    result_end.setText(ans);
                    result_front.setText(input + "=");
                    addHistroy(input + "=" + ans);
                }catch (Exception e){
                    result_front.setText("ERROR");
                    result_end.setText("");
                }

                break;
            case R.id.btn_settings:
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup_settings = new PopupMenu(this, view);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater_settings = popup_settings.getMenuInflater();
                //填充菜单
                inflater_settings.inflate(R.menu.menu_settings, popup_settings.getMenu());
                //绑定菜单项的点击事件
                popup_settings.setOnMenuItemClickListener(this);
                //显示(这一行代码不要忘记了)
                popup_settings.show();
                break;
            case R.id.btn_main_choose:
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(this, view);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.menu_cal_array, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(this);
                //显示(这一行代码不要忘记了)
                popup.show();
                break;
            case R.id.btn_convert_choose:
                //跳转到换算器页面
                Intent intent=new Intent(SciCalActivity.this, ConvertLengthActivity.class);
                startActivity(intent);
                break;
        }
    }
    //弹出式菜单的单击事件处理
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                finish();
                break;
            case R.id.set:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.history:
                Intent intent_his = new Intent(SciCalActivity.this, CalHistoryActivity.class);
                startActivity(intent_his);
                break;
            case R.id.base_cal:
                Intent base_intent = new Intent(SciCalActivity.this,BaseCalActivity.class);
                startActivity(base_intent);
                break;
            case R.id.sci_cal:
                Intent intent=new Intent(SciCalActivity.this,SciCalActivity.class);
                startActivity(intent);
                break;
            case R.id.house_loan_cal:
                Intent house_loan_intent = new Intent(SciCalActivity.this,HouseLoanCalActivity.class);
                startActivity(house_loan_intent);
                break;
            case R.id.car_loan_cal:
                Intent car_loan_intent = new Intent(SciCalActivity.this, CarLoanCalActivity.class);
                startActivity(car_loan_intent);
                break;
            case R.id.basic_cal:
                Intent intent_two=new Intent(SciCalActivity.this, MainActivity.class);
                startActivity(intent_two);
                break;
            default:
                break;
        }
        return false;
    }

    private void enabledButton(int flag){
        if(flag == 1){
            btn0.setEnabled(true);
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);

            plus.setEnabled(true);
            sub.setEnabled(true);
            multi.setEnabled(true);
            divide.setEnabled(true);
            point.setEnabled(true);
            equal.setEnabled(true);
            clean.setEnabled(true);
            delete.setEnabled(true);
            log.setEnabled(true);
            ln.setEnabled(true);
            sin.setEnabled(true);
            cos.setEnabled(true);
            tan.setEnabled(true);
            pi.setEnabled(true);
            e.setEnabled(true);
            factorial.setEnabled(true);
            i.setEnabled(false);
            left.setEnabled(true);
            right.setEnabled(true);
            sqrt.setEnabled(true);
            evo.setEnabled(true);
            double_zero.setEnabled(true);
        }
        else {
            btn0.setEnabled(true);
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);

            plus.setEnabled(true);
            sub.setEnabled(true);
            multi.setEnabled(true);
            divide.setEnabled(true);
            point.setEnabled(true);
            equal.setEnabled(true);
            clean.setEnabled(true);
            delete.setEnabled(true);
            log.setEnabled(false);
            ln.setEnabled(false);
            sin.setEnabled(false);
            cos.setEnabled(false);
            tan.setEnabled(false);
            pi.setEnabled(true);
            e.setEnabled(true);
            factorial.setEnabled(false);
            i.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
            sqrt.setEnabled(false);
            evo.setEnabled(false);
            double_zero.setEnabled(false);
        }
    }

    private void addHistroy(String calcValue){
        ContentValues valuesIn = new ContentValues();
        valuesIn.put(CalcHisrory.calcValueName, calcValue);
        SqliteManage.getInstance(this).insertItem(CalcHisrory.TableName, valuesIn);
    }
}
