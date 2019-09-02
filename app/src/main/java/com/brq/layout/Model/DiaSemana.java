package com.brq.layout.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class DiaSemana implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id =0;

    private String txtNomeDia;
    private String txtNomeMat;
    private String txtSala;

    @Ignore
    public DiaSemana(String txtNomeDia, String txtNomeMat, String txtSala) {
        this.txtNomeDia = txtNomeDia;
        this.txtNomeMat = txtNomeMat;
        this.txtSala = txtSala;
    }

    public DiaSemana(){}


    public String getTxtNomeDia() {
        return txtNomeDia;
    }

    public String getTxtNomeMat() {
        return txtNomeMat;
    }

    public String getTxtSala() {
        return txtSala;
    }

    public void setTxtNomeDia(String txtNomeDia) {
        this.txtNomeDia = txtNomeDia;
    }

    public void setTxtNomeMat(String txtNomeMat) {
        this.txtNomeMat = txtNomeMat;
    }

    public void setTxtSala(String txtSala) {
        this.txtSala = txtSala;
    }

    @Override
    public String toString() {
        return getTxtNomeDia()+" - "+getTxtNomeMat()+" - "+getTxtSala();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
