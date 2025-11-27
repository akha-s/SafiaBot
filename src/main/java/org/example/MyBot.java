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
        String phone = "";
        String city = "";

        if (update.hasMessage() && update.getMessage().hasContact()) {
            Long chatId = update.getMessage().getChatId();
            Integer messageId = update.getMessage().getMessageId();
            Contact contact = update.getMessage().getContact();

            String phoneNumber = contact.getPhoneNumber();

            try {
                phone = phoneNumber;
                System.out.println(phone);
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

            for (int i = 1; i <= 9; i++) {
                if (text.equals(String.valueOf(i))) {
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

        }

        else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Long chatId = callbackQuery.getMessage().getChatId();
            String data = callbackQuery.getData();
            Integer messageId = callbackQuery.getMessage().getMessageId();

            System.out.println(data);

            if(data.equals("uzId")) {
                try {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(messageId);
                    ids.add(messageId - 1);
                    DeleteMessages deleteMessages = new DeleteMessages();
                    deleteMessages.setChatId(chatId);
                    deleteMessages.setMessageIds(ids);
                    execute(deleteMessages);
                    execute(myBotService.tel(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if(data.equals("ruId")) {
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

            if (data.equals("sozlamaId")) {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setReplyMarkup(myBotService.sozlama(chatId, city, phone));
                    editMessageText.setText("Muloqot tili: \uD83C\uDDFA\uD83C\uDDFF O'zbek tili\nTelefon raqam: " + phone + "\nShahar: " + city + "\n\n Quyidagilardan birini tanlang");
                    execute(editMessageText);
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

            for (String i : myBotService.cities) {
                if (data.equals(i.toLowerCase() + "Id")) {
                    try {
                        city = i;
                        System.out.println(city);
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
                        city = i;
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
