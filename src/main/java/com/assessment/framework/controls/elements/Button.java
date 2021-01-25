package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.api.ImplementedBy;
import com.assessment.framework.controls.internals.Control;


@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void PerformClick();

    String GetButtonText();

    void PerformSubmit();
}
