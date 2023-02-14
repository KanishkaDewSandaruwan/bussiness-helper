package com.example.businesshelper.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHandler extends SQLiteOpenHelper {

    Context context;

    private static final int VERSION = 2;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss ");
    String currentDateandTime = sdf.format(new Date());

    private static final String DBNAME = "businessHelper";

    //Table Category
    private static final String CATEGORY_TABLE_NAME = "products";
    private static final String CATEGORY_ID = "cat_id";
    private static final String CATEGORY_NAME = "cat_name";

    //Table Products
    private static final String PRODUCT_TABLE_NAME = "products";
    private static final String PRODUCT_ID = "pid";
    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_DESCRIPTION = "product_description";
    private static final String PRODUCT_PRICE = "product_price";
    private static final String PRODUCT_QTY = "product_qty";
    private static final String PRODUCT_CATEGORY = "product_category";
    private static final String PRODUCT_STATUS = "product_status";
    private static final String PRODUCT_INSDATE = "product_insert_date";

    //Table EXPENSIVE
    private static final String EXPENSIVE_TABLE_NAME = "expensive";
    private static final String EXPENSIVE_ID = "expensive_id";
    private static final String EXPENSIVE_BILL_NUMBER = "expensive_bill_number";
    private static final String EXPENSIVE_AMOUNT = "expensive_amount";
    private static final String EXPENSIVE_DATE = "expensive_date";

    //Table Cart
    private static final String CART_TABLE_NAME = "cart";
    private static final String CART_ID = "cart_id";
    private static final String CART_PRODUCT_ID = "cart_pid";
    private static final String CART_PRODUCT_AMOUNT = "cart_product_amount";
    private static final String CART_PRODUCT_QTY = "cart_product_qty";

    //Table Sales
    private static final String SALES_TABLE_NAME = "sales";
    private static final String SALES_ID = "sale_id";
    private static final String SALES_TOTAL = "sales_total_amount";
    private static final String SALES_DATE = "sales_date";


    public DBHandler(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Crate Category Table

        String Category_table_query = "CREATE TABLE "+ CATEGORY_TABLE_NAME +"("
                +CATEGORY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +CATEGORY_NAME+" TEXT);";
        db.execSQL(Category_table_query);

        //Create Product Table

        String Products_table_query = "CREATE TABLE "+ PRODUCT_TABLE_NAME +"("
                +PRODUCT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PRODUCT_NAME+" TEXT, "
                +PRODUCT_DESCRIPTION+" TEXT, "
                +PRODUCT_PRICE+" INTEGER, "
                +PRODUCT_QTY+" INTEGER, "
                +PRODUCT_CATEGORY+" INTEGER, "
                +PRODUCT_STATUS+" INTEGER, "
                +PRODUCT_INSDATE+" DATETIME);";

        db.execSQL(Products_table_query);

        //Create Expensive Table

        String Expensive_table_query = "CREATE TABLE "+EXPENSIVE_TABLE_NAME+"("
                +EXPENSIVE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +EXPENSIVE_BILL_NUMBER+" TEXT, "
                +EXPENSIVE_AMOUNT+" INTEGER, "
                +EXPENSIVE_DATE+" DATE);";

        db.execSQL(Expensive_table_query);

        //Create Cart Table
        String Cart_table_query = "CREATE TABLE "+ CART_TABLE_NAME +"("
                +CART_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +CART_PRODUCT_ID+" INTEGER, "
                +CART_PRODUCT_QTY+" INTEGER, "
                +CART_PRODUCT_AMOUNT+" INTEGER);";

        db.execSQL(Cart_table_query);

        //Create Sales Table
        String Sales_table_query = "CREATE TABLE "+ SALES_TABLE_NAME +"("
                +SALES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +SALES_TOTAL+" INTEGER, "
                +SALES_DATE+" DATE);";

        db.execSQL(Sales_table_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE_CART = "DROP TABLE IF EXISTS "+ CART_TABLE_NAME;
        String DROP_TABLE_CATEGORY = "DROP TABLE IF EXISTS "+ CATEGORY_TABLE_NAME;
        String DROP_TABLE_PRODUCT = "DROP TABLE IF EXISTS "+ PRODUCT_TABLE_NAME;
        String DROP_TABLE_EXPENSIVE = "DROP TABLE IF EXISTS "+ EXPENSIVE_TABLE_NAME;
        String DROP_TABLE_SALES = "DROP TABLE IF EXISTS "+ SALES_TABLE_NAME;

        db.execSQL(DROP_TABLE_CART);
        db.execSQL(DROP_TABLE_CATEGORY);
        db.execSQL(DROP_TABLE_PRODUCT);
        db.execSQL(DROP_TABLE_EXPENSIVE);
        db.execSQL(DROP_TABLE_SALES);
        onCreate(db);

    }
}
