package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.api.ImplementedBy;
import com.assessment.framework.controls.internals.Control;


@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void EnterText(String text);

    String GetTextValue();

    void PerformClick();

    void CleanTextBox();

}
