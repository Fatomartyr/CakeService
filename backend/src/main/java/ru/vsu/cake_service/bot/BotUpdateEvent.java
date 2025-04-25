package ru.vsu.cake_service.bot;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class BotUpdateEvent extends ApplicationEvent {
    private final Update update;

    public BotUpdateEvent(Object source, Update update) {
        super(source);
        this.update = update;
    }
}

