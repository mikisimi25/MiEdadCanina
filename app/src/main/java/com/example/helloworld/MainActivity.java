package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data binding
        //Haciendo data binding los elementos del layout se crean en el momento de compilación y no en el de ejecución
        //infalte -> formar un layout
        //a partir del ActivityMainBinding vamos a formar el layout activity main
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //R.layout.activity_main -> binding.getRoot()
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        //findViewById(R.id.age_edit) -> binding.ageEdit
        /*EditText ageEdit = findViewById(R.id.age_edit);
        TextView result_text = findViewById(R.id.result_text);
        Button button = findViewById(R.id.button);*/

        /*Log.v("MainActivity", "Activiy created verbose");
        Log.d("MainActivity", "Activiy created debug");
        Log.i("MainActivity", "Activiy created info");
        Log.w("MainActivity", "Activiy created warning");
        Log.e("MainActivity", "Activiy created error");*/

        binding.button.setOnClickListener(view -> {
            String age = binding.ageEdit.getText().toString();
            String resultString = "";

            if (!age.isEmpty()) {
                int ageInt = Integer.parseInt(age);
                int result = ageInt * 7;
                resultString = getString(R.string.result_format, result);
            } else {
                Log.d("MainActivity", getString(R.string.age_field_is_empty));
                //context -> contexto, desde donde se está llamando
                Toast.makeText(this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_SHORT);
            }

            binding.resultText.setText(resultString);
        });
    }
}