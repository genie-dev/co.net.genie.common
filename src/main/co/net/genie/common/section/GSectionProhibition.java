package co.net.genie.common.section;

import co.net.genie.common.GProhibition;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class GSectionProhibition extends GProhibition {

    public GSectionProhibition(GCode code) {
        super(code);
    }

    public GSectionProhibition(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public GSectionProhibition(GCode code, ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public GSectionProhibition(String message) {
        super(message);
    }

    public GSectionProhibition(String message, GTranslationInterface.ARGS args) {
        super(message, args);
    }



    public GSectionProhibition(Throwable cause) {
        super(cause);
    }

    public GSectionProhibition(Throwable cause, GTranslationInterface.ARGS args) {
        super(cause, args);
    }

}
