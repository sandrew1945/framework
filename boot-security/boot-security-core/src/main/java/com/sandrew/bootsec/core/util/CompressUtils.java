package com.sandrew.bootsec.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class CompressUtils
{
    public static byte[] comressString(byte[] originStr)
    {
        try
        {
            if (null == originStr || originStr.length <= 0)
            {
                return originStr;
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try (DeflaterOutputStream dos = new DeflaterOutputStream(os))
            {
                dos.write(originStr);
            }
            return os.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] extractString(byte[] zipStr)
    {
        try
        {
            if (null == zipStr || zipStr.length <= 0)
            {
                return zipStr;
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try (OutputStream ios = new InflaterOutputStream(os))
            {
                ios.write(zipStr);
            }

            return os.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
    {
        String s = "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";
        System.out.println("原字符串:" + s + " 长度:" + s.length());
        System.out.print("压缩字符串：");
        System.out.println(new String(comressString(s.getBytes())) + " 长度：" + comressString(s.getBytes()).length);
        System.out.println("解压缩字符串：" + new String(extractString(comressString(s.getBytes()))));
    }
}
