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
import org.helyx.logging4me.layout.SimpleLayout;

public class ConsoleAppender extends AbstractAppender {
	
	private static ConsoleAppender consoleLogWriter;
	
	public static String CONSOLE_APPENDER_NAME = "CONSOLE";
	
	static {
		consoleLogWriter = new ConsoleAppender();
	}

	private ConsoleAppender() {
		super();
	}

	public void onWrite(int level, Logger logger, String message, Date date) {
		try {			
			if (level == Logger.FATAL || level == Logger.ERROR) {
				System.err.println(formatLog(level, logger, message, date));
			}
			else {
				System.out.println(formatLog(level, logger, message, date));
			}
		}
		catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	public void open() throws Exception {

	}

	public void close() throws Exception {
		
	}

	public void flush() throws Exception {
		
	}

	public static ConsoleAppender getInstance() {
		return consoleLogWriter;
	}

	public String getName() {
		return CONSOLE_APPENDER_NAME;
	}

}
