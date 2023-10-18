package webUI.testSuiteFilab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoly.*;
import webUI.session.Session;

public class Ejercicio4 {

    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    Sttings sttings = new Sttings();
    Token token = new Token();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void loginTesting(){
        String oldPassword = "12345";
        String newPassword="54321";

        mainPage.loginButton.click();
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("selenium@seleniumupb.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();

        menuSection.settingsButton.click();
        sttings.oldPassword.setText(oldPassword);
        sttings.newPassword.setText(newPassword);
        sttings.okButton.click();

        menuSection.logoutButton.click();
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(token.user);
        loginSection.pwdTextBox.setText(newPassword);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR no se pudo iniciar sesion");
    }
}
