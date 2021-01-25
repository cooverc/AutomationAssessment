package com.assessment.framework.controls.elements;


import com.assessment.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;


public class LabelBase extends ControlBase implements Label {


    public LabelBase(WebElement element) {
        super(element);
    }

    @Override
    public void PerformClick() {
        getWrappedElement().click();
    }

    @Override
    public String GetTextValue() {
        return getWrappedElement().getText();
    }

}
