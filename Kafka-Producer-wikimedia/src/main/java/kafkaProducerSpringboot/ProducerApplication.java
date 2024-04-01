package kafkaProducerSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(ProducerApplication.class);

	}

	@Autowired
	private WikiMediaChnagesProducer wikiMediaChnagesProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		wikiMediaChnagesProducer.sendMessage();

	}

}
