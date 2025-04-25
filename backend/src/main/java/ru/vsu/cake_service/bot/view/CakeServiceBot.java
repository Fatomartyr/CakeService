package ru.vsu.cake_service.bot.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vsu.cake_service.bot.BotUpdateEvent;

@Component
public class CakeServiceBot extends TelegramLongPollingBot {

    private final ApplicationEventPublisher publisher;

    public CakeServiceBot(@Value("${bot.token}") String token,
                          ApplicationEventPublisher publisher) {
        super(token);
        this.publisher = publisher;
    }

    @Override
    public void onUpdateReceived(Update update) {
        publisher.publishEvent(new BotUpdateEvent(this, update));
    }

    @Override
    public String getBotUsername() {
        return "FatomartyrCakeBot";
    }
}
