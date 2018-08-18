package cn.jeeweb.modules.sys.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConneUtils {
private static String URL = "http://fund.eastmoney.com/js/fundcode_search.js";
	 /**
     * 原来我们用手工通过浏览器访问网页，现在通过JAVA代码访问网页 URL
     * 统一资源定位符（URL，英语UniformResourceLocator的缩写）也被称为网页地址，是因特网上标准的资源的地址。
     * 获取网易云音乐的信息
     */
    public static void test1() {
        try {
            URL url = new URL(URL);
            System.out.println(url.getHost());// 获取网络地址
            System.out.println(url.getFile());// 获取文件
            System.out.println(url.getPort());// 获取端口号
            System.out.println(url.getProtocol());// 获取网络协议
            System.out.println(url.getDefaultPort());// 获取端口
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从网页上获取内容
     */
    public static void test2() {
        try {
            URL url = new URL(URL);
            URLConnection conn = url.openConnection();// 打开链接
            InputStream is = conn.getInputStream();// 获取数据流
            // URLConnection is =url.openStream();//缩写
            Scanner sc = new Scanner(is, "GBK");// 扫描数据流并存放在sc里,编码方式 GBK
            while (sc.hasNextLine()) {// 判断是否存在下一行
                System.out.println(sc.nextLine());// 输出当前行内容
            }
            sc.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 由于访问网络需要连网，当不联网的时候，我就没办法使用数据 所以，我们要把从网页获取的内容存到本地来 步骤： 1、从网上获取数据 2、将数据存入文本
     */
    public static void test3() {
        StringBuffer sb = new StringBuffer();
        // Constructs a string buffer with no characters in it and an initial
        // capacity of 16 characters.

        try {
            URL url = new URL(URL);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner sc = new Scanner(is, "UTF-8");
            // String content ="";
            // StringBuffer sb = new StringBuffer();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");// 把当前行内容存放在StringBuffer
                                                        // sb里 ,append（）附加）
                // content+=sc.nextLine();
                // System.out.println(content+=sc.nextLine());
            }
            sc.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 把数据存放在文件中
        try {
            //// Creates a new PrintWriter, without automatic line flushing,
            //// with the specified file name.
            PrintWriter pw = new PrintWriter("content.txt");
            pw.println(sb.toString());
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("执行成功");
    }

    /**
     * 从网页上获取数据
     * 
     * @param myUrl
     * @return
     */
    public static String getContentFromUrl(String myUrl, String charset) {
        StringBuffer sb = new StringBuffer();
        URL url;
        try {
            url = new URL(myUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner sc = new Scanner(is, charset);
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");
            }
            sc.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("执行成功");
        return sb.toString();
    }

    public static boolean writeContentToFile(String content, String fileName) {
        boolean sign = false;
        // 把数据存入在文件夹中
        PrintWriter pw;
        try {
            pw = new PrintWriter(fileName);
            pw.println(content);
            pw.flush();
            pw.close();
            sign = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sign = false;
        }

        return sign;

    }

    /**
     * 输出文件
     * 
     * @param args
     */
    public static String test3x() {
        StringBuffer sbx = new StringBuffer();
        try {
            URL urlx = new URL(URL);
            InputStream uc = urlx.openStream();
            Scanner sc = new Scanner(uc, "UTF-8");
            while (sc.hasNextLine()) {
                sbx.append(sc.nextLine()).append("\r\n");
            }
            sc.close();
            uc.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("执行成功");
        return sbx.toString();
    }

    public static boolean test3xx(String content) {
        boolean sign = false;
        try {
            PrintWriter pw = new PrintWriter("a.html");
            pw.println(content);
            pw.flush();
            pw.close();
            sign = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sign = false;
        }
        return sign;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getContentFromUrl(URL,"UTF-8"));
	}

}
