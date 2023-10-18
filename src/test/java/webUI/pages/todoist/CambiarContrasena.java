package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.TextBox;
public class CambiarContrasena {
    public TextBox contraantigua = new TextBox(By.xpath("//span[text()='Current password']/../../..//input"));
    public TextBox contrasenaNueva = new TextBox(By.xpath("//span[text()='New password']/../../..//input"));
    public TextBox contrasenaNueva2 = new TextBox(By.xpath("//span[text()='Confirm new password']/../../..//input"));
    public Button continuar = new Button(By.xpath("//*[@class='_8313bd46 _7a4dbd5f _5e45d59f _43792df1 _2a3b75a1 _56a651f6']//*[text()='Change password']"));


}

