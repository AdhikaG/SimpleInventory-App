package com.first.utsmcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Items_Activity extends AppCompatActivity {

    ItemsDB itemsDB;
    String ItemName;
    String ItemDescription;
    String ItemQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_activity);

        TextView tv_Name = findViewById(R.id.tv_name);
        final EditText et_Name = findViewById(R.id.et_itName);
        TextView tv_Description = findViewById(R.id.tv_desc);
        final EditText et_Description = findViewById(R.id.et_itDesc);
        TextView tv_Quantity = findViewById(R.id.tv_Quantity);
        final EditText et_Quantity = findViewById(R.id.et_Quantity);
        Button Submit = findViewById(R.id.btn_Submit);
        TextView backButton = findViewById(R.id.tv_arrow);
        itemsDB = new ItemsDB(this);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ItemName = et_Name.getText() + "";
                ItemDescription = et_Description.getText() + "";
                ItemQuantity = et_Quantity.getText() + "";


                if (ItemName == "") {

                    Toast.makeText(Add_Items_Activity.this, "Item Name Must be Filled", Toast.LENGTH_SHORT).show();
                } else if (ItemDescription == "") {
                    Toast.makeText(Add_Items_Activity.this, "Description Must be Filled", Toast.LENGTH_SHORT).show();
                } else if (ItemQuantity == "") {
                    Toast.makeText(Add_Items_Activity.this, "Quantity Must be Filled", Toast.LENGTH_SHORT).show();
                } else {
                    Bridge.InDB.insertItem(ItemName, ItemDescription,ItemQuantity);

                    finish();
                }
            }
        });
    }
}