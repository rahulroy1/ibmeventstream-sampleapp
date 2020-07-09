package com.travelcrushers.flighteventcpature;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventStreamsController {
    private KafkaTemplate<String, String> template;
    private List<String> messages = new CopyOnWriteArrayList<>();

    public EventStreamsController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Autowired
	private KafkaTemplate<String, String> kafkaTempletae;
	private static final String TOPIC="dynamicflightevents";

    @KafkaListener(topics = "${listener.topic}")
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
        messages.add(cr.value());
    }

    @PostMapping(value = "send/{msg}")
    public void send(@PathVariable String msg) throws Exception {
        template.sendDefault(msg);
    }

    @PostMapping(value = "sendpost")
    public void sendPost(@RequestBody String msg) throws Exception {
        kafkaTempletae.send(TOPIC,msg);
    }

    @GetMapping("received")
    public String recv() throws Exception {
        String result = messages.toString();
        messages.clear();
        return result;
    }
}