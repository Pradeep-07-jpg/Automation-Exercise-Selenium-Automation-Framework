package automation_excercise_utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonReader {
	
	public static CartData jsonToMap() throws IOException
	{
		
		String filePath = "/src/test/resources/TestData/cart-data.json";
		//Convert json to String
		String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+ filePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		CartData data = mapper.readValue(jsonContent, CartData.class);
		
		return data;
		
	}

}
