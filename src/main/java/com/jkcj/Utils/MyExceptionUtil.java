package com.jkcj.Utils;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
  *@Auther:Xhy
  *@Date:2020/2/17 20:06
  *@Description:错误定制工具
  **/
public final class MyExceptionUtil {
    public static String getErrorMsg(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}

