package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyBotService {

    String[] cities = {"Toshkent", "Farg'ona", "Chirchiq", "Urganch", "Bekobod", "Andijon", "Buxoro", "Termez", "Jizzax", "Navoiy", "Namangan", "Qarshi", "Qibray", "Nukus", "Shimkent (Qozog'iston)", "Olmaota (Qoraqalpog'iston)"};
    String[] lans = {"\uD83C\uDDFA\uD83C\uDDFF O'zbek tili", "\uD83C\uDDF7\uD83C\uDDFA Русский язык", "\uD83C\uDDEC\uD83C\uDDE7 English", "\uD83C\uDDF0\uD83C\uDDFF Қазақ"};String curlan = lans[0];

    String[] onetotwo = {"Safia Nukus", "Avayxon", "Avtobozor", "Oqqo'rg'on", "Algoritm", "Olmaliq", "Al-Xorazmiy", "Angren", "Andalus (Shuhrat)", "Andijon Navro'z"};
    String[] twotothree = {"Andijon O'zbegim", "Ardus", "Atlas", "Axmad", "Ashrafiy", "Aeroport", "Bekabad", "Beltepa", "Beshqayrog'och", "Bobur-MKAD"};
    String[] threetofour = {"Botnika", "Boshka", "Bulvar", "Bunyodkor", "Safia Buxoro", "Vatan", "Vega", "Safia Suvsoz", "Gagarin", "G'azalkent"};
    String[] fourtofive = {"Ganga", "Geydar Aliyev", "Glinka", "Globus", "Grandmir", "Gulobod", "Safia Darxon", "Do'mbirabod", "Kamolon", "Drujba mandarin"};
    String[] fivetosix = {"Duty Free", "Jomiy", "Bekobod", "Zenit", "Ziyolilar", "Ibn Sino", "Izza", "Kadishevo", "Qorasaroy", "Qarshi Keles"};
    String[] sixtoseven = {"Qibray", "Qo'qon", "Kommunism", "Kompas", "Qandolatchilik Fabrikasi", "Qorasuv", "Krestik", "Ko'kcha", "Qo'rg'ontepa", "Qushbegi"};
    String[] seventoeight = {"Labzak", "Lakokraska", "Lunacharskiy", "Maksim Gorkiy", "Malika", "Mevazor", "Mega Planet", "Medgorobod", "Mehrjon", "Minor"};
    String[] eighttonine = {"Navoiy", "Nazarbek", "Namangan G'alaba", "Safia Namangan", "Next", "Novza", "Nurafshon", "Okean", "Parkent", "Parus"};
    String[] ninetoten = {"Pioneskiy", "Rakat", "Risoviy", "Sayram", "Sampi", "Sarakulka", "Sebzor", "Shimoliy Vokzal", "Sergeli", "Seoul Mun"};
    String[] tentoeleven = {"Siti Mol", "Sputnik", "Tansiqboyev", "Toshmi", "Telebashnya", "Termiz", "Tinchlik", "TTZ", "To'ytepa", "Turin"};
    String[] eleventotwelve = {"Uzbum", "Uy Bozor", "Urganch", "O'rikzor", "Uch Qahramon", "Fayzobod", "Farxadskiy", "Farg'ona", "Feruza", "Hightown"};
    String[] twelvetothirteen = {"Xast-Imom", "Huvaydo", "C1 (Sodiq Azimov)", "MUM", "Chig'atoy", "Chinoz", "Chirchiq", "Chorsu", "Shahriston", "Shota Rustaveli"};
    String[] thirteentofourteen = {"Shoximardon", "Shoxsaroy", "SHTAB", "Eco Bozor", "Erkin", "Eshonguzar", "Yangi Qo'yliq", "Yangi Yunusobod", "Yangibozor", "Yangi Xayot", "Yangiyo'l"};

    String[] mazali = {"Yumaloq tortlar", "To'g'ri burchakli tortlar", "Mini tortlar", "Katta piroglar", "Yumaloq piroglar", "Pirojniylar", "Ruletlar", "Eklerlar", "Makaronslar", "Tayyor taomlar", "Shirinliklar", "Pechenye", "Qadoqdagi eklerlar", "Shirin pishiriqlar", "Kekslar", "Tartaletkalar", "Qatlamali pishiriqlar", "To'yimli pishiriq", "Zanjabilli praynik", "⬅\uFE0F Asosiy menyuga"};

    String[] yumaloqtort = {"Mini tort Vishenka", "Tort Admiral", "Tort Barbi", "Tort Baunti", "Tort Verona", "Tort Viktoriya", "Tort Julyetta", "Tort Julyetta bezatilgan", "Tort Dinozavrik", "Tort Iriska", "Tort Karamelli-medovik", "Tort Kiyevcha", "Tort Kiyevcha bezatilgan", "Tort Kiyevcha pushti", "Tort Kiyevcha rojok bilan", "Tort Korzinka", "Tort Miks", "Tort 'Molochnaya devochka'", "Tort Morojenko", "Tort Oreo", "Tort 'Pesochno-malinoviy", "Tort Praga", "Tort 'Ptichye moloko'", "Tort Raduga shokoladli", "Tort Rafaello", "Tort Roshe", "Tort 'Safiya bejeviy'", "Tort Safia bezatilgan", "Tort Safia pushti", "Tort Snikers", "Tort Mevali", "Tort Qora shahzoda", "Tort Shokolad-banan", "Tort Shokolad-malina", "Tort Reza meva-tvorogli", "⬅\uFE0F Ortga"};
    String[] yumaloqtortphoto = {"https://t.me/safiapictures/14", "https://t.me/safiapictures/15", "https://t.me/safiapictures/16", "https://t.me/safiapictures/17", "https://t.me/safiapictures/18", "https://t.me/safiapictures/19", "https://t.me/safiapictures/20", "https://t.me/safiapictures/21", "https://t.me/safiapictures/22", "https://t.me/safiapictures/23", "https://t.me/safiapictures/24", "https://t.me/safiapictures/25", "https://t.me/safiapictures/26", "https://t.me/safiapictures/27", "https://t.me/safiapictures/28", "https://t.me/safiapictures/29", "https://t.me/safiapictures/32", "https://t.me/safiapictures/33", "https://t.me/safiapictures/34", "https://t.me/safiapictures/35", "https://t.me/safiapictures/36", "https://t.me/safiapictures/37", "https://t.me/safiapictures/38", "https://t.me/safiapictures/39", "https://t.me/safiapictures/40", "https://t.me/safiapictures/41", "https://t.me/safiapictures/42", "https://t.me/safiapictures/44", "https://t.me/safiapictures/45", "https://t.me/safiapictures/46", "https://t.me/safiapictures/47", "https://t.me/safiapictures/48", "https://t.me/safiapictures/49", "https://t.me/safiapictures/50", "https://t.me/safiapictures/51"};
    String[] yumaloqtortcaption = {"Mini tort Vishenka\n\nKlassik ganash va yangi uzilgan olcha bilan qumoq xamir. Tort 6-8 kishi uchun mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Admiral\n\n4 xil biskvit: vanilli, yong‘oqli, makli va shokoladli. Shokoladli, vanilli krem va iris kremi bilan uyg‘unlikda olcha va funduk pastasi bilan shokoladli xrustiland nachinkasi. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Barbi\n\nReza mevalar singdirilgan oq biskvit, mayin yogurt kremi, “Plombir” kremi va qulupnay-malina kremi bilan uygʻunlikda. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Baunti\n\nMayin kokosli shantilye va Baunti kokosli toʻldirmasi bilan birgalikda shokolad singdirilgan shokoladli biskvit. Tort 6-8 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Apelsinli kurd va mevali\n\nOlchali, bananli, malinali va olmali krem bilan uygʻunlikda oq biskvit. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Viktoriya\n\nShokoladli qiyom singdirilgan shokoladli biskvit, saryogʻ va kakaoli quyultirilgan sut asosidagi shokoladli krem bilan birgalikda. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Julyetta\n\nReza mevalar singdirilgan oq biskvit, mayin yogurt kremi, “Plombir” kremi va qulupnay-malina kremi bilan uygʻunlikda. Tort 8-10 kishi uchun mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi."};
    String[] yumaloqtortnarx = {"115 000", "299 000", "299 000", "259 000", "219 000", "269 000", "249 000", "259 000", "299 000", "319 000", "259 000", "329 000", "349 000", "319 000", "289 000", "309 000", "259 000", "249 000", "299 000", "375 000", "185 000", "219 000", "165 000", "315 000", "239 000", "409 000", "369 000", "299 000", "359 000", "299 000", "299 000", "269 000", "285 000", "345 000", "299 000", "249 000"};

    String[] togriburchakli = {"Afganskiy To'g'ri burchakli tort ", "Dari To'g'ri burchakli tort ", "Italyano To'g'ri burchakli tort ", "Karamelli Medovik To'g'ri burchakli tort", "Limonli To'g'ri burchakli tort", "Malinka To'g'ri burchakli tort", "Markiza To'g'ri burchakli tort", "Merengali To'g'ri burchakli tort", "Mikado To'g'ri burchakli tort", "Milano To'g'ri burchakli tort", "Napolean To'g'ri burchakli tort", "Yong'oqli medovik To'g'ri burchakli tort", "Saksoniya To'g'ri burchakli tort", "Snikers To'g'ri burchakli tort", "Tvorog-biskviti", "Mevali sariq To'g'ri burchakli tort", "Mevali pushti To'g'ri burchakli tort", "Qora shahzoda To'g'ri burchakli tort", "Shokolad-banan To'g'ri burchakli tort", "Shokolad-malina To'g'ri burchakli tort", "Shokoladli medovik To'g'ri burchakli tort", "Reza meva-Malinka To'g'ri burchakli tort", "Yakobs To'g'ri burchakli tort", "⬅\uFE0F Ortga"};
    String[] togriburchakliphoto = {"https://t.me/safiapictures/52", "https://t.me/safiapictures/53", "https://t.me/safiapictures/54", "https://t.me/safiapictures/55", "https://t.me/safiapictures/56", "https://t.me/safiapictures/57", "https://t.me/safiapictures/59", "https://t.me/safiapictures/60", "https://t.me/safiapictures/61", "https://t.me/safiapictures/62", "https://t.me/safiapictures/63", "https://t.me/safiapictures/65", "https://t.me/safiapictures/66", "https://t.me/safiapictures/67", "https://t.me/safiapictures/69", "https://t.me/safiapictures/70", "https://t.me/safiapictures/71", "https://t.me/safiapictures/72", "https://t.me/safiapictures/73", "https://t.me/safiapictures/74", "https://t.me/safiapictures/75", "https://t.me/safiapictures/76", "https://t.me/safiapictures/77"};
    String[] togriburchaklicaption = {"Toʻgʻri burchakli tort Afganskiy\n\nQumoq lochira, merenga, yong'oq, qaynatib tayyorlangan quyultirilgan sut qoʻshilgan sariyogʻli krem. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Dari\n\nTvorog-qaymoqli krem va malinali konfi bilan uygʻunlikda yupqa, oq biskvit qavatlari. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Italyano\n\nQaymoqli krem va iriskali quyultirilgan sutdan toʻldirmali yongʻoqli biskvit. Tort 16 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Karamelli medovik\n\nQaymoqli krem va mayin karamel bilan uygʻunlikda asalli va karamelli yupqa lochiralar qavatlari. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Limonli\n\nQuyultirilgan sut va limon toʻldirmali sariyog'li krem bilan uygʻunlikda qarsildoq bezeli qumoq xamir. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Malinka\n\nMalina-qaymoqli va banan-qaymoqli kremli oq biskvit. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Markiza\n\nQumoq lochira, merenga, qaynatib tayyorlangan quyultirilgan sut va yongʻoq qoʻshilgan sariyog'li krem. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "To'g'ri burchakli tort Merengali\n\nOq shokoladdan ganashli oq biskvit, malinali quyuq shinni va apelsin kurdidan toʻldirma bilan koʻpirtirilgan qaymoq asosida krem-muzqaymoqli qarsildoq merenga. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Mikado\n\nShokoladli asalli tort, qaynatib pishirilgan quyultirilgan sutdan shokoladli qaynatma krem va koʻpirtirilgan qaymoq bilan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Milano\n\nShokolad-qaymoqli krem va shokolad toʻldirmali yupqa shokolad-yongʻoqli biskvit. Tort 16 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Napoleon\n\nQuyultirilgan sut bilan sariyogʻli kremli yupqa qatlamli qumoq xamir. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Yong'oqli medovik\n\nQaymoqli krem bilan uygʻunlikda asalli, yongʻoqli yupqa lochira. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Saksoniya\n\nShokolad-qaymoqli krem va olcha toʻldirmali yumshoq shokolad-keksli biskvit. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Snikers\n\nShokolad singdirilgan, karamel-yeryongʻoqli, qaymoq-quyultirilgan kremli shokoladli biskvit. Toʻldirmasi iriska, yeryongʻoq va shokoladdan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Tvorog-biskvitli\n\nTvorog-qaymoqli kremli, shakar siropi singdirilgan oq biskvit. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Mevali sariq\n\nApelsinli va malina konfili qaymoqli krem bilan birgalikda yupqa, sariyogʻli biskvit qavatlari. 24 kishiga moʻljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Mevali pushti\n\n“Salma” biskviti yupqa qatlamlari, qaymoq-bananli va qaymoq olchali krem bilan. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Qora shahzoda\n\nShokoladli qumoq lochiralar, qaymoqli shokoladli krem, olchali konfidan toʻldirma. Tort 16 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Shokolad-banan\n\nTryufelli, shokoladli, qahvali krem bilan uygʻunlikda, banan va qora shokoladdan toʻldirma bilan shokoladli biskvit. To'rt 16 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Shokolad-malina\n\nQuyultirilgan sutga belangan sariyogʻli kremli va barra malinadan toʻldirmali yupqa qumoq lochiralar. Tort oq yumshoq konfet va mavsumiy reza mevalar bilan bezalgan. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Shokoladli medovik\n\nQaymoq-smetanali krem bilan yupqa asalli-shokoladli lochiralar. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Reza meva-Malinka\n\nShakar qiyomi singdirilgan oq biskvit, qaymoqli krem-muzqaymoq va malina bilan birgalikda. Tort koʻpirtirilgan qaymoq, zefir va malina bilan bezatilgan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Toʻgʻri burchakli tort Yakobs\n\nQahva-qaymoqli krem va shokolad toʻldirmali qahvali yupqa biskvit. Tort 24 kishiga mo'ljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi."};
    String[] togriburchaklinarx = {"356 000", "352 000", "324 000", "336 000", "356 000", "368 000", "352 000", "179 000", "372 000", "372 000", "316 000", "360 000", "352 000", "448 000", "328 000", "396 000", "368 000", "384 000", "388 000", "388 000", "352 000", "396 000", "384 000"};

    String[] minitort = {"Bento mini - tort", "Berri keyk Mini tort", "Kofe-toffi Mini tort", "'Lesnoy orex' Mini tort", "milk-slays Mini tort", "Rafaello Mini tort", "Mini-tort Tiramisu", "Shokolad-banan Mini tort", "Tort Bravo", "Torti Parij", "Tort Smorodina", "⬅\uFE0F Ortga"};
    String[] minitortphoto = {"https://t.me/safiapictures/78", "https://t.me/safiapictures/79", "https://t.me/safiapictures/80", "https://t.me/safiapictures/81", "https://t.me/safiapictures/83", "https://t.me/safiapictures/84", "https://t.me/safiapictures/85", "https://t.me/safiapictures/86", "https://t.me/safiapictures/87", "https://t.me/safiapictures/88", "https://t.me/safiapictures/89"};
    String[] minitortcaption = {"Bento mini - tort\n\n", "Mini tort Berri keyk\n\nBodomli, vanilli krem va reza mevali quyuq shinni bilan uygʻunlikda reza meva singdirilgan oq biskvit. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini tort Kofe-toffi\n\nQahvali-smetanali krem, bodom va karameldan toʻldirma bilan uygʻunlikda shokoladli-asalli lochiralar. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini tort \"Lesnoy orex\"\n\nShakar siropi singdirilgan, qaymoqli-smetanali krem, funduk va qahva-shokolad ganashidan toʻldirma bilan uygʻunlikda shokoladli biskvit. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini tort Milk-slays\n\nQahvali-smetanali krem, sutli shokoladdan shokoladli yumshoq konfet bilan uygʻunlikda shokoladli-asalli lochiralar. 6-8 kishiga moʻljallangan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini tort Rafaello\n\nSutli sirop singdirilgan oq biskvit, qarsildoq bodom qatlami, bodomli yongʻoqli konfet va kokosli Shantilye kremi bilan quyultirilgan sutli vafli toʻldirma. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini-tort Tiramisu\n\nQahvali, vanilli krem va qahvali muss bilan uygʻunlikda qahva singdirilgan oq biskvit. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Mini tort Shokolad-banan\n\nShokoladli Shantilye kremi, bananli namelaka va sutli shokolad boʻlaklaridan toʻldirma bilan uygʻunlikda shokoladli biskvit. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Bravo\n\nKaramellangan banan bilan shokoladli biskvit, shokoladli muss, krustilant, kremyu, toffi-karamel toʻldirmali. Shokolad qiyomi va shokoladli dekor bilan bezatilgan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Torti Parij\n\nYongʻoqli lochira, fundukli krem, qahvali ganash, sutli qiyom. Shokoladli yumshoq konfet, irisdan krem, Snikers shokoladi, funduk, qumoq uvoq bilan bezatilgan. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Tort Smorodina\n\nOq shokoladga belangan vanilli “Plombir” kremi bilan uygʻunlikda, reza meva sharbati singdirilgan shokoladli biskvit va butun smorodina mevalaridan toʻldirma. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi."};
    String[] minitortnarx = {"144 000", "209 000", "189 000", "199 000", "185 000", "235 000", "199 000", "225 000", "225 000", "225 000", "189 000"};

    String[] pirog = {"Bokucha paxvala Pirog", "Pirog olma-olchali", "Pirog olchali", "Pirog limonli mozaika", "Mishka Pirog", "Pirog tvorogli mozaika", "Tvorojnik Pirog", "Pirog olmali", "Pirog Mishka qadoqda", "Bokucha paxvala qadoqda", "⬅\uFE0F Ortga"};
    String[] pirogphoto = {"https://t.me/safiapictures/90", "https://t.me/safiapictures/91", "https://t.me/safiapictures/92", "https://t.me/safiapictures/93", "https://t.me/safiapictures/94", "https://t.me/safiapictures/95", "https://t.me/safiapictures/96", "https://t.me/safiapictures/97", "https://t.me/safiapictures/98", "https://t.me/safiapictures/99"};
    String[] pirogcaption = {"Pirog Bokucha paxlava\n\nMerenga va yong'oqli masalliqli qumoq xamir, asal qiyomi bilan qoplangan va yongʻoq bilan bezatilgan. Pirog 24 kishiga xizmat qiladi.", "Pirog olma-olchali\n\nQumoq xamir va barra olma hamda olchadan yumshoq toʻldirma.", "Pirog olchali\n\nQumoq xamir va barra olchadan yumshoq toʻldirma.", "Pirog limonli mozaika\n\nQumoq xamir va barra limon va olmadan yumshoq toʻldirma.", "Pirog Mishka\n\nQumoq xamir va yongʻoq hamda bargakdan toʻldirma.", "Pirog tvorogli mozaika\n\nQumoq xamir va yangi tvorogdan yumshoq toʻldirma.", "Pirog Tvorojnik\n\nQumoq xamir va yangi tvorogdan yumshoq toʻldirma.", "Pirog olmali\n\nQumoq xamir, yumshoq olmali toʻldirma.", "Pirog Mishka qadoqda\n\nQumoq xamir, masalligʻi bargak va yongʻoq", "Bokucha paxlava qadoqda\n\nMerenga toʻldirmali qumoq xamir va yongʻoq"};
    String[] pirognarx = {"284 000", "260 000", "280 000", "208 000", "300 000", "240 000", "240 000", "208 000", "28 000", "29 000"};

    String[] yumaloqpirog = {"Pirog Malina-mevali", "Shirmoy pirog olma va olchali", "⬅\uFE0F Ortga"};
    String[] yumaloqpirogphoto = {"https://t.me/safiapictures/100", "https://t.me/safiapictures/101"};
    String[] yumaloqpirogcaption = {"Pirog Malina-mevali\n\nQumoq xamir, smetanali va malinali toʻldirma.", "Shirmoy pirog olma va olchali\n\nShirmoy xamir, olcha va olma bilan tsukatli to’ldirma."};
    String[] yumaloqpirognarx = {"13 000", "59 000"};

    String[] pirojni = {"Batonchik 'Kartoshka'", "Granola", "Amore Mini projniy", "Apelsinka Mini projniy", "Karamelka Mini projniy", "'Kartoshka' Mini projniy", "Snikers Mini projniy", "'Tri shokolada' Mini projniy", "'Flamingo' Mini projniy", "Shokoladli Mini projniy", "Ekzot Mini projniy", "Berri keyk Pirojniy", "Blek rosberri Pirojniy", "Blek forest Pirojniy", "Brauni Pirojniy", "Vinni Pirojniy", "Tipratikan Pirojniy", "Kartoshka Pirojniy", "'Medovik v stakane' Pirojniy", "Mishka Pirojniy", "Pavlova Pirojniy", "Pavlova limonli Pirojniy", "Pavlova malinali Pirojniy", "Povlavo shokoladli", "Snikers Pirojniy", "Tiramisu Pirojniy", "Tiramisu bankacha Pirojniy", "Esterxazi Pirojniy", "Reza mevali opera Pirojniy", "reza mevali labne Pirojniy", "Oreo Pirojniy-makarons", "Rafaello Pirojniy-makarons", "Snikers Pirojniy-makarons", "Chizkeyk Pirojniy-makarons", "Julyetta Pirojniy-rulet", "Iriska Pirojniy-rulet", "Snikers Pirojniy-rulet", "Tiramisu San-Sebastyan", "Chizkeyk San-Sebastyan", "Shololadli San-Sebastyan", "Lotus Chizkeyk", "Asalli Chizkeyk", "Nyu-York Chizkeyk", "Oreo Chizkeyk", "Ekzotik Chizkeyk", "San-Sebastyan uchun shokolad", "⬅\uFE0F Ortga"};
    String[] pirojniphoto = {"https://t.me/safiapictures/102", "https://t.me/safiapictures/103", "https://t.me/safiapictures/104", "https://t.me/safiapictures/105", "https://t.me/safiapictures/106", "https://t.me/safiapictures/107", "https://t.me/safiapictures/108", "https://t.me/safiapictures/109", "https://t.me/safiapictures/110", "https://t.me/safiapictures/111", "https://t.me/safiapictures/112", "https://t.me/safiapictures/113", "https://t.me/safiapictures/114", "https://t.me/safiapictures/115", "https://t.me/safiapictures/116", "https://t.me/safiapictures/117", "https://t.me/safiapictures/118", "https://t.me/safiapictures/119", "https://t.me/safiapictures/120", "https://t.me/safiapictures/121", "https://t.me/safiapictures/122", "https://t.me/safiapictures/123", "https://t.me/safiapictures/124", "https://t.me/safiapictures/125", "https://t.me/safiapictures/126", "https://t.me/safiapictures/127", "https://t.me/safiapictures/128", "https://t.me/safiapictures/129", "https://t.me/safiapictures/130", "https://t.me/safiapictures/131", "https://t.me/safiapictures/132", "https://t.me/safiapictures/133", "https://t.me/safiapictures/134", "https://t.me/safiapictures/135", "https://t.me/safiapictures/136", "https://t.me/safiapictures/137", "https://t.me/safiapictures/138", "https://t.me/safiapictures/139", "https://t.me/safiapictures/140", "https://t.me/safiapictures/141", "https://t.me/safiapictures/142", "https://t.me/safiapictures/143", "https://t.me/safiapictures/144", "https://t.me/safiapictures/145", "https://t.me/safiapictures/146", "https://t.me/safiapictures/147"};
    String[] pirojnicaption = {"Batonchik\n\nShokoladli biskvit, yongʻoq, qaynatib quyultirilgan sutli koʻpirtirilgan qaymoq.", "Granola\n\nGrekcha yogurt, myusli (suli yormasi, bodom, kungaboqar urugʻlari, asal, oq mayiz, qora mayiz, yanchilgan dolchin).", "Mini pirojniy Amore\n\nQavha - shokoladli biskvit, qahvali muss, qahva-shokoladli toʻldirma.", "Mini pirojniy Apelsinka\n\nApelsinli - shaftolili konfi, bodomli biskvit, silliq qiyom, shokoladli dekor.", "Mini pirojniy Karamelka\n\nKaramelli - yongʻoqli muss, karamelli iris, silliq qiyom, shokoladli dekor.", "Mini pirojniy Kartoshka\n\nShokoladli biskvit, shokoladli krem, shokoladli ganash va kokosli qirindi.", "Mini pirojniy Snikers\n\nShokoladli biskvit, karamel nachinka, nuga, shokoladli muss. Shokoladli gurme bodom bilan, shokoladli shantili, yeryong‘oq va shokoladli dekor bilan bezatilgan.", "Mini pirojniy Tri shokolada\n\nQora, sutli va oq shokoladli muss bilan uyg’unlikda shokoladli biskvit, xrustiland, shokoladli qumoq xamir", "Mini pirojniy Flamingo\n\nAsosi chizkeyk, qulupnayli shantilye, gurme flamingo bodom bilan.", "Mini pirojniy Shokoladli\n\nToffi, sutli gurme va tuzli yeryong‘oq bilan uyg’unlikda shokoladli keks. Shokolad bilan bezatilgan", "Mini pirojniy Ekzot\n\nAsalli korj, kivi, oq shantili kremi, ananas va mango-marakuya pyuresi. Ananas pyuresi, limon sharbati va yalpizdan tayyorlangan konfi. Glazur va shokolad bezaklari bilan bezatilgan.", "Pirojniy Berri keyk\n\nOq va apelsinli biskvit, yumshoq vanilli muss, bodomli krem, reza meva quyuq shinnisidan toʻldirma.", "Pirojniy Blek rosberri\n\nShokoladli biskvit “Blek dabl”, malina singdirilgan, malinali konfi va shokoladli ganash. Sutli shantilye va sutli gurme bilan bezatilgan", "Pirojniy Blek forest\n\nVanilli, sutli “Shantilye” kremi bilan uygʻunlikda shokoladli qumoq tartaletka, olcha va olchali konfidan toʻldirma.", "Pirojniy Brauni\n\nTuzlangan karamel, qora shokoladli muss va sutli gurme bilan uygʻunlikda banan qoʻshib va qahva singdirib tayyorlangan shokoladli biskvit. Karamelli shantilye va shokoladli toʻldirma bilan bezatilgan.", "Pirojniy Vinni\n\nApelsinli biskvit, ananasli va pishloqli muss, ananasli konfi.", "Pirojniy Tipratikan\n\nShokoladli biskvit, shokoladli krem, shokoladli ganash, shokoladli dekor, yong'oqlar", "Pirojniy Kartoshka\n\nShokoladli biskvit, shokoladli krem, shokoladli ganash va kokosli qirindi.", "Pirojniy Medovik v stakane\n\nAsalli yumshoq biskvit, asalli qaynatma krem.", "Pirojniy Mishka\n\nPishirilgan oreo chizkeyk va shokoladli gurme.", "Pirojniy Pavlova\n\nQarsildoq yumshoq merenga, reza mevali konfi, qaymoqli krem.", "Pirojniy Pavlova limonli\n\nLimonli kurd, qaymoqli krem va Plombir kremi bilan uygʻunlikda qarsildoq va yumshoq merenga. Fizalis va zefir bilan bezalgan.", "Pirojniy Pavlova malinali\n\nPlombir kremi va shokoladli krem bilan uygʻunlikda qarsildoq va yumshoq merenga. Malinali bilan bezalgan.", "Pirojniy Pavlova shokoladli\n\nQaymoqli-shokoladli krem bilan uygʻunlikda qarsildoq va yumshiq merenga. Golubika va Mikado olchasi bilan bezalgan.", "Pirojniy Snikers\n\nShokoladli biskvit, nuga, karamel, sutli muss va tuzlangan yeryongʻoq.", "Pirojniy Tiramisu\n\nQahva singdirilgan oq biskvit. Qahva-kremli toʻldirma, vanilli krem, qahvali muss asos. Vanilli va sutli shantilye bilan bezatilgan.", "Pirojniy Tiramisu bankachada\n\nBiskvit, qahvali krem, shokoladli-qaymoqli krem, kakao", "Pirojniy Esterxazi\n\nYongʻoqli lochira (bodom, funduk va yongʻoq), iris va quyultirilgan sutli qaynatilgan sariyogʻli krem va funduk bilan uygʻunlikda.", "Pirojniy Reza mevali opera\n\nKokosli krem, reza mevali muss va shokolad-reza mevali ganashdan toʻldirma bilan uygʻunlikda reza mevali sirop singdirilgan bodomli biskvit.", "Pirojniy Reza mevali labne\n\nPishloq-sufle va barra olcha, malina reza mevalari bilan qumoq asos.", "Pirojniy-makarons Oreo\n\nQaymoqli-vanilli krem, oq shokolad va tvorogli pishloq bilan uygʻunlikda bodomli xamir.", "Pirojniy-makarons Rafaello\n\nKokos-quyultirilgan sutli krem, tvorogli pishloq bilan uygʻunlikda bodomli xamir", "Pirojniy-makarons Snikers\n\nQaymoqli-vanilli krem, karamelli shokolad, tuzlangan yeryongʻoq solingan yeryongʻoqli pasta bilan uygʻunlikda kakaoli va bodomli xamir.", "Pirojniy-makarons Chizkeyk\n\nQaymoq-vanilli krem, oq shokolad, tvorogli pishloq va reza mevali konfi bilan uygʻunlikda bodomli xamir.", "Pirojniy-rulet Julyetta\n\nMayin yogurtli krem va Plombir kremi bilan uygʻunlikda, reza meva singdirilgan, malinali (qulupnayli) konfi qatlami bilan oq biskvit.", "Pirojniy-rulet Iriska\n\nYongʻoqli biskvit, shokoladli ganash, karamelli krem, sutli shokoladli, yongʻoqli va karamelli qarsildoq qatlam.", "Pirojniy-rulet Snikers\n\nShantilye karamelli kremi, yeryongʻoqli tuzlangan karamel va qaymoqli krem chiz bilan uygʻunlikda shokolad singdirilgan shokoladli yumshoq biskvit", "San-Sebastyan Tiramisu\n\nKofe ta'mli tvorog-qaymoqli chizkeyk shokolad bo'laklari bilan.", "Chizkeyk San-Sebastyan\n\nTvorog-qaymoqli chizkeyk", "San-Sebastyan Shokoladli\n\nSutli va qora shokolad qo'shilgan tvorog-qaymoqli chizkeyk", "Chizkeyk Lotus\n\nYumshoq qumoq xamir, chiz asos, lotus pasta.", "Chizkeyk Asalli\n\nAsalli lochira, asalli krem-chiz, asalli krem, asalli uvoq", "Chizkeyk Nyu-York\n\nMayin qumshakar, krem-chiz, malinali konfi.", "Chizkeyk Oreo\n\nShokoladli biskvit, krem-chiz oreo, sutli va oq krem-chiz, sutli ganash.", "Chizkeyk Ekzotik\n\nApelsinli krustilant, pishloqli marakuyya muss, pishloqli toʻldirma, mango-marakuyya konfi.", "San-Sebastyan uchun shokolad\n\nSutli shokolad."};
    String[] pirojninarx = {"9 000", "29 000", "11 000", "11 000", "11 000", "7 000", "11 000", "11 000", "11 000", "11 000", "11 000", "31 000", "33 000", "27 000", "35 000", "36 000", "13 000", "9 000", "33 000", "36 000", "28 000", "28 000", "28 000", "28 000", "31 000", "28 000", "33 000", "29 000", "32 000", "28 000", "29 000", "29 000", "29 000", "29 000", "36 000", "36 000", "39 000", "37 000", "36 000", "37 000", "35 000", "35 000", "32 000", "33 000", "35 000", "7 000"};

    String[] rulet = {"Rulet Merengali", "Rulet Merengali fistashka bilan", "Rulet 'Skazka'", "⬅\uFE0F Ortga"};
    String[] ruletphoto = {"https://t.me/safiapictures/148", "https://t.me/safiapictures/149", "https://t.me/safiapictures/150"};
    String[] ruletcaption = {"Rulet Merengali\n\nKoʻpirtirilgan qaymoq va barra malina bilan uygʻunlikda qarsildoq yumshoq merenga. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Rulet Merengali fistashka bilan\n\nMuzlatilgan va barra malinali pista krem bilan birgalikda pistali qarsildoq mayin merenga. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi.", "Rulet \"Skazka\"\n\nShakar siropi singdirilgan oq biskvit, tabiiy sariyogʻli krem. Iste'mol qilishdan oldin tortni 2 soat davomida muzdan tushirish tavsiya etiladi."};
    String[] ruletnarx = {"209 000", "239 000", "169 000"};

    String[] ekler = {"Ekler Vanil-malinali", "Ekler Lotus-karamel", "Ekler Rafaello", "Ekler Tiramisu", "Ekler Xandon pist-olcha", "Ekler Shokolad-Nutella", "⬅\uFE0F Ortga"};
    String[] eklerphoto = {"https://t.me/safiapictures/151", "https://t.me/safiapictures/153", "https://t.me/safiapictures/154", "https://t.me/safiapictures/155", "https://t.me/safiapictures/156", "https://t.me/safiapictures/157"};
    String[] eklercaption = {"Ekler Vanil-malinali\n\nVanilli krem, malina va malinali konfi bilan uygʻunlikda krakelin bilan qoplangan qaynoq suvda qorilgan xamir.", "Ekler Lotus-karamel\n\nQaynatilgan xamir, karamelli krem, fundukli lotus nachinkasi va karamelli krustillant uyg‘unligida.", "Ekler Rafaello\n\nKokosli krem, vaflili krustilantdan toʻldirma bilan uygʻunlikda qaynoq suvda qorilgan xamir.", "Ekler Tiramisu\n\nQahvali qaynatma krem, qahva singdirilgan savoyardi pechenyesi bilan uygʻunlikda qaynoq suvda qorilgan xamir. Kakaoli vanilli krem bilan bezatilgan.", "Ekler Xandon pista-olcha\n\nQaynatilgan xamir, xandon pistali krem va olchali nachinka bilan uygʻunlashgan.", "Ekler Shokolad-Nutella\n\nQaynatilgan xamir, shokoladli qaynatma krem, fundukli shokoladli nachinka va shokoladli krustillant uyg'unligida."};
    String[] eklernarx = {"19 000", "23 000", "21 000", "21 000", "23 000", "20 000"};

    String[] makarons = {"Makarons Vanil dona", "Makarons Xandon pista dona", "Makarons Shokolad dona", "Makarons Ekzotik dona", "Makarons Reza meva dona", "Makarons miks 10 dona", "Makarons miks 5 dona", "⬅\uFE0F Ortga"};
    String[] makaronsphoto = {"https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/159", "https://t.me/safiapictures/160"};
    String[] makaronscaption = {"Makarons Vanil dona\n\nVanil toʻldirmali bodomli xamir.", "Makarons Xandon pista dona\n\nXandon pista toʻldirmali bodomli xamir.", "Makarons Shokolad dona\n\nShokolad toʻldirmali bodomli xamir.", "Makarons Ekzotik dona\n\nEkzotik toʻldirmali bodomli xamir.", "Makarons Reza meva dona\n\nReza meva toʻldirmali bodomli xamir.", "Makarons miks 10 dona\n\nTurli toʻldirmali bodomli xamir.", "Makarons miks 5 dona\n\nTurli toʻldirmali bodomli xamir."};
    String[] makaronsnarx = {"8 000", "8 000", "8 000", "8 000", "8 000", "75 000", "39 000"};

    String[] tayyotovqat = {"Boul mol go'shtli", "Boul tovuqli", "Roll tovuqli", "Salat Grechka", "Salat Sezar", "Sendvich go'shtli", "Yasmiq sho'rva", "Sendvich tovuqli", "Sendvich-kruassan kurkali", "Tovuq filesi sabzavotlar bilan", "⬅\uFE0F Ortga"};
    String[] tayyorovqatphoto = {"https://t.me/safiapictures/161", "https://t.me/safiapictures/162", "https://t.me/safiapictures/163", "https://t.me/safiapictures/164", "https://t.me/safiapictures/165", "https://t.me/safiapictures/166", "https://t.me/safiapictures/167", "https://t.me/safiapictures/168", "https://t.me/safiapictures/169", "https://t.me/safiapictures/170"};
    String[] tayyorovqatcaption = {"Boul mol go’shtli\n\nYumshoq mol go‘shti, qaynatilgan guruch, grechka, aysberg salati, shirin makkajo‘xori, yangi cherrilar, loviya, limon, bodringlar, bedana tuxumi va bir nechta souslardan iborat boul.", "Boul tovuqli\n\nTovuq go‘shti, qaynatilgan guruch, grechka, aysberg salati, chuka, shirin makkajo‘xori, yangi cherrilar, loviya, limon, bodringlar, bedana tuxumi va bir nechta souslardan iborat boul.", "Roll tovuqli\n\nYumshoq lavashda yangi pomidor, bodring, aysberg va tar-tar sousi qo’shib tayyorlangan tovuqli roll.", "Salat Grekcha\n\nYangi bodring, cherri, bulg’or qalampir, limon, fetaksa pishlog’i va ziravorlar bilan salat barglari, qora va yashil zaytun va brend qaylasi qo’shib tayyorlangan salat.", "Salat Sezar\n\nTovuq lahmi, aysberg barglari, yangi cherri, qarsildoq suxarik, “Sezar” brend qaylasi va parmezan bilan salat.", "Sendvich go'shtli\n\nMol go’shtidan bekon va dudlangan kesik, yumshoq pishloq, aysberg, yangi bodring, pomidor, patison va “Sezar” brend qaylasi bilan qarsildoq toster nonidan sendvich.", "Yasmiq sho’rva\n\nSabzavotlar va ziravorlar bilan to’yimli yasmiq sho’rva.", "Sendvich tovuqli\n\nBrenddan Chiabatta, sarimsoq, toshchoʻp va rozmarin bilan toblab pishirilgan tovuq toʻsh goʻshti, quritilgan pomidor, Aysberg salati yaproqlari va bodring tilimlari.", "Sendvich-kruassan kurkali\n\nBrenddan Briosh Kruassan noni, dudlangan kurka lahmi, Chedder pishlogʻi, mayonez, zanjabil, soya qaylasi, ukrop, limon sharbati, Aysberg yaproqlari va bodring tilimlari.", "Tovuq filesi sabzavotlar bilan\n\nBaqlajon, qovoqcha, bulg’or qalampiri, cherri, ziravorlar, sarimsoq va sersuv tovuq lahmi."};
    String[] tayyorovqatnarx = {"50 000", "50 000", "26 000", "35 000", "36 000", "29 000", "23 000", "31 000", "31 000", "42 000"};

    String[] shirinlik = {"Olchali murabbo", "Buta mevali murabbo", "Jem olmali", "Draje 'keshyu v shokolade", "Draje 'Mindal v shokolade'", "Draje 'Funduk v shokolade", "Keks apelsinli dona", "Ledenets", "Ledenets o'yinchoqli", "Marshmellou raduga", "Mishka Barni", "Oreshek", "Popkorn karamelli", "Popkorn shokoladli", "Shirin o'yinchoq Betmen", "Shirin o'yinchoq Kapitan Amerika", "Truboschla quuyltirilgan sutli", "To'g'rama chak chak mini korobka", "Turkcha chak chak", "Chupa-pops", "Chupa-pops mastikali", "Shokolad Safia karamel-yong'oqli", "Shokolad Safia kokosli", "⬅\uFE0F Ortga"};
    String[] shirinlikphoto = {"https://t.me/safiapictures/171", "https://t.me/safiapictures/172", "https://t.me/safiapictures/173", "https://t.me/safiapictures/174", "https://t.me/safiapictures/175", "https://t.me/safiapictures/176", "https://t.me/safiapictures/177", "https://t.me/safiapictures/178", "https://t.me/safiapictures/179", "https://t.me/safiapictures/180", "https://t.me/safiapictures/181", "https://t.me/safiapictures/182", "https://t.me/safiapictures/183", "https://t.me/safiapictures/184", "https://t.me/safiapictures/185", "https://t.me/safiapictures/185", "https://t.me/safiapictures/186", "https://t.me/safiapictures/187", "https://t.me/safiapictures/188", "https://t.me/safiapictures/189", "https://t.me/safiapictures/190", "https://t.me/safiapictures/191", "https://t.me/safiapictures/191"};
    String[] shirinlikcaption = {"Olchali murabbo\n\nDanaksiz olcha, shakar, sitrus pektinlari, suv, kislotalilik regulyatori – limon kislota.", "Buta mevali murabbo\n\nMuzlatilgan buta meva, shakar", "Jem olmali\n\nTozalangan olma pyuresi, shakar, kislotalilik regulyatori - limon kislota.", "Draje Keshyu v shokolade\n\nOq shokolad qoplangan keshyu", "Draje Mindal v shokolade\n\nQora shokolad qoplangan bodom", "Draje Funduk v shokolade\n\nKaramelli shokolad qoplangan funduk", "Keks apelsinli dona\n\nShakarlangan apelsin mevalari bilan uygʻunlikda apelsinli yumshoq keks.", "Ledenets\n\nShakar kukuni, suv", "Ledenets o'yinchoqli\n\nShakar kukuni, suv, mastika", "Marshmellou Raduga\n\nOlma sharbati, shakar, jelatin (halol), tuxum, glyukoza, tabiiy aromatizator, tabiiy boʻyoq modda", "Mishka Barni\n\nOliy navli un, shakar, tuxum, vanilin, tuz, shokolad.", "Oreshek\n\nQaynatma quyultirilgan sut va yongʻoqli qumoq xamir", "Popkorn karamelli\n\nPopkorn karamelli", "Popkorn shokoladli\n\nPopkorn shokoladli", "Shirin o'yinchoq Betmen\n\nShakar kukuni, suv", "Shirin o'yinchoq Kapitan Amerika\n\nShakar kukuni, suv", "Trubochka quyultirilgan sutli\n\nQaynatib tayyorlangan quyultirilgan sutli shirin vafli xamiri.", "To'g'rama chak chak mini korobka\n\nTo'g'rama chak chak mini korobka", "Turkcha chak chak\n\nQumoq xamir, sariyogʻ va shokoladli ganash hamda kunjut va qaynatilgan quyultirilgan sut bilan uygʻunlikda.", "Chupa-pops\n\nShokolad qoʻshilgan yongʻoqli keks. Sutli shokolad bilan qoplangan.", "Chupa-pops mastikali\n\nShokolad qoʻshilgan yongʻoqli keks. Sutli shokolad bilan qoplangan va mastika bilan bezalgan.", "Shokolad Safia karamel-yong'oqli\n\nSutli shokolad, karamel, yeryongʻoq, mayiz", "Shokolad Safia kokosli\n\nSutli shokolad, kokosli toʻldirma"};
    String[] shirinliknarx = {"32 000", "39 000", "32 000", "55 000", "49 000", "49 000", "9 000", "10 000", "16 000", "13 000", "8 000", "5 500", "35 000", "35 000", "13 000", "13 000", "14 000", "59 000", "69 000", "12 000", "17 000", "13 000", "13 000"};

    String[] pechenye = {"Biskotti klassik", "Grissini mini", "Grissini", "Baunti Mini pechenye", "Lochira Mini pechenye", "Ovsyanka Mini pechenye", "Sushki Mini pechenye", "Muraveynik", "Bananchiklar Pechenye", "Baunti Pechenye", "Biskotti Pechenye", "Brauni dona Pechenye", "Zvezda mini Pechenye", "Zvezda Pechenye", "Karamelli dona Pechenye", "Keta Pechenye", "Kukis Pechenye", "Kunjutli Pechenye", "Kurabye mini Pechenye", "Limonli Pechenye", "Lochira Pechenye", "Luna mini Pechenye", "Luna Pechenye", "Mazurki Pechenye", "Mezumi Pechenye", "Nutella Pechenye", "Ovsyanka Pechenye", "Pechenye 'Palochki'", "Rakuchka mini Pechenye", "Rakushka Pechenye", "Rogalik olchali mini Pechenye", "Rogalik olchali Pechenye", "Rogalik yong'oqli Pechenye", "Rogalik quyultirilgan sutli mini", "Rogalik quyultirilgan sutli Pechenye", "Sushki Pechenye", "Shrek Pechenye", "Turkcha paxlava", "Keklar glyutensiz", "Mini keklar grechkali", "Keklar guruchli", "⬅\uFE0F Ortga"};
    String[] pechenyephoto = {"https://t.me/safiapictures/192", "https://t.me/safiapictures/193", "https://t.me/safiapictures/194", "https://t.me/safiapictures/195", "https://t.me/safiapictures/196", "https://t.me/safiapictures/197", "https://t.me/safiapictures/198", "https://t.me/safiapictures/199", "https://t.me/safiapictures/200", "https://t.me/safiapictures/201", "https://t.me/safiapictures/202", "https://t.me/safiapictures/203", "https://t.me/safiapictures/204", "https://t.me/safiapictures/205", "https://t.me/safiapictures/206", "https://t.me/safiapictures/207", "https://t.me/safiapictures/208", "https://t.me/safiapictures/209", "https://t.me/safiapictures/210", "https://t.me/safiapictures/211", "https://t.me/safiapictures/212", "https://t.me/safiapictures/213", "https://t.me/safiapictures/214", "https://t.me/safiapictures/215", "https://t.me/safiapictures/216", "https://t.me/safiapictures/217", "https://t.me/safiapictures/218", "https://t.me/safiapictures/219", "https://t.me/safiapictures/220", "https://t.me/safiapictures/221", "https://t.me/safiapictures/222", "https://t.me/safiapictures/223", "https://t.me/safiapictures/224", "https://t.me/safiapictures/225", "https://t.me/safiapictures/226", "https://t.me/safiapictures/227", "https://t.me/safiapictures/228", "https://t.me/safiapictures/229", "https://t.me/safiapictures/230", "https://t.me/safiapictures/231", "https://t.me/safiapictures/232"};
    String[] pechenyecaption = {"Biskotti klassik\n\nQumoq xamir, yongʻoqlar.", "Grissini mini\n\nKunjutli non tayoqchalari.", "Grissini\n\nKunjutli non tayoqchalari.", "Mini pechenye Baunti\n\nSutli shokolad boʻlaklari bilan qumoq-kokosli xamir.", "Mini pechenye Lochira\n\nSariyogʻ va sutda qorilgan xamir, kunjut.", "Mini pechenye Ovsyanka\n\nQumoq xamir suli yormasi bilan, yong‘oq va dolchin.", "Mini pechenye Sushki\n\nSariyogʻ va sut qoʻshilgan xamir, kunjut.", "Muraveynik\n\nAsal-karamelli krem va qaynatma quyultirilgan sutli qumoq xamir", "Pechenye Bananchiklar\n\nQumoq xamir, bezeli va yong‘oqli to’ldirma, qaynatilgan quyultirilgan sut va yong‘oqlar bilan bezatilgan", "Pechenye Baunti\n\nSutli shokolad boʻlaklari bilan qumoq-kokosli xamir.", "Pechenye Biskotti\n\nQumoq xamir, yongʻoq.", "Pechenye Brauni dona\n\nToʻyingan shokolad taʼmi bilan.", "Pechenye Zvezda mini\n\nQumoq xamir, olma, limon.", "Pechenye Zvezda\n\nQumoq xamir, olma, limon.", "Pechenye Karamelli dona\n\nQumoq xamir, fundukli karamel", "Pechenye Keta\n\nQumoq xamir, shakar bilan yongʻoq.", "Pechenye Kukis\n\nQumoq xamir, shokolad boʻlaklari va yongʻoq.", "Pechenye Kunjutli\n\nKunjut qoʻshilgan qumoq xamir.", "Pechenye Kurabye mini\n\nQumoq xamir, yongʻoq.", "Pechenye Limonli\n\nLimonli sedra bilan qumoq xamir.", "Pechenye Lochira\n\nSariyogʻ va sut qoʻshilgan xamir, kunjut.", "Pechenye Luna mini\n\nSariyogʻda tayyorlangan qumoq xamir.", "Pechenye Luna\n\nSariyogʻda tayyorlangan qumoq xamir.", "Pechenye Mazurki\n\nKishmish, yongʻoq va bargak qoʻshilgan biskvit asos.", "Pechenye Mezumi\n\nBeze, yongʻoq va shokolad boʻlaklari.", "Pechenye Nutella\n\nQumoq xamir, nutella, sutli shokolad boʻlaklaridan masalliq.", "Pechenye Ovsyanka\n\nQumoq xamir suli yormasi bilan, yong‘oq va dolchin.", "Pechenye \"Palochki\"\n\nQaymoq va sutda qorilgan, kunjut sepilgan xamir.", "Pechenye Rakushka mini\n\nQumoq xamir, beze, yongʻoq.", "Pechenye Rakushka\n\nQumoq xamir, beze, yongʻoq.", "Pechenye Rogalik olchali mini\n\nSmetana solingan qumoq xamir, olcha toʻldirmali.", "Pechenye Rogalik olchali\n\nSmetana solingan qumoq xamir, olcha toʻldirmali.", "Pechenye Rogalik yong'oqli\n\nQumoq xamir, shakar bilan qirgʻichdan oʻtkazilgan yongʻoq.", "Pechenye Rogalik quyultirilgan sutli mini\n\nSmetana solingan qumoq xamir, quyultirilgan sutdan toʻldirma.", "Pechenye Rogalik quyultirilgan sutli\n\nSmetana solingan qumoq xamir, quyultirilgan sutdan toʻldirma.", "Pechenye Sushki\n\nSariyogʻ va sutda tayyorlangan xamir. Kunjut bilan bezatilgan.", "Pechenye Shrek\n\nSariyogʻ va sutda tayyorlangan qumoq xamir", "Turkcha paxlava\n\nQumoq xamir, beze, yongʻoq va mayizdan masalliq", "Keklar glyutensiz\n\nKungaboqar urugʻi magʻzi, zigʻir urugʻi, oq kunjut, oʻsimlik moyi, tuz, suvdan parhezbop glyutensiz kulchalar.", "Mini keklar grechkali\n\nGrechka uni, glyutensiz undan aralashma asosida, oq kunjut, suli yormasi, zigʻir urugʻi, asal va uzum danaklari moyi qoʻshib tayyorlangan parhezbop grechixa kulchalari.", "Keklar guruchli\n\nGlyutensiz guruch uni asosida, zigʻir urugʻi, suli yormasi, oq kunjut, asal va uzum danagi moyi qoʻshib tayyorlangan hazmi yengil, parhezbop kulchalar."};
    String[] pechenyenarx = {"5 000", "12 000", "21 000", "20 000", "11 000", "13 000", "12 000", "5 500", "36 000", "49 000", "33 000", "19 000", "29 000", "50 000", "19 000", "37 000", "18 000", "24 000", "29 000", "33 000", "27 000", "26 000", "48 000", "29 000", "24 000", "19 000", "27 000", "14 000", "28 000", "62 000", "28 000", "55 000", "42 000", "26 000", "55 000", "21 000", "26 000", "35 000", "34 000", "35 000", "35 000"};

    String[] qadoqekler = {"Bushe Assorti", "Bushe oq shokoladli mini", "Bushe shokoladli mini", "Mini trubochka mini", "Mini trubochka", "Mini ekler Assorti mini", "Mini ekler Assorti", "Mini ekler Zavarnoy mini", "Mini ekler Zavarnoy", "Mini ekler Rangli mini", "Mini ekler Rangli", "Mini ekler Shokoladli mini", "Mini ekler Shokoladli", "⬅\uFE0F Ortga"};
    String[] qadoqeklerphoto = {"https://t.me/safiapictures/233", "https://t.me/safiapictures/234", "https://t.me/safiapictures/235", "https://t.me/safiapictures/236", "https://t.me/safiapictures/237", "https://t.me/safiapictures/238", "https://t.me/safiapictures/239", "https://t.me/safiapictures/240", "https://t.me/safiapictures/241", "https://t.me/safiapictures/242", "https://t.me/safiapictures/243", "https://t.me/safiapictures/244", "https://t.me/safiapictures/245"};
    String[] qadoqeklercaption = {"Bushe Assorti\n\nBiskvitli pechenye, vanilli krem, shokolad.", "Bushe oq shokoladli mini\n\nBiskvitli pechenye, vanilli krem, oq shokolad.", "Bushe shokoladli mini\n\nBiskvitli pechenye, vanilli krem, qora shokolad.", "Mini trubochka mini\n\nQat-qat xamir, qaymoqli-vanilli krem", "Mini trubochka\n\nQat-qat xamir, qaymoqli-vanilli krem", "Mini ekler Assorti mini\n\nEklerlar assortisi uchta turdan iborat: \"Baunti\", \"O'rikli\" va \"Qahvali\". Baunti, o'rik kremi va kofe kremi bilan to'ldirilgan qaynoq suvga qorilgan xamir.", "Mini ekler Assorti\n\nEklerlar assortisi uchta turdan iborat: \"Baunti\", \"O'rikli\" va \"Qahvali\". Baunti, o'rik kremi va kofe kremi bilan to'ldirilgan qaynoq suvga qorilgan xamir", "Mini ekler Zavarnoy mini\n\nQaynoq suvga qorilgan xamir, sariyog'li krem.", "Mini ekler Zavarnoy\n\nQaynoq suvga qorilgan xamir, sariyog'li krem.", "Mini ekler Rangli mini\n\nQaynoq suvga qorilgan xamir, qaymoqli-quyultirilgan sutli krem (olcha/shokolad/vanil).", "Mini ekler Rangli\n\nQaynoq suvga qorilgan xamir, qaymoqli-quyultirilgan sutli krem (olcha/shokolad/vanil).", "Mini ekler Shokoladli mini\n\nSariyog'li krem bilan qaynatma xamir. Shokolad qiyomi bilan qoplangan.", "Mini ekler Shokoladli\n\nSariyog'li krem bilan qaynatma xamir. Shokolad qiyomi bilan qoplangan."};
    String[] qadoqeklernarx = {"75 000", "39 000", "39 000", "25 000", "59 000", "45 000", "95 000", "25 000", "59 000", "39 000", "93 000", "31 000", "69 000"};

    String[] shirinpishiriq = {"Bulochka o'rik-bodom", "Vatrushka Bulochka", "Konvert Bulochka", "Bulochka olchali", "Bulochka makli", "Bulochka malinali", "Bulochka yong'oqli", "Bulochka olmali", "Bulochka quyultirilgan sutli", "Bulochka smorodinali", "Sochnik Bulochka", "Bulochka tvorog-bananli", "Ponchik o'rikli/2 dona", "Ponchik shokoladli/2 dona", "⬅\uFE0F Ortga"};
    String[] shirinpishiriqphoto = {"https://t.me/safiapictures/246", "https://t.me/safiapictures/247", "https://t.me/safiapictures/248", "https://t.me/safiapictures/249", "https://t.me/safiapictures/250", "https://t.me/safiapictures/251", "https://t.me/safiapictures/252", "https://t.me/safiapictures/253", "https://t.me/safiapictures/254", "https://t.me/safiapictures/255", "https://t.me/safiapictures/256", "https://t.me/safiapictures/257", "https://t.me/safiapictures/258", "https://t.me/safiapictures/259"};
    String[] shirinpishiriqcaption = {"Bulochka oʻrik-bodom\n\nOʻrik toʻldirmali achitqi solingan shirmoy xamir. Bulochka limonli yumshoq konfet va bodom gulbarglari bilan bezatilgan.", "Bulochka Vatrushka\n\nShirmoy xamir, tvorogdan toʻldirma.", "Bulochka Konvert\n\nShirmoy xamir, tvorogdan toʻldirma.", "Bulochka olchali\n\nShirmoy xamir, olchadan toʻldirma.", "Bulochka makli\n\nShirmoy xamir, makdan toʻldirma.", "Bulochka malinali\n\nMalina toʻldirmali achitqi solingan shirmoy xamir. Bulochka qumoq uvoqlari bilan bezatilgan.", "Bulochka yong'oqli\n\nShirmoy xamir, yongʻoqdan toʻldirma.", "Bulochka olmali\n\nShirmoy xamir, kesik olmadan toʻldirma.", "Bulochka quyultirilgan sutli\n\nShirmoy xamir, qaynatib quyultirilgan sutdan toʻldirma.", "Bulochka smorodinali\n\nQora smorodinadan toʻldirmali achitqi solingan shirmoy xamir. Bulochka bodomli yumshoq konfet va bodom gulbarglari bilan bezatilgan.", "Bulochka Sochnik\n\nQumoq xamir, tvorogdan toʻldirma.", "Bulochka tvorog-bananli\n\nTvorog va banan boʻlaklaridan shirmoy xamir.", "Ponchik o'rikli/2 dona\n\nKungaboqar moyida qovurilgan masalligʻli xamir. Oʻrik quyuq shinnisidan toʻldirmali.", "Ponchik shokoladli/2 dona\n\nKungaboqar moyida qovurilgan masalligʻli xamir. Shokolad bilan qoplangan."};
    String[] shirinpishiriqnarx = {"12 000", "9 000", "9 000", "12 000", "10 500", "12 500", "12 000", "9 000", "12 000", "12 500", "10 000", "12 000", "18 000", "20 000"};

    String[] keks = {"Keks apelsinli", "Keks olchali", "Keks olmali", "⬅\uFE0F Ortga"};
    String[] keksphoto = {"https://t.me/safiapictures/260", "https://t.me/safiapictures/261", "https://t.me/safiapictures/262"};
    String[] kekscaption = {"Keks apelsinli\n\nShakarlangan apelsin mevasi bilan birga yumshoq apelsinli keks. Keks shakar pomadka va shakarlangan apelsin mevasi bilan bezatilgan.", "Keks olchali\n\nShokoladli olchali keks yangi uzilgan olcha bilan birgalikda shokoladli va vanilli xamirdan iborat. Keks shokoladli yumshoq konfet va olcha bilan bezatilgan.", "Keks olmali\n\nDolchinli, karamellangan olma va karamellangan yongʻoqli yumshoq keks."};
    String[] keksnarx = {"85 000", "85 000", "85 000"};

    String[] tartaletka = {"Mini Tartaletka", "Mini tartaletka Volter", "Mini tartaletka Shokoladli", "⬅\uFE0F Ortga"};
    String[] tartaletkaphoto = {"https://t.me/safiapictures/263", "https://t.me/safiapictures/264", "https://t.me/safiapictures/265"};
    String[] tartaletkacaption = {"Mini tartaletka\n\nShokoladli ganash va koʻpirtirilgan qaymoqdan toʻldirmali yongʻoqli qumoq xamir. Mavsumiy reza mevalar bilan bezalgan.", "Mini tartaletka Volter\n\nQaymoqli karamelga belangan yongʻoq, bodom, keshyu, pista va fundukdan toʻldirma bilan qumoq-bodomli xamir.", "Mini tartaletka shokoladli\n\nShokoladli sutli ganash va mavsumiy barra reza mevalar bilan shokoladli qumoq xamir."};
    String[] tartaletkanarx = {"8 000", "8 500", "8 000"};

    String[] qatlamali = {"Kosichka makli", "Kosichka yong'oqli", "kruassan klassik", "Kruassan bodomli", "Kruassan pistali", "Kruassan shokoladli", "Kruassan Reza mevali", "Datskiy makli dona", "Datskiy yong'oqli dona", "Qatlama olmali", "Shokoladli Pain", "⬅\uFE0F Ortga"};
    String[] qatlamaliphoto = {"https://t.me/safiapictures/266", "https://t.me/safiapictures/267", "https://t.me/safiapictures/268", "https://t.me/safiapictures/269", "https://t.me/safiapictures/270", "https://t.me/safiapictures/271", "https://t.me/safiapictures/272", "https://t.me/safiapictures/273", "https://t.me/safiapictures/274", "https://t.me/safiapictures/275", "https://t.me/safiapictures/276"};
    String[] qatlamalicaption = {"Kosichka makli\n\nQatlama-achitqili xamir, makdan toʻldirma. Shakar siropi quyilgan.", "Kosichka yong'oqli\n\nQatlama-achitqili xamir, yongʻoqdan toʻldirma. Shakar siropi quyilgan.", "Kruassan klassik\n\nOshirma qatlama xamir.", "Kruassan bodomli\n\nBodomli oshirma qatlama xamir.", "Kruassan pistali\n\nPistali oshirma qatlama xamir.", "Kruassan shokoladli\n\nShokolad-fundukli pastadan tayyorlangan yengil qatlamli xamir.", "Kruassan Reza mevali\n\nMavsumiy reza mevali oshirma qatlama xamir.", "Datskiy makli dona\n\nQatlama-achitqili xamir, makdan toʻldirma. Shakar siropi quyilgan.", "Datskiy yong'oqli dona\n\nQatlama-achitqili xamir, yongʻoqdan toʻldirma. Shakar siropi quyilgan.", "Qatlama olmali\n\nPatisyer kremi, olma, dolchin va shakar bilan qat-qat xamirdan qatlama.", "Shokoladli Pain\n\nQaynatma krem va shokoladning ikki turi bilan qatlama-achitqili xamir. Asal siropi singdirilgan."};
    String[] qatlamalinarx = {"12 000", "12 000", "19 000", "29 000", "39 000", "26 000", "26 000", "4 500", "4 500", "19 000", "23 000"};

    String[] toyimli = {"Balish pyure va pishloqli", "Balish pyure va ismaloqli", "Blinchik go'shtli", "Blinchik tvorogli", "Bulochka sosiskali", "Qovurilgan chuchvara go'shtli qadoqda", "Qo'vurilgan chuchvara go'shtli kg", "Go'shtli obinon", "Paramach", "Parmuda go'shtli va tovuqli", "Pide", "Yopiq pitsa", "Ochiq pitsa", "Rasstegay karamli", "Rasstegay kartoshkali", "Rasstegay go'shtli", "Rasstegay tuxumli", "Qatlama sosiskali", "Smetanali somsa tovuqli", "Smetanali somsa go'shtli", "Mini somsa tovuqli/4 dona", "Mini somsa go'shtli/4 dona", "Somsa ko'katli", "Somsa kartoshkali", "Somsa tovuqli", "Somsa go'shtli", "Somsa qovoqli", "Xachapuri kalbasa va pishloqli", "Xachapuri pishloqli", "Yupqa", "⬅\uFE0F Ortga"};
    String[] toyimliphoto = {"https://t.me/safiapictures/277", "https://t.me/safiapictures/278", "https://t.me/safiapictures/279", "https://t.me/safiapictures/280", "https://t.me/safiapictures/281", "https://t.me/safiapictures/282", "https://t.me/safiapictures/283", "https://t.me/safiapictures/284", "https://t.me/safiapictures/285", "https://t.me/safiapictures/286", "https://t.me/safiapictures/287", "https://t.me/safiapictures/288", "https://t.me/safiapictures/289", "https://t.me/safiapictures/290", "https://t.me/safiapictures/291", "https://t.me/safiapictures/292", "https://t.me/safiapictures/293", "https://t.me/safiapictures/294", "https://t.me/safiapictures/295", "https://t.me/safiapictures/296", "https://t.me/safiapictures/297", "https://t.me/safiapictures/298", "https://t.me/safiapictures/299", "https://t.me/safiapictures/300", "https://t.me/safiapictures/301", "https://t.me/safiapictures/302", "https://t.me/safiapictures/303", "https://t.me/safiapictures/304", "https://t.me/safiapictures/305", "https://t.me/safiapictures/306"};
    String[] toyimlicaption = {"Balish pyure va pishloqli\n\nPyure va pishloqdan toʻldirmali yogʻli xamir.", "Balish pishloq va ismaloqli\n\nIsmaloq va pishloqdan toʻldirmali yogʻli xamir.", "Blinchik go'shtli\n\nQaymoq surtilgan xamir, mol goʻshti qiymasidan toʻldirma.", "Blinchik tvorogli\n\nQaymoq surtilgan xamir, tvorogdan toʻldirma.", "Bulochka sosiskali\n\nMasalliqli xamir, kanadacha sosiska.", "Qovurilgan chuchvara go'shtli qadoqda\n\nMol goʻshtidan qiyma, murch va tuzdan toʻldirmali, sariyogʻ solingan, qovurilgan oshirilmagan xamir.", "Qovurilgan chuchvara go'shtli kg\n\nMol goʻshti qiymasidan toʻldirmali, sariyogʻda qovurilgan chuchvara.", "Goʻshtli obinon\n\nMol goʻsht qiymasi, piyoz va ziravorlardan toʻldirmali yogʻli xamir.", "Paramach\n\nMol goʻshti qiymasi va piyoz toʻldirmali, achitqi solingan xamirdan paramach.", "Parmuda go'shtli va tovuqli\n\nSmetanali qumoq xamirdan somsa, goʻsht va tovuq goʻshtidan toʻldirma.", "Pide\n\nPishloq va sulugunidan toʻldirmali yogʻli xamir.", "Yopiq pitsa\n\nTovuq goʻshti, pishloq, qo'ziqorin va pomidorli qumoq xamir.", "Ochiq pitsa\n\nDudlangan kolbasa, bulgʻor qalampiri, ketchup, zaytun va pishloqdan toʻldirmali yogʻli xamir.", "Rasstegay karamli\n\nKaramdan toʻldirmali masalliqli xamir.", "Rasstegay kartoshkali\n\nKartoshka pyuredan toʻldirmali masalliqli xamir.", "Rasstegay go'shtli\n\nMasalliqli xamir, mol goʻshti qiymasi.", "Rasstegay tuxumli\n\nMasalliqli xamir, tuxum va koʻkpiyozdan toʻldirma.", "Qatlama sosiskali\n\nSosiskali, achitqi solingan qat-qat xamir.", "Smetanali somsa tovuqli\n\nTovuq goʻshti, piyoz va ziravorlardan toʻldirmali, smetana qo‘shilgan qumoq xamir.", "Smetanali somsa go'shtli\n\nGoʻshtli toʻldirmali, smetana solingan qumoq xamir.", "Mini somsa tovuqli/4 dona\n\nTovuq goʻshti, piyoz va ziravorlardan toʻldirmali qat-qat xamirdan somsa.", "Mini somsa go'shtli/4 dona\n\nQiymalangan goʻsht, piyoz va ziravorlardan toʻldirmali qat-qat xamirdan somsa.", "Somsa ko'katli\n\nIsmaloq va yalpizdan toʻldirmali qat-qat xamirdan somsa.", "Somsa kartoshkali\n\nKartoshka, piyoz va ziravorlardan toʻldirmali qat-qat xamirdan somsa.", "Somsa tovuqli\n\nTovuq goʻshti, piyoz va ziravorlardan toʻldirmali qat-qat xamirdan somsa.", "Somsa go'shtli\n\nToʻg'ralgan goʻsht, piyoz va ziravorli qat-qat xamirdan somsa.", "Somsa qovoqli\n\nQovoq, piyoz va ziravorlardan toʻldirmali qat-qat xamirdan somsa.", "Xachapuri kolbasa va pishloqli\n\nDudlangan kolbasa va pishloqli achitqi solingan qat-qat xamir.", "Xachapuri pishloqli\n\nPishloqli achitqi solingan qat-qat xamir.", "Yupqa\n\nMol goʻshti qiyma, piyoz va qizil sabzidan toʻldirmali oshirilmagan xamir."};
    String[] toyimlinarx = {"10 000", "10 000", "10 000", "7 000", "11 000", "39 000", "129 000", "10 000", "10 000", "9 000", "15 000", "12 000", "13 000", "7 500", "7 500", "10 500", "9 000", "17 000", "8 000", "8 500", "12 000", "18 000", "7 500", "7 500", "8 000", "9 500", "7 000", "14 000", "14 000", "11 500"};

    String[] praynik = {"Imbirli praynik Kapkeyk", "Imbirli praynik Prins", "Imbirli praynik Prinsessa", "Zanjabilli praynik 'Safia'", "Zanjabilli praynik 'Muzyurak'", "Bo'yaladigan praynik Dinozavrik", "Bo'yaladigan praynik Parovozik", "Bo'yaladigan praynik Poni", "⬅\uFE0F Ortga"};
    String[] zanjabilliphoto = {"https://t.me/safiapictures/307", "https://t.me/safiapictures/308", "https://t.me/safiapictures/309", "https://t.me/safiapictures/310", "https://t.me/safiapictures/311", "https://t.me/safiapictures/312", "https://t.me/safiapictures/313", "https://t.me/safiapictures/314"};
    String[] zanjabillicaption = {"Imbirli pryanik Kapkeyk\n\nShakar qiyomli zanjabilli pryanik.", "Imbirli pryanik Prins\n\nShakar qiyomli zanjabilli pryanik.", "Imbirli pryanik Prinsessa\n\nShakar qiyomli zanjabilli pryanik.", "Zanjabilli pryanik \"Safia\"\n\nShakar qiyomli zanjabilli pryanik.", "Zanjabilli pryanik \"Muzyurak\"\n\nShakar qiyomli zanjabilli pryanik.", "Bo'yaladigan pryanik Dinozavrik\n\nBo'yash uchun mo‘ljallangan pryanik.", "Bo'yaladigan pryanik Parovozik\n\nBo'yash uchun mo‘ljallangan pryanik.", "Bo'yaladigan pryanik Poni\n\nBo'yash uchun mo‘ljallangan pryanik."};
    String[] zanjabillinarx = {"27 000", "27 000", "27 000", "27 000", "27 000", "35 000", "35 000", "35 000"};

    String[] togriovqatlanish = {"TO Piroglar", "TO Yarim tayyor mahsulotlar", "TO Tortlari (PP)", "TO Pishiriqlar", "TO Pirojniylar (PP)", "⬅\uFE0F Asosiy menyuga"};

    String[] topirog = {"TO Pirog olma-olchali", "TO Pirog olchali", "TO Pirog mishka", "TO Pirog tvorog va klyukvali", "Pirog tvorogli chia va olxo'ri qoqi bilan tvorogli", "TO Pitog olmali", "⬅\uFE0F Ortga TO"};
    String[] topirogphoto = {"https://t.me/safiapictures/315", "https://t.me/safiapictures/316", "https://t.me/safiapictures/317", "https://t.me/safiapictures/318", "https://t.me/safiapictures/319", "https://t.me/safiapictures/320"};
    String[] topirogcaption = {"TO Pirog olcha-olmali\n\nOlma va olchadan sersuv to’ldirma bilan glyutensiz undan olma-olchali pirog.", "TO Pirog olchali\n\nTabiiy olcha va shakarni o’rnini bosuvchi mahsulotlar bilan glyutensiz undan olchali pirog.", "TO Pirog Mishka\n\nGlyutensiz undan oqsil va tabiiy shakarni o’rnini bosuvchi mahsulotlardan yumshoq yupqa qatlamli “Ptichye moloko” pirojniysi.", "TO Pirog tvorog va klyukvali\n\nQaymoqli tvorog va quritilgan klyukva bilan glyutensiz undan klyukvali tvorogli pirog.", "Pirog tvorogli chia va olxo’ri qoqi bilan tvorogli\n\nShakar qo’shmasdan glyutensiz asosida tayyorlangan chia va olxo’ri qoqi bilan tvorogli pirog.", "TO Pirog olmali\n\nYangi olma bilan va shakar qo’shmasdan glyutensiz undan tayyorlangan olmali pirog."};
    String[] topirognarx = {"27 000", "26 000", "43 000", "27 000", "28 000", "27 000"};

    String[] toyarimtayyor = {"TO Varenik kartoshka va qo'ziqorinli", "TO Somsa ko'katli va pishloqli/3 dona", "TO Somsa tovuqli/3 dona", "TO Somsa qiyma go'shtli/4 dona", "TO Somsa go'shtli va piyozli/3 dona", "TO Manti go'shtli", "TO Chuchvara mol go'shtli", "⬅\uFE0F Ortga TO"};
    String[] toyarimtayyorphoto = {"https://t.me/safiapictures/321", "https://t.me/safiapictures/322", "https://t.me/safiapictures/323", "https://t.me/safiapictures/324", "https://t.me/safiapictures/325", "https://t.me/safiapictures/326", "https://t.me/safiapictures/327"};
    String[] toyarimtayyorcaption = {"TO Varenik kartoshka va qo’ziqorinli\n\nKartoshka va qo‘ziqorinli glyutensiz varenik.", "TO Somsa ko’katli va pishloqli/3 dona\n\nMavsumiy ko’katlar va pishloq bilan glyutensiz undan somsa.", "TO Somsa tovuqli/3 dona\n\nTovuq go’shtidan to’ldirmali glyutensiz undan somsa.", "TO Somsa qiyma go’shtli/4 dona\n\nMol go’shti qiymasidan to’ldirmali glyutensiz undan somsa.", "TO Somsa go’shtli va piyozli/3 dona\n\nChopma go’sht va piyozdan to’ldirmali glyutensiz undan somsa.", "TO Manti go’shtli\n\nMol go’shtidan to’ldirmali yupqa glyutensiz xamirdan manti.", "TO Chuchvara mol go’shtli\n\nShirali mol go’shtidan to’ldirmali glyutensiz undan uyda tugulgan chuchvara."};
    String[] toyarimtayyornarx = {"39 000", "46 000", "46 000", "72 000", "53 000", "41 000", "54 000"};

    String[] totortpp = {"Mevali TO (PP) mini torti", "O'rmon rezavor mevali tort TO (PP)", "TO Tort Snikers", "TO Tort Pista-malinali", "Matcha Limonli", "TO Tort Shokolad-olchali", "⬅\uFE0F Ortga TO"};
    String[] totortppphoto = {"https://t.me/safiapictures/328", "https://t.me/safiapictures/329", "https://t.me/safiapictures/330", "https://t.me/safiapictures/331", "https://t.me/safiapictures/332", "https://t.me/safiapictures/333"};
    String[] totortppcaption = {"Mevali TO (PP) mini torti\n\nMevali TO (PP) mini torti tabiiy apelsin sharbati bilan namlangan oq klassik bikvitdan iborat. Ko’pirtirilgan yengil qaymoq va PP beze, malina va banan bilan birgalikda. Tort tvorogli pishloq kremi va yangi rezavor mevalar bilan bezatilgan. Bug'doy uni va shakarsiz, glyutensiz un va tabiiy shakar o’rnini bosuvchi steviya va eritrit aralashmasi asosida tayyorlangan. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi.", "O’rmon rezavor mevali tort TO (PP)\n\nTO (PP) torti \"O'rmon rezavorlari\" - karkade choyi va rezavor namlannmasi va malina konfisi bilan birgalikda steviyasi asosida tayyorlangan. Pirojniy bug'doy uni va shakarsiz, glyutensiz un va tabiiy shakar o’rnini bosuvchi aralashmasi asosida tayyorlangan. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi.", "TO Tort Snikers\n\nYeryong’oq, karamel va shakarsiz shokolad bilan glyutensiz undan tayyorlangan TO “Snikers” torti. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi.", "TO Tort Pista-malinali\n\nTvorogli pishloq va TO quyultirilgan sutda nayin krem bilan uyg’unlikda tabiiy malina, maymunjon, golubika, pista qo’shib glyutensiz undan tayyorlangan “Malinali pistali” TO torti. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi.", "Matcha Limon\n\nPP \"Matcha Limon\" torti – yapon matcha choyi va vanil sharbatiga singdirilgan bodomli bikvit, steviya asosidagi limonli konfityur va matcha choyli engil muss bilan birlashtirilgan. Pirojniy bug'doy uni va shakarsiz, glyutensiz un va tabiiy shakar o’rnini bosuvchi aralashmasi asosida tayyorlangan. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi.", "TO Tort Shokolad-olchali\n\nOlcha va shakarsiz krem, hamda steviyada sutli va qora shokolad qo’shib, glyutensiz undan tayyorlangan oshirma lochira asosidagi “Shokoladli-olchali” TO torti. Tortga buyurtmalar 3-4 kun oldin qabul qilinadi."};
    String[] totortppnarx = {"196 000", "223 000", "247 000", "247 000", "223 000", "212 000"};

    String[] topishiriq = {"TO Blinchik go'shtli", "TO Kish tovuq va  qo'ziqorinli", "TO Kish sabzavotli", "TO Somsa ko'katli va pishloqli", "TO Somsa tovuqli", "TO Somsa qiyma go'shtli", "TO Somsa go'shtli va piyozli", "⬅\uFE0F Ortga TO"};
    String[] topishiriqphoto = {"https://t.me/safiapictures/334", "https://t.me/safiapictures/335", "https://t.me/safiapictures/336", "https://t.me/safiapictures/337", "https://t.me/safiapictures/338", "https://t.me/safiapictures/339", "https://t.me/safiapictures/340"};
    String[] topishiriqcaption = {"TO Blinchik go’shtli\n\nMol go’shti qiymasidan to’ldirmali glyutensiz undan blinchiklar.", "TO Kish tovuq va qo’ziqorinli\n\nTovuq lahmi, qo’ziqorin va pishloqdan to’ldirmali glyutensiz undan kish.", "TO Kish sabzavotli\n\nBulg’or qalampiri, pomidor, shirin makkajo’xori, no’xatdan to’ldirmali glyutensiz undan ko’kat qo’shib tayyorlangan kish.", "TO Somsa ko’katli va pishloqli\n\nMavsumiy ko’katlar va pishloq bilan glyutensiz undan somsa.", "TO Somsa tovuqli\n\nYumshoq tovuq go’shtidan to’ldirmali glyutensiz undan somsa.", "TO Somsa qiyma go’shtli\n\nMol go’shti qiymasidan to’ldirmali glyutensiz undan somsa.", "TO Somsa go’shtli va piyozli\n\nChopma go’sht va piyozdan to’ldirmali glyutensiz undan somsa."};
    String[] topishiriqnarx = {"15 000", "26 000", "37 000", "16 000", "16 000", "20 000", "20 000"};

    String[] topirojniypp = {"TO batonchik klassik", "TO batonchik shokoladli", "TO Mini profitroli", "TO Nyu-York Chizkeyk", "TO Pirojniy Vishenka", "TO Pirojniy Kartoshka", "TO Pirojniy O'rmon rezavorlari", "TO Pirojniy 'Lesniye yagodi'", "TO pirojniy Malinali", "TO Pirojniy Malinali", "TO Pirojniy Medovik", "TO Pirojniy Napoleon", "TO Pirojniy 'Ptichye moloko'", "TO Pirojniy Skazka", "TO Pirojniy Chay Matcha", "TO Pirojniy Merengali", "TO San-Sebastyan chizkeyk", "TO Choy matcha-limonli", "TO Chia pudding laktozasiz", "TO Ekler", "⬅\uFE0F Ortga TO"};
    String[] topirojniyppphoto = {"https://t.me/safiapictures/341", "https://t.me/safiapictures/342", "https://t.me/safiapictures/343", "https://t.me/safiapictures/344", "https://t.me/safiapictures/345", "https://t.me/safiapictures/346", "https://t.me/safiapictures/347", "https://t.me/safiapictures/348", "https://t.me/safiapictures/349", "https://t.me/safiapictures/350", "https://t.me/safiapictures/351", "https://t.me/safiapictures/352", "https://t.me/safiapictures/353", "https://t.me/safiapictures/354", "https://t.me/safiapictures/355", "https://t.me/safiapictures/356", "https://t.me/safiapictures/357", "https://t.me/safiapictures/358", "https://t.me/safiapictures/359", "https://t.me/safiapictures/360"};
    String[] topirojniyppcaption = {"TO batonchik klassik\n\nQuritilgan bargak, suli yormasi, Goji rezavor mevalar, tabiiy yeryongʻoqli pasta, quritilgan xurmo, quritilgan anjir, yongʻoq, qovoq urugʻi, tabiiy asal, apelsin sedrasi.", "TO batonchik shokoladli\n\nTO granola, suli yormasi, yongʻoq, soya proteini, tabiiy funduk pastasi, quritilgan qora olxoʻri, steviyaga belangan qora shokolad 72%, tabiiy asal.", "TO Mini profitroli\n\nShakarsiz qaymoqli to’ldirma bilan glyutensiz unda tayyorlangan oshirma xamirdan mini-profitroli.", "TO Nyu York chizkeyk\n\nTvorogli pishloq ta’mi bilinib turadigan, glyutensiz undan tayyorlangan “Nyu-York” chizkeyki.", "TO Pirojniy Vishenka\n\nGlyutensiz undan shokoladli biskvit va krem bilan tabiiy shakarni o’rnini bosuvchi mahsulotlar va shokolad asosida shakarsiz tayyorlangan “Olcha” pirojniysi.", "TO Pirojniy Kartoshka\n\nYongʻoq, TO granola va qora shokolad bilan uygʻunlikda glyutensiz undan aralashma asosidagi biskvit.", "TO pirojniy O'rmon rezavorlari\n\nReza mevali krem va malinali konfi bilan uygʻunlikda karkade choyi bilan va steviyaga belab reza meva singdirilgan reza mevali biskvit.", "TO Pirojniy “Lesniye yagodi”\n\nMalina, maymunjon, qulupnay va qora smorodina kabi reza mevalar hamda shakarsiz qaymoqli krem bilan glyutensiz undan “Lesnaya yagoda” pirojniysi.", "TO pirojniy Malinali\n\nTvorogli pishloq, malinali krem va barra malina bilan uygʻunlikda glyutensiz undan aralashma asosidagi biskvit.", "TO Pirojniy Malinali\n\nShakarsiz tvorogli krem va yang uzilgan malina bilan glyutensiz undan “Malinali” pirojniy.", "TO pirojniy Medovik\n\nAsal, tvorogli krem va malinali konfi bilan uygʻunlikda glyutensiz undan aralashma asosidagi asalli yupqa lochira.", "TO Pirojniy Napoleon\n\nQaymoqli krem va reza mevali konfi bilan uygʻunlikda glyutensiz undan aralashma asosidagi qumoq xamir.", "TO Pirojniy “Ptichye moloko”\n\nGlyutensiz undan oqsil va tabiiy shakarni o’rnini bosuvchi mahsulotlardan yumshoq yupqa qatlamli “Ptichye moloko” pirojniysi.", "TO Pirojniy Skazka\n\nShakarsiz sutli shokolad asosida yoqimli bodom ta’mi va krem bilan glyutensiz undan “Skazka” ruleti.", "TO Pirojniy Chay Matcha\n\nYapon Matcha choyi, steviyaga belab singdirilgan vanil, limonli konfityur, matcha choyli yengil muss bilan bodomli biskvit.", "TO Pirojniy Merengali\n\nQaymoqli krem, yangi uzilgan malina va qizil smorodinadan to’ldirmali glyutensiz kraxmalda merengadan rulet.", "TO San-Sebastyan chizkeyk\n\nShakarsiz sutli va qora shokolad qo’shib va tvorogli-qaymoqli asos bilan “San-Sebastyan” chizkeyki.", "TO Choy matcha-limon\n\nTabiiy matcha, limon va shakarsiz qaymoqli krem qo’shib glyutensiz unda tayyorlangan biskvitdan “Matcha-limon” pirojniysi.", "TO Chia pudding laktozasiz\n\nLaktozasiz yogurt, chia urug’lari va yangi mango va marakuyya bilan kokos sutida chiali puding.", "TO Ekler\n\nShakarsiz qora va sutli shokoladdan qaymoqli to’ldirma va dekor bilan glyutensiz undan yumshoq xamirda tayyorlangan ekler."};
    String[] topirojniyppnarx = {"19 000", "17 000", "37 000", "37 000", "27 000", "15 000", "35 000", "33 000", "34 000", "23 000", "31 000", "37 000", "18 000", "37 000", "34 000", "19 000", "41 000", "33 000", "39 000", "17 000"};

    String[] yarimtayyor = {"Varenik kartoshkali", "Do'lma karamli", "Do'lma mol go'shtidan", "Kotlet mol go'shtidan/5 dona", "Kotlet tovuq go'shtidan/5 dona", "Kotlet kiyevcha/3 dona", "Mini chuchvara Rangli", "Naggets/12 dona", "Chuchvara qo'y go'shtidan", "Chuchvara mol go'shtidan", "Sirnik/8 dona", "Qatlama uchun qat-qat xamir", "Somsa uchun qat-qat xamir", "Cheburek go'shtli/4 dona", "⬅\uFE0F Asosiy menyuga"};
    String[] yarimtayyorphoto = {"https://t.me/safiapictures/361", "https://t.me/safiapictures/362", "https://t.me/safiapictures/363", "https://t.me/safiapictures/364", "https://t.me/safiapictures/365", "https://t.me/safiapictures/366", "https://t.me/safiapictures/367", "https://t.me/safiapictures/368", "https://t.me/safiapictures/369", "https://t.me/safiapictures/370", "https://t.me/safiapictures/371", "https://t.me/safiapictures/372", "https://t.me/safiapictures/373", "https://t.me/safiapictures/374"};
    String[] yarimtayyorcaption = {"Varenik kartoshkali\n\nUn, kartoshka, piyoz, tuz, qalampir, sariyogʻ, tuxum", "Do'lma karamli\n\nMol goʻshti, piyoz, guruch, tuz, oʻsimlik moyi, xitoy tuzi, murch, zira, yanchilgan, suv, karam.", "Dolma mol go'shtidan\n\nMol goʻshti, uzum barglari, guruch, piyoz, tuz, kinza, zira, qalampir, oʻsimlik moyi, suv.", "Kotlet mol go'shtidan/5 dona\n\nMol goʻshtidan qiyma, piyoz, ziravorlar (konservantlarsiz)", "Kotlet tovuq go'shtidan/5 dona\n\nTovuq goʻshtidan qiyma, piyoz, ziravorlar (konservantlarsiz)", "Kotlet kiyevcha/3 dona\n\nTovuq lahmi, sariyogʻ, shivit, tuz, qalampir, bulash uchun suxari uni.", "Mini chuchvara Rangli\n\nLavlagi, sabzi, ismaloq sharbati qoʻshib tayyorlangan xamir, mol goʻshti, piyoz va ziravorlardan qiymali toʻldirma (konservantlarsiz).", "Naggets/12 dona\n\nTovuq lahmi, sariyogʻ, tuz, qalampir, bulash uchun suxari uni, oregano.", "Chuchvara qo'y go'shtidan\n\nXamir, qoʻy goʻshtidan qiyma, piyoz, ziravorlar (konservantlarsiz).", "Chuchvara mol go'shtidan\n\nXamir, mol goʻshtidan qiyma, piyoz, ziravorlar (konservantlarsiz).", "Sirnik/8 dona\n\nTvorog, bugʻdoy uni, tuxum, shakar, xamir yumshatkich.", "Qatlama uchun qat-qat xamir\n\nBugʻdoy uni, sariyogʻ, oʻsimlik moyi, shakar, tuz, toza ichimlik suvi", "Somsa uchun qat-qat xamir\n\nBugʻdoy uni, sariyogʻ, oʻsimlik moyi, shakar, tuz, toza ichimlik suvi", "Cheburek go'shtli/4 dona\n\nBugʻdoy uni, tuxum, margarin, mol yogʻi, tuz, qalampir, mol lahm goʻshti, piyoz."};
    String[] yarimtayyornarx = {"15 000", "39 000", "49 000", "70 000", "60 000", "49 000", "59 000", "29 000", "53 000", "53 000", "31 000", "24 000", "24 000", "29 000"};

    String[] non = {"Non 'Borodinskiy'", "Non 'Slavyanskiy aromat'", "Non 'Sport aktiv'", "Non 'Tartin'", "⬅\uFE0F Asosiy menyuga"};
    String[] nonphoto = {"https://t.me/safiapictures/375", "https://t.me/safiapictures/376", "https://t.me/safiapictures/377", "https://t.me/safiapictures/378"};
    String[] noncaption = {"Non \"Borodinskiy\"\n\nBug‘doy uni va kepak unidan tayyorlangan, solod, xamirturush va zakvaska qo‘shilgan non", "Non \"Slavyanskiy aromat\"\n\nBug‘doy va javdar unidan tayyorlangan, solod va ziravorlarning boy hidiga ega, don va xamirturush qo‘shilgan non.", "Non \"Sport aktiv\"\n\nChigit, suli va sabzi donlari qo‘shilgan, xamirturushda tayyorlangan bug‘doy noni.", "Non \"Tartin\"\n\nBug‘doy unidan va chigit donlaridan tayyorlangan, sekin zakvaskada xamirturush qo‘shilib pishirilgan non."};
    String[] nonnarx = {"15 000", "15 000", "15 000", "15 000"};

    String[] barmenyu = {"Yangi siqilgan sharbatlar", "Milksheyklar", "Limonadlar", "Qahva", "⬅\uFE0F Asosiy menyuga"};

    String[] yangisiqilgan = {"Apelsinli Fresh", "Sabzi-olmali Fresh (Safia)", "Sabzili Fresh (Safia)", "Olmali fresh (Safia)", "⬅\uFE0F Ortga Bar"};
    String[] yangisiqilganphoto = {"https://t.me/safiapictures/379", "https://t.me/safiapictures/380", "https://t.me/safiapictures/381", "https://t.me/safiapictures/382"};
    String[] yangisiqilgancaption = {"Apelsinli Fresh\n\n", "Sabzi-olmali Fresh (Safia)\n\n", "Sabzili Fresh (Safia)\n\n", "Olmali Fresh (Safia)\n\n"};
    String[] yangisiqilgannarx = {"50 000", "30 000", "22 000", "30 000"};

    String[] milksheyk = {"Bananli milksheyk", "Vanilli milksheyk", "Shokoladli milksheyk", "Rezavor mevali milksheyk", "⬅\uFE0F Ortga Bar"};
    String[] milksheykphoto = {"https://t.me/safiapictures/383", "https://t.me/safiapictures/384", "https://t.me/safiapictures/385", "https://t.me/safiapictures/386"};
    String[] milksheykcaption = {"Bananli milksheyk\n\n", "Vanilli milksheyk\n\n", "Shokoladli milksheyk\n\n", "Rezavor mevali milksheyk\n\n"};
    String[] milksheyknarx = {"40 000", "40 000", "45 000", "45 000"};

    String[] limonad = {"Ko'k Ays-ti", "Lesnaya yagoda limonad", "Tarxun apelsin limonad", "Mevali Ays-ti", "Sitrus limonad", "Qora Ays-ti", "⬅\uFE0F Ortga Bar"};
    String[] limonadphoto = {"https://t.me/safiapictures/387", "https://t.me/safiapictures/388", "https://t.me/safiapictures/389", "https://t.me/safiapictures/390", "https://t.me/safiapictures/391", "https://t.me/safiapictures/392"};
    String[] limonadcaption = {"Koʻk Ays-ti\n\n", "Lesnaya yagoda limonad\n\n", "Tarxun apelsin limonad\n\n", "Mevali Ays-ti\n\n", "Sitrus limonad\n\n", "Qora Ays-ti\n\n"};
    String[] limonadnarx = {"29 000", "35 000", "35 000", "29 000", "29 000", "29 000"};

    String[] kofe = {"Karamelli Frappe", "Ays amerikano", "Ays latte", "Ays kapuchino", "Shokoladli Frappe", "⬅\uFE0F Ortga Bar"};
    String[] kofephoto = {"https://t.me/safiapictures/393", "https://t.me/safiapictures/394", "https://t.me/safiapictures/395", "https://t.me/safiapictures/396", "https://t.me/safiapictures/397"};
    String[] kofecaption = {"Karamelli Frappe\n\n", "Ays amerikano\n\n", "Ays latte\n\n", "Ays kapuchino\n\n", "Shokoladli Frappe\n\n"};
    String[] kofenarx = {"24 000", "33 000", "29 000", "37 000", "37 000"};

    String[] qahva = {"Qahva abonementi - 15", "Qahva abonementi - 30", "⬅\uFE0F Asosiy menyuga"};
    String[] qahvaphoto = {"https://t.me/safiapictures/398", "https://t.me/safiapictures/399"};
    String[] qahvacaption = {"Qahva abonementi – 15\n\nAbonementga 15 ta tanlov bo‘yicha qahva ichimliklari porsiyasi kiradi: Amerikano (150 ml), Kapuchino (200 ml), Latte (200 ml), Espresso (50 ml), Ays latte, Ays amerikano, Ays kapuchino, Ikki hissa amerikano, Ikki hissa kapuchino, Ikki hissa espresso va Ikki hissa latte. Abonement amal qilish muddati – 15 kalendar kun (xarid qilingan kun hisobga olinmaydi). Ushbu muddat tugaganidan so‘ng abonement bekor qilinadi. Ulardan istalganini tanlang. Vaqtingiz va pulingizni tejang!", "Qahva abonementi – 30\n\nAbonementga 30 ta tanlov bo‘yicha qahva ichimliklari porsiyasi kiradi: Amerikano (150 ml), Kapuchino (200 ml), Latte (200 ml), Espresso (50 ml), Ays latte, Ays amerikano, Ays kapuchino, Ikki hissa amerikano, Ikki hissa kapuchino, Ikki hissa espresso va Ikki hissa latte. Abonement amal qilish muddati – 30 kalendar kun (xarid qilingan kun hisobga olinmaydi). Ushbu muddat tugaganidan so‘ng abonement bekor qilinadi. Ulardan istalganini tanlang. Vaqtingiz va pulingizni tejang!"};
    String[] qahvanarx = {"200 000", "350 000"};

    public SendMessage lan(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Iltimos, tilni tanlang:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton uz = new InlineKeyboardButton();
        uz.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili");
        uz.setCallbackData("uzId");
        row.add(uz);
        rowList.add(row);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton ru = new InlineKeyboardButton();
        ru.setText("\uD83C\uDDF7\uD83C\uDDFA Русский язык");
        ru.setCallbackData("ruId");
        row1.add(ru);
        rowList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();

        InlineKeyboardButton en = new InlineKeyboardButton();
        en.setText("\uD83C\uDDEC\uD83C\uDDE7 English");
        en.setCallbackData("enId");
        row2.add(en);
        rowList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton qz = new InlineKeyboardButton();
        qz.setText("\uD83C\uDDF0\uD83C\uDDFF Қазақ");
        qz.setCallbackData("qzId");
        row3.add(qz);
        rowList.add(row3);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;

    }

    public InlineKeyboardMarkup lan1(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Iltimos, tilni tanlang:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton uz = new InlineKeyboardButton();
        uz.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili");
        uz.setCallbackData("uzId");
        row.add(uz);
        rowList.add(row);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton ru = new InlineKeyboardButton();
        ru.setText("\uD83C\uDDF7\uD83C\uDDFA Русский язык");
        ru.setCallbackData("ruId");
        row1.add(ru);
        rowList.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();

        InlineKeyboardButton en = new InlineKeyboardButton();
        en.setText("\uD83C\uDDEC\uD83C\uDDE7 English");
        en.setCallbackData("enId");
        row2.add(en);
        rowList.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton qz = new InlineKeyboardButton();
        qz.setText("\uD83C\uDDF0\uD83C\uDDFF Қазақ");
        qz.setCallbackData("qzId");
        row3.add(qz);
        rowList.add(row3);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;

    }

    public InlineKeyboardMarkup uzmenu(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Safiaga xush kelibsiz! Quyidagilardan birini tanlang:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Biz haqimiza");
        button.setCallbackData("haqidaId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Menyu");
        button.setCallbackData("menuId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Qadriyatlarimiz");
        button.setCallbackData("qadriyatId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Manzillarimiz");
        button.setCallbackData("manzilId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Keytring");
        button.setCallbackData("keytingId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Tilni almashtirish");
        button.setCallbackData("sozlamaId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public SendMessage uzmenu1(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Safiaga xush kelibsiz! Quyidagilardan birini tanlang:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Biz haqimiza");
        button.setCallbackData("haqidaId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Menyu");
        button.setCallbackData("menuId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Qadriyatlarimiz");
        button.setCallbackData("qadriyatId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Manzillarimiz");
        button.setCallbackData("manzilId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Keytring");
        button.setCallbackData("keytingId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Tilni almashtirish");
        button.setCallbackData("sozlamaId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage shahar(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Istoqamat qilayotgan shahringizni tanlang:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();

        for (String city : cities) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(city);
            button.setCallbackData(city.toLowerCase() + "Id");
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage haqida(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Biz haqimizda bilmoqchi bo'lgan ma'lumotingiz turini tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Biz haqimizda");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Yutuqlarimiz");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Safia Store (\uD83C\uDDFA\uD83C\uDDFF)");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Bekor qilish");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendPhoto biz(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/3"));
        sendPhoto.setCaption("Safia Cafe & Bakery - bu haqiqiy oilaviy afsonaga va O‘zbekistonning eng yirik qandolat brendiga aylangan pishiriqqa bo‘lgan katta muhabbat haqidagi ilhomlantiruvchi hikoyadir. \n" + "\nTo‘qqiz yil ichida kompaniya mahalliy oilaviy biznesdan xalqaro brendga qadar ta’sirchan yo‘lni bosib o‘tdi. Bugun Safia Cafe & Bakery - bu:\n" + "\n145 ta filial, shu jumladan Qozog‘istondagi 4 ta shinam qahvaxona,Markaziy Osiyodagi eng yirik qandolat fabrikalaridan biri, minglab xodimlar, va yuz minglab minnatdor mijozlar, ularning kunlari bizning mehnatimiz tufayli biroz shirinroq bo‘ladi.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytbizId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto yutuq(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/4"));
        sendPhoto.setCaption("Safia Cafe&Bakery — Oʻzbekistonda muvaffaqiyatli oilaviy biznes namunasi.\n" + "\n" + "Buni kompaniya loyiq koʻrilgan koʻplab mukofotlar ham tasdiqlaydi.\n" + "\n" + "Mehmonlar va mijozlar mehrini qozongan va ularning eʼtirofiga sazovor boʻlgan holda, 2024-yil Safia Cafe&Bakery 5-marta “Yil brendi” mukofotini oldi.\n" + "\n" + "2023-yil TAF2023 marketing konferensiyasi doirasida Digital Innovator nominatsiyasida mukofotga loyiq koʻrildi.\n" + "\n" + "2021-yildan 2023-yilgacha Safia Cafe&Bakery kompaniyasi Employer Brand Award ish beruvchi brendi sohasida bir necha bor xalqaro mukofot gʻolibiga aylandi. \n" + "\n" + "Mehmonlarimiz bizdna kutadiganlarni ularga taqdim eta olish va ularning biz haqimizdagi fikrlari doim ijobiy boʻlishini taʼminlash imkoniyatimiz asosiy yutugʻimiz boʻlib qolaveradi. ");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytbizId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto store(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/6"));
        sendPhoto.setCaption("Mehmonlarimizga yanada yaqin boʻlish uchun cheklangan Safia Store kolleksiyasini yoʻlga qoʻydik.\n" + "\n" + "Unda hayotingizni toʻldiradigan va samimiylik baxsh etadigan betakror dizaynli hammasini topasiz.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytbizId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage qadriyat(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qadriyatlarimiz turlari:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⛰ Atrof-muhit");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66\u200D\uD83D\uDC66 Oila");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83E\uDDBD\u200D➡\uFE0F Inklyuziya");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Bekor qilish");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendPhoto muhit(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/7"));
        sendPhoto.setCaption("Ekologiyaga shu makon va zamonda qaygʻurgan holda, kelajak avlod uchun barqaror va toza istiqbolni taʼminlash – biznig qatʼiy maqsadimizdir!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytqadrId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto oila(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/8"));
        sendPhoto.setCaption("Ishimizni yaxshi koʻramiz! Oilaviy qadriyatlarga amal qilgan holda, qandolatchilik mahoratimizni rivojlantirib bormoqdamiz. Har bir inson va uning oilasi uchun bayram muhiti yaratamiz. Mehmonlarimizga samimiy munosabat bildirgan holda, mahsulotlarimiz eng yuqori sifatdagi tabiiy toʻldirmalardan tayyorlanishini kafolatlaymiz.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytqadrId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto inkl(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/9"));
        sendPhoto.setCaption("Barcha uchun qaygʻurib, ish oʻrinlari va adolatli mehnat sharoitlari bilan taʼminlaymiz!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytqadrId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage keytring(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Keytring turlari:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Safia Catering (\uD83C\uDDFA\uD83C\uDDFF)");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Afzalliklarimiz");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Hamkorlarimiz");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Bekor qilish");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendPhoto catering(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/10"));
        sendPhoto.setCaption("Bu biz siz uchun tashkil etib beradigan ayni sizning marosimingiz! Biz ham jismoniy shaxslarga, ham yuridikshaxslarga oʻz xizmatlarimizni taklif etamiz. \n" + "\n" + "Bizning mahoratli oshpazlarimiz va qandolatchilarimiz Toshkent shahri va xorijdagi eng nomdor oshpazlik muassasalarida oʻqib, oʻz malakalarini oshirganlar. Oʻzining boy tajribasiga suyangan holda, bizning mahoratli qandolatchilarimiz sizning  shaxsiy gʻoyalaringizni roʻyobga chiqaradilar va sizga zarur maslahatlarni bera oladilar.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytkeytId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto afzal(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/11"));
        sendPhoto.setCaption("Sizning taʼb va istaklaringizga qarab, biz tadbir uchun joyni tanlashdan boshlab, uni yuqori saviyada oʻtkazishgachaboʻlgan barcha bosqichlarni oʻz ichiga olgan ajoyib marosimni tashkil etib beramiz. “Tayyor tadbir” nomli xizmatlar kompleksi: joy tanlash, individual menyutuzish, koʻngilochar dastur kontenti, mebel, texnika va boshqa zaruriy jihozlar taʼminotini qamrab oladi.\n" + "\n" + "Oʻz ishining chinakam ustasi boʻlgan bezakchilarimizning fantaziyasi va ijodkorligi chegara bilmaydi. Biz tadbiringiz uchun xos va mos boʻlgan siz tasavvur qilgandan ham ziyoda noyob dizayn yaratamiz.\n" + "\n" + "Sifat va nozik taʼb – muvaffaqiyatimiz garovi. Mahsulotlarni tanlar ekanmiz, hamisha siz haqingizda va tadbirni zarur darajada oʻtkazish haqida oʻylaymiz.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytkeytId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto hamkor(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/12"));
        sendPhoto.setCaption("6 yil davomida biz har xil formatdagi qator tadbirlarni tashkil etishga muvaffaq boʻldik.\n" + "\n" + "Biz quyidagi kompaniyalar va brendlar bilan hamkorlik qilish baxtiga muyassar boʻlganmiz: Oʻzbekiston Milliy banki, Asiaalliance bank, World bank, Uztelecom, OKMK, Coca-cola Uzbekistan, BritishAmerican Tobacco, BeelineUzbekistan, Ucell, Humans va boshqalar!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅\uFE0F Qaytish");
        button.setCallbackData("qaytkeytId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage filial(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Barcha filiallarimiz: \nTelefon raqami: +998 78 113 40 40 \nIshlash vaqti: 08:00 dan 23:00 gacha");
        return sendMessage;
    }

    public SendMessage filialone(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (1-10)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();

        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextoneId");
        row1.add(next);
        rowList.add(row1);


        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < onetotwo.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(onetotwo[i]);
            button.setCallbackData(onetotwo[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public InlineKeyboardMarkup filialone1(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (1-10)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();

        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextoneId");
        row1.add(next);
        rowList.add(row1);


        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < onetotwo.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(onetotwo[i]);
            button.setCallbackData(onetotwo[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialtwo(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (11-20)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();

        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qayttwoId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nexttwoId");
        row1.add(next);


        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < twotothree.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(twotothree[i]);
            button.setCallbackData(twotothree[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialthree(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (21-30)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();

        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytthreeId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextthreeId");
        row1.add(next);


        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < threetofour.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(threetofour[i]);
            button.setCallbackData(threetofour[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialfour(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (31-40)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();

        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytfourId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextfourId");
        row1.add(next);


        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < fourtofive.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(fourtofive[i]);
            button.setCallbackData(fourtofive[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }

        if (!row.isEmpty()) {
            rowList.add(row);
        }

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialfive(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (41-50)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytfiveId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextfiveId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < fivetosix.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(fivetosix[i]);
            button.setCallbackData(fivetosix[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialsix(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (51-60)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytsixId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextsixId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < sixtoseven.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(sixtoseven[i]);
            button.setCallbackData(sixtoseven[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialseven(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (61-70)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytsevenId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextsevenId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < seventoeight.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(seventoeight[i]);
            button.setCallbackData(seventoeight[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialeight(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (71-80)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qayteightId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nexteightId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < eighttonine.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(eighttonine[i]);
            button.setCallbackData(eighttonine[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialnine(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (81-90)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytnineId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextnineId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < ninetoten.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(ninetoten[i]);
            button.setCallbackData(ninetoten[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialten(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (91-100)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qayttenId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nexttenId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < tentoeleven.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(tentoeleven[i]);
            button.setCallbackData(tentoeleven[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialeleven(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (101-110)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytelevenId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nextelevenId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < eleventotwelve.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(eleventotwelve[i]);
            button.setCallbackData(eleventotwelve[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialtwelve(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (111-120)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qayttwelveId");
        row1.add(qayt);
        rowList.add(row1);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡\uFE0F Keyingisi");
        next.setCallbackData("nexttwelveId");
        row1.add(next);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < twelvetothirteen.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(twelvetothirteen[i]);
            button.setCallbackData(twelvetothirteen[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup filialthirteen(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filiallarimiz: 131 ta (121-131)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅\uFE0F Asosiy menu");
        qaytf.setCallbackData("qaytfId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅\uFE0F Orqaga");
        qayt.setCallbackData("qaytthirteenId");
        row1.add(qayt);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < thirteentofourteen.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(thirteentofourteen[i]);
            button.setCallbackData(thirteentofourteen[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public SendMessage tel(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Telefon nomeringizni yuboring");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton mynum = new KeyboardButton();
        mynum.setText("\uD83D\uDCDE Mening nomerim");
        mynum.setRequestContact(true);
        row.add(mynum);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage orgmenu(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Kategoriyani tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton bir = new KeyboardButton();
        bir.setText("\uD83C\uDF70 Mazali shirinliklar bu yerda");
        row.add(bir);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton ikki = new KeyboardButton();
        ikki.setText("\uD83E\uDD57 To'g'ri ovqatlanish shirinliklari");
        row1.add(ikki);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton uch = new KeyboardButton();
        uch.setText("\uD83E\uDD5F Yarim tayyor mahsulotlar");
        row2.add(uch);
        rowList.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton tort = new KeyboardButton();
        tort.setText("\uD83E\uDD56 Avstriya noni");
        row3.add(tort);
        rowList.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton besh = new KeyboardButton();
        besh.setText("\uD83C\uDF79 Bar menyusi");
        row4.add(besh);
        rowList.add(row4);

        KeyboardRow row5 = new KeyboardRow();
        KeyboardButton olti = new KeyboardButton();
        olti.setText("\uD83E\uDDF8 Animatorlar yetkazib berish");
        row5.add(olti);
        rowList.add(row5);

        KeyboardRow row6 = new KeyboardRow();
        KeyboardButton yetti = new KeyboardButton();
        yetti.setText("☕\uFE0F Qahva abonementlari");
        row6.add(yetti);
        rowList.add(row6);

        KeyboardRow row7 = new KeyboardRow();
        KeyboardButton sakkiz = new KeyboardButton();
        sakkiz.setText("❌ Bekor qilish");
        row7.add(sakkiz);
        rowList.add(row7);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Savat");
        row7.add(savat);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage mazali(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Mazali shirinliklar bu yerda");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < mazali.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(mazali[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage yumaloqtort(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yumaloq tortlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < yumaloqtort.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(yumaloqtort[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage togriburchakli(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("To'g'ri burchakli tortlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < togriburchakli.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(togriburchakli[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage minitort(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Mini tortlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < minitort.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(minitort[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage kattapirog(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Katta piroglar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < pirog.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(pirog[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage yumaloqpirog(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yumaloq piroglar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < yumaloqpirog.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(yumaloqpirog[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage pirojniy(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Pirojniylar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < pirojni.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(pirojni[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage rulet(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Ruletlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < rulet.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(rulet[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage ekler(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Eklerlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < ekler.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(ekler[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage makarons(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Makaronslar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < makarons.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(makarons[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage tayyortaom(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Tayyor taomlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < tayyotovqat.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(tayyotovqat[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage shirinlik(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Shirinliklar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < shirinlik.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(shirinlik[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage pechenye(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Pechenye");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < pechenye.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(pechenye[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage qadoqekler(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qadoqdagi eklerlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < qadoqekler.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(qadoqekler[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage shirinpishiriq(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Shirin pishiriqlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < shirinpishiriq.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(shirinpishiriq[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage keks(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Kekslar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < keks.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(keks[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage tartaletka(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Tartaletkalar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < tartaletka.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(tartaletka[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage qatlamali(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qatlamali pishiriqlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < qatlamali.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(qatlamali[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage toyimli(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("To'yimli pishiriq");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < toyimli.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(toyimli[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage zanjabilli(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Zanjabilli pishiriqlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < praynik.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(praynik[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage togriovqatlanish(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("To'g'ri ovqatlanish shirinliklari");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < togriovqatlanish.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(togriovqatlanish[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage topirog(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("TO Piroglar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < topirog.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(topirog[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage toyarimtayyor(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("TO Yarim tayyor mahsulotlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < toyarimtayyor.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(toyarimtayyor[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage totortpp(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("TO Tortlari (PP)");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < totortpp.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(totortpp[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage topishiriq(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("TO Pishiriqlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < topishiriq.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(topishiriq[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage topirojniypp(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("TO Pirojniylar (PP)");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < topirojniypp.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(topirojniypp[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage yarimtayyor(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yarim tayyor mahsulotlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < yarimtayyor.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(yarimtayyor[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage non(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Avstriya noni");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < non.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(non[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage barmenyu(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Bar menyusi");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < barmenyu.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(barmenyu[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage sharbat(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yangi siqilgan sharbatlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < yangisiqilgan.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(yangisiqilgan[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage milksheyk(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Milksheyklar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < milksheyk.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(milksheyk[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage limonad(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Limonadlar");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < limonad.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(limonad[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage kofe(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qahva");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < kofe.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(kofe[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage qahva(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qahva abonementlari");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < qahva.length; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(qahva[i]);
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendPhoto tovar(Long chatId, String photo, String caption, String narx) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(photo));
        sendPhoto.setCaption(caption + "\n \nNarxi: " + narx + " so'm");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        for (int i = 1; i < 10; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(String.valueOf(i) + " ta");
            row.add(button);

            if (row.size() == 3) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton ortga = new KeyboardButton();
        ortga.setText("⬅\uFE0F Asosiy menyuga");
        row1.add(ortga);
        rowList.add(row1);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Savat");
        row1.add(savat);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        return sendPhoto;
    }

    public SendPhoto animatorbn(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://t.me/safiapictures/13"));
        sendPhoto.setCaption("Animator bilan yetkazib berish xizmati\n" + "\nTasavvur qiling, multfilmdagi xuddi shu qahramon tortni sizga etkazib beradi! ?⭐\uFE0F\n" + "\n" + "Bolalar uchun har qanday bayram, ayniqsa, bolaning tug'ilgan kuni kabi muhim, avjiga yoki chiroyli yakunga muhtoj. Biz sizning farzandingizning bayramini sehrli va unutilmas qilishni taklif qilamiz.\n" + "\n" + "Animator tortni bolaga an'anaviy qo'shiq ostida topshiradi, Xo'sh, bundan ham sehrliroq nima bo'lishi mumkin\n" + "\nNarxi: 180 000 so'm");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton qosh = new KeyboardButton();
        qosh.setText("\uD83D\uDED2 Savatga qo'shish");
        row.add(qosh);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton qayt = new KeyboardButton();
        qayt.setText("⬅\uFE0F Asosiy menyuga");
        row1.add(qayt);
        rowList.add(row1);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Savat");
        row1.add(savat);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage savat(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDECD Buyurtmangiz qabul qilinmoqda...");

        return sendMessage;
    }

    public SendMessage tasdiqlash(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Savatga qo'shishni tasdiqlaysizmi?");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Ha ✅");
        button.setCallbackData("yesId");
        row.add(button);
        rowList.add(row);

        button = new InlineKeyboardButton();
        button.setText("Yo'q ❌");
        button.setCallbackData("noId");
        row.add(button);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage yes(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Savatga qo'shildi ✅");
        return sendMessage;
    }

    public SendMessage no(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Xaridda davom eting \uD83D\uDECD");
        return sendMessage;
    }

    public SendMessage qz(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83C\uDDF0\uD83C\uDDFF⚙\uFE0F Жақында, басқа тілді таңдаңыз");
        return sendMessage;
    }

}
