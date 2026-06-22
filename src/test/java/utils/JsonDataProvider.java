package utils;

import java.util.List;

import org.testng.annotations.DataProvider;

import api.payloads.LoginData;


public class JsonDataProvider {

    @DataProvider(name = "loginJsonData")
    public static Object[][] loginJsonData() {

        List<LoginData> data =
                JsonUtils.getLoginData();

        Object[][] obj =
                new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {

            obj[i][0] = data.get(i);
        }

        return obj;
    }
    
}
