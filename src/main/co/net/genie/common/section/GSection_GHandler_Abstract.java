package co.net.genie.common.section;


import co.net.genie.common.ValidateArgument;
import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.section.GSection_Abstract;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.Validator_NotNull;
import co.net.genie.common.validators.Validator_True;

import java.util.concurrent.ExecutorService;

public abstract class GSection_GHandler_Abstract
        <
                SECTION extends GSection_Abstract<INTERFACE_FIELD>,
                INTERFACE_FIELD extends GField


        >
    extends GHandler_Abstract
        <
                SECTION,
                GCode,
                String

        >
{



    public GSection_GHandler_Abstract(ExecutorService executor) {
        super(executor);

    }

    @Override
    final protected void setup_GField_Related_Items(SECTION field) {
        new ValidateArgument(GSection_Abstract.class, field, new Validator_NotNull());
        new ValidateArgument(GSection_Abstract.class, field instanceof GSection_Abstract, new Validator_True());

        GSection_Abstract section = (GSection_Abstract) field;

        for (Object item : section) {
            GField field_item = (GField) item;
            field_item.setup_GHandler(init_new_GField_GHandler(field_item));
        }

    }

    protected abstract GHandler_Abstract init_new_GField_GHandler(GField field);


}
