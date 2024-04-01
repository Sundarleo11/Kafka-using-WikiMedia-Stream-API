package kafkaProducerSpringboot;

import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class WikiMediaChnagesProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChnagesProducer.class);

	private KafkaTemplate<String, String> KafkaTemplate;

	public WikiMediaChnagesProducer(KafkaTemplate<String, String> KafkaTemplate) {

		this.KafkaTemplate = KafkaTemplate;
	}

	public void sendMessage() throws InterruptedException {

		String topic = "wikimedia-recentchange";
		// To Read the RealTime Stream Data from wikimedia, we can use event
		
		//https://stream.wikimedia.org/v2/stream/recentchange
		
		EventHandler eventHandler=new wikimediaEventHandler(KafkaTemplate,topic);
		
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		
		EventSource.Builder builder=new EventSource.Builder(eventHandler,URI.create(url));
		EventSource run=builder.build();
		run.start();
		
		TimeUnit.MINUTES.sleep(10);

	}
}
