package co.sqasa.task;

import co.sqasa.ui.homepage.HomepageForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;


public class SelectDates implements Task {

    private final String year;
    private final String month;
    private final String day;

    public SelectDates(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(month).from(HomepageForm.MONTH_SELECTOR),
                SelectFromOptions.byVisibleText(year).from(HomepageForm.YEAR_SELECTOR),
                Click.on("//a[@class='ui-state-default' and text()='" + day + "']")
        );
    }
}