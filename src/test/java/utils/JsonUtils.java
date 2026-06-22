package utils;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.payloads.LoginData;
public class JsonUtils {

    public static List<LoginData> getLoginData() {

        try {

            ObjectMapper mapper =
                    new ObjectMapper();

            return mapper.readValue(
                    new File(
                        "src/test/resources/testdata/loginData.json"),
                    new TypeReference<List<LoginData>>() {});

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to read JSON file", e);
        }
    }
    
}
