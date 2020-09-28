package co.net.genie.common.field;

import co.net.genie.common.GLanguage;
import co.net.genie.common.handler.GHandlerError;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.translator.GCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import co.net.genie.common.Environment;
import co.net.genie.common.ValidateArgument;
import co.net.genie.common.annotations.NotNull;
import co.net.genie.common.annotations.Nullable;
import co.net.genie.common.translator.GTranslationInterface;

import co.net.genie.common.validators.*;


public class GField

implements GTranslationInterface, GTranslationInterface.ArgsProvider {


	static {
		//Before static LOGGER.
		Environment.init();
	}

	static final public Logger LOGGER = LogManager.getLogger(GField.class);


	//********************* IMMUTABLES **********************
	private final GTranslationInterface translation;

	//******************* synchronized on this ********************
	@Nullable
	private GHandler_Abstract field_handler = null;
	private boolean promoted = false;
	private boolean hidden = false;
	private GField field_parent = null;

	public GField(@NotNull GCode code) {
		this(code, null);

	}

	public GField(@NotNull GCode code, @Nullable GField field_parent) {
		new ValidateArgument(GCode.class, code, new Validator_NotNull());

		this.translation = code.getTranslation(this);;

		this.field_parent = field_parent;
	}



	@Nullable
	final public GField getParent() {
		return field_parent;
	}

	@Override
	final public GLanguage getGLanguage() {
		return this.translation.getGLanguage();
	}

	@Override
	final public GCode getGCode() {
		return this.translation.getGCode();
	}

	/**May be overridden.<br>
	 * These args are passed to translation.<br>
	 *
	 *
	 */
	@Override
	public ARGS getGArgs() {
		return new GTranslationInterface.ARGS();
	}


	@Override
	final public String getGDescription_developer() {
		return this.translation.getGDescription_developer();
	}


	@Override
	final public String getGCaption() {
		return this.translation.getGCaption();
	}

	@Override
	final public String getGDescription() {
		return this.translation.getGDescription();
	}







	synchronized final public boolean isPromoted() {
		return promoted;
	}

	synchronized final public boolean isHidden() {
		return hidden;
	}

	synchronized final public void setPromoted(boolean promoted) {
		this.promoted = promoted;

		if(promoted) {
			this.hidden = false;
		}
	}

	synchronized final public void setHidden(boolean hidden) {
		this.hidden = hidden;

		if(hidden) {
			this.promoted = false;
		}
	}

	synchronized public void setup_GHandler( @Nullable GHandler_Abstract field_handler) {

		if(field_handler == null && this.field_handler != null) {
			this.field_handler.setup_GField(null);
			this.field_handler = null;
		}
		else {
			try {
				this.field_handler = field_handler;
				this.field_handler.setup_GField(this);
			}
			catch (Throwable err) {
				//Handler may fail to cast to FIELD
				new GHandlerError(this + " fail to setup_GHandler(...) : " + err.getMessage());
			}
		}
	}

	synchronized public GHandler_Abstract getGHandler() {
		return field_handler;
	}


	@Override
	public String toString() {

		String args = this.getGArgs().size() > 0 ? "[" + this.getGArgs() + "]" : "";

		return this.getClass().getSimpleName() + "#" + getGCode() + args;

	}

}
