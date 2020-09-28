package co.net.genie.common.field;

import co.net.genie.common.GError;
import co.net.genie.common.logging.LogMarker_Common;
import co.net.genie.common.object.GObject_Abstract;
import org.apache.logging.log4j.Marker;


public class GFieldError extends GError {



	public GFieldError(String message) {
		super(GField.LOGGER, LogMarker_Common.FIELD, message, new ARGS());
	}

	public GFieldError(Marker log_marker, String message) {
		super(GField.LOGGER, log_marker, message, new ARGS());
	}


	public GFieldError(Throwable cause) {
		super(GField.LOGGER, LogMarker_Common.FIELD, cause, new ARGS());
	}

	public GFieldError(Marker log_marker, Throwable cause) {
		super(GField.LOGGER, log_marker, cause, new ARGS());
	}

	
}
