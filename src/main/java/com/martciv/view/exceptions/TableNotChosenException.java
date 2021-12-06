package com.martciv.view.exceptions;

public class TableNotChosenException extends ViewException {
    public TableNotChosenException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public TableNotChosenException() {
        super("Table not chosen;");
    }
}