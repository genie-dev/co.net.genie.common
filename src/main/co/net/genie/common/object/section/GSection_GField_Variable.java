package co.net.genie.common.object.section;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField_Variable;
import co.net.genie.common.translator.GCode;

public class GSection_GField_Variable
        <
                INTERFACE_OBJECT extends GObject_Interface,
                INTERFACE_FIELD extends GObject_GField_Variable<INTERFACE_OBJECT, ?>
        >
extends GObject_GSection
        <
                INTERFACE_OBJECT,
                INTERFACE_FIELD
         >


{



    public GSection_GField_Variable(GCode code) {
        super(code);
    }



}
