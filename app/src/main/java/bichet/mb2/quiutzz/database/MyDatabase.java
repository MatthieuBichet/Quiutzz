package bichet.mb2.quiutzz.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by MAURI5 on 30/03/2018.
 */

@Database(entities = {Question.class,Joueur.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DaoQuestion daoQuestion();

}
