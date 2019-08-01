package my.example;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.util.Properties;

/**
 * 解析邮件，转成文件
 */
public class EmlFileParser {
    public static void main(String[] args){
        if (args != null && args.length == 2) {
            String filePath = args[0];
            String saveFilePath = args[1]+"\\";
            Properties props = new Properties();
            Session mailSession = Session.getDefaultInstance(props, null);
            Message msg = null;
            try {
                InputStream inMsg = new FileInputStream(filePath);
                msg = new MimeMessage(mailSession, inMsg);
                StringBuffer stringBuffer = new StringBuffer();
                Object o = msg.getContent();
                // getContent() 是获取包裹内容, Part相当于外包装
                if (o instanceof Multipart) {
                    Multipart multipart = (Multipart) o;
                    reMultipart(multipart, stringBuffer,saveFilePath);
                } else if (o instanceof Part) {
                    Part part = (Part) o;
                    rePart(part, stringBuffer,saveFilePath);
                }
                // 生成的文件路径
                builderEmlTxtFile( saveFilePath  + msg.getSubject()+".txt",stringBuffer.toString());
                System.out.println("文件解析成功，文件在："+saveFilePath+"目录下");
            } catch (Exception e) {
                System.out.println("文件解析异常");
            }
        } else {
            System.out.println("请输入参数，如\"D:\\tmp\\email_test_20190727.eml\" \"D:\\bak2\"");
        }
    }

    /**
     * 根据文件路径和邮件内容生成txt文件
     * @param path 路径
     * @param emlContext 邮件内容
     * @throws IOException
     */
    private static void builderEmlTxtFile(String path,String emlContext) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(emlContext);
        bw.flush();
        bw.close();
        fw.close();
    }

    /**
     * 解析邮件内容
     * @param part
     * @param stringBuffer
     * @param saveFilePath
     * @throws Exception
     */
    private static void rePart(Part part, StringBuffer stringBuffer,String saveFilePath) throws Exception {
        if (part.getDisposition() != null) {
            String strFileNmae = part.getFileName();
            if(strFileNmae!=null) {
                strFileNmae= MimeUtility.decodeText(strFileNmae);
                InputStream in = part.getInputStream();// 打开附件的输入流
                // 读取附件字节并存储到文件中
                java.io.FileOutputStream out = new FileOutputStream(saveFilePath+strFileNmae);
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
                in.close();
                out.close();
            }
        } else {
            if (part.getContentType().startsWith("text/plain")) {
                stringBuffer.append(part.getContent());
            } else {
                stringBuffer.append(delHtmlTags(part.getContent().toString()));
            }
        }
    }

    /**
     * 清除HTML标签
     * @param htmlStr
     * @return 邮件文本内容
     */
    public static String delHtmlTags(String htmlStr) {
        //定义script的正则表达式，去除js可以防止注入
        String scriptRegex="<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式，去除style样式，防止css代码过多时只截取到css样式代码
        String styleRegex="<style[^>]*?>[\\s\\S]*?<\\/style>";
        //定义HTML标签的正则表达式，去除标签，只提取文字内容
        String htmlRegex="<[^>]+>";
        //定义空格,回车,换行符,制表符
        String spaceRegex = "\\s*|\t|\r|\n";
        // 过滤script标签
        htmlStr = htmlStr.replaceAll(scriptRegex, "");
        // 过滤style标签
        htmlStr = htmlStr.replaceAll(styleRegex, "");
        // 过滤html标签
        htmlStr = htmlStr.replaceAll(htmlRegex, "");
        // 过滤空格等
        htmlStr = htmlStr.replaceAll(spaceRegex, "");
        return htmlStr.trim(); // 返回文本字符串
    }
    /**
     * 接卸包裹（含所有邮件内容(包裹+正文+附件)）
     * @param multipart
     * @param stringBuffer
     * @param saveFilePath
     * @throws Exception
     */
    private static void reMultipart(Multipart multipart, StringBuffer stringBuffer,String saveFilePath) throws Exception {
        // 依次处理邮件各个部分
        for (int j = 0, n = multipart.getCount(); j < n; j++) {
            Part part = multipart.getBodyPart(j);// 解包, 取出 MultiPart的各个部分,
            /*每部分可能是邮件内容,
             也可能是另一个小包裹(MultipPart)
             判断此包裹内容是不是一个小包裹, 一般这一部分是 正文 Content-Type: multipart/alternative*/
            if (part.getContent() instanceof Multipart) {
                Multipart p = (Multipart) part.getContent();// 转成小包裹
                reMultipart(p,stringBuffer,saveFilePath);// 递归迭代
            } else {
                rePart(part,stringBuffer,saveFilePath);
            }
        }
    }
}