package com.example.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        itemList = new ArrayList<>();
        itemList.add(new Item("Item 1", "Description of Item 1"));
        itemList.add(new Item("Item 2", "Description of Item 2"));
        itemList.add(new Item("Item 3", "Description of Item 3"));
        itemList.add(new Item("Item 4", "Description of Item 4"));


        itemAdapter = new ItemAdapter(itemList, new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("item_name", item.getName());
                intent.putExtra("item_description", item.getDescription());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(itemAdapter);
    }
}