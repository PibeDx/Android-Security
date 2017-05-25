package com.josecuentas.android_security.security;

/**
 * Created by jcuentas on 25/05/17.
 */
// onco_salud
public class CheckRunEmulador {


    /*
    * Verifica si la aplicacion esta corriendo en un emulador
    * */
    public static boolean checkEmulator() {

        try {

            boolean goldfish = getSystemProperty("ro.hardware").contains("goldfish");

            boolean emu = getSystemProperty("ro.kernel.qemu").equals("1");

            boolean sdk = getSystemProperty("ro.product.model").equals("sdk");

            if (emu || goldfish || sdk) {

                return true;

            }

        } catch (Exception e) {

        }

        return false;

    }

    private static String getSystemProperty(String name)

            throws Exception {

        Class systemPropertyClazz = Class

                .forName("android.os.SystemProperties");



        return (String) systemPropertyClazz
                .getMethod("get", new Class[] { String.class })
                .invoke(systemPropertyClazz, new Object[] { name });
    }

}
