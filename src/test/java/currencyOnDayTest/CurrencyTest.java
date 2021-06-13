package currencyOnDayTest;

import currency.Currency;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyTest {

    @DataProvider(name = "dataprovider")
    public Object[][] dP() {
        return new Object[][]{
                {12, "BEF"},
                {1, "ALL"}
                , {2, "DZD"}};
    }

    @Test(dataProvider = "dataprovider")
    public void currencyById(int cur_ID, String expectedAbriviatore) {
        //константа
        RestAssured.baseURI = "https://www.nbrb.by/api/exrates/currencies/" + cur_ID;
        RequestSpecification httpReguest = RestAssured.given();
        Response response = httpReguest.request(Method.GET);
        Currency currensy = response.getBody().as(Currency.class);
        String actualResult = currensy.cur_Abbreviation;
        Assert.assertEquals(actualResult, expectedAbriviatore, "The exchange rate does not match the date");
    }

    @DataProvider(name = "currencyDataByIdDate")
    public Object[][] ByIdDate() {
        return new Object[][]{
                {298,"2017-7-5",3.2812}
                , {145,"2018-7-5",1.9946}
                , {292, "2017-7-5",2.2071}
                , {145, "2019-7-5",2.0488}
                , {298, "2020-7-5",3.4359}};
    }

    @Test(dataProvider = "currencyDataByIdDate")
    public void currencyValueByIdDateTest(int cur_ID, String date,double actual) {
        RestAssured.baseURI = "https://www.nbrb.by/api/exrates/rates/" + cur_ID;
        RequestSpecification httpReguest = RestAssured.given().queryParam("ondate",date);
        Response response = httpReguest.request(Method.GET);
        Currency Currensy = response.getBody().as(Currency.class);
        double actualResult=Currensy.cur_OfficialRate;
        Assert.assertEquals(actualResult,actual,"The exchange rate on the given date is incorrect");
    }
}
