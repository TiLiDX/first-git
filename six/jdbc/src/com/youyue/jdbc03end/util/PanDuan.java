package com.youyue.jdbc03end.util;

public class PanDuan {
    public static boolean isEmpty(String str){
        if (str==null || str.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
