package currency;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Currency extends BaseCurrency {

    @JsonProperty("Cur_ParentID")
    public int cur_ParentID;
    @JsonProperty("Cur_Code")
    public String cur_Code;
    @JsonProperty("Cur_Name_Bel")
    public String cur_Name_Bel;
    @JsonProperty("Cur_Name_Eng")
    public String cur_Name_Eng;
    @JsonProperty("Cur_QuotName")
    public String cur_QuotName;
    @JsonProperty("Cur_QuotName_Bel")
    public String cur_QuotName_Bel;
    @JsonProperty("Cur_QuotName_Eng")
    public String cur_QuotName_Eng;
    @JsonProperty("Cur_NameMulti")
    public String cur_NameMulti;
    @JsonProperty("Cur_Name_BelMulti")
    public String cur_Name_BelMulti;
    @JsonProperty("Cur_Name_EngMulti")
    public String cur_Name_EngMulti;
    @JsonProperty("Cur_Periodicity")
    public int cur_Periodicity;
    @JsonProperty("Cur_DateStart")
    public Date cur_DateStart;
    @JsonProperty("Cur_DateEnd")
    public Date cur_DateEnd;
    @JsonProperty("Cur_Abbreviation")
    public String cur_Abbreviation;
}
