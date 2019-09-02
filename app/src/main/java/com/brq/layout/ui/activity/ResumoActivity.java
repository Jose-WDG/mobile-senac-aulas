package com.brq.layout.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.brq.layout.Dao.DiaDao;
import com.brq.layout.DataBese.GestorDataBase;
import com.brq.layout.DataBese.dao.RoomDiaDao;
import com.brq.layout.Model.DiaSemana;
import com.brq.layout.R;

public class ResumoActivity extends AppCompatActivity {

    private static final String TITULO_RESUMO = "Resumo";
    private static final String CHAVE_ITEM_CLICADO = "itemClicado";
    private RoomDiaDao dao;
    private EditText activityResumeNomeDiaEdit, activityResumeNomeMat, activityResumeSal;
    private Button btnUpdate;
    private DiaSemana itemClicado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);
        setTitle(TITULO_RESUMO);
        GestorDataBase dataBase = Room.databaseBuilder(this, GestorDataBase.class, "Gestor.db")
                .allowMainThreadQueries()
                .build();
        dao = dataBase.getRoomDiaDao();
        initComponents();
        returnItemClicado();
        insertDadosFormAtt();
        btnAttContato();
    }

    private void returnItemClicado() {
        Intent item = getIntent();
        itemClicado = (DiaSemana) item.getSerializableExtra(CHAVE_ITEM_CLICADO);
    }

    private void insertDadosFormAtt() {
        activityResumeNomeDiaEdit.setText(itemClicado.getTxtNomeDia());
        activityResumeNomeMat.setText(itemClicado.getTxtNomeMat());
        activityResumeSal.setText(itemClicado.getTxtSala());
    }

    private void btnAttContato() {
        btnUpdate.setOnClickListener(view -> {
            String nomeAtt, nomeAttMateria, salaAtt;

            nomeAtt = activityResumeNomeDiaEdit.getText().toString();
            nomeAttMateria = activityResumeNomeMat.getText().toString();
            salaAtt = activityResumeSal.getText().toString();

            itemClicado.setTxtNomeDia(nomeAtt);
            itemClicado.setTxtNomeMat(nomeAttMateria);
            itemClicado.setTxtSala(salaAtt);

            dao.updateDay(itemClicado);
            finish();
        });
    }

    private void initComponents() {

        activityResumeNomeDiaEdit = findViewById(R.id.activity_resume_nomeDia_edit);
        activityResumeNomeMat = findViewById(R.id.activity_resume_nomeMateria_edit);
        activityResumeSal = findViewById(R.id.activity_resume_sala_edit);
        btnUpdate = findViewById(R.id.activity_resume_btnSalvar_Edit);
    }


}
