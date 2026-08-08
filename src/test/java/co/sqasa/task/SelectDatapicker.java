package co.sqasa.task;

import co.sqasa.ui.homepage.HomepageForm;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class SelectDatapicker implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver()
                .switchTo()
                .frame(BrowseTheWeb.as(actor).getDriver().findElement(By.className("demo-frame")));

        actor.attemptsTo(
                Click.on(HomepageForm.DATAPICKER)
        );
    }
}
