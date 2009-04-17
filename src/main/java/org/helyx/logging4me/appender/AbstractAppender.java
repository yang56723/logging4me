/**
 * Copyright (C) 2007-2009 Alexis Kinsella - $ {website} - <Helyx.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.helyx.logging4me.appender;

import java.util.Date;

import org.helyx.logging4me.Logger;
import org.helyx.logging4me.layout.Layout;

public abstract class AbstractAppender implements Appender {

	private int thresholdLevel = Logger.DEBUG;
	
	private Layout layout;

	public AbstractAppender() {
		super();
	}

	public void write(int level, Logger logger, String message, Date date) {
		try {
			if(isLoggable(level)) {
				onWrite(level, logger, message, date);
			}
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		}
	}

	public abstract void onWrite(int level, Logger logger, String message, Date date);
	
	protected String formatLog(int level, Logger logger, String message, Date date) {
		if (layout == null) {
			return message;
		}
		return layout.format(level, logger.getCategory().getName(), message, date);
	}
	
	public int getThresholdLevel() {
		return thresholdLevel;
	}

	public void setThresholdLevel(int thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
	}

	
	public boolean isLoggable(int level) {
		return level >= thresholdLevel;
	}
	
	public boolean isFatalEnabled() {
		return Logger.FATAL >= thresholdLevel;
	}
	
	public boolean isErrorEnabled() {
		return Logger.ERROR >= thresholdLevel;
	}
	
	public boolean isWarnEnabled() {
		return Logger.WARN >= thresholdLevel;
	}
	
	public boolean isInfoEnabled() {
		return Logger.INFO >= thresholdLevel;
	}
	
	public boolean isDebugEnabled() {
		return Logger.DEBUG >= thresholdLevel;
	}
	
	public boolean isTraceEnabled() {
		return Logger.TRACE >= thresholdLevel;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}
	
}