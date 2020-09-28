package co.net.genie.common.object.field;


import co.net.genie.common.datatype.GType_Boolean;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;

@SuppressWarnings("rawtypes")
public class GStatus
        <
                INTERFACE_OBJECT extends GObject_Interface

        >
extends GObject_GField_Variable
        <

                INTERFACE_OBJECT,
                Boolean
        >

{


    public GStatus(GCode code, boolean value_default) {
        super(code, new GType_Boolean(), value_default);



    }





}
