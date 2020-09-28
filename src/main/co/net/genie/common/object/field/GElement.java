package co.net.genie.common.object.field;


import co.net.genie.common.datatype.GType_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.ValidatorInterface;


@SuppressWarnings("rawtypes")
public class GElement
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


    public GElement(GCode code, GType_Abstract<PRIM> type, PRIM defaultValue, ValidatorInterface...validators) {
        super(code, type, defaultValue, validators);

    }




}
