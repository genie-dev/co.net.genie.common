package co.net.genie.common.object.field;




import co.net.genie.common.GException;
import co.net.genie.common.handler.GHandlerError;
import co.net.genie.common.logging.LogMarker_Common;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.utils.CompletedFuture;

import java.util.concurrent.Future;

@SuppressWarnings("rawtypes")
public class GMethod
        <
                INTERFACE_OBJECT extends GObject_Interface,
                METH_ARGS,
                METH_RESULT
        >
    extends GObject_GField
        <
                INTERFACE_OBJECT
        >
{




    public GMethod(GCode code) {
        super(code);
    }


    final public Future<METH_RESULT> call(METH_ARGS args) {

            GMethod_GHandler<INTERFACE_OBJECT, GMethod<INTERFACE_OBJECT, METH_ARGS, METH_RESULT>, METH_ARGS, METH_RESULT> provided_field_handler;

            try {
                provided_field_handler = (GMethod_GHandler<INTERFACE_OBJECT, GMethod<INTERFACE_OBJECT, METH_ARGS, METH_RESULT>, METH_ARGS, METH_RESULT>) getGHandler();
            }
            catch (Throwable err) {
                throw new GHandlerError(LogMarker_Common.HANDLER_FIELD, err);
            }


            if(provided_field_handler == null) {

                return new CompletedFuture<METH_RESULT>(new GException(this + " no action provided!"));


            }
            else { //(provided_field_handler != null)

                Future<METH_RESULT> future = provided_field_handler.fire_GFieldAction(args, null);
                return  future;
            }


    }




}
