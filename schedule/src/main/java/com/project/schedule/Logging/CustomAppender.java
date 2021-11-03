package com.project.schedule.Logging;

import java.io.Serializable;
import java.util.concurrent.locks.*;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.PatternLayout;

@Plugin(name="CustomAppender", category="Core", elementType="appender", printObject=true)
public final class CustomAppender extends AbstractAppender {
    protected CustomAppender(String name, Filter filter,
                             Layout<? extends Serializable> layout, final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }
    @Override
    public void append(LogEvent event) {

        try {
            final byte[] bytes = getLayout().toByteArray(event);
            System.out.write(bytes);
        } catch (Exception ex) {
            if (!ignoreExceptions()) {
                throw new AppenderLoggingException(ex);
            }
        }
    }
    @PluginFactory
    public static CustomAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            LOGGER.error("No name provided for CustomAppender");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new CustomAppender(name, filter, layout, true);
    }
}