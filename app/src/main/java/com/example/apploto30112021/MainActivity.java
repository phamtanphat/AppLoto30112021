package com.example.apploto30112021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTvHistory, mTvResult;
    Button mBtnReset, mBtnRandom;
    ArrayList<Integer> mArrNumbers;
    Random mRandom;
    String mStringHistory = "";
    ScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList : Collection


        // Khởi tạo mảng
//        ArrayList<Integer> arrNumbers = new ArrayList<>();
//
//        // thêm dữ liệu vào mảng
//        arrNumbers.add(5);
//
//        // Cập nhật dữ liệu của phần tử
//        arrNumbers.set(0,10);
//
//        // Xóa phần tử
//        arrNumbers.remove(0);
//
//        // lấy dữ liệu
//        arrNumbers.get(0);

        // Tạo 1 mảng có 100 phần tử chứa giá trị từ 1 -> 100

        // Nút lại
        //   + reset mảng cho chưa lại từ 1 -> 100

        // Nút rao
        //   + random 1 giá trị ngẫu nhiên trong mảng
        //   + hiển thị giá trị lên giao diện
        //   + xóa giá trị trong mảng
        initView();
        initData();
        event();

    }

    private void initData() {
        // tạo 1 mảng 100 số từ 1 -> 100
        mArrNumbers = createArrNumbers();

        // Khởi tạo random
        mRandom = new Random();
    }

    private ArrayList<Integer> createArrNumbers() {
        ArrayList<Integer> arrNumbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            arrNumbers.add(i);
        }
        return arrNumbers;
    }

    private void event() {
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý nếu 99 số thì reset mà 100 thì thoát không xử lý gì hết
                if (mArrNumbers != null){
                    if (mArrNumbers.size() > 0 && mArrNumbers.size() < 100){
                        mArrNumbers.clear();
                    }else if (mArrNumbers.size() == 100){
                        return;
                    }
                }
                mArrNumbers = createArrNumbers();
                mStringHistory = "";
                mTvResult.setText("");
                mTvHistory.setText(mStringHistory);

            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRandom();
            }
        });
    }

    private void handleRandom(){
        if (mArrNumbers.size() > 0){
            int index = mRandom.nextInt(mArrNumbers.size());
            int value = mArrNumbers.get(index);
            mStringHistory +=  value + " - ";
            if (mArrNumbers.size() == 1){
                mStringHistory = mStringHistory.substring(0 , mStringHistory.length() - 3);
            }
            mTvResult.setText(value+"");
            mTvHistory.setText(mStringHistory);
            mArrNumbers.remove(index);

        }else{
            Toast.makeText(MainActivity.this, "Trò chơi kết thúc", Toast.LENGTH_SHORT).show();
        }

        // Scroll tới vị trí mới
//        View lastChild = mScrollView.getChildAt(mScrollView.getChildCount() - 1);
//        int bottom = lastChild.getBottom() + mScrollView.getPaddingBottom();
//        int sy = mScrollView.getScrollY();
//        int sh = mScrollView.getHeight();
//        int delta = bottom - (sy + sh);
//
//        mScrollView.smoothScrollBy(0, bottom);


    }

    private void initView() {
        mTvHistory = findViewById(R.id.textViewHistory);
        mTvResult = findViewById(R.id.textViewResult);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnReset = findViewById(R.id.buttonReset);
        mScrollView = findViewById(R.id.scrollView);
    }
}