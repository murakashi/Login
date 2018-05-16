package bean;

public class User {

	private String id;
	private String pass;
	private String name;
	private String adress;
	private String kengen;


	public String getKengen() {
		return kengen;
	}
	public void setKengen(String kengen) {
		this.kengen = kengen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

}
