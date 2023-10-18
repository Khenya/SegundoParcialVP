package webUI.pages.todoly;

import org.openqa.selenium.By;
import webUI.controls.Button;
import webUI.controls.Control;
import webUI.controls.TextBox;

import javax.swing.*;

public class SignUpSection {
    public TextBox fullName = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox email = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox password = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Control checkBoxs = new Control(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signup = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));

}
