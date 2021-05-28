package my.example.service;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
/**
 * Created by ti on 2017/12/25.
 */
@Service
@PropertySource(value = {"file:/etc/sdre/sdre.properties"})
public class PushTopicCallbackService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
//    private MessageService messageService;

    //    @JmsListener(destination = "${AWS_SQS_PUSH_TOPIC_CALLBACK_QUEUE_NAME}")
    public void pushCallback(String requestJSON){
        try {
            logger.info("Push topic callback message:" + requestJSON);
            JSONObject jo = JSONObject.fromObject(requestJSON);
            String messageCode = jo.getString("messageCode");
            String callbackKey = jo.getString("callbackKey");
            if ("200".equals(messageCode)) {
//                messageService.updateSendStatus(Long.parseLong(callbackKey));
            } else {
                logger.error("pushCallback push message " + callbackKey + " fail, info : " + jo.getString("info") + ", description : " + jo.getString("description"));
            }
        }catch (Exception e){
            logger.error("Push topic callback message:" + requestJSON + ", error:",e);
        }
    }
}
