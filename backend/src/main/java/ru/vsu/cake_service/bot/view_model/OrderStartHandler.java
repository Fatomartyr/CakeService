package ru.vsu.cake_service.bot.view_model;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.vsu.cake_service.bot.BotUpdateEvent;
import ru.vsu.cake_service.bot.service.SendMessageService;
import ru.vsu.cake_service.bot.service.UserStateService;

import java.util.List;

@Component
public class OrderStartHandler {

    private final SendMessageService sendMessageService;
    private final UserStateService userStateService;

    public OrderStartHandler(SendMessageService sendMessageService, UserStateService userStateService) {
        this.sendMessageService = sendMessageService;
        this.userStateService = userStateService;
    }

    @EventListener
    public void onBotUpdate(BotUpdateEvent event) {
        Update update = event.getUpdate();

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            Long chatId = update.getMessage().getChatId();

            sendMessageService.sendMessage(chatId, "Добро пожаловать в службу заказа тортов! 🎂");
            InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton orderButton = new InlineKeyboardButton("Заказать торт по фото");
            orderButton.setCallbackData("order_photo");
            keyboardMarkup.setKeyboard(List.of(List.of(orderButton)));

            sendMessageService.sendMessage(chatId, "Нажмите на кнопку ниже, чтобы начать заказ.", keyboardMarkup);
        }
    }
}

