package stepdefinitions;

import co.sqasa.task.SelectDates;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SelectDatesStepDefinitions {

    @Then("{actor} selects the date {string}, {string}, {string}")
    public void selectsDate(Actor actor, String year, String month, String day) {
        actor.attemptsTo(
                new SelectDates(year, month, day)
        );
    }
}