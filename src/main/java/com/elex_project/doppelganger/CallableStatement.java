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

public final class CallableStatement extends BaseCallableStatementWrapper {
	public CallableStatement(final java.sql.CallableStatement statement) {
		super(statement);
	}

	public @NotNull CompletableFuture<Integer> executeUpdate(final @NotNull ExecutorService executorService) {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeUpdate());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<Boolean> execute(final @NotNull ExecutorService executorService) {
		final CompletableFuture<Boolean> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(execute());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<ResultSet> executeQuery(final @NotNull ExecutorService executorService) {
		final CompletableFuture<ResultSet> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeQuery());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return new ResultSet(super.executeQuery());
	}
}
