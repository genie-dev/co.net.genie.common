package co.net.genie.common.object.field;

import java.util.HashSet;
import java.util.concurrent.Future;

import co.net.genie.common.*;
import co.net.genie.common.handler.GHandlerError;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.logging.LogMarker_Common;
import co.net.genie.common.object.GObjectProhibition;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.utils.CompletedFuture;
import co.net.genie.common.validators.*;
import co.net.genie.common.datatype.*;



public class GObject_GField_Variable
		<
				INTERFACE_OBJECT extends GObject_Interface,
				PRIM
		>
	extends GObject_GField
		<
				INTERFACE_OBJECT

		>
{

	private final GType_Abstract<PRIM> type;
	private final ValidatorInterface[] validators;
	private PRIM value;



	public GObject_GField_Variable(GCode code, GType_Abstract<PRIM> type, PRIM defaultValue, ValidatorInterface...validators) {
		super(code);

		new ValidateArgument(GType_Abstract.class, type,  new Validator_NotNull());
		new ValidateArgument(Object.class, defaultValue,  new Validator_AlwaysValid());

		this.type = type;

		this.validators = validators != null ? validators : new ValidatorInterface[]{};

		try {
			this.value = validate_Value(defaultValue);
		}
		catch (ValidatorProhibition e) {
			throw new InvalidArgumentsError("DEFAULT VALUE", "" + defaultValue, e.getMessage());
		}

	}


	/**Override this method to setup GField property <b>Editable</b>.
	 *
	 * @return
	 */
	public boolean property_Editable() {
		return true;
	}

	final public GType_Abstract<PRIM> getGType() {
		return this.type;
	}

	final public HashSet<ValidatorInterface> getValidators() {

		HashSet<ValidatorInterface> validators_copy = new HashSet<ValidatorInterface>();

		for(ValidatorInterface v : validators) {
			validators_copy.add(v);
		}

		return validators_copy;
	}

	final public PRIM validate_Value(PRIM value) throws ValidatorProhibition {

		PRIM value_to_apply = type.applyTypeToValue(value);

		for (ValidatorInterface validator : validators) {
			validator.validate(this, value_to_apply);
		}

		return value_to_apply;

	}

	synchronized final public void setup_Value(PRIM value) throws ValidatorProhibition {

		this.value = validate_Value(value);

	}

	synchronized final public void setup_Value_StringISOCompatible(String value) throws GTypeConverterException, ValidatorProhibition {
		setup_Value(getGType().convertStringISOCompatibleToValue(value));
	}

	synchronized final public void setup_Value_StringLocaleCompatible(String value) throws GTypeConverterException, ValidatorProhibition {
		setup_Value(getGType().convertStringLocaleCompatibleToValue(value));
	}








	synchronized final public PRIM getValue() throws ValueGetProhibition {
		return this.value;
	}

	final public String getValue_StringISOCompatible() throws ValueGetProhibition {
		return this.getGType().convertValueToStringISOCompatible(this.getValue());
	}

	final public String getValue_StringLocaleCompatible() throws ValueGetProhibition {
		return this.getGType().convertValueToStringLocaleCompatible(this.getValue());
	}

	final public Future<PRIM> setValue(PRIM value) {

		if(!property_Editable()) {
			return new CompletedFuture<PRIM>(new GObjectProhibition(this + " is not Editable!"));
		}

		GHandler_Abstract<?, PRIM, PRIM> provided_field_handler;

		try {
			provided_field_handler = (GHandler_Abstract<?, PRIM, PRIM>) getGHandler();
		}
		catch (Throwable err) {
			throw new GHandlerError(LogMarker_Common.HANDLER_FIELD, err);
		}


		if(provided_field_handler == null) {

			try {
				setup_Value(value);
				return new CompletedFuture<PRIM>(value);
			}
			catch (Throwable err) { // ValidatorProhibition
				return new CompletedFuture<PRIM>(err);
			}

		}
		else { //(provided_field_handler != null)

			Future<PRIM> future = provided_field_handler.fire_GFieldAction(value, value);
			return  future;
		}

	}


	final public Future<PRIM> setValue_StringISOCompatible(String string) throws GTypeConverterException, ValidatorProhibition {
		return this.setValue(this.getGType().convertStringISOCompatibleToValue(string));
	}

	final public Future<PRIM> setValue_StringLocaleCompatible(String string) throws GTypeConverterException, ValidatorProhibition {
		return this.setValue(this.getGType().convertStringLocaleCompatibleToValue(string));
	}






}
