package com.first.utsmcs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Vector;

public class ItemsDB {


    Vector<Items> itemsA = new Vector<>();
    Items itemsB;
    private ItemDatabaseHelper IDBHelper;
    private Context ctx;
    String itemName;
    String itemDescription;
    String itemQuantity;

    public ItemsDB(Context ctx) {

        this.ctx = ctx;
        IDBHelper = new ItemDatabaseHelper(ctx);


    }
//
//    public Items getItems(int itemId) {
//
//        SQLiteDatabase idb = IDBHelper.getReadableDatabase();
//
//        String selection = "itemId = ?";
//        String[] selectionArgs = {"" + itemId};
//        Cursor cursor = idb.query(ItemDatabaseHelper.Table_Inventory, null, selection,
//                selectionArgs, null, null, null);
//
//
//        Items item = new Items();
//
//        while (cursor.moveToNext()) {
//
//
//
//        }
//        cursor.close();
//        idb.close();
//        return item;
//
//    }


        public void insertItem(String Name , String Description, String Quantity){

            SQLiteDatabase idb = IDBHelper.getWritableDatabase();

            ContentValues con_val = new ContentValues();
            con_val.put(ItemDatabaseHelper.ItemName, Name);
            con_val.put(ItemDatabaseHelper.ItemDescription, Description);
            con_val.put(ItemDatabaseHelper.ItemQuantity, Quantity);

            idb.insert(ItemDatabaseHelper.Table_Inventory, null, con_val);
            idb.close();
            getInventory();
    }
//
//        public void updateItem( String Name , String Description, String Quantity){
//
//            SQLiteDatabase idb = IDBHelper.getWritableDatabase();
//            ContentValues con_val = new ContentValues();
//
//            idb.update(ItemDatabaseHelper.Table_Inventory,con_val, "Name = ? ", new String[]{Name});
//            idb.update(ItemDatabaseHelper.Table_Inventory,con_val, "Description = ? ", new String[]{Description});
//            idb.update(ItemDatabaseHelper.Table_Inventory,con_val,"Quantity = ? ", new String[] {Quantity});
//            idb.close();
//            getInventory();
//
//        }

        public void getInventory(){

            Vector<Items> temp = itemsA;
            itemsA.removeAll(temp);


            SQLiteDatabase idb = IDBHelper.getReadableDatabase();
            Cursor iCursor = idb.rawQuery("SELECT * FROM " + IDBHelper.Table_Inventory, null);
            iCursor.moveToFirst();

            while (iCursor.moveToNext()){

                String itemId = iCursor.getString((iCursor.getColumnIndex(IDBHelper.ItemsID)));
                itemName = iCursor.getString((iCursor.getColumnIndex(IDBHelper.ItemName)));
                 itemDescription = iCursor.getString((iCursor.getColumnIndex(IDBHelper.ItemDescription)));
                 itemQuantity = iCursor.getString((iCursor.getColumnIndex((IDBHelper.ItemQuantity))));


                itemsB = new Items(itemName,itemDescription,itemQuantity);
                itemsA.add(itemsB);
            }

        }


}





