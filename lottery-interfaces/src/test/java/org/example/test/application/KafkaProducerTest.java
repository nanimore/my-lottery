package org.example.test.application;


import org.example.application.mq.demo.KafkaProducerDemo;
import org.example.application.mq.producer.KafkaProducer;
import org.example.common.Constants;
import org.example.domain.activity.model.vo.InvoiceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description: Kafka 消息测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerTest.class);

    @Resource
    private KafkaProducer kafkaProducer;

    @Resource
    private KafkaProducerDemo kafkaProducerDemo;

    @Test
    public void test_send() throws InterruptedException {
        // 循环发送消息
        while (true) {
            kafkaProducerDemo.send("你好，我是Lottery 001");
            Thread.sleep(3500);
        }
    }

    @Test
    public void test_send2() throws InterruptedException {

        InvoiceVO invoice = new InvoiceVO();
        invoice.setuId("fustack");
        invoice.setOrderId(1444540456057864192L);
        invoice.setAwardId("3");
        invoice.setAwardType(Constants.AwardType.DESC.getCode());
        invoice.setAwardName("Code");
        invoice.setAwardContent("苹果电脑");
        invoice.setShippingAddress(null);
        invoice.setExtInfo(null);

        kafkaProducer.sendLotteryInvoice(invoice);

        while (true){
            Thread.sleep(10000);
        }
    }
}
