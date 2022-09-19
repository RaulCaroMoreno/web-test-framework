package utils;

import static utils.Constants.SOURCE_TEST_DATA;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class DataExtractor {


    public Map<String,String> getJsonData(String testName) {
        String jsonContent = null;
        HashMap<String,String> data = null;
        try{
            jsonContent = FileUtils.readFileToString(new File(SOURCE_TEST_DATA + testName.replace(" ", "").replace("test","") +".json"));
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(jsonContent,
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch(Exception ioException) {
            throw new IllegalArgumentException("File data not found");
        }
        return data;
    }

}
