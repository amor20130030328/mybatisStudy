package com.gy.constant;

public enum GenderEnum {
	
	MAN("0","男"),
	WEMEN("1","女");
	
	private String key;
	
	private String value;
	
	
	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	private GenderEnum(String key,String value) {
		this.key = key;
		this.value = value;
	}
	
	
	public static String Parse(String key) {
		
		switch (key) {
		case "0":
			
			return GenderEnum.MAN.getValue();
		case "1":
			return GenderEnum.WEMEN.getValue();
		}
		return "";
	}
	

}
