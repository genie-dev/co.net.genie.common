package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCodes_GObject;

public class GMethod_Create
        <
                INTERFACE_OBJECT extends GObject_Interface

        >

extends GMethod
        <
                INTERFACE_OBJECT,
                INTERFACE_OBJECT, //Setup object. method GMethod_Create assigns GField_ID and Owner.
                Boolean
        >
{
    public GMethod_Create() {
        super(GCodes_GObject.do_Create);
    }
}
