package com.example.yfsl.recyclerviewitemclicllistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MessageBean> listData;
    private MessageBean messageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        if (listData == null){
            listData = new ArrayList<>();
        }
        for (int i = 0;i<15;i++){
            messageData = new MessageBean();
            messageData.setMessage("数据"+i);
            listData.add(messageData);
        }

        MyAdapter myAdapter = new MyAdapter(this,listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击了item"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
