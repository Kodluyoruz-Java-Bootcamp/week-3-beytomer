package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Realty;
import emlakcepte.service.RealtyService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

	@Autowired
	private RealtyService realtyService;

	@Autowired
	private RestTemplate restTemplate;

	private static final String webUrl="http:/localhost:8081/banners";

	// GET /realtyes
	@GetMapping
	public ResponseEntity<List<Realty>> getAll() {
		ResponseEntity<List>result =restTemplate.getForEntity(webUrl,List.class);
		List<Realty> responseBody=result.getBody();
		return ResponseEntity.ok(responseBody);
	}

	// POST /realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty) {
		realtyService.create(realty);
		ResponseEntity<Realty> result= restTemplate.postForEntity(webUrl,realty,Realty.class);
		Realty responseBody = result.getBody();
		System.out.println("realty" + realty);

		return  ResponseEntity.ok(responseBody);
	}

}
