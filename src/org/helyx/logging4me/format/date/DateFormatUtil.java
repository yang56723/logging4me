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
package org.helyx.logging4me.format.date;

import java.util.Calendar;
import java.util.Date;

import org.helyx.logging4me.format.number.NumberFormatUtil;

public class DateFormatUtil {
	
	private DateFormatUtil() {
		super();
	}

	public static String formatDatetimeWithMilliSeconds(Date date) {
		return formatDatetime(date, "/", ":", ", ", true, ".");
	}

	public static String formatDatetime(Date date) {
		return formatDatetime(date, "/", ":", ", ", false, null);
	}
	
	public static String formatDatetime(Date date, String dateSeparator, String timeSeparator, String dateTimeSeparator) {
		return formatDatetime(date, dateSeparator, timeSeparator, dateTimeSeparator, false, null);
	}
	
	public static String formatDatetime(Date date, String dateSeparator, String timeSeparator, String dateTimeSeparator, boolean showMilliSeconds, String milliSecondsSeparator) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String year = NumberFormatUtil.format(calendar.get(Calendar.YEAR), 4);
		String month = NumberFormatUtil.format(calendar.get(Calendar.MONTH) + 1, 2);
		String day = NumberFormatUtil.format(calendar.get(Calendar.DATE), 2);
		String hour = NumberFormatUtil.format(calendar.get(Calendar.HOUR_OF_DAY), 2);
		String minute = NumberFormatUtil.format(calendar.get(Calendar.MINUTE), 2);
		String second = NumberFormatUtil.format(calendar.get(Calendar.SECOND), 2);
			
		String result = day + dateSeparator + month + dateSeparator + year + dateTimeSeparator + hour + timeSeparator + minute + timeSeparator + second;
		
		if (showMilliSeconds) {
			String milliSeconds  = NumberFormatUtil.format(calendar.get(Calendar.MILLISECOND), 3);

			result += milliSecondsSeparator + milliSeconds;
		}
		
		return result;
	}

	public static String formatDate(Date date) {
		return formatDate(date, "/");
	}

	public static String formatDate(Date date, String separator) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String year = NumberFormatUtil.format(calendar.get(Calendar.YEAR), 4);
		String month = NumberFormatUtil.format(calendar.get(Calendar.MONTH) + 1, 2);
		String day = NumberFormatUtil.format(calendar.get(Calendar.DATE), 2);
		
		return day + separator + month + separator + year;
	}

	public static String formatTime(Date date) {
		return formatTime(date, ":");
	}

	public static String formatTime(Date date, String separator) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String hour = NumberFormatUtil.format(calendar.get(Calendar.HOUR_OF_DAY), 2);
		String minute = NumberFormatUtil.format(calendar.get(Calendar.MINUTE), 2);
		String second = NumberFormatUtil.format(calendar.get(Calendar.SECOND), 2);
		
		return hour + separator + minute + separator + second;
	}
	
}
