package bean;

import java.util.ArrayList;

public class Syohin {

	private String s_id;
	private String s_name;
	private String tanka;
	private String[] s_arr;
	private ArrayList<String[]> s_list;

	public ArrayList<String[]> getS_list() {
		return s_list;
	}

	public void setS_list(ArrayList<String[]> s_list) {
		this.s_list = s_list;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getTanka() {
		return tanka;
	}

	public void setTanka(String tanka) {
		this.tanka = tanka;
	}

}
