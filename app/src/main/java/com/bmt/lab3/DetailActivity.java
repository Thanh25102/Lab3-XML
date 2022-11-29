package com.bmt.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bmt.lab3.dto.BaseModel;

public class DetailActivity extends AppCompatActivity {
    private TextView title, description, pubDate, guid, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        Intent intent = getIntent();
        BaseModel baseModel = (BaseModel) intent.getSerializableExtra("data");

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        pubDate = findViewById(R.id.pubDate);
        guid = findViewById(R.id.guid);
        link = findViewById(R.id.link);

        title.setText(baseModel.getTitle());
        description.setText(baseModel.getDescription());
        pubDate.setText(baseModel.getPubDate());
        guid.setText(baseModel.getGuid());
        link.setText(baseModel.getLink());
    }
}