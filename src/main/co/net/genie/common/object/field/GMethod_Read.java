package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCodes_GObject;

public class GMethod_Read
        <
                INTERFACE_OBJECT extends GObject_Interface

        >

extends GMethod
        <
                INTERFACE_OBJECT,
                String, // actually - void
                Boolean
        >
{
    public GMethod_Read() {
        super(GCodes_GObject.do_Identify);
    }
}
