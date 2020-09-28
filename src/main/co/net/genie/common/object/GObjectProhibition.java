package co.net.genie.common.object;

import co.net.genie.common.*;
import co.net.genie.common.translator.*;

public class GObjectProhibition extends GProhibition {

    public GObjectProhibition(GCode code) {
        super(code);
    }

    public GObjectProhibition(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GObjectProhibition(GCode code, GTranslationInterface.ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GObjectProhibition(String message) {
        super(message);
    }

    public GObjectProhibition(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }



    public GObjectProhibition(Throwable cause) {
        super(cause);
    }

    public GObjectProhibition(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }

}
