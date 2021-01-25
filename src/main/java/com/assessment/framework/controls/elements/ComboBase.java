package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ComboBase extends ControlBase implements Combo{

    Select select = null;

    public ComboBase(WebElement element) {
        super(element);
        select = new Select(element);
    }


    @Override
    public String GetFirstTextValue() {
        return select.getFirstSelectedOption().getText();
    }

    @Override
    public void GetClickFirstTextValue() {
        PerformClick();
        select.selectByIndex(1); }


    @Override
    public void PerformClick() { getWrappedElement().click(); }


}
