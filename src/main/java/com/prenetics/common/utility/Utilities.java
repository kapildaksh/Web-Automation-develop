package com.prenetics.common.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;


public class Utilities {

	private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}).*");
	private static final Logger LOGGER = Logger.getLogger(Utilities.class);
	private static final ReadPropertiesFile PROPS = new ReadPropertiesFile();

	private final ThreadLocal<Map<String, String>> storage = ThreadLocal.withInitial(HashMap::new);

	public String getValue(String name) {
		return System.getProperty(name, storage.get().get(name));
	}

	public String setValue(String name, String value) {
		LOGGER.debug(String.format("Save key %s, value %s", name, value));
		return storage.get().put(name, value);
	}
	public ReadPropertiesFile getProps() {
		return PROPS;
	}

	public String getEmailString() {
		
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = "test-automation+" + Long.toString(System.currentTimeMillis()) + salt.toString() + "@prenetics.com";
		return saltStr;
	}


	public String getISODateTimeForToday() {
		return getISODateTime(new Date());
	}

	public String getISODateTime(Date date) {
		return getISODateTimeformat().format(date);
	}

	public String getISODateForToday() {
		return getISODate(new Date());
	}

	public String getISODate(Date date) {
		return getISODateformat().format(date);
	}

	public Date parseDateTime(String isoTimeStamp) {
		try {
			return getISODateTimeformat().parse(isoTimeStamp.replaceAll("\\+0([0-9]){1}\\:00", "+0$100"));
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private DateFormat getISODateTimeformat() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	}

	private DateFormat getISODateformat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	public String getDate(String isoDateTime) {
		java.util.regex.Matcher matcher = DATE_PATTERN.matcher(isoDateTime);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			throw new IllegalArgumentException(String.format("Cannot match against %s", DATE_PATTERN.toString()));
		}
	}

	public Matcher<String> getDateMatcher(String date) {
		return new TypeSafeDiagnosingMatcher<String>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("has the same date as ").appendText(date);
			}

			@Override
			protected boolean matchesSafely(String dateString, Description mismatchDescription) {
				return date.equals(getDate(dateString));
			}

		};
	}

	public Date getDate(Date date, int days) {
		return getDate(date, days, false);
	}
	
	public Date getDate(Date date, int days, boolean businessDayOnly) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		final IntPredicate condition;
		final IntSupplier val;
		final IntFunction<Integer> next;
		if (days < 0) {
			condition = workdays -> workdays > days;
			val = () -> -1;
			next = i -> i - 1;
		} else {
			condition = workdays -> workdays < days;
			val = () -> 1;
			next = i -> i + 1;
		}
		int workdays = 0;
		while (condition.test(workdays)) {
			cal.add(Calendar.DAY_OF_MONTH, val.getAsInt());
			if (! businessDayOnly || (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
				workdays = next.apply(workdays);
			}			
		}
		return cal.getTime();
	}

	public String currentDate() {
		return getISODateformat().format(Calendar.getInstance().getTime());
	}

	public String futureDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String newDate = getISODateformat().format(cal.getTime());
		return newDate;
	}

	public String pastDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String newDate = getISODateformat().format(cal.getTime());
		return newDate + "T00:00:00Z";
	}

	public Matcher<String> getDateMatcher(Date date, int increment) {
		String actualDate = getISODate(getDate(date, increment));
		LOGGER.info(String.format("Matcher for date %s with increment %s = %s", date.toString(), increment, actualDate));
		return getDateMatcher(actualDate);
	}

	public <V> V tryGet(int seconds, int tries, Supplier<V> supplier) {
		Throwable holder = null;
		for (int i = 0; i < tries; i++) {
			try {
				return supplier.get();
			} catch (Throwable t) {
				holder = t;
				try {
					Thread.sleep(seconds * 1000);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		throw new IllegalStateException("Fail to retry", holder);
	}

		
}