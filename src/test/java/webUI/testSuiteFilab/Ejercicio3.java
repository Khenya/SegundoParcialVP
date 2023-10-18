package webUI.testSuiteFilab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoly.*;
import webUI.session.Session;
public class Ejercicio3 {
    private String projectName;
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    SignUpSection signUpSection = new SignUpSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void signupTesting() {
        this.singUp();
        this.createProject();
    }

    public void createProject() {
        projectName = "Project 11 ";

        menuSection.addNewProjectButton.click();
        menuSection.newProjectInput.setText(projectName);
        menuSection.confirmNewProjectButton.click();

        Assertions.assertTrue(
                menuSection.selectProjectButton(projectName).isControlDisplayed(),
                "Error: El proyecto no se creo correctamente");
    }

    public void singUp(){
        mainPage.signUpFree.click();
        signUpSection.fullName.setText("brenda");
        signUpSection.email.setText("bi1afAAa1@gmail.com");
        signUpSection.password.setText("12345");
        signUpSection.checkBoxs.click();
        signUpSection.signup.click();

        createProject();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me crear una cuenta");
    }
}
