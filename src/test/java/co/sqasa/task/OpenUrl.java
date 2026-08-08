package co.sqasa.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUrl implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://jqueryui.com/datepicker/")
        );
    }

    public static OpenUrl datepickerPage() {
        return new OpenUrl();
    }
}
