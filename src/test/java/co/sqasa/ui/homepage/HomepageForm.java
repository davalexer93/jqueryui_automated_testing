package co.sqasa.ui.homepage;

import net.serenitybdd.screenplay.targets.Target;

public class HomepageForm {

    public static Target MONTH_YEAR_CALENDAR = Target.the("Month and Year Calendar").locatedBy("//a[@href='/resources/demos/datepicker/dropdown-month-year.html']");
    public static Target DATAPICKER = Target.the("Datapicker").locatedBy("#datepicker");
    public static Target CALENDAR = Target.the("Calendar").locatedBy("//div[@id='ui-datepicker-div']");
    public static Target MONTH_SELECTOR = Target.the("Month").locatedBy(".ui-datepicker-month");
    public static Target YEAR_SELECTOR = Target.the("Year").locatedBy(".ui-datepicker-year");

}
