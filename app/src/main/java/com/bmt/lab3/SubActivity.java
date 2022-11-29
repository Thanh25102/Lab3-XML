package com.bmt.lab3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab3.adapter.SubRecyclerAdapter;
import com.bmt.lab3.dto.Vitamin;

import java.util.List;

public class SubActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        List<Vitamin> vitamins =(List<Vitamin>) intent.getSerializableExtra("data");

        recyclerView = findViewById(R.id.recyclerSubView);
        SubRecyclerAdapter<Vitamin> recyclerAdapter = new SubRecyclerAdapter<>((datas)->{});

        recyclerAdapter.setData(vitamins);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}