package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.Control;

public class AppPage {
    public Control todayTitle = new Control(By.id("empty-state-holder"));
    public Button flecha = new Button(By.id(":r0:"));
}
