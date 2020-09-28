package co.net.genie.common.field;

import co.net.genie.common.GException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class GFieldException extends GException {

    public GFieldException(GCode code) {
        super(code);
    }

    public GFieldException(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GFieldException(GCode code, ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GFieldException(String message) {
        super(message);
    }

    public GFieldException(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }

    public GFieldException(Throwable cause) {
        super(cause);
    }

    public GFieldException(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }


}
