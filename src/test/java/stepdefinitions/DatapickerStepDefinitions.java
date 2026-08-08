package stepdefinitions;

import co.sqasa.task.CheckOpenCalendar;
import co.sqasa.task.OpenUrl;
import co.sqasa.task.SelectDatapicker;
import co.sqasa.task.SelectMonthYearCalendar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;


public class DatapickerStepDefinitions {
    @Given("{actor} opens the jqueryUI page")
    public void clickDatepicker(Actor actor) {
        actor.attemptsTo(
                OpenUrl.datepickerPage()
        );
    }

    @When("{actor} clicks on the datepicker")
    public void clickOnDatepicker(Actor actor) {
        actor.attemptsTo(
                new SelectMonthYearCalendar(),
                new SelectDatapicker()
        );
    }

    @Then("{actor} sees the datepicker displayed and enabled")
    public void seesDatepickerDisplayed(Actor actor) {
        actor.attemptsTo(
                new CheckOpenCalendar()
        );
    }
}
