package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@delPlace")
	public void delPlaceBefore() throws IOException {
		
		StepDefination sd = new StepDefination();
		if (StepDefination.place_id==null) {
			
			sd.add_place_payload_with("hassan house", "world cross center");
			sd.user_calls_with_http_request("addPlaceApi", "post");
			sd.verify_that_place_has_been_created_by("hassan house", "getPlaceApi");
		}
		
	}

}
