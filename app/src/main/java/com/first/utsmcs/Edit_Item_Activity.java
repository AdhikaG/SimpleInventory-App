package com.first.utsmcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_Item_Activity extends AppCompatActivity {

    ItemsDB itemsDB;
    String ItemNameEdit;
    String ItemDescriptionEdit;
    String ItemQuantityEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item_activity);


        TextView tv_NameEdit = findViewById(R.id.tv_nameEdit);
        final EditText et_itNameEdit = findViewById(R.id.et_itNameEdit);
        TextView tv_DescriptionEdit = findViewById(R.id.tv_descEdit);
        final EditText et_DescriptionEdit = findViewById(R.id.et_itDescEdit);
        TextView tv_QuantityEdit = findViewById(R.id.tv_QuantityEdit);
        final EditText et_QuantityEdit = findViewById(R.id.et_QuantityEdit);
        TextView backButtonEdit = findViewById(R.id.tv_arrowEdit);
        Button SubmitEdit = findViewById(R.id.btn_submitEdit);

        backButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }

        });

        SubmitEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                 ItemNameEdit =  et_itNameEdit.getText()+"";
                 ItemDescriptionEdit = et_DescriptionEdit.getText()+"";
                 ItemQuantityEdit =  et_QuantityEdit.getText()+"";

                if(ItemNameEdit == ""){

                    Toast.makeText(Edit_Item_Activity.this, "Item Name Must be Filled", Toast.LENGTH_SHORT).show();
                }

                if(ItemDescriptionEdit == ""){
                    Toast.makeText(Edit_Item_Activity.this, "Description Must be Filled", Toast.LENGTH_SHORT).show();
                }


                if(ItemQuantityEdit == ""){
                    Toast.makeText(Edit_Item_Activity.this, "Quantity Must be Filled", Toast.LENGTH_SHORT).show();
                }
                else {
                 //   Bridge.InDB.updateItem(ItemNameEdit, ItemDescriptionEdit,ItemQuantityEdit);

                    finish();
                }



            }
        });


    }
}
