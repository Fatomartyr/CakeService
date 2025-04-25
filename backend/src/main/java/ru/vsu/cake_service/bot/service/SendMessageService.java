package ru.vsu.cake_service.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageService {
    private final TelegramLongPollingBot bot;

    public SendMessageService(TelegramLongPollingBot bot) {
        this.bot = bot;
    }

    public void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Send message error: " + e.getMessage());
        }
    }

    public void sendMessage(Long chatId, String text, InlineKeyboardMarkup markup) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        message.setReplyMarkup(markup);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Send message error: " + e.getMessage());
        }
    }
}
