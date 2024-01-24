package TestData;

public enum apiResources {

	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("maps/api/place/get/json"),
	delPlaceApi("/maps/api/place/delete/json");
	private String resourse;
	apiResources( String resourse) {
		// TODO Auto-generated constructor stub
		this.resourse = resourse;
	}
	
	public String getResource() {
		
		return resourse;
	}
}
