package com.brq.layout.DataBese;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.brq.layout.DataBese.dao.RoomDiaDao;
import com.brq.layout.Model.DiaSemana;

@Database(entities = {DiaSemana.class},version = 1,exportSchema = false)
    public abstract class GestorDataBase extends RoomDatabase {

    public abstract RoomDiaDao getRoomDiaDao();

}
