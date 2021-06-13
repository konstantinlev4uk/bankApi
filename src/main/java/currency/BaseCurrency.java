package currency;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BaseCurrency {
    @JsonProperty("Cur_ID")
    public int cur_ID;
    @JsonProperty("Date")
    public Date date;
    @JsonProperty("Cur_Abbreviation")
    public String cur_Abbreviation;
    @JsonProperty("Cur_Scale")
    public int cur_Scale;
    @JsonProperty("Cur_Name")
    public String cur_Name;
    @JsonProperty("Cur_OfficialRate")
    public double cur_OfficialRate;
}
