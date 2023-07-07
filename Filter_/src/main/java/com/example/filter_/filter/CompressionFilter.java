package com.example.filter_.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

@WebFilter(urlPatterns = "/*", filterName = "compressionFilter")
public class CompressionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        String acceptEncodings = httpReq.getHeader("Accept-Encoding");
        if (acceptEncodings != null && acceptEncodings.indexOf("gzip") > -1) {
            // 得到响应对象的封装类对象
            CompressionResponseWrapper respWrapper = new CompressionResponseWrapper(
                    httpResp);

            // 设置Content-Encoding实体报头，告诉浏览器实体正文采用了gzip压缩编码
            respWrapper.setHeader("Content-Encoding", "gzip");
            filterChain.doFilter(httpReq, respWrapper);

            //得到GZIPOutputStream输出流对象
            GZIPOutputStream gzipos = respWrapper.getGZIPOutputStream();
            //调用GZIPOutputStream输出流对象的finish()方法完成将压缩数据写入响应输出流的操作，
            // 无须关闭输出流
            gzipos.finish();
        } else {
            filterChain.doFilter(httpReq, httpResp);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
