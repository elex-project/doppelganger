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

public final class H2DB extends BaseDatabase {
	/**
	 * * jdbc:h2:~/test
	 *
	 *   임베디드 모드. 사용자 홈 디렉토리의 'test'.
	 *
	 * * jdbc:h2:mem:test
	 *
	 *   인메모리 모드. 'test' 데이터베이스
	 *
	 * * jdbc:h2:tcp://localhost//opt/server
	 *
	 *   서버 모드.
	 */
	public static final class Builder extends AbsBuilder<H2DB> {
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
			return getConnectionStringH2DB(filePath);
		}

		@NotNull
		@Contract(" -> new")
		@Override
		public H2DB build() throws SQLException {
			return new H2DB(getConnectionString());
		}
	}

	public H2DB(String connString) throws SQLException {
		super(connString);
	}

	public static H2DB mem(final String dbName) throws SQLException {
		return new H2DB("jdbc:h2:mem:"+dbName);
	}
}
