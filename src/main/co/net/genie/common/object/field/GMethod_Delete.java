package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCodes_GObject;

public class GMethod_Delete
        <
                INTERFACE_OBJECT extends GObject_Interface

        >

extends GMethod
        <
                INTERFACE_OBJECT,
                String, //Delete message
                Boolean
        >
{
    public GMethod_Delete() {
        super(GCodes_GObject.do_Delete);
    }
}
