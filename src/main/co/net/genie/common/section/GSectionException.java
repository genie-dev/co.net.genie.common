package co.net.genie.common.section;

import co.net.genie.common.GException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class GSectionException extends GException {

    public GSectionException(GCode code) {
        super(code);
    }

    public GSectionException(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GSectionException(GCode code, ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GSectionException(String message) {
        super(message);
    }

    public GSectionException(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }

    public GSectionException(Throwable cause) {
        super(cause);
    }

    public GSectionException(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }


}
