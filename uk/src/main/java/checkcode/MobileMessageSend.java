package checkcode;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 */
public class MobileMessageSend {
	private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";
	private static final String APP_KEY = "6a950b66a234c44a996155bbcc2acc89";
	private static final String APP_SECRET = "74bdb791f5aa";
	private static final String NONCE = "316258487";

	public static String sendMsg(String phone) throws IOException {
		
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);

        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("templateid","3049280"));
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
        

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

        String code= JSON.parseObject(responseEntity).getString("code");
        System.out.println("responseEntity..."+responseEntity.toString());
        if (code.equals("200")){
            return "success";
        }
        return "error";
    }
}
