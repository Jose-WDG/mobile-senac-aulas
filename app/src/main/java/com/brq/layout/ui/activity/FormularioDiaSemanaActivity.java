package com.brq.layout.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.brq.layout.Dao.DiaDao;
import com.brq.layout.DataBese.GestorDataBase;
import com.brq.layout.DataBese.dao.RoomDiaDao;
import com.brq.layout.Model.DiaSemana;
import com.brq.layout.R;

import static com.brq.layout.R.layout.activity_formulario_dia_semana;

public class FormularioDiaSemanaActivity extends AppCompatActivity {
    private static final String TITULO_APPBAR = "Novo Registro";
    private EditText nomeDiaSema;
    private EditText nomeMateria;
    private EditText sala;
    private RoomDiaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_formulario_dia_semana);
        setTitle(TITULO_APPBAR);
        GestorDataBase dataBase = Room.databaseBuilder(this, GestorDataBase.class, "Gestor.db")
                .allowMainThreadQueries()
                .build();
        dao = dataBase.getRoomDiaDao();
        initComponents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_dia_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.act_for_dia_menu_salvar) {
            finalizarFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void finalizarFormulario() {
        DiaSemana novoDia = criaRegistro();
        salvarRegistro(novoDia, dao);
    }

    private void initComponents() {
        nomeDiaSema = findViewById(R.id.activity_for_dia_nome);
        nomeMateria = findViewById(R.id.activity_for_dia_nome_aula);
        sala = findViewById(R.id.activity_for_dia_nome_sala);
    }

    private void salvarRegistro(DiaSemana novoDia, RoomDiaDao dao) {

        if (nomeDiaSema.getText().toString().equals("")) {
            Toast.makeText(FormularioDiaSemanaActivity.this, "Nome do Dia obrigatório!", Toast.LENGTH_LONG).show();
        } else {
            dao.salvar(novoDia);
            finish();
        }

    }

    private DiaSemana criaRegistro() {

        String txtNomeDia = nomeDiaSema.getText().toString();
        String txtNomeMat = nomeMateria.getText().toString();
        String txtSala = sala.getText().toString();

        return new DiaSemana(txtNomeDia, txtNomeMat, txtSala);
    }
}
