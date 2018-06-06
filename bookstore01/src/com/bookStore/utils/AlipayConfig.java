package com.bookStore.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091400512823";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDAopfNJ7sCEfcBaPFbz58kmNB23Qt812M7Yv3HoVHtna/qZM6UoyvzHL0PVhsgSSFIivT03AVXwvKS5wvp584a4RaAIPdxLy3uuYB4gRnI0YN1ZtPh8g14XZkh4Nid5SpS+tp1I8fW7hz3Cx7DFyA3miqVizv64eN/32ouTB6AY93OV4/DLrnfXkgSqFrvasx2vyYqvYhcXcP2WM6erOQHEp6kDIckxJPWO3o4h8xSreW7Er1UYR0nE4XtauShG7k73hUzCMcMsk0VYp2jbXxnjQejO9gzGshHGWpSjFJbaD86Ka0K9nsaFcKY0B8+Ez/ICZhRA1jau0kgCBitxvN1AgMBAAECggEAYc5sGssQZVWvvzSET2RUXiWEusUyvvkxNgbl6YUb7vSATBdQ2CEdAHvX9kB212aqEoYTJ3vK7qtZtILBBsseV4FvhjC20e3teWcQNp7983uFLoe+DttyQWnshUn/UfP4EFezsYQwRA10AW7Q+Kb2QaTx+CnQk2o7s0JBTC5z0iWBBYUOhd+31fjrcRhAtb0G7C0oBHD+ua3htb15hpoZDsc/EDxqO1WGFxgXWaNOSKQxaBHeDNVQskXJFSUuVy7AArlNFjz2dKj7Nhu7gjQRYHtSs1sZ+QfGMtyw7kF0lY7+uGLnH+YbaB1rzkQA/hjZdYTe5/kiXbqJVnaaRiMxpQKBgQDgamZS6U/UPx6kqSWAbFoGsKgMQhVtewIB1fw0ugjho3fYl5JYuN7ZNVwrjd9gsCi9PhyjEtHGBJE+Z/CylqVK/7QBwIa83f1PHEzUDCrUWs0pVgjCkJztwde86rfH33D+v/HL7A4+Y6pg9szCVvA1UWkfoEBBrfjzNl5h91adrwKBgQDbvyfKrjtEVbtI1EaTp74GNnHp0fARgSWhvWY3RxjIiQIDcFmiZwGXaxntlbv8S6Jav1yMPK/pEU13/aG+a7MZiq5zfvyDrjcRA3yyu+xJACJvhKXaYug2xpE0z5q5zn8xduux3H7ToDeqoX/HlGUXuV13Psxpkqjofw4ZnTdOGwKBgBYAOGHef7YGLiHkd0m81aKcRQ1WmTUvfwXhDaW5q087sG8qhO1vymEvCwc2FHUtMAFFipcuLCSmo/qjRASuIixVHzegwVTYypGr65hKTRSehkiMJ7Wzab8hZt4dgMD2leRTuwfL76WMLdLtvys6TLhdb9nq4wHNZX+qj9w43GP/AoGAE6YQBMt3eTDBQk3Y0bMaBqwvm1yuPqJxnvi0fxTYXnYBvBT7rs3PEp78/oV4/aI1ri+WMuPqRsjJSIVhRQmURiBkYOdl5NBbFCZfrAupoQ1mBtqxicl2Qg+XREWb7ClOrjmX8Ztpq7qTv6oZJttZ/rkQZm0zEe2PNNrHg/rOyykCgYBNorYPmuKmoiNv9sl9zyM5QBNJ1ciPId/btrclyNeFj+lTRMkp5evb3F59AYzLER6T1RwzXsgOkNrSMNB5/eZEEJij5xy9N5wNp4cCvuNQYcDh0Y7amFcv17Sl2R5EyCnpJrkfW1xJpWeBIP1bAujqos6ys/pEKoPmmPsivW5WHQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArHiLd8ccPntLgOIVpU2P5eiTlH51al\r\n" + 
    		"\r\n" + 
    		"+vMoUa5UH/xGKy8MxJFgF1Q/EGnnOkoj8erB0yr10ARzDiyQb1SW34I9epruyYEgtVoxefHbIo0C0krOCQ1EHrHhHqC\r\n" + 
    		"\r\n" + 
    		"dXjLSFrHMcprjSr5d4Z8gG/kzjpVpbBXhTo6tYiFsStVBC9XidxBCxn6C8d0TQBz92ezYdDdq01aoJlGEpfEjbfHmxc\r\n" + 
    		"\r\n" + 
    		"njjiWiuMWRn1Ld1SEPhhjzQm74Zs9xe34OVAJi7Fr/uAz9dQREwWZJLd2VtmRekvjtS3w10bFPCWbpnqQ7fr8hMOyUf\r\n" + 
    		"\r\n" + 
    		"fnINQW1d2btbx28HopjRepFQNeegJyJd/2PJBFQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/bookstore01/client/cart/paysuccess.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

