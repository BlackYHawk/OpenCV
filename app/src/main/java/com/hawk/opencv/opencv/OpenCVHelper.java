package com.hawk.opencv.opencv;

/**
 * Created by lan on 2017-10-26.
 */

public class OpenCVHelper {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static native int[] gray(int[] buf, int w, int h);

}
