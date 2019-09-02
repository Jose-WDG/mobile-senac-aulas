package com.brq.layout.Dao;

import com.brq.layout.Model.DiaSemana;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class DiaDao {
    private final static List<DiaSemana> registros = new ArrayList<>();
    private static int contador = 1;

    public void salvar(DiaSemana novoDia) {
        novoDia.setId(contador);
        registros.add(novoDia);
        atualizaId();
    }

    private int atualizaId() {
        return contador++;
    }

    public List<DiaSemana> getAllDay() {
        return new ArrayList<>(registros);
    }

// --Commented out by Inspection START (30/08/2019 11:05):
//    public DiaSemana getDay(String nomeDia) {
//        if (!registros.isEmpty()) {
//            for (DiaSemana dia : registros) {
//                if (dia.getTxtNomeDia().equals(nomeDia)) {
//                    return dia;
//                }
//            }
//        }
//        return null;
//    }
// --Commented out by Inspection STOP (30/08/2019 11:05)

    public void updateDay(DiaSemana dia) {
        if (!registros.isEmpty()) {
            DiaSemana diaEncontrado = BuscaItemPorId(dia);
            if (diaEncontrado != null) {
                int posicaoDia = registros.indexOf(diaEncontrado);
                registros.set(posicaoDia, dia);

            }
        }

    }

    private DiaSemana BuscaItemPorId(DiaSemana dia) {
        DiaSemana diaEncontrado = null;
        for (DiaSemana resul : registros) {

            if (resul.getId() == dia.getId()) {
                diaEncontrado = resul;
            }
        }
        return diaEncontrado;
    }

    @SuppressWarnings("RedundantCollectionOperation")
    public void deleTDay(DiaSemana item) {
            if(registros.contains(item))
                registros.remove(item);
    }
}
