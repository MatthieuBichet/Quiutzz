package bichet.mb2.quiutzz;

import android.arch.persistence.room.Room;
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

import java.util.ArrayList;
import java.util.List;

import bichet.mb2.quiutzz.MainActivity;
import bichet.mb2.quiutzz.R;
import bichet.mb2.quiutzz.database.Joueur;
import bichet.mb2.quiutzz.database.MyDatabase;
import bichet.mb2.quiutzz.database.Question;

import static bichet.mb2.quiutzz.MainActivity.get;

public class EcranQuizz extends AppCompatActivity {

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
        //List<Joueur> joueur1 = new ArrayList<>();
        Button boutonrep1 = (Button) findViewById(R.id.button);
        Button boutonrep2 = (Button) findViewById(R.id.button2);
        Button boutonrep3 = (Button) findViewById(R.id.button3);
        Button boutonrep4 = (Button) findViewById(R.id.button4);
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
            public void run (){
                Joueur joueur1 = new Joueur();
                joueur1.setName(message);
                get().getDB().daoQuestion().updateJoueur(joueur1);
                List<Question> questions = MainActivity.get().getDB().daoQuestion().getAllquestion();


            }
        }).start();
    }

}
