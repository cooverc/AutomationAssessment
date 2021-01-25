package com.assessment.framework.controls.elements;

import com.assessment.framework.controls.api.ImplementedBy;
import com.assessment.framework.controls.internals.Control;


@ImplementedBy(LabelBase.class)
public interface Label extends Control {


    void PerformClick();

    String GetTextValue();

}
