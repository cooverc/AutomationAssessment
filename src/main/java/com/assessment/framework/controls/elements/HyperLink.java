package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.api.ImplementedBy;
import com.assessment.framework.controls.internals.Control;


@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {


    void ClickLink();

    String GetUrlText();

    boolean CheckUrlTextContains(String containsText);

    String GetTextValue();
}

