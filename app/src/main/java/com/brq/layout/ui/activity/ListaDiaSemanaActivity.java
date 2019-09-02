package com.brq.layout.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.brq.layout.Model.DiaSemana;
import com.brq.layout.R;
import com.brq.layout.ui.ListaDiasView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.brq.layout.ui.activity.ConstantesActivities.CHAVE_DIA;


public class ListaDiaSemanaActivity extends AppCompatActivity {


    private ListaDiasView listaDiasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_semana);
        listaDiasView = new ListaDiasView(this);
        configuraFab();
        configList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lida_dia_menu, menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaDiasView.attListDados();
    }


    @Override
    public boolean onContextItemSelected(@SuppressWarnings("NullableProblems") final MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.act_lis_dia_menu_remover) {
            listaDiasView.DialogDelete(item);
        }
        return super.onContextItemSelected(item);

    }

    private void abrirResumoForm(DiaSemana diaSemana) {
        Intent resumo = new Intent(ListaDiaSemanaActivity.this,ResumoActivity.class);
        resumo.putExtra(CHAVE_DIA, diaSemana);
        startActivity(resumo);
    }



    private void configuraFab() {
        FloatingActionButton btnFloat = findViewById(R.id.activity_main_btnFloat);
        btnFloat.setOnClickListener(view -> startActivity(new Intent(
                ListaDiaSemanaActivity.this,
                FormularioDiaSemanaActivity.class)));
    }



    private void configList() {
        ListView listaDiaSema = findViewById(R.id.activityMainListDiasSemana);
        listaDiasView.configuraAdapter(listaDiaSema);
        configuraListenerDeCliqueProItem(listaDiaSema);
        registerForContextMenu(listaDiaSema);
    }

    private void configuraListenerDeCliqueProItem(ListView listaDiaSema) {
        listaDiaSema.setOnItemClickListener((adapterView, v, position, id) -> {
            DiaSemana nomeItemClicado = (DiaSemana) adapterView.getItemAtPosition(position);
            //String nomeItemClicado = adapterView.getItemAtPosition(position).toString();
            abrirResumoForm(nomeItemClicado);
        });
    }


}
