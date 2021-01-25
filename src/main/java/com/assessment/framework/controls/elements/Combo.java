package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.api.ImplementedBy;
import com.assessment.framework.controls.internals.Control;



@ImplementedBy(Combo.class)
public interface Combo extends Control {

    String GetFirstTextValue();

    void PerformClick();

    void GetClickFirstTextValue();

}
