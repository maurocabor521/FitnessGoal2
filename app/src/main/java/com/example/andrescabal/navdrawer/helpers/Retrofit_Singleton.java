package com.example.andrescabal.navdrawer.helpers;

/**
 * Created by Andrés Cabal on 5/05/2018.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Singleton {


    private static Retrofit retrofit;

        public static Retrofit getInstance() {
            if(retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://fitness-goal.firebaseio.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            return retrofit;
        }

}
