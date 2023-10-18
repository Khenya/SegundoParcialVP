package webUI.pages.todoist;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.Control;

public class Configuraciones {
    public Control imagen = new Control(By.xpath("//div[@class='_2a3b75a1 _509a57b4 e5a9206f _3692f9c2 _50ba6b6b _985b733f']//img[@src='https://d1nbslm0j6pual.cloudfront.net?text=B&size=50']"));
    public Button logout = new Button(By.xpath("//*[contains(@class, 'user_menu_label') and contains(text(), 'Cerrar sesión')]"));}
