package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;

import java.util.concurrent.ExecutorService;

public class GMethod_Read_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >

extends GMethod_GHandler
        <
                INTERFACE_OBJECT,
                GMethod_Read<INTERFACE_OBJECT>,
                String,
                Boolean
        >

{
    public GMethod_Read_GHandler(ExecutorService executor) {
        super(executor);
    }
}
