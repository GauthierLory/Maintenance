package voyageplanning.informatique.cgmatane.qc.cq.voyageplanning.Donnee;


/**
 * Created by Gauthier on 09/03/2018.
 */

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BaseDeDonnees extends SQLiteOpenHelper {

    private static BaseDeDonnees instance = null;

    public static BaseDeDonnees getInstance(Context contexte) {

        if (null == instance) instance = new BaseDeDonnees(contexte);
        return instance;
    }

    public static BaseDeDonnees getInstance() {
        return instance;
    }

    public BaseDeDonnees(Context contexte) {
        super(contexte, "evenement", null, 1);

    }

    public  void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table voyagePlanning(id_voyagePlanning INTEGER PRIMARY KEY, destination TEXT, compagnie TEXT, date TEXT, heure TEXT, description TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2)
    {
        String DELETE_TABLE = "drop table voyagePlanning";
        db.execSQL(DELETE_TABLE);
        String CREATE_TABLE = "create table voyagePlanning(id_voyagePlanning INTEGER PRIMARY KEY, destination TEXT, compagnie TEXT, date TEXT, heure TEXT, description TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {

        String DELETE = "delete from evenement where 1 = 1";
        db.execSQL(DELETE);

        String INSERT_1 = "insert into voyagePlanning(destination ,compagnie, date, heure ,description) VALUES(\"USA\",\"AIRLINES\",18 juin\",\"6h\",avec les parents\")";
        String INSERT_2 = "insert into voyagePlanning(destination ,compagnie, date, heure ,description) VALUES(\"EUROPE\",\"AIRLINES\",\"28 juin\",\"12h\",avec les parents\")";
        String INSERT_3 = "insert into voyagePlanning(destination ,compagnie, date, heure ,description) VALUES(\"AFRICA\",\"AIRLINES\",\"38 juin\",\"18h\",avec les parents\")";
        String INSERT_4 = "insert into voyagePlanning(destination ,compagnie, date, heure ,description) VALUES(\"ASIA\",\"AIRLINES\",\"48 juin\",\"24h\",avec les parents\")";

        db.execSQL(INSERT_1);
        db.execSQL(INSERT_2);
        db.execSQL(INSERT_3);
        db.execSQL(INSERT_4);
    }

}