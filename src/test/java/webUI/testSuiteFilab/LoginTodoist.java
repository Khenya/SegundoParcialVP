package webUI.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoist.*;
import webUI.session.Session;

public class LoginTodoist {
    LoginPage loginPage = new LoginPage();
    AppPage appPage = new AppPage();
    Configuraciones configuraciones = new Configuraciones();
    Configuraciones2 configuraciones2 = new Configuraciones2();
    CambiarContrasena contrasena = new CambiarContrasena();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }
    @Test
    public void login(){
        loginPage.emailInput.setText("brendaaa@gmail.com");
        loginPage.passwordInput.setText("szdrwgwsrdfgvws");

        loginPage.logInButton.click();

        appPage.flecha.click();
        configuraciones.imagen.click();
        configuraciones2.cambiarContrasena.click();

        contrasena.contraantigua.click();
        contrasena.contraantigua.setText("szdrwgwsrdfgvws");
        contrasena.contrasenaNueva.click();
        contrasena.contrasenaNueva.setText("hvbkevwfiyhv");
        contrasena.contrasenaNueva2.click();
        contrasena.contrasenaNueva2.setText("hvbkevwfiyhv");


        Assertions.assertTrue(appPage.todayTitle.isControlDisplayed(),
                "ERROR no se pudo iniciar sesion");


    }

}
