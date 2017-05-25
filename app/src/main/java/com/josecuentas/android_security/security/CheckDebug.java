package com.josecuentas.android_security.security;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by jcuentas on 25/05/17.
 */

public class CheckDebug {

    /*
    * Verifica si la aplicacion esta corriendo en modo debug
    * */
    public static boolean checkDebuggable(Context context){

        return (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}
