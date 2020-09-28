package co.net.genie.common.object.field;


import co.net.genie.common.handler.GHandlerError;
import co.net.genie.common.logging.LogMarker_Common;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.utils.CompletedFuture;

import java.util.concurrent.Future;

public class GSearch

        <
                INTERFACE_OBJECT extends GObject_Interface

        >
extends GObject_GField
        <
                INTERFACE_OBJECT

        >


{

    private boolean has_match = false;

    public GSearch(GCode code) {
        super(code);

    }

    synchronized final public boolean hasMatch() {
        return has_match;
    }

    synchronized final public void setup_Match(boolean has_match) {

        this.has_match = has_match;

    }

    final public Future<Boolean> setSearchString(String search_string) {

        GSearch_GHandler_Abstract<INTERFACE_OBJECT, GSearch<INTERFACE_OBJECT>> provided_search_handler;

        try {
            provided_search_handler = (GSearch_GHandler_Abstract<INTERFACE_OBJECT, GSearch<INTERFACE_OBJECT>>) getGHandler();
        }
        catch (Throwable err) {
            throw new GHandlerError(LogMarker_Common.HANDLER_FIELD, err);
        }


        if(provided_search_handler == null) {

            setup_Match(false);
            return new CompletedFuture<Boolean>(false);

        }
        else { //(provided_search_handler != null)

            Future<Boolean> future = provided_search_handler.fire_GFieldAction(search_string, false);
            return  future;
        }

    }

}



	


