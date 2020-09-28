package co.net.genie.common.object;

import co.net.genie.common.object.GObject_Abstract;
import co.net.genie.common.logging.LogMarker_Common;

import co.net.genie.common.*;
import org.apache.logging.log4j.Marker;


public class GObjectError extends GError {



	public GObjectError(String message) {
		super(GObject_Interface.LOGGER, LogMarker_Common.OBJECT, message, new ARGS());
	}

	public GObjectError(Marker log_marker, String message) {
		super(GObject_Interface.LOGGER, log_marker, message, new ARGS());
	}


	public GObjectError(Throwable cause) {
		super(GObject_Interface.LOGGER, LogMarker_Common.OBJECT, cause, new ARGS());
	}

	public GObjectError(Marker log_marker, Throwable cause) {
		super(GObject_Interface.LOGGER, log_marker, cause, new ARGS());
	}

	
}
