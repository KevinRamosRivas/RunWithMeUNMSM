package com.arge.correosm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.arge.correosm.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class perfil_Activity extends AppCompatActivity {

    ImageButton home;
    ImageButton evento;
    ImageButton perfil;
    public ImageButton mButtonCloseSession;
    public SharedPreferences mPref;
    public TextView nameUser, codeTextView, districtTextView;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("alumnoA");

        home = (ImageButton) findViewById(R.id.id_home);
        evento = (ImageButton) findViewById(R.id.id_evento);
        perfil = (ImageButton) findViewById(R.id.id_perfil);
        mButtonCloseSession = (ImageButton) findViewById(R.id.btnCloseSession);
        mPref = getSharedPreferences("Preferences", MODE_PRIVATE);
        nameUser = (TextView) findViewById(R.id.nameUser);
        codeTextView = (TextView) findViewById(R.id.codeTextView);
        districtTextView = (TextView) findViewById(R.id.districtTextView);

//        recuperar datos de la base de datos de firebase
        Log.d("mAuth", mPref.getString("mAuth", ""));
        mDatabase.child(mPref.getString("mAuth", "")).
                child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d("nombre", task.getResult().getValue().toString());
                            nameUser.setText(task.getResult().getValue().toString());
                        } else {
                            Log.d("nombre", "Error getting data", task.getException());
                            nameUser.setText("Error getting data");
                        }

                    }
                }
        );
        mDatabase.child(mPref.getString("mAuth", "")).child("codigo").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d("codigo", task.getResult().getValue().toString());
                    codeTextView.setText(task.getResult().getValue().toString());
                } else {
                    Log.d("codigo", "Error getting data", task.getException());
                    codeTextView.setText("Error getting data");
                }
            }
        });
        mDatabase.child(mPref.getString("mAuth", "")).child("addres").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d("distrito", task.getResult().getValue().toString());
                    districtTextView.setText(task.getResult().getValue().toString());
                } else {
                    Log.d("distrito", "Error getting data", task.getException());
                    districtTextView.setText("Error getting data");
                }
            }
        });


        mButtonCloseSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPref.edit();
                editor.clear();
                editor.commit();
                //eliminar todos los activitys
                Intent intent = new Intent(perfil_Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(perfil_Activity.this, map_alumnoB.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(perfil_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}