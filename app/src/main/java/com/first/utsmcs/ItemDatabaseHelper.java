package com.first.utsmcs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDatabaseHelper extends SQLiteOpenHelper {

        private static final String DatabaseName = "Products";
        private static final Integer Version = 1;

        public static final String Table_Inventory = "InventoryItems";
        public static final String ItemsID = "id";
        public static final String ItemName = "name";
        public static final String ItemDescription = "description";
        public static final String ItemQuantity = "quantity";


        private static final String Create_Table = " CREATE TABLE IF NOT EXISTS "
                + Table_Inventory + "(" + ItemsID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ItemName + " TEXT, " +
                ItemDescription + " TEXT, " +
                ItemQuantity + " TEXT); ";


        public ItemDatabaseHelper(Context context) {
         super (context,DatabaseName, null , Version);

        }

    @Override
    public void onCreate(SQLiteDatabase ItemDB) {

            ItemDB.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase ItemDB, int OldVer, int NewVer) {

            String Drop = " DROP TABLE IF EXISTS " + Table_Inventory;
            ItemDB.execSQL(Drop);
            onCreate(ItemDB);

    }



}


