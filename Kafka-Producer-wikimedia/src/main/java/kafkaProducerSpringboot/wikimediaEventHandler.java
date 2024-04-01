package kafkaProducerSpringboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;

public class wikimediaEventHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(wikimediaEventHandler.class);

	private KafkaTemplate<String, String> KafkaTemplate;

	private String topic;

	public wikimediaEventHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {

		this.KafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		
		LOGGER.info(String.format("Stream Event Info -> %s", messageEvent.getData()));
		//System.out.print("data"+messageEvent.getData());	
		KafkaTemplate.send(topic,messageEvent.getData());

	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
