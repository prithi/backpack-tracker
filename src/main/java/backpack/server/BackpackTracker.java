package backpack.server;

//* * * * * * java -jar /home/prithi/backpack.jar -cronjob every 1 min
import java.net.URL;

import org.apache.commons.mail.EmailException;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import backpack.server.Structure;

public class BackpackTracker {

	public static void CartOpen() throws EmailException, JsonParseException, JsonMappingException, IOException {
		URL jsonUrl = new URL("https://api.backpackbang.com/api/v1/throttle/allow-checkout");
		ObjectMapper objectMapper = new ObjectMapper();

		Structure backpack = objectMapper.readValue(jsonUrl, Structure.class);

		if (backpack.allow.equals("true")) {

			String[] address = { "toqitahmid@gmail.com", "niloykhann@gmail.com", "bahmed@teamamericany.com",
					"uttam.2787@gmail.com", "shibly.seu@gmail.com", "ekramulhq26@gmail.com", "akramul@gmail.com", "amitiqbal20@gmail.com" };

			for (int i = 0; i < address.length; i++) {
				Notify notify = new Notify(address[i]);
				notify.email();
			}

		} else if (backpack.allow.equals("false")) {
			System.out.println(backpack);
		}

	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, EmailException {

		for (int i = 0; i < 120; i++) {
			CartOpen();
		}

		// System.out.println(backpack);
	}
}
