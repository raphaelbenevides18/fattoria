package br.com.rlb.tdd;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class TesteUrl {
	
	 public static void main( String[] args ) throws Exception
	    {
		URI uri = new URI("http://migre.me/api.json?");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri.toURL().toString())
			.queryParam("url", "http://www.ocaminhodoprogramador.com.br");
		String conteudo = target.request().get(String.class);
		System.out.println(conteudo);
			
		Map<String, String> map = new HashMap<>();
	        ObjectMapper mapper = new ObjectMapper();
	        
	        map = mapper.readValue(conteudo, new TypeReference<HashMap<String, String>>() {});
	        System.out.println(map.get("migre"));
	    }

}
