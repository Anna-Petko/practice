package ru.bellintegrator.practice.organization.exception;

import java.util.Objects;

public class NoSuchEntityDaoException extends RuntimeException {
	private String message;

	public NoSuchEntityDaoException(String message) {
		Objects.requireNonNull(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
