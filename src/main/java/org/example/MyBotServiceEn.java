package org.example;

public class MyBotServiceEn {

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel .*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io .*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

    public class MyBotService {

        String[] onetotwo = {"Safia Nukus", "Avaykhon", "Car Market", "Oqqorg’on", "Algorithm", "Olmaliq", "Al-Khorazmi", "Angren", "Andalus (Shuhrat)", "Andijan Navruz"};
        String[] twotothree = {"Andijan Ozbegim", "Ardus", "Atlas", "Ahmad", "Ashrafi", "Airport", "Bekabad", "Beltepa", "Beshqayrogoch", "Bobur-MKAD"};
        String[] threetofour = {"Botanika", "Boshka", "Boulevard", "Bunyodkor", "Safia Bukhara", "Vatan", "Vega", "Safia Suvsoz", "Gagarin", "Gazalkent"};
        String[] fourtofive = {"Ganga", "Heydar Aliyev", "Glinka", "Globus", "Grandmir", "Gulobod", "Safia Darkhon", "Dombirabod", "Kamolon", "Druzhba Mandarin"};
        String[] fivetosix = {"Duty Free", "Jomiy", "Bekabad", "Zenit", "Intellectuals", "Ibn Sino", "Izza", "Kadishevo", "Qorasaroy", "Karshi Keles"};
        String[] sixtoseven = {"Qibray", "Kokand", "Communism", "Compass", "Confectionery Factory", "Qorasuv", "Krestik", "Kukcha", "Qorgontepa", "Qushbegi"};
        String[] seventoeight = {"Labzak", "Lakokraska", "Lunacharsky", "Maxim Gorky", "Malika", "Mevazor", "Mega Planet", "Medgorobod", "Mehrjon", "Minor"};
        String[] eighttonine = {"Navoi", "Nazarbek", "Namangan Victory", "Safia Namangan", "Next", "Novza", "Nurafshon", "Ocean", "Parkent", "Parus"};
        String[] ninetoten = {"Pionerskiy", "Rakat", "Risoviy", "Sayram", "Sampi", "Sarakulka", "Sebzor", "North Station", "Sergeli", "Seoul Gate"};
        String[] tentoeleven = {"City Mall", "Sputnik", "Tansiqboyev", "TashMI", "Tele-tower", "Termez", "Tinchlik", "TTZ", "Toytepa", "Turin"};
        String[] eleventotwelve = {"Uzbum", "Home Market", "Urgench", "Orikzor", "Three Heroes", "Fayzobod", "Farhadsky", "Fergana", "Feroza", "Hightown"};
        String[] twelvetothirteen = {"Khast-Imom", "Huvaydo", "C1 (Sodiq Azimov)", "MUM", "Chigatay", "Chinoz", "Chirchik", "Chorsu", "Shahriston", "Shota Rustaveli"};
        String[] thirteentofourteen = {"Shokh Mardon", "Shokhsaroy", "HQ", "Eco Market", "Erkin", "Eshonguzar", "New Qoyliq", "New Yunusobod", "New Bazaar", "New Life", "Yangiyol"};

        String[] mazali = {"Round Cakes", "Rectangular Cakes", "Mini Cakes", "Large Pies", "Round Pies", "Pastries", "Swiss Rolls", "Eclairs", "Macarons", "Ready Meals", "Desserts", "Cookies", "Packed Eclairs", "Sweet Pastries", "Cupcakes", "Tartlets", "Layered Pastries", "Nutritious Pastry", "Gingerbread", "⬅️ Back to Main Menu"};

        String[] yumaloqtort = {"Mini Cake Vischenka", "Cake Admiral", "Cake Barbie", "Cake Bounty", "Cake Verona", "Cake Victoria", "Cake Julyetta", "Cake Julyetta Decorated", "Cake Little Dinosaur", "Cake Iriska", "Caramel Honey Cake", "Kiev Cake", "Kiev Cake Decorated", "Kiev Cake Pink", "Kiev Cake with Chocolate Stick", "Basket Cake", "Mix Cake", "Milk Girl Cake", "Ice Cream Cake", "Oreo Cake", "Raspberry Shortbread Cake", "Prague Cake", "Bird’s Milk Cake", "Chocolate Rainbow Cake", "Rafaello Cake", "Roshe Cake", "Safia Beige Cake", "Safia Decorated Cake", "Safia Pink Cake", "Snickers Cake", "Fruit Cake", "Black Prince Cake", "Chocolate Banana Cake", "Chocolate Raspberry Cake", "Berry Cottage Cheese Cake", "⬅️ Back"};
        String[] yumaloqtortphoto = {"https://t.me/safiapictures/14", "https://t.me/safiapictures/15", "https://t.me/safiapictures/16", "https://t.me/safiapictures/17", "https://t.me/safiapictures/18", "https://t.me/safiapictures/19", "https://t.me/safiapictures/20", "https://t.me/safiapictures/21", "https://t.me/safiapictures/22", "https://t.me/safiapictures/23", "https://t.me/safiapictures/24", "https://t.me/safiapictures/25", "https://t.me/safiapictures/26", "https://t.me/safiapictures/27", "https://t.me/safiapictures/28", "https://t.me/safiapictures/29", "https://t.me/safiapictures/32", "https://t.me/safiapictures/33", "https://t.me/safiapictures/34", "https://t.me/safiapictures/35", "https://t.me/safiapictures/36", "https://t.me/safiapictures/37", "https://t.me/safiapictures/38", "https://t.me/safiapictures/39", "https://t.me/safiapictures/40", "https://t.me/safiapictures/41", "https://t.me/safiapictures/42", "https://t.me/safiapictures/44", "https://t.me/safiapictures/45", "https://t.me/safiapictures/46", "https://t.me/safiapictures/47", "https://t.me/safiapictures/48", "https://t.me/safiapictures/49", "https://t.me/safiapictures/50", "https://t.me/safiapictures/51"};
        String[] yumaloqtortcaption = {"Mini Cake Vischenka\n\nDelicate sponge filled with classic ganache and fresh cherries. Serves 6–8 people. Recommended to defrost for 2 hours before serving.", "Cake Admiral\n\nFour types of sponge: vanilla, nut, poppy seed, and chocolate. Layers of chocolate, vanilla cream, and caramel crème, combined with cherry, hazelnut paste, and chocolate crunch filling. Defrost 2 hours before serving.", "Cake Barbie\n\nWhite sponge soaked with berry syrup, light yogurt cream, plombir cream, and strawberry-raspberry cream. Defrost 2 hours before serving.", "Cake Bounty\n\nChocolate sponge soaked with chocolate, layered with coconut chantilly and Bounty coconut filling. Serves 6–8 people. Defrost 2 hours before serving.", "Orange Curd & Fruit Cake\n\nWhite sponge with cherry, banana, raspberry, and apple creams. Defrost 2 hours before serving.", "Cake Victoria\n\nChocolate sponge soaked with chocolate syrup, filled with butter and cocoa condensed milk cream. Defrost 2 hours before serving.", "Cake Julyetta\n\nWhite sponge soaked with berries, light yogurt cream, plombir cream, and strawberry-raspberry cream. Serves 8–10 people. Defrost 2 hours before serving."};
        String[] yumaloqtortnarx = {"115 000", "299 000", "299 000", "259 000", "219 000", "269 000", "249 000", "259 000", "299 000", "319 000", "259 000", "329 000", "349 000", "319 000", "289 000", "309 000", "259 000", "249 000", "299 000", "375 000", "185 000", "219 000", "165 000", "315 000", "239 000", "409 000", "369 000", "299 000", "359 000", "299 000", "299 000", "269 000", "285 000", "345 000", "299 000", "249 000"};


    }
