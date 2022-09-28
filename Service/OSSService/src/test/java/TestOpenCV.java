import com.alibaba.fastjson.JSON;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.RpcAcsRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateRequest;
import com.aliyuncs.ocr.model.v20191230.RecognizeLicensePlateResponse;
import com.aliyuncs.profile.DefaultProfile;

import java.util.ArrayList;
import java.util.List;

public class TestOpenCV {
    static IAcsClient client = null;

    public static void main(String[] args) throws Exception {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "你的AccessKeyID", "你的AccessKeySecret");
        DefaultProfile profile = DefaultProfile.getProfile("-",
                "", "");
        client = new DefaultAcsClient(profile);
        testRecognizeLicensePlate(); // 车牌识别
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

    public static void testRecognizeLicensePlate() throws Exception {
        System.out.println("--------  车牌识别 --------------");

        RecognizeLicensePlateRequest req = new RecognizeLicensePlateRequest();
//        req.setImageURL("https://car-1010.oss-cn-hangzhou.aliyuncs.com/F(%7B4%40MOS8_5N.png?versionId=");
        req.setImageURL("https://-.com/F%28%%40MOS8_5N.png");
//        req.setImageURL("F({4[]DYLDL51K2@MOS8_5N.png");
        RecognizeLicensePlateResponse resp = getAcsResponse(req);
        RecognizeLicensePlateResponse.Data data = resp.getData();
        List<RecognizeLicensePlateResponse.Data.Plate> plates = data.getPlates();
        List<String> plateNumber=new ArrayList<>();
        for (RecognizeLicensePlateResponse.Data.Plate plate:
                plates) {
            plateNumber.add(plate.getPlateNumber());
        }
        System.out.println(plates.get(0));
        printResponse(req.getSysActionName(), resp.getRequestId(), resp);
    }

    public static void printResponse(String actionName, String requestId, AcsResponse data) {
        System.out.println(String.format("actionName=%s, requestId=%s, data=%s", actionName, requestId, JSON.toJSONString(data)));
    }

}
