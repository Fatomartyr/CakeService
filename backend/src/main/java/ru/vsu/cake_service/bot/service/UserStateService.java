package ru.vsu.cake_service.bot.service;

import org.springframework.stereotype.Service;
import ru.vsu.cake_service.bot.UserState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserStateService {
    private final Map<Long, UserState> userStates = new ConcurrentHashMap<>();

    public void setState(Long chatId, UserState state) {
        userStates.put(chatId, state);
    }

    public UserState getState(Long chatId) {
        return userStates.getOrDefault(chatId, UserState.NONE);
    }

    public void resetState(Long chatId) {
        userStates.put(chatId, UserState.NONE);
    }
}
