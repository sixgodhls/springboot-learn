package com.example.filter_.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {

    private final GZIPServletOutputStream gzipsos;
    private final PrintWriter pw;

    public CompressionResponseWrapper(HttpServletResponse response)
            throws IOException {
        super(response);
        //用响应输出流创建GZIPServletOutputStream对象
        gzipsos = new GZIPServletOutputStream(response.getOutputStream());
        ////用GZIPServletOutputStream对象作为参数，构造PrintWriter对象
        pw = new PrintWriter(gzipsos);
    }

    /**
     * 重写setContentLength()方法，以避免Content-Length实体报头所指出的长度
     * 和压缩后的实体正文长度不匹配
     */
    @Override
    public void setContentLength(int len) {}

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return gzipsos;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;
    }

    /**
     * 过滤器调用这个方法来得到GZIPOutputStream对象，以便完成将压缩数据写入输出流的操作
     */
    public GZIPOutputStream getGZIPOutputStream() {
        return gzipsos.getGZIPOutputStream();
    }

}
