import java.util.ArrayList;
import java.util.List;

class NameEditor {
	private boolean isValidate(String name){
		if(name.length() > 5){
			return false;
		}
		return true;
	}

	private String shorten(String name){
		String shortName = name.substring(0, 5);
		return shortName;
	}

	private String extend(String name){
		String frontBlank = " ".repeat((5-name.length()) / 2);
		String endBlank = " ".repeat(5 - name.length() - frontBlank.length());
		String extendedName = frontBlank + name + endBlank;

		return extendedName;
	}

	private String edit(String name){
		String newName;
		if(isValidate(name)){
			newName = extend(name);
			return newName;
		}
		newName = shorten(name);
		return newName;
	}

	protected List<String> makeList(String[] names){

		List<String> nameList = new ArrayList<>();
		for(String name : names){
			String editedName = edit(name);
			nameList.add(editedName);
		}

		return nameList;
	}
}
