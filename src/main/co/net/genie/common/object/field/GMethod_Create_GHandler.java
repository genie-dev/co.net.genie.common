package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;

import java.util.concurrent.ExecutorService;

public class GMethod_Create_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >

extends GMethod_GHandler
        <
                INTERFACE_OBJECT,
                GMethod_Create<INTERFACE_OBJECT>,
                INTERFACE_OBJECT,
                Boolean
        >

{
    public GMethod_Create_GHandler(ExecutorService executor) {
        super(executor);
    }
}
