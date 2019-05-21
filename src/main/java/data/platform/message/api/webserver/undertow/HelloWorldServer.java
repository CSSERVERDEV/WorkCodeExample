package data.platform.message.api.webserver.undertow;

//import io.undertow.Undertow;
//import io.undertow.server.HttpHandler;
//import io.undertow.server.HttpServerExchange;
//import io.undertow.util.Headers;

/**
 * Undertow Web 服务器使用异步IO的方式向界面输出字符串
 */
public class HelloWorldServer {
    public static void main(String[] args) {
//        Undertow server = Undertow.builder()
//                .addHttpListener(8080, "localhost").setHandler(new HttpHandler() {//设置HttpHandler的回调方法
//                    @Override
//                    public void handleRequest(HttpServerExchange exchange)
//                            throws Exception {
//                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                        exchange.getResponseSender().send("This is my first insert server!");
//                    }
//                }).build();
//        server.start();
    }
}
