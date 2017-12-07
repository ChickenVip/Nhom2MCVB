package jwd.models;

public class GetInfo {

	String perid,name,phone, idcard, address, avartar;
	int age;
	
	public GetInfo(String perid,String name,int age,String phone,
			String idcard,String address,String avartar)
	{
		this.perid = perid;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.idcard = idcard;
		this.address = address;
		this.avartar = avartar;
	}
	
	public String getPerid() {
		return perid;
	}


	public void setPerid(String perid) {
		this.perid = perid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIdcard() {
		return idcard;
	}
	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAvartar() {
		return avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
