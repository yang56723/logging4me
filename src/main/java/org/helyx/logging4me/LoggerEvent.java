/**
 * Copyright (C) 2007-2009 Alexis Kinsella - http://www.helyx.org - <Helyx.org>
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
package org.helyx.logging4me;

import java.util.Date;

public class LoggerEvent {

	public final int level;
	
	public final Logger logger;
	
	public final String message;
	
	public final long time;
	
	public final Date date;

	public LoggerEvent(int level, Logger logger, String message) {
		super();
		this.level = level;
		this.logger = logger;
		this.message = message;
		this.time = System.currentTimeMillis();
		this.date = new Date(time);
	}

	public LoggerEvent(int level, Logger logger, String message, Date date) {
		super();
		this.level = level;
		this.logger = logger;
		this.message = message;
		this.time = date.getTime();
		this.date = date;
	}
	
}
