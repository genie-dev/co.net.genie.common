package co.net.genie.common.field;

import co.net.genie.common.GProhibition;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class GFieldProhibition extends GProhibition {

    public GFieldProhibition(GCode code) {
        super(code);
    }

    public GFieldProhibition(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GFieldProhibition(GCode code, ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GFieldProhibition(String message) {
        super(message);
    }

    public GFieldProhibition(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }



    public GFieldProhibition(Throwable cause) {
        super(cause);
    }

    public GFieldProhibition(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }

}
