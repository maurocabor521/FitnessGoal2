package com.example.andrescabal.navdrawer.helpers;

import java.util.List;

/**
 * Created by Andrés Cabal on 29/07/2017.
 */

public class Constants {
    //CONSTANTES TABLA USUARIO
    public  static final String TABLA_RECETA ="receta";
   public  static final String CAMPO_ID="id";
    public  static final String CAMPO_NOMBRE="nombre";
    public  static final String CAMPO_ALIMENTOS="alimento";

    public static final String CREAR_TABLA_RECETA=
            "CREATE TABLE "+ TABLA_RECETA +"("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_ALIMENTOS+" TEXT)";


}
