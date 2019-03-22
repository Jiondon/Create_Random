package com.example.administrator.myapplication;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    private Handler mHandler;
    private boolean mRunning = false;
    boolean starting  = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(new startClickListener());

//        Button endBtn = (Button) findViewById(R.id.end);
//        endBtn.setOnClickListener(new endClickListener());

//        HandlerThread thread = new HandlerThread("MyHandlerThread");
//        thread.start();//创建一个HandlerThread并启动它
//        mHandler = new Handler(thread.getLooper());//使用HandlerThread的looper对象创建Handler，如果使用默认的构造方法，很有可能阻塞UI线程
//        mHandler.post(mBackgroundRunnable);//将线程post到Handler中
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        starting = true;
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        starting = false;
//    }
//
//    //实现耗时操作的线程
//    Runnable mBackgroundRunnable = new Runnable() {
//        @Override
//        public void run() {
//            //----------模拟耗时的操作，开始---------------
//            TextView txt1 = (TextView) findViewById(R.id.first_red);
//            TextView txt2 = (TextView) findViewById(R.id.second_red);
//            TextView txt3 = (TextView) findViewById(R.id.third_red);
//            TextView txt4 = (TextView) findViewById(R.id.four_red);
//            TextView txt5 = (TextView) findViewById(R.id.five_red);
//            TextView txt6 = (TextView) findViewById(R.id.six_red);
//            TextView txt7 = (TextView) findViewById(R.id.seven_blue);
//
//            //点击开始按钮
//            //随机生成7个数字
//            int startNum=1;
//            int endNum=34;
//            Random random = new Random();
//            String[] arr1 = new String[6];// 创建一个大小为6的数组
//
//            while (starting) {
//                int num1 = random.nextInt(endNum - startNum) + startNum;
//                txt1.setText(String.valueOf(num1));
//                int num2 = random.nextInt(endNum - startNum) + startNum;
//                txt2.setText(String.valueOf(num2));
//                int num3 = random.nextInt(endNum - startNum) + startNum;
//                txt3.setText(String.valueOf(num3));
//                int num4 = random.nextInt(endNum - startNum) + startNum;
//                txt4.setText(String.valueOf(num4));
//                int num5 = random.nextInt(endNum - startNum) + startNum;
//                txt5.setText(String.valueOf(num5));
//                int num6 = random.nextInt(endNum - startNum) + startNum;
//                txt6.setText(String.valueOf(num6));
//
//                int num7 = random.nextInt(endNum - startNum) + startNum;
//                txt7.setText(String.valueOf(num7));
//                //将随机数显示在view中
//            }
//        }
//    //----------耗时的操作，结束---------------
//
//    };

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //销毁线程
//        mHandler.removeCallbacks(mBackgroundRunnable);
//    }

    class startClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            starting = true;
            Toast.makeText(MainActivity.this, "开始随机生成数据", Toast.LENGTH_SHORT).show();

            TextView txt1 = (TextView) findViewById(R.id.first_red);
            TextView txt2 = (TextView) findViewById(R.id.second_red);
            TextView txt3 = (TextView) findViewById(R.id.third_red);
            TextView txt4 = (TextView) findViewById(R.id.four_red);
            TextView txt5 = (TextView) findViewById(R.id.five_red);
            TextView txt6 = (TextView) findViewById(R.id.six_red);
            TextView txt7 = (TextView) findViewById(R.id.seven_blue);

            //点击开始按钮
            //随机生成7个数字
            int startNum=1;
            int endNum=33;
            Random random = new Random();
            String[] numArray = new String[33];
            for(int i=0;i<33;i++){
                numArray[i] = String.valueOf(i+1);
            }
            //List<Integer> list = Arrays.asList(intarray); 编译通不过
//            List<String> list = Arrays.asList(numArray);  //无法remove，原因是？

            List<String> list = new ArrayList<>();//数据集合
            List<String> list_string = new ArrayList<>();//数据集合  保存随机生成的数据

            for(int i=0;i<33;i++){
                list.add(String.valueOf(i+1));
            }
            int num1 = random.nextInt(endNum - startNum+1) + startNum - 1;
//            txt1.setText(list.get(num1));
            list_string.add(list.get(num1));
            list.remove(num1);

            int num2 = random.nextInt(endNum-1 - startNum+1) + startNum - 1;
//            txt2.setText(list.get(num2));
            list_string.add(list.get(num2));
            list.remove(num2);

            int num3 = random.nextInt(endNum-2 - startNum+1) + startNum - 1;
//            txt3.setText(list.get(num3));
            list_string.add(list.get(num3));
            list.remove(num3);

            int num4 = random.nextInt(endNum-3 - startNum+1) + startNum - 1;
//            txt4.setText(list.get(num4));
            list_string.add(list.get(num4));
            list.remove(num4);

            int num5 = random.nextInt(endNum-4 - startNum+1) + startNum - 1;
//            txt5.setText(list.get(num5));
            list_string.add(list.get(num5));
            list.remove(num5);

            int num6 = random.nextInt(endNum-5 - startNum+1) + startNum - 1;
//            txt6.setText(list.get(num6));
            list_string.add(list.get(num6));
            list.remove(num6);

            Log.i("TAG  ", "onClick:  "+String.valueOf(list_string.size()));

            String temp;
            for(int j=0;j<list_string.size();j++) {
                for (int i = 0; i < list_string.size() - 1; i++) {
                    int i0 = Integer.parseInt(list_string.get(i));
                    int i1 = Integer.parseInt(list_string.get(i+1));
                    if (i0 > i1) {
                        temp = list_string.get(i);
                        list_string.set(i, list_string.get(i + 1));
                        list_string.set(i + 1, temp);
                    }
                }
            }
//            list_int.sort;//正序比较
            //排序
            txt1.setText(list_string.get(0));
            txt2.setText(list_string.get(1));
            txt3.setText(list_string.get(2));
            txt4.setText(list_string.get(3));
            txt5.setText(list_string.get(4));
            txt6.setText(list_string.get(5));

            int startNum1=1;
            int endNum1=16;
            int num7 = random.nextInt(endNum1 - startNum1+1) + startNum1;
            txt7.setText(String.valueOf(num7));
            //将随机数显示在view中
            list.clear();
        }
    }

//    class endClickListener implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            //点击开始按钮
//            starting = false;
//            Toast.makeText(MainActivity.this, "数据生成结束", Toast.LENGTH_SHORT).show();
//        }
//    }
}
