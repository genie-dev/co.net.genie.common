package co.net.genie.common.object.field;





import co.net.genie.common.datatype.*;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.*;


@SuppressWarnings("rawtypes")
public class GProperty
        <
                INTERFACE_OBJECT extends GObject_Interface,
                PRIM
        >
        extends GObject_GField_Variable
        <
                INTERFACE_OBJECT,
                PRIM
        >
{

    public GProperty(GCode code, GType_Abstract<PRIM> type, PRIM defaultValue, ValidatorInterface...validators) {
        super(code, type, defaultValue, validators);

    }




}
