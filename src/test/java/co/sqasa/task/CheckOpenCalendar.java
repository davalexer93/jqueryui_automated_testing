package co.sqasa.task;

import co.sqasa.ui.homepage.HomepageForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

public class CheckOpenCalendar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(Target.the("Calendar Element")
                                .locatedBy(HomepageForm.CALENDAR.getCssOrXPathSelector()))
                        .isDisplayed(),
                Ensure.that(Target.the("Calendar Element")
                                .locatedBy(HomepageForm.CALENDAR.getCssOrXPathSelector()))
                        .isEnabled(),
                Click.on(HomepageForm.MONTH_SELECTOR),
                Click.on(HomepageForm.YEAR_SELECTOR)
        );
    }
}
