package bichet.mb2.quiutzz.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by MAURI5 on 30/03/2018.
 */
@Entity (tableName = "InfoJoueur")
public class Joueur {

    public Joueur(String name, String difficultee, int score) {
        this.name = name;
        this.difficultee = difficultee;
        this.score = score;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo (name ="Name")
    private String name;

    @ColumnInfo (name ="Niveau")
    private String difficultee;

    @ColumnInfo (name ="Score")
    private int score;

    public String getDifficultee() {
        return difficultee;
    }

    public void setDifficultee(String difficultee) {
        this.difficultee = difficultee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
