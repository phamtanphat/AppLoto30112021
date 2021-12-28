package com.example.apploto30112021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView mTvHistory , mTvResult;
    Button mBtnReset, mBtnRandom;
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
    }

    private void initView() {
        mTvHistory = findViewById(R.id.textViewHistory);
        mTvResult = findViewById(R.id.textViewResult);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnReset = findViewById(R.id.buttonReset);
    }
}