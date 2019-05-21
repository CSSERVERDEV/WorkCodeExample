package data.platform.message;

//import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import org.springframework.kafka.annotation.KafkaListener;

/**
 * 消费类
 */
@Component
public class KafkaConsumer {

    public static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


//    @KafkaListener(topics = {"jktopic"})
//    public void jktopic(ConsumerRecord consumerRecord) throws InterruptedException {
//        logger.info(String.valueOf(consumerRecord.offset()));
//        logger.info(consumerRecord.value().toString());
//        Thread.sleep(3000);
//
//
//    }


}