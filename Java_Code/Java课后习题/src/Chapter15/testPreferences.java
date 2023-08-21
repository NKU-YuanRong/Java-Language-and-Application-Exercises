package Chapter15;

import java.util.prefs.Preferences;

import Free_Test.Demo;

public class testPreferences {
	public static void main(String[] args) {
		Preferences prefs = Preferences.userNodeForPackage(Demo.class);
		prefs.put("name", "LiuYanchen");
		prefs.putInt("age", 30);
		String s = prefs.get("name", null);
		System.out.println(s);
		System.out.println(prefs.getInt("age", -1));
		System.out.println(prefs.getInt("height", -1));
	}
}
