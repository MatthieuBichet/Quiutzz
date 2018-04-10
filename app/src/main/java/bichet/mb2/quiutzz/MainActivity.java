package bichet.mb2.quiutzz;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import bichet.mb2.quiutzz.database.DaoQuestion;
import bichet.mb2.quiutzz.database.Joueur;
import bichet.mb2.quiutzz.database.MyDatabase;
import bichet.mb2.quiutzz.database.Question;



public class MainActivity extends AppCompatActivity {
    public final static String MESSAGE_SUP = "android.bichet.mb2.quiutzz.message";
    public int qcount=0;
    public static MainActivity INSTANCE;
    private MyDatabase db; //Variable database
    String q,rep1,rep2,rep3,rep4;
    public static MainActivity get() {
        return INSTANCE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //Initialisation de la base de donnée (database)
         db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "database")
                 .allowMainThreadQueries()
                 .fallbackToDestructiveMigration()
                 .build();
        INSTANCE = this;



        Button bouton =(Button) findViewById(R.id.Start); //Ajout de l'id Start au .C
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Add_question.class));
            }
        });

    }
    public MyDatabase getDB() { // Accès public de la base de donnée
        return db;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   public void Envoi(View view)
   {
        Intent intent = new Intent(this, EcranQuizz.class);
        EditText editText = (EditText) findViewById(R.id.chp_saisie);
        String message = editText.getText().toString();
        //List<Question> list = new ArrayList<>();
       // Joueur joueur1 = new Joueur();
        //joueur1.setName(message);
        //db.daoQuestion().updateJoueur(joueur1);
        intent.putExtra(MESSAGE_SUP,message);
        startActivity(intent);
    }
   /* public void AddQuestion (View view)
    {
        new Thread (new Runnable() { //Création d'une tache afin de pouvoir utiliser la database
            public void run(){ //lancement de la tache
                runOnUiThread(new Runnable(){ //utilisation de la tache UI afin de récupérer les données dans l'UI
                public void run() { //lancement

                qcount = qcount+1;


                EditText editText = (EditText) findViewById(R.id.addqn);
                q = editText.getText().toString();

                editText = (EditText) findViewById(R.id.r1);
                rep1 = editText.getText().toString();

                editText = (EditText) findViewById(R.id.r2);
                rep2 = editText.getText().toString();

                 editText = (EditText) findViewById(R.id.r3);
                rep3 = editText.getText().toString();

                editText = (EditText) findViewById(R.id.r4);
                rep4 = editText.getText().toString();
                    }//Fin de la tache UI
                });
            //Utilisation de la tache pour modifier la database (récupération des infos de questions
            Question question = new Question();
            question.setNumero(qcount);
            question.setIntitule(q);
            question.setRéponse1(rep1);
            question.setRéponse2(rep2);
            question.setRéponse3(rep3);
            question.setRéponse4(rep4);
            db.daoQuestion().insertQuestion(question);
            }
        }).start();//Fin de la tâche parallèle
        }*/

}
