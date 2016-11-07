package com.wxmimperio.wechat.main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


/**
 * Created by weiximing.imperio on 2016/8/26.
 */

public class WeChatAssistMain {
    private static int PORT = 80;
    private static final String CONTEXT = "/";

    /**
     * 创建Jetty Server
     *
     * @param port
     * @param contextPath
     * @return
     * @throws IOException
     */
    private static Server createServerInSource(int port, String contextPath) throws IOException {
        Server server = new Server();
        // 设置在JVM退出时关闭Jetty的钩子
        server.setStopAtShutdown(true);

        //http的连接器
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);

        //解决Windows下重复启动Jetty不报告端口冲突的问题
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[]{connector});

        WebAppContext webContext = new WebAppContext(new ClassPathResource("webapp").getURI().toString(), contextPath);
        webContext.setDescriptor(new ClassPathResource("webapp/WEB-INF").getURI().toString() + "/web.xml");
        //设置webapp的位置
        webContext.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webContext);
        return server;
    }

    /**
     * 启动jetty服务
     *
     * @param port
     * @throws IOException
     */
    private void startJetty(String port) throws IOException {
        if (port != null) {
            PORT = Integer.valueOf(port);
        }
        final Server server = WeChatAssistMain.createServerInSource(PORT, CONTEXT);
        try {
            server.stop();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        String port = null;
        if (args.length != 0) {
            port = args[0];
        }
        new WeChatAssistMain().startJetty(port);
    }
}