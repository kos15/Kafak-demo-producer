package com.kafkademo.Kafa.demo.service;

import com.kafkademo.Kafa.demo.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLlocation(String Location){
        this.kafaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, Location);
        this.logger.info("Message produced");
        return false;
    }
}
