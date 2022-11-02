package com.example.calculator.Core;



import java.util.Stack;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(){
        this.real = 0;
        this.imaginary = 0;
    }
    public Complex(double real,double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal(){
        return this.real;
    }
    public double getImaginary(){
        return this.imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }
    public Complex add(Complex a,Complex b){
        return new Complex(a.real+b.real, a.imaginary+b.imaginary);
    }
    public Complex sub(Complex a, Complex b){
        return new Complex(a.real-b.real,a.imaginary-b.imaginary);
    }
    public Complex multi(Complex a,Complex b){
        return new Complex((a.real*b.real-a.imaginary*b.imaginary),(a.real*b.imaginary+a.imaginary*b.real));
    }
    public Complex divide(Complex a,Complex b)
    {
        return new Complex(((a.real*b.real+a.imaginary*b.imaginary)/(b.real*b.real+b.imaginary*b.imaginary)),((a.imaginary*b.real-a.real*b.imaginary)/(b.real*b.real+b.imaginary*b.imaginary)));
    }
    //计算复数
    public String CalComplex(String input){
        Stack<Complex> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String[] ans  = input.split(" ");
        for(String token:ans){
            if(token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                //当栈不是空的，并且栈中最上面的一个元素是加减乘除的人任意一个
                if(token.length()>1)
                    if(token.equals("-i")||(token.charAt(1)>='0'&&token.charAt(1)<='9')) {
                        operandStack.push(getComplex(token));
                        continue;
                    }
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '÷' || operatorStack.peek() == '×')) {
                    processAnOperator(operandStack, operatorStack);   //开始运算
                }
                operatorStack.push(token.charAt(0));   //运算完之后将当前的运算符入栈
            }
            //当前运算符是乘除的时候，因为优先级高于加减，因此要判断最上面的是否是乘除，如果是乘除就运算，否则的话直接入栈
            else if (token.charAt(0) == '×' || token.charAt(0) == '÷') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '÷' || operatorStack.peek() == '×')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));   //将当前操作符入栈
            }
            //如果是左括号的话直接入栈，什么也不用操作,trim()函数是用来去除空格的，由于上面的分割操作可能会令操作符带有空格
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            //如果是右括号的话，清除栈中的运算符直至左括号
            else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);    //开始运算
                }
                operatorStack.pop();   //这里的是运算完之后清除左括号
            }
            else {
                operandStack.push(getComplex(token));
            }
        }
        //最后当栈中不是空的时候继续运算，知道栈中为空即可
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop().toString();
    }
    //从堆栈中取出两个数进行计算
    public void processAnOperator(Stack<Complex> operandStack, Stack<Character> operatorStack){
        char op = operatorStack.pop();
        Complex op1 = operandStack.pop();  //从存储数据的栈中弹出连个两个数用来和操作符op运算
        Complex op2 = operandStack.pop();
        if (op == '+')  //如果操作符为+就执行加运算
            operandStack.push(add(op1,op2));
        else if (op == '-')
        {
            operandStack.push(sub(op2,op1));   //因为这个是栈的结构，自然是上面的数字是后面的，因此用op2-op1
        }
        else if (op == '×')
            operandStack.push(multi(op2,op1));
        else operandStack.push(divide(op2,op1));
    }
    //将一个字符串区分出复数
    public Complex getComplex(String s){
        if(s.contains("i") && !s.endsWith("i")){
            if(s.contains("+")){
                System.out.println("f");
                String str = s;
                String[] strs = str.split("\\+");
                if(strs[0].charAt(0) == '-'){
                    s = strs[1] + strs[0];
                }
                else
                    s = strs[1] + "+" + strs[0];
            }else if(s.startsWith("-")){
                System.out.println("s");
                String str = s;
                String[] strs = str.split("-");
                s = "-" + strs[2] + "-" + strs[1];
            }else{
                System.out.println("t");
                String str = s;
                String[] strs = str.split("-");
                System.out.println(strs.length);
                s = "-" + strs[1] + "+" + strs[0];
            }
        }
        System.out.println(s);
        s = s.trim();  //去除多余空格
        int op = -1;  //存储运算符的位置
        int i_index = -1;  //存储i的位置
        int len = s.length();
        String a = "";  //实部
        String b = "";  //虚部
        if (s!=null&&!"".equals(s)){
            for (int i=0;i<len;i++){
                if (s.charAt(i) == '+'||s.charAt(i) == '-')  op = i;  //记录实部虚部连接号
                if (s.charAt(i) == 'i')  i_index = i;  //记录虚部后面的i
            }
            if(i_index==-1){  //不含i，只有实部(不能加上op的判断，实部有可能为-)
                a = s;
                b = "0";
            }else if (op==-1&&i_index!=-1){
                if (i_index==0){  //i
                    a = "0";
                    b = "1";
                }else{  //2i
                    a = "0";
                    b = s.substring(0,i_index);
                }
            }else if (op==0&&i_index!=1){  //-i
                if (i_index==1){
                    a = "0";
                    b = "-1";
                }else{
                    a = "0";
                    b = s.substring(0,i_index);
                }
            }else if (i_index - op==1){  //虚部系数为1或-1
                a = s.substring(0,op);
                b = s.charAt(op) + "1";
                if ("".equals(a)) a = "0";
            }else if (i_index!=-1&&op!=-1){  //含i，不含op，实部为正且不含实部
                a = s.substring(0,op);
                b = s.substring(op,i_index);
                if ("".equals(a)) a = "0";
                if ("".equals(b)) b = "0";
            }//在使用Double.valueOf()将字符串转化为double类型的时候，已经考虑的正负号.

        }
        return new Complex(Double.valueOf(a),Double.valueOf(b));
    }


    @Override
    public String toString() {
        if(imaginary > 0)
            return real+"+"+imaginary+"i";
        else if(real==0&&imaginary!=0)
            return imaginary+"i";
        else if(imaginary < 0)
            return real+""+imaginary+"i";
        else
            return String.valueOf(real);
    }
}





