package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
     
    public class HttpMoLiRobotRequest {
        public static String sendMess(String param) {
            String result = "";
            String enParam;
            JSONObject CallBack;
            BufferedReader in = null;
            try {
    			enParam = URLEncoder.encode(param,"UTF-8");
    			//对编码进行URL转码
                //在线获取人机对话内容
                String urlNameString = "http://i.itpk.cn/api.php?question=" + enParam;
                URL realUrl = new URL(urlNameString);
                // 打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                // 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                // 建立实际的连接伪装浏览器发起请求
                connection.connect();
                // 获取所有响应头字段
                Map<String, List<String>> map = connection.getHeaderFields();
                // 遍历所有的响应头字段
                for (String key : map.keySet()) {
                    System.out.println(key + "--->" + map.get(key));
                }
                // 定义 BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),"UTF-8"));
                String tempmess = in.readLine();//服务器返回只有一行无需其他操作
                if(tempmess.startsWith("?{")) {
                CallBack = new JSONObject(in.readLine().substring(1));
                	result = CallBack.getString("content");
                }
                else
                {
                	result = tempmess.substring(1);
                }
                
                //对服务器返回对象进行检测
                //判断是否为JSON
            } catch (Exception e) {
                System.out.println("发送GET请求出现异常！" + e);
                e.printStackTrace();
            }
            // 使用finally块来关闭输入流
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            System.out.println(result);
            return result;
        }
     
        
        public static void main(String[] args) {
            //发送 GET 请求
            String s=HttpMoLiRobotRequest.sendMess("我是你爸爸");
            System.out.println(s);
            
        }
    }