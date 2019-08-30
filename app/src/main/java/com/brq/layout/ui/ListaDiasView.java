package com.brq.layout.ui;

import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import com.brq.layout.Dao.DiaDao;
import com.brq.layout.Model.DiaSemana;
import com.brq.layout.ui.adapter.ListaDiasAdapter;


public class ListaDiasView {
    private final DiaDao dao;
    private ListaDiasAdapter adapter;
    private Context context;

    public ListaDiasView(Context context) {
        this.context = context;
        this.dao = new DiaDao();
        this.adapter = new ListaDiasAdapter(context);
    }

    public void DialogDelete(final MenuItem item) {
        new AlertDialog.Builder(this.context)
                .setTitle("Remover Registro")
                .setMessage("Tem certeza que deseja remover o registro?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    DiaSemana diaEscolhido = adapter.getItem(menuInfo.position);
                    remove(diaEscolhido);
                })
                .setNegativeButton("Não",null)
                .show();
    }

    private void remove(DiaSemana diaEscolhido) {
        this.dao.deleTDay(diaEscolhido);
        attListDados();
    }

    public void attListDados() {
        this.adapter.update(this.dao.getAllDay());
    }

    public void configuraAdapter(ListView listaDiaSema) {
        this.adapter = new ListaDiasAdapter(this.context);
        listaDiaSema.setAdapter(adapter);
    }


}
