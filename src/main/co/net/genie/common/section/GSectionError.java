package co.net.genie.common.section;

import co.net.genie.common.GError;
import co.net.genie.common.field.GField;
import co.net.genie.common.logging.LogMarker_Common;
import org.apache.logging.log4j.Marker;


public class GSectionError extends GError {



	public GSectionError(String message) {
		super(GField.LOGGER, LogMarker_Common.FIELD, message, new ARGS());
	}

	public GSectionError(Marker log_marker, String message) {
		super(GField.LOGGER, log_marker, message, new ARGS());
	}


	public GSectionError(Throwable cause) {
		super(GField.LOGGER, LogMarker_Common.FIELD, cause, new ARGS());
	}

	public GSectionError(Marker log_marker, Throwable cause) {
		super(GField.LOGGER, log_marker, cause, new ARGS());
	}

	
}
