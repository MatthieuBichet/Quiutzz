package bichet.mb2.quiutzz;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bichet.mb2.quiutzz.MainActivity;
import bichet.mb2.quiutzz.R;
import bichet.mb2.quiutzz.database.Joueur;
import bichet.mb2.quiutzz.database.MyDatabase;
import bichet.mb2.quiutzz.database.Question;

import static bichet.mb2.quiutzz.MainActivity.get;

public class EcranQuizz extends AppCompatActivity {

    Button boutonrep1;
    Button boutonrep2;
    Button boutonrep3;
    Button boutonrep4;
    public String Rep1, Rep2, Rep3, Rep4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_quizz);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_SUP);
/*créer le textView*/
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText(message);
        setContentView(R.layout.activity_ecran_quizz);
        boutonrep1   =  findViewById(R.id.button);
        boutonrep2  =  findViewById(R.id.button2);
        boutonrep3   =  findViewById(R.id.button3);
        boutonrep4  =  findViewById(R.id.button4);


        initB(message);
        loadQ(1);
        get().toastT(2);


        //Button bouton =(Button) findViewById(R.id.Start); //Ajout de l'id Start au .C
/*définir le layout activite_affich_message comme
étant le layout de l’activité*/
        setContentView(R.layout.activity_ecran_quizz);
/*récupérer le layout*/
      RelativeLayout monLayout =  (RelativeLayout) findViewById(R.id.quiz_layout);
/*rajouter le textView au layout*/
        monLayout.addView(textView,0);
/*définition de la barre d’action */
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void initB (final String message)
    {

        new Thread (new Runnable(){
            public void run () {
                Joueur joueur1 = new Joueur();
                joueur1.setName(message);
                get().getDB().daoQuestion().insertJoueur(joueur1);
            }
        }).start();
        get().toastT(3);
    }

    public void loadQ ( final int num)
    {
        new Thread (new Runnable(){
            public void run (){

                //List<Question> questionList = MainActivity.get().getDB().daoQuestion().getAllquestion();
                Question question = get().getDB().daoQuestion().findByNumber(num);
                //=question.getIntitule()
                Rep1 = question.getRéponse1();
                Rep2 = question.getRéponse2();
                Rep3 = question.getRéponse3();
                Rep4 = question.getRéponse4();
            }
        }).start();
        get().toastT(4);
    }
    public void Actu (View view) {
            boutonrep1.setText(Rep1);
            boutonrep2.setText(Rep2);
            boutonrep3.setText(Rep3);
            boutonrep4.setText(Rep4);
            setContentView(R.layout.content_ecran_quizz);
        }



}