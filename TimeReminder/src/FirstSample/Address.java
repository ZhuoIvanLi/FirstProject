package FirstSample;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;

	// create and address with elements
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getFullAddress() {
		return street + '\n' + city + "," + state + ' ' + zip + '\n';
	}
}
