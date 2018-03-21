package checkcode;

import java.util.Date;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class AliSms {
	private static final String URL="http://gw.api.taobao.com/router/rest";  
	//成为开发者，创建应用后系统自动生成  
	private static final String APP_KEY="23699904";  
	private static final String SECRET="04ddbefb7cc23405a73d67895a188397";  
	//短信模板的内容  
	public String getCheckcode(String phone){
		String code = "";
		//初始化验证码
		Random r = new Random(new Date().getTime());
		for(int i=0;i<4;i++){
			code += r.nextInt(10);
		}
		String json="{\"code\":\""+code+"\"}";  
		TaobaoClient client = new DefaultTaobaoClient(URL, APP_KEY, SECRET);  
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();  
		req.setExtend("123456");  
		req.setSmsType("normal");
		req.setSmsFreeSignName("尤克小应用");//签名  
		req.setSmsParamString(json);  
		req.setRecNum(phone);  //手机号码
		req.setSmsTemplateCode("SMS_60035219"); //模板ID
		String msg = "error";
		try {  
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);  
//			System.out.println(rsp.getResult().getErrCode());  
			msg = code;
		} catch (Exception e) {  
			// TODO: handle exception  
			msg = "error";  
		}  
		return msg;
	}
}