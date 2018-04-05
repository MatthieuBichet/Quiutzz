package bichet.mb2.quiutzz.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by MAURI5 on 30/03/2018.
 */

@Dao
public interface DaoQuestion {

    @Query("SELECT * FROM question")
    List<Question> getAllquestion();

    //@Query("SELECT * FROM question")
    //Question getQuestion();

    @Query("SELECT * FROM infojoueur")
    List<Joueur> getAlljoueur();
    @Query("SELECT * FROM question WHERE numero LIKE :numero LIMIT 1")
    Question findByNumber(int numero);

    @Query("SELECT * FROM InfoJoueur WHERE name LIKE :name LIMIT 1")
    Joueur findByName(String name);

    @Insert
    void insertAllQuestion(List<Question> questions);
    @Insert
    void insertQuestion(Question question);
    @Insert
    void insertAllJoueur(List<Joueur> joueurs);
    @Insert
    void insertJoueur(Joueur joueur);
    @Update
    void updateJoueur(Joueur... joueurs);
    @Update
    void updateQuestion(Question... questions);

    @Delete
    void deleteQuestion(Question question);
    @Delete
    void deleteJoueur(Joueur joueur);
}