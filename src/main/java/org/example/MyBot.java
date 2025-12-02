package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessages;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        MyBotService myBotService = new MyBotService();
        MyBotServiceRu myBotServiceRu = new MyBotServiceRu();
        MyBotServiceEn myBotServiceEn = new MyBotServiceEn();

        if (update.hasMessage() && update.getMessage().hasContact()) {
            Long chatId = update.getMessage().getChatId();
            Integer messageId = update.getMessage().getMessageId();
            Contact contact = update.getMessage().getContact();

            try {
                List<Integer> ids = new ArrayList<>();
                ids.add(messageId);
                ids.add(messageId - 1);
                DeleteMessages deleteMessages = new DeleteMessages();
                deleteMessages.setChatId(chatId);
                deleteMessages.setMessageIds(ids);
                execute(deleteMessages);
                execute(myBotService.shahar(chatId));
            } catch (RuntimeException | TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            Integer messageId = update.getMessage().getMessageId();
            String firstName = update.getMessage().getChat().getFirstName();

            System.out.println(text);

            if (text.equals("/start")) {
                try {
                    System.out.println(firstName);
                    execute(myBotService.lan(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Biz haqimizda")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.biz(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Наша история")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.biz(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Our History")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.biz(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Yutuqlarimiz")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.yutuq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Наши достижения")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.yutuq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Our Achievenments")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.yutuq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Store (\uD83C\uDDFA\uD83C\uDDFF)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.store(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Store (\uD83C\uDDF7\uD83C\uDDFA)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.store(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Store (\uD83C\uDDEC\uD83C\uDDE7)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.store(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⛰ Atrof-muhit")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.muhit(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⛰ Окружающая среда")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.muhit(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⛰ Environment")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.muhit(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66\u200D\uD83D\uDC66 Oila")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.oila(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66\u200D\uD83D\uDC66 Семья")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.oila(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66\u200D\uD83D\uDC66 Family")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.oila(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDBD\u200D➡\uFE0F Inklyuziya")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.inkl(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDBD\u200D➡\uFE0F Инклюзия")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.inkl(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDBD\u200D➡\uFE0F Inclusion")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.inkl(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Catering (\uD83C\uDDFA\uD83C\uDDFF)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.catering(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Catering (\uD83C\uDDF7\uD83C\uDDFA)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.catering(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Safia Catering (\uD83C\uDDEC\uD83C\uDDE7)")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.catering(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Afzalliklarimiz")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.afzal(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Наши преимущества")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.afzal(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Our Advantages")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.afzal(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Hamkorlarimiz")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotService.hamkor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Наши партнёры")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceRu.hamkor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Our Partners")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId - 1);
                    execute(deleteMessage);
                    execute(myBotServiceEn.hamkor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF70 Mazali shirinliklar bu yerda")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Yumaloq tortlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.yumaloqtort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("To'g'ri burchakli tortlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.togriburchakli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Mini tortlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.minitort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Katta piroglar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.kattapirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Yumaloq piroglar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.yumaloqpirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Pirojniylar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.pirojniy(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Ruletlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.rulet(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Eklerlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.ekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Makaronslar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.makarons(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Tayyor taomlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.tayyortaom(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Shirinliklar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.shirinlik(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Pechenye")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.pechenye(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Qadoqdagi eklerlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.qadoqekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Shirin pishiriqlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.shirinpishiriq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Kekslar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.keks(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Tartaletkalar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.tartaletka(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Qatlamali pishiriqlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.qatlamali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("To'yimli pishiriq")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.toyimli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Zanjabilli praynik")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.zanjabilli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F Ortga")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF70 Вкусные сладости здесь")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Круглые торты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.yumaloqtort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Прямоугольные торты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.togriburchakli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Мини торты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.minitort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Большие пироги")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.kattapirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Круглые пироги")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.yumaloqpirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Пирожные")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.pirojniy(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Рулеты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.rulet(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Эклеры")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.ekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Макаронс")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.makarons(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Готовые блюда")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.tayyortaom(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Сладости")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.shirinlik(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Печенье")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.pechenye(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Упакованные эклеры")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.qadoqekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Сладкая выпечка")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.shirinpishiriq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Кексы")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.keks(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Тарталетки")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.tartaletka(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Слоеная выпечка")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.qatlamali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Сытная выпечка")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.toyimli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Имбирный пряник")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.zanjabilli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F Назад")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF70 Delicious sweets here")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Round cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.yumaloqtort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Rectangle cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.togriburchakli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Mini cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.minitort(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Big pies")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.kattapirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Round pies")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.yumaloqpirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Pastries")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.pirojniy(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Rolls")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.rulet(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Eclairs")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.ekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Macarons")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.makarons(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Prepared meals")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.tayyortaom(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Sweets")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.shirinlik(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Cookies")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.pechenye(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Packaged eclairs")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.qadoqekler(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Desserts")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.shirinpishiriq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.keks(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Tartlets")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.tartaletka(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Layered pastries")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.qatlamali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Hearty pastries")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.toyimli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Gingerbread")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.zanjabilli(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅️ Back")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.mazali(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD57 To'g'ri ovqatlanish shirinliklari")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.togriovqatlanish(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("TO Piroglar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.topirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("TO Yarim tayyor mahsulotlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.toyarimtayyor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("TO Tortlari (PP)")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.totortpp(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("TO Pishiriqlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.topishiriq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("TO Pirojniylar (PP)")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.topirojniypp(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F Ortga TO")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.togriovqatlanish(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD57 Диетические сладости")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.togriovqatlanish(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ПП Пироги")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.topirog(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ПП Полуфабрикаты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.toyarimtayyor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ПП Торты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.totortpp(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ПП Выпечка")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.topishiriq(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("ПП Пирожные")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.topirojniypp(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅️ Назад ПП")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.togriovqatlanish(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD57 Proper nutrition sweets")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.togriovqatlanish(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("PN Pies")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.topirog(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("PN Semi-finished products")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.toyarimtayyor(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("PN Cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.totortpp(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("PN Pastries")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.topishiriq(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("PN Petit cakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.topirojniypp(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅️ Back to PN")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.togriovqatlanish(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD5F Yarim tayyor mahsulotlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.yarimtayyor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD5F Полуфабрикаты")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.yarimtayyor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD5F Semi-prepared products")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.yarimtayyor(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD56 Avstriya noni")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.non(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD56 Австрийский хлеб")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.non(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDD56 Austrian bread")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.non(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF79 Bar menyusi")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.barmenyu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF79 Бар меню")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.barmenyu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83C\uDF79 Bar menu")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.barmenyu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Yangi siqilgan sharbatlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.sharbat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Milksheyklar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.milksheyk(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Limonadlar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.limonad(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Qahva")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.kofe(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F Ortga Bar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.barmenyu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("☕\uFE0F Qahva abonementlari")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.qahva(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDDF8 Animatorlar yetkazib berish")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.animatorbn(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDED2 Savatga qo'shish")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.tasdiqlash(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Свежевыжатые соки")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.sharbat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Милкшейки")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.milksheyk(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Лимонады")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.limonad(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Кофе")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.kofe(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅️ Назад к Бару")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.barmenyu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("☕️ Кофейные абонементы")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.qahva(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🧸 Доставка аниматоров")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.animatorbn(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("🛒 Добавить в корзину")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.tasdiqlash(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F Asosiy menyuga")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅\uFE0F В главное меню")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Freshly squeezed juices")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.sharbat(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Milkshakes")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.milksheyk(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Lemonades")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.limonad(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Coffee")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.kofe(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("⬅️ Back to Bar")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.barmenyu(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("☕ Coffee subscriptions")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.qahva(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83E\uDDF8 Animator delivery")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.animatorbn(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDED2 Add to cart")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);

                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);

                    execute(deleteMessages);
                    execute(myBotServiceEn.tasdiqlash(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("❌ Bekor qilish")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.uzmenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("❌ Отмена")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.rumenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("❌ Cancel")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.enmenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDED2 Savat")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.savat(chatId));
                    execute(myBotService.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDED2 Корзина")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.savat(chatId));
                    execute(myBotServiceRu.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("\uD83D\uDED2 Cart")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    ids.add(messageId - 2);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.savat(chatId));
                    execute(myBotServiceEn.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            for (int i = 1; i <= 9; i++) {
                if (text.equals(String.valueOf(i) + " ta")) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tasdiqlash(chatId));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 1; i <= 9; i++) {
                if (text.equals(String.valueOf(i) + " шт")) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tasdiqlash(chatId));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 1; i <= 9; i++) {
                if (text.equals(String.valueOf(i) + " pcs")) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tasdiqlash(chatId));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.yumaloqtort.length - 1; i++) {
                if (text.equals(myBotService.yumaloqtort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.yumaloqtortphoto[i], myBotService.yumaloqtortcaption[i], myBotService.yumaloqtortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.togriburchakli.length - 1; i++) {
                if (text.equals(myBotService.togriburchakli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.togriburchakliphoto[i], myBotService.togriburchaklicaption[i], myBotService.togriburchaklinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.minitort.length - 1; i++) {
                if (text.equals(myBotService.minitort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.minitortphoto[i], myBotService.minitortcaption[i], myBotService.minitortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.pirog.length - 1; i++) {
                if (text.equals(myBotService.pirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.pirogphoto[i], myBotService.pirogcaption[i], myBotService.pirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.yumaloqpirog.length - 1; i++) {
                if (text.equals(myBotService.yumaloqpirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.yumaloqpirogphoto[i], myBotService.yumaloqpirogcaption[i], myBotService.yumaloqpirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.pirojni.length - 1; i++) {
                if (text.equals(myBotService.pirojni[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.pirojniphoto[i], myBotService.pirojnicaption[i], myBotService.pirojninarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.rulet.length - 1; i++) {
                if (text.equals(myBotService.rulet[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.ruletphoto[i], myBotService.ruletcaption[i], myBotService.ruletnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.ekler.length - 1; i++) {
                if (text.equals(myBotService.ekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.eklerphoto[i], myBotService.eklercaption[i], myBotService.eklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.makarons.length - 1; i++) {
                if (text.equals(myBotService.makarons[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.makaronsphoto[i], myBotService.makaronscaption[i], myBotService.makaronsnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.tayyotovqat.length - 1; i++) {
                if (text.equals(myBotService.tayyotovqat[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.tayyorovqatphoto[i], myBotService.tayyorovqatcaption[i], myBotService.tayyorovqatnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.shirinlik.length - 1; i++) {
                if (text.equals(myBotService.shirinlik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.shirinlikphoto[i], myBotService.shirinlikcaption[i], myBotService.shirinliknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.pechenye.length - 1; i++) {
                if (text.equals(myBotService.pechenye[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.pechenyephoto[i], myBotService.pechenyecaption[i], myBotService.pechenyenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.qadoqekler.length - 1; i++) {
                if (text.equals(myBotService.qadoqekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.qadoqeklerphoto[i], myBotService.qadoqeklercaption[i], myBotService.qadoqeklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.shirinpishiriq.length - 1; i++) {
                if (text.equals(myBotService.shirinpishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.shirinpishiriqphoto[i], myBotService.shirinpishiriqcaption[i], myBotService.shirinpishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.keks.length - 1; i++) {
                if (text.equals(myBotService.keks[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.keksphoto[i], myBotService.kekscaption[i], myBotService.keksnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.tartaletka.length - 1; i++) {
                if (text.equals(myBotService.tartaletka[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.tartaletkaphoto[i], myBotService.tartaletkacaption[i], myBotService.tartaletkanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.qatlamali.length - 1; i++) {
                if (text.equals(myBotService.qatlamali[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.qatlamaliphoto[i], myBotService.qatlamalicaption[i], myBotService.qatlamalinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.toyimli.length - 1; i++) {
                if (text.equals(myBotService.toyimli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.toyimliphoto[i], myBotService.toyimlicaption[i], myBotService.toyimlinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.praynik.length - 1; i++) {
                if (text.equals(myBotService.praynik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.zanjabilliphoto[i], myBotService.zanjabillicaption[i], myBotService.zanjabillinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.topirog.length - 1; i++) {
                if (text.equals(myBotService.topirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.topirogphoto[i], myBotService.topirogcaption[i], myBotService.topirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.toyarimtayyor.length - 1; i++) {
                if (text.equals(myBotService.toyarimtayyor[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.toyarimtayyorphoto[i], myBotService.toyarimtayyorcaption[i], myBotService.toyarimtayyornarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.totortpp.length - 1; i++) {
                if (text.equals(myBotService.totortpp[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.totortppphoto[i], myBotService.totortppcaption[i], myBotService.totortppnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.topishiriq.length - 1; i++) {
                if (text.equals(myBotService.topishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.topishiriqphoto[i], myBotService.topishiriqcaption[i], myBotService.topishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.topirojniypp.length - 1; i++) {
                if (text.equals(myBotService.topirojniypp[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.topirojniyppphoto[i], myBotService.topirojniyppcaption[i], myBotService.topirojniyppnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.yarimtayyor.length - 1; i++) {
                if (text.equals(myBotService.yarimtayyor[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.yarimtayyorphoto[i], myBotService.yarimtayyorcaption[i], myBotService.yarimtayyornarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.non.length - 1; i++) {
                if (text.equals(myBotService.non[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.nonphoto[i], myBotService.noncaption[i], myBotService.nonnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.yangisiqilgan.length - 1; i++) {
                if (text.equals(myBotService.yangisiqilgan[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.yangisiqilganphoto[i], myBotService.yangisiqilgancaption[i], myBotService.yangisiqilgannarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.milksheyk.length - 1; i++) {
                if (text.equals(myBotService.milksheyk[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.milksheykphoto[i], myBotService.milksheykcaption[i], myBotService.milksheyknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.limonad.length - 1; i++) {
                if (text.equals(myBotService.limonad[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.limonadphoto[i], myBotService.limonadcaption[i], myBotService.limonadnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.kofe.length - 1; i++) {
                if (text.equals(myBotService.kofe[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.kofephoto[i], myBotService.kofecaption[i], myBotService.kofenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotService.qahva.length - 1; i++) {
                if (text.equals(myBotService.qahva[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotService.tovar(chatId, myBotService.qahvaphoto[i], myBotService.qahvacaption[i], myBotService.qahvanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.yumaloqtort.length - 1; i++) {
                if (text.equals(myBotServiceRu.yumaloqtort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.yumaloqtortphoto[i], myBotServiceRu.yumaloqtortcaption[i], myBotServiceRu.yumaloqtortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.togriburchakli.length - 1; i++) {
                if (text.equals(myBotServiceRu.togriburchakli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.togriburchakliphoto[i], myBotServiceRu.togriburchaklicaption[i], myBotServiceRu.togriburchaklinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.minitort.length - 1; i++) {
                if (text.equals(myBotServiceRu.minitort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.minitortphoto[i], myBotServiceRu.minitortcaption[i], myBotServiceRu.minitortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.pirog.length - 1; i++) {
                if (text.equals(myBotServiceRu.pirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.pirogphoto[i], myBotServiceRu.pirogcaption[i], myBotServiceRu.pirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.yumaloqpirog.length - 1; i++) {
                if (text.equals(myBotServiceRu.yumaloqpirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.yumaloqpirogphoto[i], myBotServiceRu.yumaloqpirogcaption[i], myBotServiceRu.yumaloqpirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.pirojni.length - 1; i++) {
                if (text.equals(myBotServiceRu.pirojni[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.pirojniphoto[i], myBotServiceRu.pirojnicaption[i], myBotServiceRu.pirojninarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.rulet.length - 1; i++) {
                if (text.equals(myBotServiceRu.rulet[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.ruletphoto[i], myBotServiceRu.ruletcaption[i], myBotServiceRu.ruletnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.ekler.length - 1; i++) {
                if (text.equals(myBotServiceRu.ekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.eklerphoto[i], myBotServiceRu.eklercaption[i], myBotServiceRu.eklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.makarons.length - 1; i++) {
                if (text.equals(myBotServiceRu.makarons[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.makaronsphoto[i], myBotServiceRu.makaronscaption[i], myBotServiceRu.makaronsnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.tayyotovqat.length - 1; i++) {
                if (text.equals(myBotServiceRu.tayyotovqat[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.tayyorovqatphoto[i], myBotServiceRu.tayyorovqatcaption[i], myBotServiceRu.tayyorovqatnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.shirinlik.length - 1; i++) {
                if (text.equals(myBotServiceRu.shirinlik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.shirinlikphoto[i], myBotServiceRu.shirinlikcaption[i], myBotServiceRu.shirinliknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.pechenye.length - 1; i++) {
                if (text.equals(myBotServiceRu.pechenye[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.pechenyephoto[i], myBotServiceRu.pechenyecaption[i], myBotServiceRu.pechenyenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.qadoqekler.length - 1; i++) {
                if (text.equals(myBotServiceRu.qadoqekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.qadoqeklerphoto[i], myBotServiceRu.qadoqeklercaption[i], myBotServiceRu.qadoqeklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.shirinpishiriq.length - 1; i++) {
                if (text.equals(myBotServiceRu.shirinpishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.shirinpishiriqphoto[i], myBotServiceRu.shirinpishiriqcaption[i], myBotServiceRu.shirinpishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.keks.length - 1; i++) {
                if (text.equals(myBotServiceRu.keks[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.keksphoto[i], myBotServiceRu.kekscaption[i], myBotServiceRu.keksnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.tartaletka.length - 1; i++) {
                if (text.equals(myBotServiceRu.tartaletka[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.tartaletkaphoto[i], myBotServiceRu.tartaletkacaption[i], myBotServiceRu.tartaletkanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.qatlamali.length - 1; i++) {
                if (text.equals(myBotServiceRu.qatlamali[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.qatlamaliphoto[i], myBotServiceRu.qatlamalicaption[i], myBotServiceRu.qatlamalinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.toyimli.length - 1; i++) {
                if (text.equals(myBotServiceRu.toyimli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.toyimliphoto[i], myBotServiceRu.toyimlicaption[i], myBotServiceRu.toyimlinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.praynik.length - 1; i++) {
                if (text.equals(myBotServiceRu.praynik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.zanjabilliphoto[i], myBotServiceRu.zanjabillicaption[i], myBotServiceRu.zanjabillinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.ppPirog.length - 1; i++) {
                if (text.equals(myBotServiceRu.ppPirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.ppPirogPhoto[i], myBotServiceRu.ppPirogCaption[i], myBotServiceRu.ppPirogNarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.ppPolufab.length - 1; i++) {
                if (text.equals(myBotServiceRu.ppPolufab[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.ppPolufabPhoto[i], myBotServiceRu.ppPolufabCaption[i], myBotServiceRu.ppPolufabNarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.ppTort.length - 1; i++) {
                if (text.equals(myBotServiceRu.ppTort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.ppTortPhoto[i], myBotServiceRu.ppTortCaption[i], myBotServiceRu.ppTortNarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.topishiriq.length - 1; i++) {
                if (text.equals(myBotServiceRu.topishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.topishiriqphoto[i], myBotServiceRu.topishiriqcaption[i], myBotServiceRu.topishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.ppPiroj.length - 1; i++) {
                if (text.equals(myBotServiceRu.ppPiroj[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.ppPirojPhoto[i], myBotServiceRu.ppPirojCaption[i], myBotServiceRu.ppPirojCaption[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.yarimtayyor.length - 1; i++) {
                if (text.equals(myBotServiceRu.yarimtayyor[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.yarimtayyorphoto[i], myBotServiceRu.yarimtayyorcaption[i], myBotServiceRu.yarimtayyornarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.non.length - 1; i++) {
                if (text.equals(myBotServiceRu.non[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.nonphoto[i], myBotServiceRu.noncaption[i], myBotServiceRu.nonnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.yangisiqilgan.length - 1; i++) {
                if (text.equals(myBotServiceRu.yangisiqilgan[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.yangisiqilganphoto[i], myBotServiceRu.yangisiqilgancaption[i], myBotServiceRu.yangisiqilgannarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.milksheyk.length - 1; i++) {
                if (text.equals(myBotServiceRu.milksheyk[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.milksheykphoto[i], myBotServiceRu.milksheykcaption[i], myBotServiceRu.milksheyknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.limonad.length - 1; i++) {
                if (text.equals(myBotServiceRu.limonad[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.limonadphoto[i], myBotServiceRu.limonadcaption[i], myBotServiceRu.limonadnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.kofe.length - 1; i++) {
                if (text.equals(myBotServiceRu.kofe[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.kofephoto[i], myBotServiceRu.kofecaption[i], myBotServiceRu.kofenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceRu.qahva.length - 1; i++) {
                if (text.equals(myBotServiceRu.qahva[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceRu.tovar(chatId, myBotServiceRu.qahvaphoto[i], myBotServiceRu.qahvacaption[i], myBotServiceRu.qahvanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.yumaloqtort.length - 1; i++) {
                if (text.equals(myBotServiceEn.yumaloqtort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.yumaloqtortphoto[i], myBotServiceEn.yumaloqtortcaption[i], myBotServiceEn.yumaloqtortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.togriburchakli.length - 1; i++) {
                if (text.equals(myBotServiceEn.togriburchakli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.togriburchakliphoto[i], myBotServiceEn.togriburchaklicaption[i], myBotServiceEn.togriburchaklinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.minitort.length - 1; i++) {
                if (text.equals(myBotServiceEn.minitort[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.minitortphoto[i], myBotServiceEn.minitortcaption[i], myBotServiceEn.minitortnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.pirog.length - 1; i++) {
                if (text.equals(myBotServiceEn.pirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.pirogphoto[i], myBotServiceEn.pirogcaption[i], myBotServiceEn.pirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.yumaloqpirog.length - 1; i++) {
                if (text.equals(myBotServiceEn.yumaloqpirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.yumaloqpirogphoto[i], myBotServiceEn.yumaloqpirogcaption[i], myBotServiceEn.yumaloqpirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.pirojni.length - 1; i++) {
                if (text.equals(myBotServiceEn.pirojni[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.pirojniphoto[i], myBotServiceEn.pirojnicaption[i], myBotServiceEn.pirojninarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.rulet.length - 1; i++) {
                if (text.equals(myBotServiceEn.rulet[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.ruletphoto[i], myBotServiceEn.ruletcaption[i], myBotServiceEn.ruletnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.ekler.length - 1; i++) {
                if (text.equals(myBotServiceEn.ekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.eklerphoto[i], myBotServiceEn.eklercaption[i], myBotServiceEn.eklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.makarons.length - 1; i++) {
                if (text.equals(myBotServiceEn.makarons[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.makaronsphoto[i], myBotServiceEn.makaronscaption[i], myBotServiceEn.makaronsnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.tayyotovqat.length - 1; i++) {
                if (text.equals(myBotServiceEn.tayyotovqat[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.tayyorovqatphoto[i], myBotServiceEn.tayyorovqatcaption[i], myBotServiceEn.tayyorovqatnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.shirinlik.length - 1; i++) {
                if (text.equals(myBotServiceEn.shirinlik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.shirinlikphoto[i], myBotServiceEn.shirinlikcaption[i], myBotServiceEn.shirinliknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.pechenye.length - 1; i++) {
                if (text.equals(myBotServiceEn.pechenye[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.pechenyephoto[i], myBotServiceEn.pechenyecaption[i], myBotServiceEn.pechenyenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.qadoqekler.length - 1; i++) {
                if (text.equals(myBotServiceEn.qadoqekler[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.qadoqeklerphoto[i], myBotServiceEn.qadoqeklercaption[i], myBotServiceEn.qadoqeklernarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.shirinpishiriq.length - 1; i++) {
                if (text.equals(myBotServiceEn.shirinpishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.shirinpishiriqphoto[i], myBotServiceEn.shirinpishiriqcaption[i], myBotServiceEn.shirinpishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.keks.length - 1; i++) {
                if (text.equals(myBotServiceEn.keks[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.keksphoto[i], myBotServiceEn.kekscaption[i], myBotServiceEn.keksnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.tartaletka.length - 1; i++) {
                if (text.equals(myBotServiceEn.tartaletka[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.tartaletkaphoto[i], myBotServiceEn.tartaletkacaption[i], myBotServiceEn.tartaletkanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.qatlamali.length - 1; i++) {
                if (text.equals(myBotServiceEn.qatlamali[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.qatlamaliphoto[i], myBotServiceEn.qatlamalicaption[i], myBotServiceEn.qatlamalinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.toyimli.length - 1; i++) {
                if (text.equals(myBotServiceEn.toyimli[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.toyimliphoto[i], myBotServiceEn.toyimlicaption[i], myBotServiceEn.toyimlinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.praynik.length - 1; i++) {
                if (text.equals(myBotServiceEn.praynik[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.zanjabilliphoto[i], myBotServiceEn.zanjabillicaption[i], myBotServiceEn.zanjabillinarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.topirog.length - 1; i++) {
                if (text.equals(myBotServiceEn.topirog[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.topirogphoto[i], myBotServiceEn.topirogcaption[i], myBotServiceEn.topirognarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.toyarimtayyor.length - 1; i++) {
                if (text.equals(myBotServiceEn.toyarimtayyor[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.toyarimtayyorphoto[i], myBotServiceEn.toyarimtayyorcaption[i], myBotServiceEn.toyarimtayyornarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.totortpp.length - 1; i++) {
                if (text.equals(myBotServiceEn.totortpp[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.totortppphoto[i], myBotServiceEn.totortppcaption[i], myBotServiceEn.totortppnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.topishiriq.length - 1; i++) {
                if (text.equals(myBotServiceEn.topishiriq[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.topishiriqphoto[i], myBotServiceEn.topishiriqcaption[i], myBotServiceEn.topishiriqnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.topirojniypp.length - 1; i++) {
                if (text.equals(myBotServiceEn.topirojniypp[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.topirojniyppphoto[i], myBotServiceEn.topirojniyppcaption[i], myBotServiceEn.topirojniyppnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.yarimtayyor.length - 1; i++) {
                if (text.equals(myBotServiceEn.yarimtayyor[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.yarimtayyorphoto[i], myBotServiceEn.yarimtayyorcaption[i], myBotServiceEn.yarimtayyornarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.non.length - 1; i++) {
                if (text.equals(myBotServiceEn.non[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.nonphoto[i], myBotServiceEn.noncaption[i], myBotServiceEn.nonnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.yangisiqilgan.length - 1; i++) {
                if (text.equals(myBotServiceEn.yangisiqilgan[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.yangisiqilganphoto[i], myBotServiceEn.yangisiqilgancaption[i], myBotServiceEn.yangisiqilgannarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.milksheyk.length - 1; i++) {
                if (text.equals(myBotServiceEn.milksheyk[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.milksheykphoto[i], myBotServiceEn.milksheykcaption[i], myBotServiceEn.milksheyknarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.limonad.length - 1; i++) {
                if (text.equals(myBotServiceEn.limonad[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.limonadphoto[i], myBotServiceEn.limonadcaption[i], myBotServiceEn.limonadnarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.kofe.length - 1; i++) {
                if (text.equals(myBotServiceEn.kofe[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.kofephoto[i], myBotServiceEn.kofecaption[i], myBotServiceEn.kofenarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (int i = 0; i < myBotServiceEn.qahva.length - 1; i++) {
                if (text.equals(myBotServiceEn.qahva[i])) {
                    try {
                        List<Integer> ids = new ArrayList<>();
                        ids.add(messageId);
                        ids.add(messageId - 1);
                        DeleteMessages deleteMessages = new DeleteMessages();
                        deleteMessages.setChatId(chatId);
                        deleteMessages.setMessageIds(ids);
                        execute(deleteMessages);
                        execute(myBotServiceEn.tovar(chatId, myBotServiceEn.qahvaphoto[i], myBotServiceEn.qahvacaption[i], myBotServiceEn.qahvanarx[i]));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Long chatId = callbackQuery.getMessage().getChatId();
            String data = callbackQuery.getData();
            Integer messageId = callbackQuery.getMessage().getMessageId();

            System.out.println(data);

            if (data.equals("uzId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.shahar(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("ruId")) {
                try {
                    myBotService.curlan = data;
                    System.out.println(myBotService.curlan);
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setText("Выберите город назначения:");
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.shahar(chatId));

                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("enId")) {
                try {
                    myBotService.curlan = data;
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setText("Select destination city:");
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.shahar(chatId));

                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("haqidaId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("haqidaruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("haqidaenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceEn.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytbizId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytbizruId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytbizenId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.haqida(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qadriyatId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qadriyatruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qadriyatenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceEn.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytqadrId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytqadrruId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytqadrenId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.qadriyat(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("keytingId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("keytingruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("keytingenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceEn.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytkeytId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytkeytruId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytkeytenId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceEn.keytring(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("manzilId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.filial(chatId));
                    execute(myBotService.filialone(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("manzilruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.filial(chatId));
                    execute(myBotServiceRu.filialone(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("manzilenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceEn.filial(chatId));
                    execute(myBotServiceEn.filialone(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextoneId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwo(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (11-20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttwoId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialthree(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (21-30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextthreeId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfour(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (31-40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfourId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfive(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (41-50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfiveId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialsix(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfiveId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialsix(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsixId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialseven(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (61-70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsevenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeight(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (71-80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexteightId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialnine(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (81-90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextnineId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialten(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (91-100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeleven(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (101-110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextelevenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwelve(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (111-120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttwelveId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialthirteen(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (121-131)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextoneruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialtwo(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (11-20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttworuId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialthree(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (21-30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextthreeruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialfour(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (31-40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfourruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialfive(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (41-50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfiveruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialsix(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsixruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialseven(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (61-70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsevenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialeight(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (71-80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexteightruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialnine(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (81-90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextnineruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialten(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (91-100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialeleven(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (101-110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextelevenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialtwelve(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (111-120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttwelveruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialthirteen(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (121-131)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextoneenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialtwo(chatId));
                    editMessageText.setText("Our Branches: 131 (11–20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttwoenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialthree(chatId));
                    editMessageText.setText("Our Branches: 131 (21–30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextthreeenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialfour(chatId));
                    editMessageText.setText("Our Branches: 131 (31–40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfourenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialfive(chatId));
                    editMessageText.setText("Our Branches: 131 (41–50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextfiveenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialsix(chatId));
                    editMessageText.setText("Our Branches: 131 (51–60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsixenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialseven(chatId));
                    editMessageText.setText("Our Branches: 131 (61–70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextsevenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialeight(chatId));
                    editMessageText.setText("Our Branches: 131 (71–80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexteightenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialnine(chatId));
                    editMessageText.setText("Our Branches: 131 (81–90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextnineenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialten(chatId));
                    editMessageText.setText("Our Branches: 131 (91–100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialeleven(chatId));
                    editMessageText.setText("Our Branches: 131 (101–110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nextelevenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialtwelve(chatId));
                    editMessageText.setText("Our Branches: 131 (111–120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("nexttwelveenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.filialthirteen(chatId));
                    editMessageText.setText("Our Branches: 131 (121–131)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttwoId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialone1(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (1-10)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthreeId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwo(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (11-20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfourId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialthree(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (21-30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfiveId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfour(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (31-40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsixId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfive(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (41-50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsevenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialsix(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayteightId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialseven(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (61-70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytnineId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeight(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (71-80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialnine(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (81-90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytelevenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialten(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (91-100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttwelveId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeleven(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (101-110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthirteenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwelve(chatId));
                    editMessageText.setText("Filiallarimiz: 131 ta (111-120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.uzmenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttworuId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialone1(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (1-10)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthreeruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialtwo(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (11-20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfourruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialthree(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (21-30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfiveruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialfour(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (31-40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsixruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialfive(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (41-50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsevenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialsix(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayteightruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialseven(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (61-70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytnineruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialeight(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (71-80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialnine(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (81-90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytelevenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialten(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (91-100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttwelveruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialeleven(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (101-110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthirteenruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.filialtwelve(chatId));
                    editMessageText.setText("Наши филиалы: 131 шт. (111-120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfruId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotServiceRu.rumenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttwoenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialone1(chatId));
                    editMessageText.setText("Our Branches: 131 (1-10)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthreeenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwo(chatId));
                    editMessageText.setText("Our Branches: 131 (11-20)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfourenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialthree(chatId));
                    editMessageText.setText("Our Branches: 131 (21-30)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfiveenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfour(chatId));
                    editMessageText.setText("Our Branches: 131 (31-40)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsixenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialfive(chatId));
                    editMessageText.setText("Our Branches: 131 (41-50)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytsevenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialsix(chatId));
                    editMessageText.setText("Our Branches: 131 (51-60)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayteightenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialseven(chatId));
                    editMessageText.setText("Our Branches: 131 (61-70)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytnineenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeight(chatId));
                    editMessageText.setText("Our Branches: 131 (71-80)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialnine(chatId));
                    editMessageText.setText("Our Branches: 131 (81-90)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytelevenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialten(chatId));
                    editMessageText.setText("Our Branches: 131 (91-100)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qayttwelveenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialeleven(chatId));
                    editMessageText.setText("Our Branches: 131 (101-110)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytthirteenenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.filialtwelve(chatId));
                    editMessageText.setText("Our Branches: 131 (111-120)");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytfenId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.uzmenu1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("yesId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.yes(chatId));
                    execute(myBotService.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("noId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.no(chatId));
                    execute(myBotService.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("tilId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.lan1(chatId));
                    editMessageText.setText("Iltimos, tilni tanlang:");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("sozlamaId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.lan1(chatId));
                    editMessageText.setText("Iltimos, tilni tanlang:");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("telId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.tel(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("shaharId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.shahar(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.uzmenu(chatId));
                    editMessageText.setText("Safiaga xush kelibsiz! Quyidagilardan birini tanlang:");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("menuId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotService.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("yesruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.yes(chatId));
                    execute(myBotServiceRu.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("noruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.no(chatId));
                    execute(myBotServiceRu.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("telruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.tel(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("shaharruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.shahar1(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("qaytruId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceRu.rumenu(chatId));
                    editMessageText.setText("Добро пожаловать в Safia! Пожалуйста, выберите один из вариантов:");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("menuruId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);
                    execute(myBotServiceRu.orgmenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("yesenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);

                    execute(myBotServiceEn.yes(chatId));
                    execute(myBotServiceEn.orgmenu(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("noenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);

                    execute(myBotServiceEn.no(chatId));
                    execute(myBotServiceEn.orgmenu(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("telenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);

                    execute(myBotServiceEn.tel(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("backenId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotServiceEn.enmenu(chatId));
                    editMessageText.setText("Welcome to Safia! Please choose an option:");
                    execute(editMessageText);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (data.equals("menuenId")) {
                try {
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(chatId);
                    deleteMessage.setMessageId(messageId);
                    execute(deleteMessage);

                    execute(myBotServiceEn.orgmenu(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            for (String i : myBotService.cities) {
                if (data.equals(i.toLowerCase() + "Id")) {
                    try {
                        EditMessageText editMessageText = new EditMessageText();
                        editMessageText.setText("Safiaga xush kelibsiz! Quyidagilardan birini tanlang:");
                        editMessageText.setChatId(chatId);
                        editMessageText.setMessageId(messageId);
                        editMessageText.setReplyMarkup(myBotService.uzmenu(chatId));

                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (String i : myBotServiceRu.cities) {
                if (data.equals(i.toLowerCase() + "Id")) {
                    try {
                        EditMessageText editMessageText = new EditMessageText();
                        editMessageText.setText("Добро пожаловать в Сафию! Выберите один из вариантов:");
                        editMessageText.setChatId(chatId);
                        editMessageText.setMessageId(messageId);
                        editMessageText.setReplyMarkup(myBotServiceRu.rumenu(chatId));

                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (String i : myBotServiceEn.cities) {
                if (data.equals(i.toLowerCase() + "Id")) {
                    try {
                        EditMessageText editMessageText = new EditMessageText();
                        editMessageText.setText("Welcome to Safia! Choose one of the options:");
                        editMessageText.setChatId(chatId);
                        editMessageText.setMessageId(messageId);
                        editMessageText.setReplyMarkup(myBotServiceEn.enmenu(chatId));

                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "safiaofficalbot";
    }

    @Override
    public String getBotToken() {
        return "8460667024:AAHw8FLVHO-RSJaGuMJ-PI-aC4hdI1oY7JU";
    }
}
