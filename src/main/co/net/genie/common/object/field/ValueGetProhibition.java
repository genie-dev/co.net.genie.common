package co.net.genie.common.object.field;

import co.net.genie.common.GProhibition;
import co.net.genie.common.field.GFieldProhibition;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GTranslationInterface;

public class ValueGetProhibition extends GFieldProhibition {

    public ValueGetProhibition(GCode code) {
        super(code);
    }

    public ValueGetProhibition(GCode code, GTranslationInterface.ARGS args) {
        super(code, args);
    }

    public ValueGetProhibition(GCode code, GTranslationInterface.ArgsProvider provider_args) {
        super(code, provider_args);
    }

    public ValueGetProhibition(String message) {
        super(message);
    }



    public ValueGetProhibition(Throwable cause) {
        super(cause);
    }


}
