/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author vektorel
 */
public class DilYukle {

    public static Properties prop = new Properties();

    public DilYukle(String dil) {
        try {
            ClassLoader loader = this.getClass().getClassLoader();
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            prop.load(new FileInputStream(path + "com/vektorel/kutuphane/util/" + dil + ".properties"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
