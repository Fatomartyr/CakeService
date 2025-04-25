package ru.vsu.cake_service.bot;

import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.vsu.cake_service.bot.view.CakeServiceBot;

@Component
@AllArgsConstructor
public class BotInitializer {
    private final CakeServiceBot cakeServiceBot;


    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(cakeServiceBot);
        }
        catch (TelegramApiException e) {
            System.out.println("Error with bot initialization: " + e.getMessage());
        }
    }

}