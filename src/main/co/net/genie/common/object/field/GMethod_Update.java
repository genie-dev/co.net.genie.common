package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCodes_GObject;
import co.net.genie.common.user.GUser;

public class GMethod_Update
        <
                INTERFACE_OBJECT extends GObject_Interface

        >

extends GMethod
        <
                INTERFACE_OBJECT,
                String, // update message
                Boolean
        >
{
    public GMethod_Update() {
        super(GCodes_GObject.do_Update);
    }
}
