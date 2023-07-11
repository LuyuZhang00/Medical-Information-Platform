package com.barry.msm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.barry.msm.service.MsmService;
import com.barry.msm.utils.ConstantPropertiesUtils;
import com.barry.vo.msm.MsmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 15:11
 */
@Service
public class MsmServiceImpl implements MsmService {

    @Override
    public boolean send(String phone, String code) {
        //判断手机号是否为空
        if(StringUtils.isEmpty(phone)) {
            return false;
        }
        //整合阿里云短信服务
        //设置相关参数
        DefaultProfile profile = DefaultProfile.getProfile(ConstantPropertiesUtils.REGION_Id,
                        ConstantPropertiesUtils.ACCESS_KEY_ID,
                        ConstantPropertiesUtils.SECRECT);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //手机号
        request.putQueryParameter("PhoneNumbers", phone);
//        //签名名称
//        request.putQueryParameter("SignName", "医疗信息平台");
//        //模板 code
//        request.putQueryParameter("TemplateCode", "SMS_282090151");
        //签名名称
        request.putQueryParameter("SignName", "医疗信息平台");
        //模板 code
        request.putQueryParameter("TemplateCode", "SMS_461810929");
        //验证码 使用 json 格式 {"code":"123456"}
        Map<String,Object> param = new HashMap();
        param.put("code",code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        //调用方法进行短信发送
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean send(MsmVo msmVo) {
        if(!StringUtils.isEmpty(msmVo.getPhone())) {
            String code = (String)msmVo.getParam().get("code");
            return this.send(msmVo.getPhone(),code);
        }
        return false;
    }

}
