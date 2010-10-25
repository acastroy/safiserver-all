package com.safi.db.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.FastDateFormat;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EvaluatorException;
import com.csvreader.CsvWriter;
import com.safi.db.VariableType;

public class VariableTranslator {

	private static final String JAVASCRIPT_DATE_PATTERN = "EEE MMM dd yyyy HH:mm:ss 'GMT'Z (z)";
	private final static FastDateFormat DATE_FORMATTER = FastDateFormat.getDateInstance(DateFormat.SHORT);
	private final static FastDateFormat DATETIME_FORMATTER = FastDateFormat.getDateTimeInstance(DateFormat.SHORT,
			DateFormat.MEDIUM);

	private final static FastDateFormat TIME_FORMATTER = FastDateFormat.getTimeInstance(DateFormat.MEDIUM);

	private final static FastDateFormat JAVASCRIPT_DATE_PARSER = FastDateFormat.getInstance(JAVASCRIPT_DATE_PATTERN);

	// public static Object translateValue(Object tartgetInstance, Object value)
	// throws IllegalArgumentException {
	// if (tartgetInstance instanceof Number) {
	// if (value instanceof Number) {
	// if (tartgetInstance instanceof Long)
	// return new Long(((Number) value).longValue());
	// else if (tartgetInstance instanceof Integer)
	// return new Integer(((Number) value).intValue());
	// else if (tartgetInstance instanceof Float)
	// return new Float(((Number) value).floatValue());
	// else if (tartgetInstance instanceof Double)
	// return new Double(((Number) value).doubleValue());
	// else
	// throw new IllegalArgumentException("Variable has unsupported type "
	// + tartgetInstance.getClass());
	// } else if (value instanceof String) {
	// if (tartgetInstance instanceof Long)
	// return new Long((String) value);
	// else if (tartgetInstance instanceof Integer)
	// return new Integer((String) value);
	// else if (tartgetInstance instanceof Float)
	// return new Float((String) value);
	// else if (tartgetInstance instanceof Double)
	// return new Double((String) value);
	// else
	// throw new IllegalArgumentException("Variable has unsupported type "
	// + tartgetInstance.getClass());
	// } else
	// throw new IllegalArgumentException("New value has unsupported type " +
	// value.getClass());
	// } else if (tartgetInstance instanceof String)
	// return value.toString();
	// else
	// throw new IllegalArgumentException("Variable has unsupported type " +
	// tartgetInstance.getClass());
	// }

	public static boolean isCompatible(VariableType newType, Object currVal) {
		try {
			translateValue(newType, currVal);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static Object translateValueFromPrototype(Object prototype, Object value) {
		if (prototype instanceof VariableType)
			return translateValue((VariableType) prototype, value);
		if (prototype instanceof String) {
			return translateValue(VariableType.TEXT, value);
		}
		if (prototype instanceof Date) {
			return translateValue(VariableType.DATE, value);
		}
		if (prototype instanceof Long || prototype instanceof Integer) {
			return translateValue(VariableType.INTEGER, value);
		}
		if (prototype instanceof Double || prototype instanceof Float) {
			return translateValue(VariableType.DECIMAL, value);
		}
		if (prototype instanceof Number) {
			return translateValue(VariableType.DECIMAL, value);
		}
		if (prototype instanceof Boolean) {
			return translateValue(VariableType.BOOLEAN, value);
		}
		if (prototype instanceof List) {
			return translateValue(VariableType.ARRAY, value);
		}
		if (prototype instanceof Number) {
			return translateValue(VariableType.DECIMAL, value);
		}
		return value;
	}

	public static Object translateValue(VariableType type, Object value) throws IllegalArgumentException {
		if (value == null)
			return null;
		switch (type) {
			case TEXT:
				if (value instanceof Date)
					return DATETIME_FORMATTER.format((Date) value);
				else if (value instanceof List)
					return formatArray((List) value);
				return value.toString();
			case INTEGER:
				if (value instanceof Long)
					return value;
				else if (value instanceof Number)
					return new Long(((Number) value).longValue());
				else
					return new Long(value.toString());
			case DECIMAL:
				if (value instanceof Number)
					return new Double(((Number) value).doubleValue());
				else
					return new Double(value.toString());
			case DATE:
				if (value instanceof Date) {
					try {
						return SimpleDateFormat.getDateInstance(DateFormat.SHORT).parse(DATE_FORMATTER.format((Date) value));
					} catch (ParseException e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value);
					}
				} else if (value instanceof Integer || value instanceof Long) {
					try {
						return SimpleDateFormat.getDateInstance(DateFormat.SHORT).parse(
								DATE_FORMATTER.format(new Date(((Number) value).longValue())));
					} catch (Exception e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value, e);
					}
				} else if (value instanceof org.mozilla.javascript.ScriptableObject) {
					try {
						return (Date) Context.jsToJava(value, Date.class);
					} catch (EvaluatorException e) {
						e.printStackTrace();
						try {
							Long time = (Long) Context.jsToJava(value, Long.class);
							return new Date(time);
						} catch (EvaluatorException e2) {
							throw new IllegalArgumentException("Couldn't format date from " + value, e2);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value, e);
					}
				} else
					return parseDate(value.toString());

			case DATETIME:
				if (value instanceof Date) {

					Date d = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).parse(
							DATETIME_FORMATTER.format((Date) value), new ParsePosition(0));
					if (d != null)
						return d;
					else
						throw new IllegalArgumentException("Couldn't format datetime from " + value);

				} else if (value instanceof Number) {
					Date d = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).parse(
							DATETIME_FORMATTER.format(new Date(((Number) value).longValue())), new ParsePosition(0));
					if (d != null)
						return d;
					else
						throw new IllegalArgumentException("Couldn't format date from " + value);
				} else if (value instanceof org.mozilla.javascript.ScriptableObject) {
					try {
						return (Date) Context.jsToJava(value, Date.class);
					} catch (EvaluatorException e) {
						e.printStackTrace();
						try {
							Long time = (Long) Context.jsToJava(value, Long.class);
							return new Date(time);
						} catch (EvaluatorException e2) {
							throw new IllegalArgumentException("Couldn't format date from " + value, e2);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value, e);
					}
				} else
					return parseDate(value.toString());
			case TIME:
				if (value instanceof Date) {
					Date d = SimpleDateFormat.getTimeInstance(DateFormat.MEDIUM).parse(TIME_FORMATTER.format((Date) value),
							new ParsePosition(0));
					if (d != null)
						return d;
					else
						throw new IllegalArgumentException("Couldn't format time from " + value);
				} else if (value instanceof Number) {
					try {
						return SimpleDateFormat.getTimeInstance(DateFormat.MEDIUM).parse(
								TIME_FORMATTER.format(new Date(((Number) value).longValue())));
					} catch (Exception e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value, e);
					}
				} else if (value instanceof org.mozilla.javascript.ScriptableObject) {
					try {
						return (Date) Context.jsToJava(value, Date.class);
					} catch (EvaluatorException e) {
						e.printStackTrace();
						try {
							Long time = (Long) Context.jsToJava(value, Long.class);
							return new Date(time);
						} catch (EvaluatorException e2) {
							throw new IllegalArgumentException("Couldn't format date from " + value, e2);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new IllegalArgumentException("Couldn't format date from " + value, e);
					}
				} else
					return parseDate(value.toString());
			case BOOLEAN:
				if (value instanceof Boolean)
					return value;
				else
					return Boolean.parseBoolean(value.toString());
			case ARRAY:
				if (value instanceof List)
					return value;
				else if (value instanceof Object[]) {
					return new ArrayList<Object>(Arrays.asList((Object[]) value));
				} else
					return parseArray(value.toString());
			case OBJECT:
			default:
				return value;

		}
	}

	// public static <T> T translateValue(Class<T> type, Object value) throws
	// IllegalArgumentException {
	// if (value == null)
	// return null;
	// VariableType vartype = null;
	// if (type == String.class) {
	// vartype = VariableType.TEXT;
	// } else if (type == int.class || type == Integer.class || type == long.class
	// || type == Long.class)
	// vartype = VariableType.DECIMAL;
	// else if (type == Date.class)
	// vartype = VariableType.DATETIME;
	// else if (type == boolean.class || type == Boolean.class)
	// vartype = VariableType.BOOLEAN;
	// else if (type == float.class || type == Float.class || type == double.class
	// || type == Double.class)
	// vartype = VariableType.DECIMAL;
	// else if (type == List.class)
	// vartype = VariableType.ARRAY;
	// else
	// vartype = VariableType.OBJECT;
	//
	// return type.cast(translateValue(vartype, value));
	// }
	//	

	public static String translateToText(VariableType type, Object value) {

		if (value == null)
			return "";
		switch (type) {
			case DATE:
				if (value instanceof Date)
					return DATE_FORMATTER.format((Date) value);
			case DATETIME:
				if (value instanceof Date)
					return DATETIME_FORMATTER.format((Date) value);
			case TIME:
				if (value instanceof Date)
					return TIME_FORMATTER.format((Date) value);
			case ARRAY:
				if (value instanceof List)
					return formatArray((List) value);
			case OBJECT:
			case TEXT:
			case INTEGER:
			case DECIMAL:
			case BOOLEAN:
			default:
				return value.toString();

		}

	}

	public static String formatArray(List<Object> list) {
		StringWriter buf = new StringWriter();
		CsvWriter writer = new CsvWriter(buf, ',');
		writer.setUseTextQualifier(true);
		writer.setEscapeMode(CsvWriter.ESCAPE_MODE_BACKSLASH);
		try {
			buildArray(list, buf, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	private static void buildArray(List array, StringWriter buf, CsvWriter writer) throws IOException {
		if (buf.getBuffer().length() > 0)
			buf.write(',');
		buf.write("[");

		for (Object o : array) {
			if (o instanceof List) {
				CsvWriter wr = new CsvWriter(buf, ',');
				wr.setEscapeMode(CsvWriter.ESCAPE_MODE_BACKSLASH);
				wr.setUseTextQualifier(true);
				buildArray((List) o, buf, wr);
			} else {
				String string = o == null ? "" : o.toString().trim();
				if (string.startsWith("\""))
					string = string.substring(1);
				if (string.endsWith("\""))
					string = string.substring(0, string.length() - 1);
				writer.write(string);
			}
		}
		buf.write("]");
	}

	public static List parseArray(String literal) throws IllegalArgumentException {
		StringReader sr = new StringReader(literal);
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			return buildArray(sr, list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// Object[] parent = new Object[list.size()];
		// return buildArray(list, parent);
	}

	// private static Object[] buildArray(ArrayList<Object> list, Object[] parent)
	// {
	// for (int i = 0; i < parent.length; i++) {
	// Object o = list.get(i);
	// if (o instanceof ArrayList) {
	// ArrayList l = (ArrayList<Object>) o;
	// parent[i] = buildArray(l, new Object[l.size()]);
	// } else
	// parent[i] = o;
	// }
	// return parent;
	// }

	public static Date parseDate(Object value) throws IllegalArgumentException {
		Exception lastException = null;
		Date date = null;
		try {
			try {
				DateFormat fmt = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);
				fmt.setLenient(false);
				date = fmt.parse(value.toString());
			} catch (ParseException e) {
			}
			// date = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT,
			// DateFormat.MEDIUM).parse(value.toString(),
			// new ParsePosition(0));
			if (date != null)
				return date;
		} catch (Exception e) {
			lastException = e;
		}
		try {

			try {
				DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);
				fmt.setLenient(false);
				date = fmt.parse(value.toString());
			} catch (ParseException e) {
			}
			// date =
			// SimpleDateFormat.getDateInstance(DateFormat.MEDIUM).parse(value.toString(),
			// new ParsePosition(0));
			if (date != null)
				return date;
		} catch (Exception e) {
			lastException = e;
		}
		try {

			try {
				DateFormat fmt = DateFormat.getTimeInstance(DateFormat.MEDIUM);
				fmt.setLenient(false);
				date = fmt.parse(value.toString());
			} catch (ParseException e) {
			}
			// date =
			// SimpleDateFormat.getTimeInstance(DateFormat.SHORT).parse(value.toString(),
			// new ParsePosition(0));
			if (date != null)
				return date;
		} catch (Exception e) {
			lastException = e;
		}
		try {
			date = new SimpleDateFormat(JAVASCRIPT_DATE_PATTERN).parse(value.toString(), new ParsePosition(0));
			if (date != null)
				return date;
		} catch (Exception e) {
			lastException = e;
		}
		try {
			date = CalendarParser.parse(value.toString()).getTime();
			if (date != null)
				return date;
		} catch (Exception e) {
			lastException = e;
		}
		throw new IllegalArgumentException("Couldn't parse date from " + value, lastException);
	}

	private static ArrayList<Object> buildArray(StringReader sr, ArrayList<Object> list) throws IOException {
		char val = (char) sr.read();
		if (val != '[')
			throw new IllegalArgumentException("Array literal must begin with '['");
		Object atom;
		while ((atom = readAtom(sr)) != null) {
			list.add(atom);
			sr.mark(0);
			if (sr.read() == ']') {
				eatTilComma(sr);
				break;
			} else
				sr.reset();
		}
		return list;
	}

	private static void eatTilComma(StringReader sr) throws IOException {
		int i;
		while (((i = sr.read()) != -1) && i != ',') {

		}

	}

	private static Object readAtom(StringReader sr) throws IOException {
		StringBuffer buf = new StringBuffer();
		int val;
		boolean escape = false;
		sr.mark(1);
		while ((val = sr.read()) != -1) {
			if (!escape && val == ',') {
				return buf.toString();
			} else if (!escape && val == '[') {
				sr.reset();
				return buildArray(sr, new ArrayList<Object>());
			} else if (!escape && val == ']') {
				sr.reset();

				return buf.toString();
			} else if (!escape && val == '\\') {
				escape = true;
				continue;
			} else {
				buf.append((char) val);
				escape = false;
				sr.mark(1);
			}

		}
		if (val == -1)
			return null;
		return buf.toString();
	}

	public static Class getClassForVarType(VariableType type) {
		switch (type) {
			case TEXT:
				return String.class;
			case INTEGER:
				return Long.class;
			case DECIMAL:
				return Double.class;
			case DATE:
			case DATETIME:
			case TIME:
				return java.util.Date.class;
			case OBJECT:
				return Object.class;
			case ARRAY:
				return List.class;
			case BOOLEAN:
				return Boolean.class;

		}
		return null;
	}

	public static Object getDefaultForVarType(VariableType type) {
		switch (type) {
			case TEXT:
			case OBJECT:
				return "";
			case INTEGER:
				return new Integer(0);
			case DECIMAL:
				return new Double(0.0d);
			case DATE:
				try {
					return SimpleDateFormat.getDateInstance(DateFormat.SHORT).parse(DATE_FORMATTER.format(new Date()));
				} catch (ParseException e) {
					e.printStackTrace();
					return new Date();
				}
			case DATETIME:
				try {
					return SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).parse(
							DATETIME_FORMATTER.format(new Date()));
				} catch (ParseException e) {
					e.printStackTrace();
					return new Date();
				}
			case TIME:
				try {
					return SimpleDateFormat.getTimeInstance(DateFormat.SHORT).parse(TIME_FORMATTER.format(new Date()));
				} catch (ParseException e) {
					e.printStackTrace();
					return new Date();
				}
			case BOOLEAN:
				return Boolean.FALSE;
			case ARRAY:
				return Collections.EMPTY_LIST;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String arrayLiteral = "[a,[b],c,[\"a\",\"b\",\"ccc\"c\"]]";
		List array = parseArray(arrayLiteral);
		for (Object o : array) {
			if (o instanceof List) {
				List oa = (List) o;
				System.out.print("[");
				for (Object a : oa) {
					System.out.print(a + ",");
				}
				System.out.print("],");
			} else
				System.out.print(o + ",");
		}
		System.out.println();

		String formatted = formatArray(array);

		array = parseArray(formatted);
		for (Object o : array) {
			if (o instanceof List) {
				List oa = (List) o;
				System.out.print("[");
				for (Object a : oa) {
					System.out.print(a + ",");
				}
				System.out.print("],");
			} else
				System.out.print(o + ",");
		}

		// formatted = formatArray(new Object[]{"a",new Object[]{"b"},"c"});
		formatted = formatArray(array);

		Date d = parseDate("Thu Oct 02 2008 13:02:36 GMT-0800 (PST)");
		System.out.println("Got tamd date " + DATETIME_FORMATTER.format(d));
	}

	public static VariableType getVarTypeForClass(Class<?> typeClass) {

		if (Date.class.isAssignableFrom(typeClass)) {
			return VariableType.DATE;
		}
		if (Long.class.isAssignableFrom(typeClass) || BigInteger.class.isAssignableFrom(typeClass)) {
			return VariableType.INTEGER;
		}
		if (Double.class.isAssignableFrom(typeClass) || BigDecimal.class.isAssignableFrom(typeClass)) {
			return VariableType.DECIMAL;
		}
		if (Number.class.isAssignableFrom(typeClass)) {
			return VariableType.DECIMAL;
		}
		if (Boolean.class.isAssignableFrom(typeClass)) {
			return VariableType.BOOLEAN;
		}
		if (List.class.isAssignableFrom(typeClass)) {
			return VariableType.ARRAY;
		}
		if (Object[].class.isAssignableFrom(typeClass)) {
			return VariableType.ARRAY;
		}
		if (String.class.isAssignableFrom(typeClass)) {
			return VariableType.TEXT;
		}
		if (typeClass != null && typeClass.isPrimitive()) {
			if (long.class.isAssignableFrom(typeClass) || short.class.isAssignableFrom(typeClass)
					|| int.class.isAssignableFrom(typeClass)) {
				return VariableType.INTEGER;
			}
			if (double.class.isAssignableFrom(typeClass) || float.class.isAssignableFrom(typeClass)) {
				return VariableType.DECIMAL;
			}
			if (float.class.isAssignableFrom(typeClass)) {
				return VariableType.DECIMAL;
			}
			if (boolean.class.isAssignableFrom(typeClass)) {
				return VariableType.BOOLEAN;
			}
		}
		return VariableType.OBJECT;
	}

}
