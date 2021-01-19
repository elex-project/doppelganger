/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public final class JavaDB extends BaseDatabase {
	/**
	 * * jdbc:derby:memory:test;create=true
	 * * jdbc:derby:test
	 */
	public static final class Builder extends AbsBuilder<JavaDB> {
		private String filePath;

		public Builder() {
			super();
		}

		public Builder fileName(String filePath) {
			this.filePath = filePath;
			return this;
		}

		@NotNull
		@Contract(pure = true)
		@Override
		protected String getConnectionString() {
			return getConnectionStringJavaDB(filePath);
		}

		@NotNull
		@Contract(" -> new")
		@Override
		public JavaDB build() throws SQLException {
			return new JavaDB(getConnectionString());
		}
	}

	public JavaDB(String connString) throws SQLException {
		super(connString);
	}

	public static JavaDB mem(final String dbName) throws SQLException {
		return new JavaDB("jdbc:derby:memory:" + dbName + ";create=true");
	}
}
