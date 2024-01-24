package TestData;

import java.util.ArrayList;
import java.util.List;

import PojoClasses.AddPlaceObject;
import PojoClasses.Location;


public class TestDataBuild {

	

	
	public AddPlaceObject AddPlacePayLoad(String name,String address)
	
	{
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		AddPlaceObject apo = new AddPlaceObject();
		apo.setAccuracy(50);
		apo.setAddress(address);
		apo.setLanguage("French-IN");
		apo.setName(name);
		apo.setPhone_number("(+91) 983 893 3937");
		apo.setTypes(types);
		apo.setLocation(location);
		apo.setWebsite("http://rahulshettyacademy.com");
		return apo;
	}
	
	public String DelPlacePayLoad(String placeId) {
		
		
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}";
	}
}

