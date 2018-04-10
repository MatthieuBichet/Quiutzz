package bichet.mb2.quiutzz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bichet.mb2.quiutzz.database.Joueur;
import bichet.mb2.quiutzz.database.Question;

import static bichet.mb2.quiutzz.MainActivity.get;

/**
 * Created by MAURI5 on 10/04/2018.
 */

public class Add_question extends AppCompatActivity {
    Button button;
    EditText question;
    EditText reponse1;
    EditText reponse2;
    EditText reponse3;
    EditText reponse4;
    Question addquestion;
    TextView num;
    List<Question> list;
    int qcount,quest;
    //Button delete;
    Context context;
    String verif,verif1,verif2,verif3,verif4;
    boolean stop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.add_question);
        button = findViewById(R.id.addqs);
       // delete = findViewById(R.id.delq);
        question = findViewById(R.id.addqn);
        reponse1 = findViewById(R.id.r1);
        reponse2 = findViewById(R.id.r2);
        reponse3 = findViewById(R.id.r3);
        reponse4 = findViewById(R.id.r4);
        num = findViewById(R.id.numquest);
        list = get().getDB().daoQuestion().getAllquestion();
        display();
        button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view) {
               stop = false;
               verif  = question.getText().toString();
               verif1 = reponse1.getText().toString();
               verif2 = reponse2.getText().toString();
               verif3 = reponse3.getText().toString();
               verif4 = reponse4.getText().toString();
               if (verif.matches("")){
                   Toast.makeText(context, "Question invalide", Toast.LENGTH_SHORT).show();

                }
               if(verif1.matches(""))
               {
                   Toast.makeText(context,"Réponse 1 invalide" ,Toast.LENGTH_SHORT ).show();
                   stop = true;
               }
               if(verif2.matches(""))
               {
                   Toast.makeText(context,"Réponse 2 invalide" ,Toast.LENGTH_SHORT ).show();
                   stop = true;
               }
               if(verif3.matches(""))
               {
                   Toast.makeText(context,"Réponse 3 invalide" ,Toast.LENGTH_SHORT ).show();
                   stop = true;
               }
               if(verif4.matches(""))
               {
                   Toast.makeText(context,"Réponse 4 invalide" ,Toast.LENGTH_SHORT ).show();
                   stop = true;
               }
               if(!stop)
               {
                quest = qcount +1;
               Question addquestion = new Question(quest, question.getText().toString(),
                       reponse1.getText().toString(),
                       reponse2.getText().toString(),
                       reponse3.getText().toString(),
                       reponse4.getText().toString());
               get().getDB().daoQuestion().insertQuestion(addquestion);
               startActivity(new Intent(Add_question.this, MainActivity.class));
               }
           }
        });
       /* delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            // TODO: 11/04/2018  Ajouter une suppression logicielle de la liste des questions
                startActivity(new Intent(Add_question.this, MainActivity.class));
            }
        });*/

    }
    public void display ()
    {
         qcount = list.size();
        ((TextView)findViewById(R.id.numquest)).setText("question n°"+qcount);
    }

}
