package main.com.domain;

public class NameEditor {
	private boolean isValidate(String name){
		if(name.length() > 5){
			return false;
		}
		return true;
	}

	private String shorten(String name){
		return name.substring(0, 5);
	}

	private String extend(String name){
		String frontBlank = " ".repeat((5-name.length()) / 2);
		String endBlank = " ".repeat(5 - name.length() - frontBlank.length());

		return frontBlank + name + endBlank;
	}

	private String edit(String name){
		if(isValidate(name)){
			return extend(name);
		}
		return shorten(name);
	}

	public String[] makeList(String[] names){
		String[] nameList = new String[names.length];
		for(int idx = 0; idx < nameList.length; idx++){
			nameList[idx] = edit(names[idx]);
		}

		return nameList;
	}
}
