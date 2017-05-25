package com.josecuentas.android_security.security;

import android.content.Context;

/**
 * Created by jcuentas on 25/05/17.
 */

public class CheckInstallPlayStore {
    private static final String PLAY_STORE_APP_ID = "com.android.vending";


    /*
    * Verifica si la aplicacion fue instalada desde el playstore
    * */
    public static boolean verifyInstaller(final Context context) {

        final String installer = context.getPackageManager()
                .getInstallerPackageName(context.getPackageName());

        return installer != null && installer.startsWith(PLAY_STORE_APP_ID);

    }
}
