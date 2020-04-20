package com.first.utsmcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Context CtxBridge;
    ItemDatabaseHelper IDBHelper;
    private ItemAdapter itemAdapter;
    RecyclerView recyclerView;
    ArrayList<Items> Inventory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView addButton = findViewById(R.id.tv_Plus);
        CtxBridge = this;
        recyclerView = findViewById(R.id.recycle_View);
        IDBHelper = new ItemDatabaseHelper(this);
        Bridge.InDB.getInventory();
        itemAdapter = new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Add_Items_Activity.class);
                startActivity(intent);
                itemAdapter = new ItemAdapter();
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(itemAdapter);
            }
        });

    }

    @Override
    protected void onResume(){

        super.onResume();
        itemAdapter = new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
    }
}
