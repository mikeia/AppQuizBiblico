package com.example.mikeias.quiz;

/**
 * Created by Mikeias on 16/12/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mikeias.quiz.Helpers.DbHelper;

public class DbGateway {

    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx){
        DbHelper helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
