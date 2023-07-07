package com.example.filter_.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPServletOutputStream  extends ServletOutputStream {

    private GZIPOutputStream gzipos;
    public GZIPServletOutputStream(ServletOutputStream sos) throws IOException
    {
        //使用响应输出流对象构造GZIPOutputStream过滤流对象
        this.gzipos = new GZIPOutputStream(sos);
    }


    /**
     * Servlet 3.1规范新增的方法，用于检查非阻塞写入是否成功，这里返回true即可。
     * @return
     */
    @Override
    public boolean isReady() {
        return true;
    }

    /**
     * Servlet 3.1规范新增的方法，为这个ServletOutputStream设置WriteListener，
     * 从而切换到非阻塞IO。只有在异步处理或HTTP升级处理中切换到非阻塞IO才有效。
     * 这里无需给出实现。
     * @param writeListener
     */
    @Override
    public void setWriteListener(WriteListener writeListener) { }

    @Override
    public void write(int data) throws IOException {
        //将写入操作委托给GZIPOutputStream对象的write()方法，从而实现响应输出流的压缩
        gzipos.write(data);
    }

    public GZIPOutputStream getGZIPOutputStream() {
        return gzipos;
    }
}
