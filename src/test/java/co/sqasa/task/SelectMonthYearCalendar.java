package co.sqasa.task;

import co.sqasa.ui.homepage.HomepageForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectMonthYearCalendar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomepageForm.MONTH_YEAR_CALENDAR)
        );
    }
}
