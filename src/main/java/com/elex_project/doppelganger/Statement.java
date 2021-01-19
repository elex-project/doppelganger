/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public final class Statement extends BaseStatementWrapper{

	public Statement(final java.sql.Statement statement) {
		super(statement);
	}

	public @NotNull CompletableFuture<Integer> executeUpdate(final String sql, final @NotNull ExecutorService executorService) {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeUpdate(sql));
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<Boolean> execute(final String sql, final @NotNull ExecutorService executorService) {
		final CompletableFuture<Boolean> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(execute(sql));
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<ResultSet> executeQuery(final String sql, final @NotNull ExecutorService executorService) {
		final CompletableFuture<ResultSet> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeQuery(sql));
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<int[]> executeBatch(final @NotNull ExecutorService executorService) {
		final CompletableFuture<int[]> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeBatch());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public ResultSet executeQuery(final String sql) throws SQLException {
		return new ResultSet(super.executeQuery(sql));
	}


}
