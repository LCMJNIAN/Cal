package com.example.calculator.Core;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Convert {
    private final String ID = "&app_id=noiinlmnvpk8xemf&app_secret=eHJuRlBYR3puUkw0WlVuc3RVUkwwdz09";
    private final String BaseUrl = "https://www.mxnzp.com/api/exchange_rate/aim";

    public String CalLength(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("皮米".equals(sour_name))
            temp_ans *= Math.pow(10,-12);
        else if("纳米".equals(sour_name))
            temp_ans *= Math.pow(10,-9);
        else if("微米".equals(sour_name))
            temp_ans *= Math.pow(10,-6);
        else if("毫米".equals(sour_name))
            temp_ans *= 0.001;
        else if("厘米".equals(sour_name))
            temp_ans *= 0.01;
        else if("分米".equals(sour_name))
            temp_ans *= 0.1;
        else if("米".equals(sour_name))
            temp_ans *= 1;
        else if("千米".equals(sour_name))
            temp_ans *= 1000;
        else if("英里".equals(sour_name))
            temp_ans *= 1609.269391696;


        if("皮米".equals(tar_name))
            temp_ans /= Math.pow(10,-12);
        else if("纳米".equals(tar_name))
            temp_ans /= Math.pow(10,-9);
        else if("微米".equals(tar_name))
            temp_ans /= Math.pow(10,-6);
        else if("毫米".equals(tar_name))
            temp_ans /= 0.001;
        else if("厘米".equals(tar_name))
            temp_ans /= 0.01;
        else if("分米".equals(tar_name))
            temp_ans /= 0.1;
        else if("米".equals(tar_name))
            temp_ans /= 1;
        else if("千米".equals(tar_name))
            temp_ans /= 1000;
        else if("英里".equals(tar_name))
            temp_ans /= 1609.269391696;

        return String.valueOf(temp_ans);
    }
    public String CalArea(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("平方米".equals(sour_name))
            temp_ans *= 1;
        else if("平方分米".equals(sour_name))
            temp_ans *= Math.pow(10,-2);
        else if("平方厘米".equals(sour_name))
            temp_ans *= Math.pow(10,-4);
        else if("平方千米".equals(sour_name))
            temp_ans *=Math.pow(10,6);
        else if("平方毫米".equals(sour_name))
            temp_ans *= Math.pow(10,-6);
        else if("公亩".equals(sour_name))
            temp_ans *= Math.pow(10,2);
        else if("公顷".equals(sour_name))
            temp_ans *=Math.pow(10,5);
        else if("平方英里".equals(sour_name))
            temp_ans *= 2589988.110336;
        else if("亩".equals(sour_name))
            temp_ans *=666.666666;
        else if("顷".equals(sour_name))
            temp_ans *=66666.6666;
        else if("平方英尺".equals(sour_name))
            temp_ans *= 0.0929;
        else if("英亩".equals(sour_name))
            temp_ans *=4046.8564224;

        if("平方米".equals(tar_name))
            temp_ans /= 1;
        else if("平方分米".equals(tar_name))
            temp_ans /= Math.pow(10,-2);
        else if("平方厘米".equals(tar_name))
            temp_ans /= Math.pow(10,-4);
        else if("平方千米".equals(tar_name))
            temp_ans /=Math.pow(10,6);
        else if("平方毫米".equals(tar_name))
            temp_ans /= Math.pow(10,-6);
        else if("公亩".equals(tar_name))
            temp_ans /= Math.pow(10,2);
        else if("公顷".equals(tar_name))
            temp_ans /=Math.pow(10,5);
        else if("平方英里".equals(tar_name))
            temp_ans /= 2589988.110336;
        else if("亩".equals(tar_name))
            temp_ans /=666.666666;
        else if("顷".equals(tar_name))
            temp_ans /=66666.6666;
        else if("平方英尺".equals(tar_name))
            temp_ans /= 0.0929;
        else if("英亩".equals(tar_name))
            temp_ans /=4046.8564224;

        return String.valueOf(temp_ans);
    }

    public String CalSpeed(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("米/秒".equals(sour_name))
            temp_ans *= 1;
        else if("千米/秒".equals(sour_name))
            temp_ans *= Math.pow(10,3);
        else if("英里/时".equals(sour_name))
            temp_ans *= 0.44704005836555;
        else if("马赫".equals(sour_name))
            temp_ans *=340.298101136595658;
        else if("英寸/秒".equals(sour_name))
            temp_ans *= 0.02539999983236;
        else if("千米/时".equals(sour_name))
            temp_ans *= 0.27777777777778;


        if("米/秒".equals(tar_name))
            temp_ans /= 1;
        else if("千米/秒".equals(tar_name))
            temp_ans /= Math.pow(10,3);
        else if("英里/时".equals(tar_name))
            temp_ans /= 0.44704005836555;
        else if("马赫".equals(tar_name))
            temp_ans /=340.298101136595658;
        else if("英寸/秒".equals(tar_name))
            temp_ans /= 0.02539999983236;
        else if("千米/时".equals(tar_name))
            temp_ans /= 0.27777777777778;


        return String.valueOf(temp_ans);
    }

    public String CalWeight(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("千克".equals(sour_name))
            temp_ans *= 1;
        else if("克".equals(sour_name))
            temp_ans *= Math.pow(10,-3);
        else if("微克".equals(sour_name))
            temp_ans *= Math.pow(10,-9);
        else if("吨".equals(sour_name))
            temp_ans *=Math.pow(10,3);
        else if("毫克".equals(sour_name))
            temp_ans *= Math.pow(10,-6);
        else if("磅".equals(sour_name))
            temp_ans *= 0.453592374495299;
        else if("斤".equals(sour_name))
            temp_ans *=0.5;
        else if("两".equals(sour_name))
            temp_ans *= 0.05;


        if("千克".equals(tar_name))
            temp_ans /= 1;
        else if("克".equals(tar_name))
            temp_ans /= Math.pow(10,-3);
        else if("微克".equals(tar_name))
            temp_ans /= Math.pow(10,-9);
        else if("吨".equals(tar_name))
            temp_ans /=Math.pow(10,3);
        else if("毫克".equals(tar_name))
            temp_ans /= Math.pow(10,-6);
        else if("磅".equals(tar_name))
            temp_ans /= 0.453592374495299;
        else if("斤".equals(tar_name))
            temp_ans /=0.5;
        else if("两".equals(tar_name))
            temp_ans /= 0.05;

        return String.valueOf(temp_ans);
    }

    public String CalTem(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("摄氏度".equals(sour_name))
            temp_ans *= 1;
        else if("华氏度".equals(sour_name))
            temp_ans =(temp_ans-32)/1.8;
        else if("开尔文".equals(sour_name))
            temp_ans -=273.15 ;

        if("摄氏度".equals(tar_name))
            temp_ans *= 1;
        else if("华氏度".equals(tar_name))
            temp_ans =temp_ans*1.8+32;
        else if("开尔文".equals(tar_name))
            temp_ans +=273.15 ;

        return String.valueOf(temp_ans);
    }

    public String CalPower(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("焦耳/秒".equals(sour_name))
            temp_ans *= 1;
        else if("瓦".equals(sour_name))
            temp_ans *= 1;
        else if("牛顿·米/秒".equals(sour_name))
            temp_ans *=1;
        else if("千瓦".equals(sour_name))
            temp_ans *=1000;

        if("焦耳/秒".equals(tar_name))
            temp_ans /= 1;
        else if("瓦".equals(tar_name))
            temp_ans /= 1;
        else if("牛顿·米/秒".equals(tar_name))
            temp_ans /=1;
        else if("千瓦".equals(tar_name))
            temp_ans /=1000;

        return String.valueOf(temp_ans);
    }

    public String CalPressure(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("帕".equals(sour_name))
            temp_ans *= 1;
        else if("毫米水柱".equals(sour_name))
            temp_ans *= 9.8;
        else if("毫米汞柱".equals(sour_name))
            temp_ans *= 133.28;
        else if("百帕".equals(sour_name))
            temp_ans *=100;
        else if("标准大气压".equals(sour_name))
            temp_ans *= 101325;
        else if("千帕".equals(sour_name))
            temp_ans *= 1000;
        else if("兆帕".equals(sour_name))
            temp_ans *= 100000;


        if("帕".equals(tar_name))
            temp_ans /= 1;
        else if("毫米水柱".equals(tar_name))
            temp_ans /= 9.8;
        else if("毫米汞柱".equals(tar_name))
            temp_ans /= 133.28;
        else if("百帕".equals(tar_name))
            temp_ans /=100;
        else if("标准大气压".equals(tar_name))
            temp_ans /= 101325;
        else if("千帕".equals(tar_name))
            temp_ans /= 1000;
        else if("兆帕".equals(tar_name))
            temp_ans /= 100000;

        return String.valueOf(temp_ans);
    }

    public String CalVolume(String sour_name,String value,String tar_name){
        Double temp_ans = Double.parseDouble(value);
        if(sour_name.equals(tar_name))
            return value;
        if("立方米".equals(sour_name))
            temp_ans *= 1;
        else if("立方厘米".equals(sour_name))
            temp_ans *= Math.pow(10,-6);
        else if("立方分米".equals(sour_name))
            temp_ans *= Math.pow(10,-3);
        else if("升".equals(sour_name))
            temp_ans *=Math.pow(10,-3);
        else if("立方毫米".equals(sour_name))
            temp_ans *= Math.pow(10,-9);
        else if("毫升".equals(sour_name))
            temp_ans *= Math.pow(10,-6);



        if("立方米".equals(tar_name))
            temp_ans /= 1;
        else if("立方厘米".equals(tar_name))
            temp_ans /= Math.pow(10,-6);
        else if("立方分米".equals(tar_name))
            temp_ans /= Math.pow(10,-3);
        else if("升".equals(tar_name))
            temp_ans /=Math.pow(10,-3);
        else if("立方毫米".equals(tar_name))
            temp_ans /= Math.pow(10,-9);
        else if("毫升".equals(tar_name))
            temp_ans /= Math.pow(10,-6);


        return String.valueOf(temp_ans);
    }
    public String CalBase(String sour_name, String value,String tar_name){
        if(sour_name.equals(tar_name))
            return value;
        BaseCalculate BC = new BaseCalculate();
        String temp_ans = value;
        if(sour_name == "十进制")
            temp_ans = temp_ans;
        else if(sour_name.equals("八进制"))
            temp_ans = BC.O_to_dec(value);
        else if(sour_name.equals("二进制"))
            temp_ans = BC.bin_to_dec(value);
        else
            temp_ans = BC.decimal(value);
        if(tar_name.equals("十进制"))
            return temp_ans;
        else if(tar_name.equals("八进制"))
            return BC.dec_to_O(temp_ans);
        else if(tar_name.equals("二进制"))
            return BC.dec_bin(temp_ans);
        else
            return BC.hexadecimal(temp_ans);
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("Newapi")
    public String CalExchangeRate(String sour_name, String value,String tar_name){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String scur = sour_name.substring(sour_name.length()-3);
        String tcur = tar_name.substring(tar_name.length()-3);
        String url = BaseUrl + "?" + "&from=" + scur+ "&to=" + tcur + ID;
        String json = loadJson(url);
        System.out.println(json);
        JSONObject object = JSONObject.parseObject(json);
        String price = object.getJSONObject("data").getString("price");
        return String.valueOf(Double.parseDouble(value)*(Double.parseDouble(price)));
    }
    public String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
