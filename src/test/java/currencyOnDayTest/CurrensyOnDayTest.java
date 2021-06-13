package currencyOnDayTest;

import currency.BaseCurrency;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class CurrensyOnDayTest {
    @Test
    public void currencyOnDayTest() throws IOException {

        InputStream inputStream = new FileInputStream("D:\\bankApi\\src\\main\\resources\\uri.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url=properties.getProperty("base.uri");
        RestAssured.baseURI = url;

        RequestSpecification httpReguest = RestAssured.given().queryParam("ondate", "2016-7-5");
        Response response = httpReguest.request(Method.GET);
        BaseCurrency baseCurrensy = response.getBody().as(BaseCurrency.class);
        System.out.println(response.getBody().asString());
        double actualResult = baseCurrensy.cur_OfficialRate;
        Assert.assertEquals(actualResult, 3.1318, "The exchange rate does not match the date");
    }
}

