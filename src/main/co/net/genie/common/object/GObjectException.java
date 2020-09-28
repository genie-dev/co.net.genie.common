package co.net.genie.common.object;

import co.net.genie.common.GException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class GObjectException extends GException {

    public GObjectException(GCode code) {
        super(code);
    }

    public GObjectException(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GObjectException(GCode code, GTranslationInterface.ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GObjectException(String message) {
        super(message);
    }

    public GObjectException(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }

    public GObjectException(Throwable cause) {
        super(cause);
    }

    public GObjectException(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }


}
