package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!"HARVEST".equals(line = bufferedReader.readLine())){
			Field[] allFields = RichSoilLand.class.getDeclaredFields();
			switch (line){
				case "private":
					print(line, allFields, Modifier.PRIVATE);
					break;
				case "protected":
					print(line, allFields, Modifier.PROTECTED);
					break;
				case "public":
					print(line, allFields, Modifier.PUBLIC);
					break;
				case "all":
					for (Field field : allFields) {
						System.out.println(field);
					}
					break;
			}
		}
	}

	private static void print(String line, Field[] allFields, int modifier) {
		for (Field field : allFields) {
			if(modifier == field.getModifiers()){
				System.out.println(String.format("%s %s %s",Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(),
						field.getName()));
			}
		}
	}
}
