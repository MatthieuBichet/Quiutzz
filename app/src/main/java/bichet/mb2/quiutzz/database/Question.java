package bichet.mb2.quiutzz.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by MAURI5 on 30/03/2018.
 */

@Entity (tableName = "Question")
public class Question {
    public Question(int numero ,String intitule, String réponse1, String réponse2, String réponse3, String réponse4) {
        this.numero = numero;
        this.intitule = intitule;
        this.réponse1 = réponse1;
        this.réponse2 = réponse2;
        this.réponse3 = réponse3;
        this.réponse4 = réponse4;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "numero")
    private int numero;

    @ColumnInfo(name = "Intitule")
    private String intitule;

    @ColumnInfo(name = "réponse1")
    private String réponse1;

    @ColumnInfo(name = "réponse2")
    private String réponse2;

    @ColumnInfo(name = "réponse3")
    private String réponse3;

    @ColumnInfo(name = "réponse4")
    private String réponse4;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getRéponse4() {
        return réponse4;
    }

    public void setRéponse4(String réponse4) {
        this.réponse4 = réponse4;
    }

    public String getRéponse3() {
        return réponse3;
    }

    public void setRéponse3(String réponse3) {
        this.réponse3 = réponse3;
    }

    public String getRéponse2() {
        return réponse2;
    }

    public void setRéponse2(String réponse2) {
        this.réponse2 = réponse2;
    }

    public String getRéponse1() {
        return réponse1;
    }

    public void setRéponse1(String réponse1) {
        this.réponse1 = réponse1;
    }

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}



    // getters and setters
}