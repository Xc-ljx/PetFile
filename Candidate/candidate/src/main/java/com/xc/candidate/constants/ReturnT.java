
package com.xc.candidate.constants;

/**
 * 功能描述
 *
 * @author l00845811
 * @since 2025-02-21
 */
public class ReturnT {

    public static final String error = "error";

    public static final String success = "success";

    public static String success() {
        return success;
    }

    public static String success(String msg) {
        return success + " " + msg;
    }

    public static String error() {
        return error;
    }

    public static String error(String msg) {
        return error + " " + msg;
    }

}
