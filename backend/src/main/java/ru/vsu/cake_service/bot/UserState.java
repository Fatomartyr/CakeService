package ru.vsu.cake_service.bot;

public enum UserState {
    NONE,
    WAITING_FOR_PHOTO,
    WAITING_FOR_CARD_NUMBER,
    WAITING_FOR_EXPIRY,
    WAITING_FOR_CVV,
    ORDER_CONFIRMED
}
