package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class TextBoxBase extends ControlBase implements TextBox {


    public TextBoxBase(WebElement element) {
        super(element);
    }

    @Override
    public void EnterText(String text) {
        getWrappedElement().clear();
        getWrappedElement().sendKeys(text);
    }

    @Override
    public String GetTextValue() {
        return getWrappedElement().getAttribute("value");
    }

    @Override
    public void PerformClick() {
        getWrappedElement().click();
    }

    @Override
    public void CleanTextBox() {
        getWrappedElement().clear();
    }
}
