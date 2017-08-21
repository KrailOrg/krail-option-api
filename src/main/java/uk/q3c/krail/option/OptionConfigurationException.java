package uk.q3c.krail.option;

/**
 * Created by David Sowerby on 21 Aug 2017
 */
public class OptionConfigurationException extends RuntimeException {
    public OptionConfigurationException() {
    }

    public OptionConfigurationException(String message) {
        super(message);
    }

    public OptionConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptionConfigurationException(Throwable cause) {
        super(cause);
    }

    public OptionConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
