package com.bmt.lab3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab3.adapter.SubRecyclerAdapter;
import com.bmt.lab3.dto.BaseModel;

import java.util.List;

public class SubActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        List<BaseModel> baseModels = (List<BaseModel>) intent.getSerializableExtra("data");

        recyclerView = findViewById(R.id.recyclerSubView);
        SubRecyclerAdapter<BaseModel> recyclerAdapter = new SubRecyclerAdapter<>((data) -> {
            Intent detail = new Intent(this, DetailActivity.class);
            detail.putExtra("data", data);
            startActivity(detail);
        });

        recyclerAdapter.setData(baseModels);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}