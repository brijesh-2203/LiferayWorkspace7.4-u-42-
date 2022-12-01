/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package userapp.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;App_App&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see App
 * @generated
 */
public class AppTable extends BaseTable<AppTable> {

	public static final AppTable INSTANCE = new AppTable();

	public final Column<AppTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppTable, String> appId = createColumn(
		"appId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AppTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppTable, String> logoUrl = createColumn(
		"logoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AppTable() {
		super("App_App", AppTable::new);
	}

}