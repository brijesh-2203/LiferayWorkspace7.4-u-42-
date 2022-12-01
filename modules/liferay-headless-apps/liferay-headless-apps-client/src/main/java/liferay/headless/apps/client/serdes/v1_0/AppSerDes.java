package liferay.headless.apps.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import liferay.headless.apps.client.dto.v1_0.App;
import liferay.headless.apps.client.json.BaseJSONParser;

/**
 * @author root322
 * @generated
 */
@Generated("")
public class AppSerDes {

	public static App toDTO(String json) {
		AppJSONParser appJSONParser = new AppJSONParser();

		return appJSONParser.parseToDTO(json);
	}

	public static App[] toDTOs(String json) {
		AppJSONParser appJSONParser = new AppJSONParser();

		return appJSONParser.parseToDTOs(json);
	}

	public static String toJSON(App app) {
		if (app == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (app.getAppId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appId\": ");

			sb.append("\"");

			sb.append(_escape(app.getAppId()));

			sb.append("\"");
		}

		if (app.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(app.getDescription()));

			sb.append("\"");
		}

		if (app.getLink() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"link\": ");

			sb.append("\"");

			sb.append(_escape(app.getLink()));

			sb.append("\"");
		}

		if (app.getLogoUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"logoUrl\": ");

			sb.append("\"");

			sb.append(_escape(app.getLogoUrl()));

			sb.append("\"");
		}

		if (app.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(app.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AppJSONParser appJSONParser = new AppJSONParser();

		return appJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(App app) {
		if (app == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (app.getAppId() == null) {
			map.put("appId", null);
		}
		else {
			map.put("appId", String.valueOf(app.getAppId()));
		}

		if (app.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(app.getDescription()));
		}

		if (app.getLink() == null) {
			map.put("link", null);
		}
		else {
			map.put("link", String.valueOf(app.getLink()));
		}

		if (app.getLogoUrl() == null) {
			map.put("logoUrl", null);
		}
		else {
			map.put("logoUrl", String.valueOf(app.getLogoUrl()));
		}

		if (app.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(app.getName()));
		}

		return map;
	}

	public static class AppJSONParser extends BaseJSONParser<App> {

		@Override
		protected App createDTO() {
			return new App();
		}

		@Override
		protected App[] createDTOArray(int size) {
			return new App[size];
		}

		@Override
		protected void setField(
			App app, String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "appId")) {
				if (jsonParserFieldValue != null) {
					app.setAppId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					app.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "link")) {
				if (jsonParserFieldValue != null) {
					app.setLink((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "logoUrl")) {
				if (jsonParserFieldValue != null) {
					app.setLogoUrl((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					app.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}