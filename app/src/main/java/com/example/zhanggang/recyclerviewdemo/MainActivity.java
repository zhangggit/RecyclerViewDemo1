package com.example.zhanggang.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> list;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        init();
        //单列
        linearLayoutManager = new LinearLayoutManager(this);
        //4列
        gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % 4;
            }
        });
        //瀑布流
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

        //点击 切换显示模式
        button.setOnClickListener(this);

    }

    //添加测试数据
    private void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第  " + i + "  条");
        }
    }

    //点击切换显示模式
    @Override
    public void onClick(View view) {
        //得到当前的模式
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //if和elseif是有先后顺序的,先判断范围小的,然后再判断范围大的,
        //因为GridLayoutManager 是继承 LinearLayoutManager ,所以他本质上也是LinearLayoutManager,
        //所以不能先判断是否是LinearLayoutManager (LinearLayoutManager范围大)
        if (layoutManager instanceof GridLayoutManager) {
            recyclerView.setLayoutManager(linearLayoutManager);
        } else if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
    }


}
