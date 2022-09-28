package commonutils.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateRequest;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateResponse;
import com.aliyuncs.profile.DefaultProfile;
import commonutils.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecognizeLicensePlateUtil {
    static IAcsClient client = null;
    private static void CreateClient(){
        DefaultProfile profile = DefaultProfile.getProfile("-",
                "", "");
        client = new DefaultAcsClient(profile);
    }
    private static <R extends RpcAcsRequest<T>, T extends AcsResponse> T getAcsResponse(R req) throws Exception {
        try {
            return client.getAcsResponse(req);
        } catch (ServerException e) {
            // 服务端异常
            System.out.println(String.format("ServerException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
            throw e;
        } catch (ClientException e) {
            // 客户端错误
            System.out.println(String.format("ClientException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
            throw e;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            throw e;
        }
    }
    public static List getRecognizeLicensePlate(String ImageURL) throws Exception {
        System.out.println("--------  车牌识别 --------------");

        RecognizeLicensePlateRequest req = new RecognizeLicensePlateRequest();
        req.setImageURL(ImageURL);
        RecognizeLicensePlateResponse resp = getAcsResponse(req);
//        printResponse(req.getSysActionName(), resp.getRequestId(), resp);
//        Map<String,String> map=new HashMap<>();
        RecognizeLicensePlateResponse.Data data = resp.getData();
        List<RecognizeLicensePlateResponse.Data.Plate> plates = data.getPlates();
        List<String> plateNumber=new ArrayList<>();
        for (RecognizeLicensePlateResponse.Data.Plate plate:
             plates) {
            plateNumber.add(plate.getPlateNumber());
        }
        return plateNumber;
    }
//
//    public static void printResponse(String actionName, String requestId, AcsResponse data) {
//        System.out.println(String.format("actionName=%s, requestId=%s, data=%s", actionName, requestId, JSON.toJSONString(data)));
//    }

}
