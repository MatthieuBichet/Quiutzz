package bichet.mb2.quiutzz;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
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
    Question question;
    String rep1, rep2, rep3, rep4,intitulé;
    Button bt1,bt2,bt3,bt4;
    List<Question> qu;
    int etat=1;
    int cb;
    MediaPlayer mpt,mpf;
   // Context context;
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
        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        question = get().getDB().daoQuestion().findByNumber(1);
        rep1 = question.getRéponse1();
        rep2 = question.getRéponse2();
        rep3 = question.getRéponse3();
        rep4 = question.getRéponse4();
        intitulé = question.getIntitule();
        //context = getApplicationContext();
        qu = get().getDB().daoQuestion().getAllquestion();
        cb = qu.size();
        mpt = MediaPlayer.create(this, R.raw.bonne);
        mpf = MediaPlayer.create(this, R.raw.mauvaise);
        setText();
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // bt1.setOnClickListener(new View.OnClickListener(){
       //     @Override

      //  });


    }
    /*public void initB (final String message)
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
*/
    public void setText()
    {

        ((TextView)findViewById(R.id.editText)).setText(intitulé);
        ((Button)findViewById(R.id.button)).setText(rep1);
        ((Button)findViewById(R.id.button2)).setText(rep2);
        ((Button)findViewById(R.id.button3)).setText(rep3);
        ((Button)findViewById(R.id.button4)).setText(rep4);
        ((TextView)findViewById(R.id.questioncb)).setText("Question "+ etat+"/ " + cb);

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(getApplicationContext(), "Bonne réponse", Toast.LENGTH_SHORT).show();
                mpt.start();
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                mpf.start();
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(), "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                mpf.start();
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(), "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                mpf.start();
                break;
        }



            if (cb > etat) {
                etat++;
                question = get().getDB().daoQuestion().findByNumber(etat);
                rep1 = question.getRéponse1();
                rep2 = question.getRéponse2();
                rep3 = question.getRéponse3();
                rep4 = question.getRéponse4();
                intitulé = question.getIntitule();
                setText();

            } else {
                startActivity(new Intent(EcranQuizz.this, MainActivity.class));
            }

    }
}
