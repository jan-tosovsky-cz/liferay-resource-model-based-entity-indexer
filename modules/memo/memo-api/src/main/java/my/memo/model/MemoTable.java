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

package my.memo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;memo_Memo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Memo
 * @generated
 */
public class MemoTable extends BaseTable<MemoTable> {

	public static final MemoTable INSTANCE = new MemoTable();

	public final Column<MemoTable, Long> memoId = createColumn(
		"memoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MemoTable, Long> resourcePrimKey = createColumn(
		"resourcePrimKey", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MemoTable, String> text = createColumn(
		"text_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MemoTable, String> summary = createColumn(
		"summary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Boolean> latest = createColumn(
		"latest", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Boolean> main = createColumn(
		"main", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemoTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemoTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MemoTable() {
		super("memo_Memo", MemoTable::new);
	}

}