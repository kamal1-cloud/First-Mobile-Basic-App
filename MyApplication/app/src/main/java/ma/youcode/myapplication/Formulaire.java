package ma.youcode.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;

public class Formulaire extends AppCompatActivity {
   EditText nom,prenom,email,telephone,age;
   RadioButton homme,femme;
   Button btn;

   AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        telephone = findViewById(R.id.telephone);
        age = findViewById(R.id.age);
        homme = findViewById(R.id.homme);
        femme = findViewById(R.id.femme);
        btn = findViewById(R.id.btn);

        // Initialize Validaion Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Ajouter la validation pour le nom
        awesomeValidation.addValidation(this,R.id.nom, RegexTemplate.NOT_EMPTY,R.string.invalid_nom);
        //Ajouter la validation pour le prenom
        awesomeValidation.addValidation(this,R.id.prenom,RegexTemplate.NOT_EMPTY,R.string.invalid_prenom);
        //Ajouter la validation pour le email
 awesomeValidation.addValidation(this,R.id.email, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        //Ajouter la validation pour le telephone
        awesomeValidation.addValidation(this,R.id.telephone,"^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",R.string.invalid_num);
        // Ajouter la validation pour l'age
        awesomeValidation.addValidation(this, R.id.age, Range.closed(16, 50), R.string.invalid_age);

        btn.setOnClickListener(new View.OnClickListener() {
            Intent i = new Intent(getApplicationContext(),MessageDeSucces.class);

            @Override
            public void onClick(View v) {
                // checker la validation
                if (awesomeValidation.validate()){
                    // succes
                    Toast.makeText(getApplicationContext(),"Form Validate Succefully ...",Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Validation Faild...",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }   }

