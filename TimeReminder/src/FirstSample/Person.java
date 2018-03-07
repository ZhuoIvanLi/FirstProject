package FirstSample;

public class Person {

	private Name name;
	private Address address;

	public Person() {
		this(new Name("Jill", 'S', "Barr"), new Address("100 main", "some add", "AB", "5t8i9f"));
	}

	public Person(Name name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return '\n' + name.getFirstName() + '\n' + address.getFullAddress() + '\n';
	}

	public int comareTo(Object o) {
		return name.compareTo(((Person) o).name);
	}

}
