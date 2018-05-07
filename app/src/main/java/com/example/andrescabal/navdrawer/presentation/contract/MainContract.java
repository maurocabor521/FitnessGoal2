package com.example.andrescabal.navdrawer.presentation.contract;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface MainContract {
    interface View {

        void goToActivity(String intemMenu);

        void showLoginErrorMessage(Throwable error);
    }

    interface Presenter {

        void closeSession();

    }
}
