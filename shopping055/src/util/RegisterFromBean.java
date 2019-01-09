package util;

import java.util.HashMap;
import java.util.Map;

public class RegisterFromBean {
	private String name;
	private String password;
	private String password2;
	private String number;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate() {
		boolean flag = true;
		if (name == null || name.trim().equals("")) {
			errors.put("name", "ÇëÊäÈëÐÕÃû.");
			flag = false;
		}
		if (password == null || password.trim().equals("")) {
			errors.put("password", "ÇëÊäÈëÃÜÂë.");
			flag = false;

		} else if (password.length() > 12 || password.length() < 6) {
			errors.put("password", "ÇëÊäÈë6~12¸ö×Ö·û.");
			flag = false;
		}
		if (password2 == null || password2.trim().equals("")) {
			errors.put("password2", "ÇëÔÙ´ÎÊäÈëÃÜÂë.");
			flag = false;
		} 
		if (number == null || number.trim().equals("")) {
			errors.put("number", "ÇëÊäÈëµç»°.");
			flag = false;
		}
		return flag;

	}

	public void setErrorMsg(String err, String errMsg) {
		if ((err != null) && (errMsg != null)) {
			errors.put(err, errMsg);
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

}
