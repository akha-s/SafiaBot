package org.example;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
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

public class MyBotServiceEn {
    String[] cities = {"Tashkent", "Fergana", "Chirchiq", "Urgench", "Bekobod", "Andijan", "Bukhara", "Termez", "Jizzakh", "Navoi", "Namangan", "Karshi", "Qibray", "Nukus", "Shymkent (Kazakhstan)", "Almaty (Qoraqalpog'iston)"};

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

    String[] togriburchakli = {"Afghan Rectangular Cake", "Dari Rectangular Cake", "Italian Rectangular Cake", "Caramel Medovik Rectangular Cake", "Lemon Rectangular Cake", "Raspberry Rectangular Cake", "Marquise Rectangular Cake", "Meringue Rectangular Cake", "Mikado Rectangular Cake", "Milano Rectangular Cake", "Napoleon Rectangular Cake", "Walnut Medovik Rectangular Cake", "Saxony Rectangular Cake", "Snickers Rectangular Cake", "Curd-Biscuit Cake", "Yellow Fruit Rectangular Cake", "Pink Fruit Rectangular Cake", "Black Prince Rectangular Cake", "Chocolate-Banana Rectangular Cake", "Chocolate-Raspberry Rectangular Cake", "Chocolate Medovik Rectangular Cake", "Fruit-Raspberry Rectangular Cake", "Jacobs Rectangular Cake", "⬅\uFE0F Back"};
    String[] togriburchakliphoto = {"https://t.me/safiapictures/52", "https://t.me/safiapictures/53", "https://t.me/safiapictures/54", "https://t.me/safiapictures/55", "https://t.me/safiapictures/56", "https://t.me/safiapictures/57", "https://t.me/safiapictures/59", "https://t.me/safiapictures/60", "https://t.me/safiapictures/61", "https://t.me/safiapictures/62", "https://t.me/safiapictures/63", "https://t.me/safiapictures/65", "https://t.me/safiapictures/66", "https://t.me/safiapictures/67", "https://t.me/safiapictures/69", "https://t.me/safiapictures/70", "https://t.me/safiapictures/71", "https://t.me/safiapictures/72", "https://t.me/safiapictures/73", "https://t.me/safiapictures/74", "https://t.me/safiapictures/75", "https://t.me/safiapictures/76", "https://t.me/safiapictures/77"};
    String[] togriburchaklicaption = {"Afghan Rectangular Cake\n\nChoux pastry, meringue, walnut, custard butter cream. Serves 24. Thaw 2 hours before serving.", "Dari Rectangular Cake\n\nWhite sponge with curd-cream and raspberry confit. Serves 24. Thaw 2 hours before serving.", "Italian Rectangular Cake\n\nNut sponge with cream and caramel custard filling. Serves 16. Thaw 2 hours before serving.", "Caramel Medovik Rectangular Cake\n\nThin honey and caramel sponge layers with creamy caramel filling. Serves 24. Thaw 2 hours before serving.", "Lemon Rectangular Cake\n\nSponge with condensed milk-lemon butter cream, crisp meringue decoration. Thaw 2 hours before serving.", "Raspberry Rectangular Cake\n\nWhite sponge with raspberry-cream and banana-cream layers. Serves 24. Thaw 2 hours before serving.", "Marquise Rectangular Cake\n\nChoux pastry, meringue, custard butter cream with walnuts. Thaw 2 hours before serving.", "Meringue Rectangular Cake\n\nWhite chocolate ganache, raspberry jelly, orange curd cream with soft meringue. Thaw 2 hours before serving.", "Mikado Rectangular Cake\n\nChocolate honey cake, chocolate custard cream and whipped cream. Thaw 2 hours before serving.", "Milano Rectangular Cake\n\nChocolate cream and chocolate-nut thin sponge. Serves 16. Thaw 2 hours before serving.", "Napoleon Rectangular Cake\n\nLayered choux pastry with condensed milk butter cream. Serves 24. Thaw 2 hours before serving.", "Walnut Medovik Rectangular Cake\n\nThin honey and walnut sponge with cream. Serves 24. Thaw 2 hours before serving.", "Saxony Rectangular Cake\n\nChocolate cream, cherry filling, soft chocolate cake sponge. Serves 24. Thaw 2 hours before serving.", "Snickers Rectangular Cake\n\nChocolate sponge with caramel-peanut filling, cream, caramel and chocolate. Thaw 2 hours before serving.", "Curd-Biscuit Cake\n\nWhite sponge with curd cream soaked in sugar syrup. Serves 24. Thaw 2 hours before serving.", "Yellow Fruit Rectangular Cake\n\nThin butter sponge with orange and raspberry cream. Serves 24. Thaw 2 hours before serving.", "Pink Fruit Rectangular Cake\n\n“Salma” sponge with banana-cream and cherry cream layers. Serves 24. Thaw 2 hours before serving.", "Black Prince Rectangular Cake\n\nChocolate sponge with chocolate cream and cherry filling. Serves 16. Thaw 2 hours before serving.", "Chocolate-Banana Rectangular Cake\n\nChocolate sponge with truffle, coffee cream, banana and dark chocolate filling. Serves 16. Thaw 2 hours before serving.", "Chocolate-Raspberry Rectangular Cake\n\nButter cream with condensed milk and raspberry filling. Decorated with soft candies and seasonal fruit. Serves 24. Thaw 2 hours before serving.", "Chocolate Medovik Rectangular Cake\n\nThin honey-chocolate sponge with cream. Serves 24. Thaw 2 hours before serving.", "Fruit-Raspberry Rectangular Cake\n\nWhite sponge soaked in sugar syrup with cream and raspberry. Decorated with whipped cream, marshmallow, and raspberries. Thaw 2 hours before serving.", "Jacobs Rectangular Cake\n\nCoffee-cream sponge with chocolate filling. Serves 24. Thaw 2 hours before serving."};
    String[] togriburchaklinarx = {"356 000", "352 000", "324 000", "336 000", "356 000", "368 000", "352 000", "179 000", "372 000", "372 000", "316 000", "360 000", "352 000", "448 000", "328 000", "396 000", "368 000", "384 000", "388 000", "388 000", "352 000", "396 000", "384 000"};

    String[] minitort = {"Bento mini - cake", "Berry Cake Mini cake", "Coffee-Toffee Mini cake", "'Lesnoy Orex' Mini cake", "Milk-Slays Mini cake", "Rafaello Mini cake", "Mini cake Tiramisu", "Chocolate-Banana Mini cake", "Cake Bravo", "Cake Paris", "Cake Blackcurrant", "⬅️ Back"};
    String[] minitortphoto = {"https://t.me/safiapictures/78", "https://t.me/safiapictures/79", "https://t.me/safiapictures/80", "https://t.me/safiapictures/81", "https://t.me/safiapictures/83", "https://t.me/safiapictures/84", "https://t.me/safiapictures/85", "https://t.me/safiapictures/86", "https://t.me/safiapictures/87", "https://t.me/safiapictures/88", "https://t.me/safiapictures/89"};
    String[] minitortcaption = {"Bento mini - cake\n\n", "Mini cake Berry Cake\n\nAlmond, vanilla cream with layered fruit jelly on white biscuit. Recommended to thaw for 2 hours before serving.", "Mini cake Coffee-Toffee\n\nCoffee-cream, almond and caramel filling with chocolate-honey layers. Recommended to thaw for 2 hours before serving.", "Mini cake 'Lesnoy Orex'\n\nChocolate biscuit with cream, hazelnuts, and coffee-chocolate ganache filling. Recommended to thaw for 2 hours before serving.", "Mini cake Milk-Slays\n\nCoffee-cream with soft milk chocolate candies and chocolate-honey layers. Serves 6-8 people. Recommended to thaw for 2 hours before serving.", "Mini cake Rafaello\n\nWhite biscuit soaked in milk syrup with crunchy almond layer, almond-hazelnut candy, and coconut Chantilly cream filling. Recommended to thaw for 2 hours before serving.", "Mini cake Tiramisu\n\nCoffee and vanilla cream with coffee mousse on white coffee-soaked biscuit. Recommended to thaw for 2 hours before serving.", "Mini cake Chocolate-Banana\n\nChocolate Chantilly cream, banana custard, milk chocolate pieces on chocolate biscuit. Recommended to thaw for 2 hours before serving.", "Cake Bravo\n\nChocolate biscuit with caramelized banana, chocolate mousse, crusty layer, cream, and toffee-caramel filling. Decorated with chocolate cream and chocolate decor. Recommended to thaw for 2 hours before serving.", "Cake Paris\n\nNutty layers with hazelnut cream, coffee ganache, milk cream, soft chocolate candies, iris cream, Snickers chocolate, hazelnuts, and wafer pieces. Recommended to thaw for 2 hours before serving.", "Cake Blackcurrant\n\nWhite chocolate vanilla 'Plombir' cream with chocolate biscuit soaked in fruit syrup and whole blackcurrants. Recommended to thaw for 2 hours before serving."};
    String[] minitortnarx = {"144 000", "209 000", "189 000", "199 000", "185 000", "235 000", "199 000", "225 000", "225 000", "225 000", "189 000"};

    String[] pirog = {"Bokucha Paxvala Pie", "Apple-Sour Cherry Pie", "Sour Cherry Pie", "Lemon Mosaic Pie", "Mishka Pie", "Cottage Cheese Mosaic Pie", "Cottage Cheese Pie", "Apple Pie", "Mishka Pie (Packaged)", "Bokucha Paxvala Pie (Packaged)", "⬅\uFE0F Back"};
    String[] pirogphoto = {"https://t.me/safiapictures/90", "https://t.me/safiapictures/91", "https://t.me/safiapictures/92", "https://t.me/safiapictures/93", "https://t.me/safiapictures/94", "https://t.me/safiapictures/95", "https://t.me/safiapictures/96", "https://t.me/safiapictures/97", "https://t.me/safiapictures/98", "https://t.me/safiapictures/99"};
    String[] pirogcaption = {"Bokucha Paxvala Pie\n\nMeringue and nut shortcrust pastry, coated with honey cream and decorated with nuts. Serves 24 people.", "Apple-Sour Cherry Pie\n\nShortcrust pastry with soft apple and sour cherry filling.", "Sour Cherry Pie\n\nShortcrust pastry with soft sour cherry filling.", "Lemon Mosaic Pie\n\nShortcrust pastry with soft lemon and apple filling.", "Mishka Pie\n\nShortcrust pastry filled with nuts and leaves.", "Cottage Cheese Mosaic Pie\n\nShortcrust pastry with soft fresh cottage cheese filling.", "Cottage Cheese Pie\n\nShortcrust pastry with soft fresh cottage cheese filling.", "Apple Pie\n\nShortcrust pastry with soft apple filling.", "Mishka Pie (Packaged)\n\nShortcrust pastry filled with leaves and nuts.", "Bokucha Paxvala Pie (Packaged)\n\nShortcrust pastry filled with meringue and nuts."};
    String[] pirognarx = {"284 000", "260 000", "280 000", "208 000", "300 000", "240 000", "240 000", "208 000", "28 000", "29 000"};

    String[] yumaloqpirog = {"Raspberry-Fruit Pie", "Creamy Apple and Sour Cherry Pie", "⬅\uFE0F Back"};
    String[] yumaloqpirogphoto = {"https://t.me/safiapictures/100", "https://t.me/safiapictures/101"};
    String[] yumaloqpirogcaption = {"Raspberry-Fruit Pie\n\nShortcrust pastry with creamy and raspberry filling.", "Creamy Apple and Sour Cherry Pie\n\nCreamy pastry with cherry and apple filling."};
    String[] yumaloqpirognarx = {"13 000", "59 000"};

    String[] pirojni = {"Baton 'Potato'", "Granola", "Amore Mini pastry", "Orange Mini pastry", "Caramel Mini pastry", "'Potato' Mini pastry", "Snickers Mini pastry", "'Three chocolates' Mini pastry", "'Flamingo' Mini pastry", "Chocolate Mini pastry", "Exotic Mini pastry", "Berry Cake Pastry", "Black Raspberry Pastry", "Black Forest Pastry", "Brownie Pastry", "Vinny Pastry", "Tropical Fruit Pastry", "Potato Pastry", "'Honey Cake in a glass' Pastry", "Bear Pastry", "Pavlova Pastry", "Lemon Pavlova Pastry", "Raspberry Pavlova Pastry", "Chocolate Pavlova", "Snickers Pastry", "Tiramisu Pastry", "Tiramisu in a jar Pastry", "Esterhazy Pastry", "Red fruit Opera Pastry", "Red fruit Labneh Pastry", "Oreo Pastry-macarons", "Rafaello Pastry-macarons", "Snickers Pastry-macarons", "Cheesecake Pastry-macarons", "Julietta Pastry-roll", "Iriska Pastry-roll", "Snickers Pastry-roll", "Tiramisu San-Sebastian", "Cheesecake San-Sebastian", "Chocolate San-Sebastian", "Lotus Cheesecake", "Honey Cheesecake", "New York Cheesecake", "Oreo Cheesecake", "Exotic Cheesecake", "Chocolate for San-Sebastian", "⬅\uFE0F Back"};
    String[] pirojniphoto = {"https://t.me/safiapictures/102", "https://t.me/safiapictures/103", "https://t.me/safiapictures/104", "https://t.me/safiapictures/105", "https://t.me/safiapictures/106", "https://t.me/safiapictures/107", "https://t.me/safiapictures/108", "https://t.me/safiapictures/109", "https://t.me/safiapictures/110", "https://t.me/safiapictures/111", "https://t.me/safiapictures/112", "https://t.me/safiapictures/113", "https://t.me/safiapictures/114", "https://t.me/safiapictures/115", "https://t.me/safiapictures/116", "https://t.me/safiapictures/117", "https://t.me/safiapictures/118", "https://t.me/safiapictures/119", "https://t.me/safiapictures/120", "https://t.me/safiapictures/121", "https://t.me/safiapictures/122", "https://t.me/safiapictures/123", "https://t.me/safiapictures/124", "https://t.me/safiapictures/125", "https://t.me/safiapictures/126", "https://t.me/safiapictures/127", "https://t.me/safiapictures/128", "https://t.me/safiapictures/129", "https://t.me/safiapictures/130", "https://t.me/safiapictures/131", "https://t.me/safiapictures/132", "https://t.me/safiapictures/133", "https://t.me/safiapictures/134", "https://t.me/safiapictures/135", "https://t.me/safiapictures/136", "https://t.me/safiapictures/137", "https://t.me/safiapictures/138", "https://t.me/safiapictures/139", "https://t.me/safiapictures/140", "https://t.me/safiapictures/141", "https://t.me/safiapictures/142", "https://t.me/safiapictures/143", "https://t.me/safiapictures/144", "https://t.me/safiapictures/145", "https://t.me/safiapictures/146", "https://t.me/safiapictures/147"};
    String[] pirojnicaption = {"Baton\n\nChocolate sponge cake, nuts, condensed milk whipped cream.", "Granola\n\nGreek yogurt, muesli (oats, almonds, sunflower seeds, honey, white raisins, black raisins, ground cinnamon).", "Mini pastry Amore\n\nCoffee - chocolate sponge, coffee mousse, coffee-chocolate filling.", "Mini pastry Orange\n\nOrange - peach candy, almond sponge, smooth cream, chocolate decoration.", "Mini pastry Caramel\n\nCaramel - nut mousse, caramel toffee, smooth cream, chocolate decoration.", "Mini pastry Potato\n\nChocolate sponge, chocolate cream, chocolate ganache, coconut crumbs.", "Mini pastry Snickers\n\nChocolate sponge, caramel filling, nougat, chocolate mousse. Decorated with chocolate gourmet almonds, chocolate chantilly, peanuts and chocolate decoration.", "Mini pastry Three chocolates\n\nChocolate sponge, dark, milk and white chocolate mousse, crunchy chocolate sponge.", "Mini pastry Flamingo\n\nCheesecake base, strawberry chantilly, gourmet flamingo almond.", "Mini pastry Chocolate\n\nChocolate cake with toffee, milk gourmet, salted peanuts, decorated with chocolate.", "Mini pastry Exotic\n\nHoney sponge, kiwi, white chantilly cream, pineapple and mango-passion fruit puree. Candy made from pineapple puree, lemon juice, and mint. Decorated with glaze and chocolate.", "Berry Cake Pastry\n\nWhite and orange sponge, soft vanilla mousse, almond cream, filled with red fruit thick jam.", "Black Raspberry Pastry\n\nChocolate sponge “Black double”, raspberry infusion, raspberry candy, chocolate ganache. Decorated with milk chantilly and milk gourmet.", "Black Forest Pastry\n\nChocolate tartlet with vanilla, milk chantilly cream, cherries and cherry candy filling.", "Brownie Pastry\n\nChocolate sponge with banana and coffee infusion, salted caramel, dark chocolate mousse and milk gourmet. Decorated with caramel chantilly and chocolate filling.", "Vinny Pastry\n\nOrange sponge, pineapple and cheese mousse, pineapple candy.", "Tropical Fruit Pastry\n\nChocolate sponge, chocolate cream, chocolate ganache, chocolate decor, nuts.", "Potato Pastry\n\nChocolate sponge, chocolate cream, chocolate ganache, coconut crumbs.", "Honey Cake in a glass Pastry\n\nSoft honey sponge, honey boiled cream.", "Bear Pastry\n\nBaked Oreo cheesecake and chocolate gourmet.", "Pavlova Pastry\n\nCrispy soft meringue, red fruit jam, whipped cream.", "Lemon Pavlova Pastry\n\nLemon curd, cream and plombir cream with crispy soft meringue. Decorated with physalis and marshmallow.", "Raspberry Pavlova Pastry\n\nPlombir cream and chocolate cream with crispy soft meringue, decorated with raspberries.", "Chocolate Pavlova\n\nWhipped chocolate cream with crispy and soft meringue, decorated with blueberries and Mikado cherries.", "Snickers Pastry\n\nChocolate sponge, nougat, caramel, milk mousse, salted peanuts.", "Tiramisu Pastry\n\nCoffee soaked white sponge, coffee-cream filling, vanilla cream, coffee mousse base. Decorated with vanilla and milk chantilly.", "Tiramisu in a jar Pastry\n\nSponge, coffee cream, chocolate-cream, cocoa.", "Esterhazy Pastry\n\nNut dacquoise (almonds, hazelnuts), toffee, condensed milk buttercream with hazelnuts.", "Red fruit Opera Pastry\n\nCoconut cream, red fruit mousse, chocolate-red fruit ganache on almond sponge soaked in red fruit syrup.", "Red fruit Labneh Pastry\n\nCheese soufflé and red fruit layers with raspberry, cherry mousse on sponge base.", "Oreo Pastry-macarons\n\nCreamy-vanilla cream, white chocolate and cottage cheese on almond dough.", "Rafaello Pastry-macarons\n\nCoconut condensed milk cream, cottage cheese on almond dough.", "Snickers Pastry-macarons\n\nCreamy-vanilla cream, caramel chocolate, salted peanuts in peanut paste on cocoa almond dough.", "Cheesecake Pastry-macarons\n\nCreamy vanilla cream, white chocolate, cottage cheese, red fruit jam on almond dough.", "Julietta Pastry-roll\n\nSoft yogurt and plombir cream, red fruit infusion, raspberry (strawberry) jam layer on white sponge.", "Iriska Pastry-roll\n\nNut sponge, chocolate ganache, caramel cream, milk chocolate, nut and caramel crunchy layer.", "Snickers Pastry-roll\n\nChantilly caramel cream, peanut salted caramel, cream cheese layer on chocolate infused soft chocolate sponge.", "Tiramisu San-Sebastian\n\nCoffee-flavored cheesecake with chocolate pieces.", "Cheesecake San-Sebastian\n\nCream cheese cheesecake.", "Chocolate San-Sebastian\n\nCream cheese cheesecake with milk and dark chocolate.", "Lotus Cheesecake\n\nSoft sponge, cheesecake base, lotus paste.", "Honey Cheesecake\n\nHoney dacquoise, honey cream-cheese, honey cream, honey crumble.", "New York Cheesecake\n\nSoft sugar, cream cheese, raspberry jam.", "Oreo Cheesecake\n\nChocolate sponge, Oreo cream cheese, milk and white cream cheese, milk ganache.", "Exotic Cheesecake\n\nOrange crust, cheese passion fruit mousse, cheese filling, mango-passion fruit confit.", "Chocolate for San-Sebastian\n\nMilk chocolate."};
    String[] pirojninarx = {"9 000", "29 000", "11 000", "11 000", "11 000", "7 000", "11 000", "11 000", "11 000", "11 000", "11 000", "31 000", "33 000", "27 000", "35 000", "36 000", "13 000", "9 000", "33 000", "36 000", "28 000", "28 000", "28 000", "28 000", "31 000", "28 000", "33 000", "29 000", "32 000", "28 000", "29 000", "29 000", "29 000", "29 000", "36 000", "36 000", "39 000", "37 000", "36 000", "37 000", "35 000", "35 000", "32 000", "33 000", "35 000", "7 000"};

    String[] rulet = {"Meringue Roll", "Meringue Roll with Pistachio", "Fairy Tale Roll", "⬅\uFE0F Back"};
    String[] ruletphoto = {"https://t.me/safiapictures/148", "https://t.me/safiapictures/149", "https://t.me/safiapictures/150"};
    String[] ruletcaption = {"Meringue Roll\n\nWhipped cream with whole raspberries on crispy soft meringue. Recommended to defrost for 2 hours before consumption.", "Meringue Roll with Pistachio\n\nFrozen meringue with pistachio cream and whole raspberries. Recommended to defrost for 2 hours before consumption.", "Fairy Tale Roll\n\nWhite sponge soaked in sugar syrup with natural butter cream. Recommended to defrost for 2 hours before consumption."};
    String[] ruletnarx = {"209 000", "239 000", "169 000"};

    String[] ekler = {"Vanilla-Raspberry Eclair", "Lotus-Caramel Eclair", "Rafaello Eclair", "Tiramisu Eclair", "Chandon Pistachio-Raspberry Eclair", "Chocolate-Nutella Eclair", "⬅️ Back"};
    String[] eklerphoto = {"https://t.me/safiapictures/151", "https://t.me/safiapictures/153", "https://t.me/safiapictures/154", "https://t.me/safiapictures/155", "https://t.me/safiapictures/156", "https://t.me/safiapictures/157"};
    String[] eklercaption = {"Vanilla-Raspberry Eclair\n\nVanilla cream with raspberry and raspberry confit on choux pastry, topped with craquelin.", "Lotus-Caramel Eclair\n\nChoux pastry with caramel cream, Lotus filling with nuts, and a caramelized crunchy layer.", "Rafaello Eclair\n\nCoconut cream with a filling made from waffle crust on choux pastry.", "Tiramisu Eclair\n\nCream with coffee syrup and Savoiardi cookies soaked in coffee on choux pastry. Decorated with cocoa-vanilla cream.", "Chandon Pistachio-Raspberry Eclair\n\nChoux pastry with Chandon pistachio cream and raspberry confit filling.", "Chocolate-Nutella Eclair\n\nChoux pastry with chocolate cream, hazelnut-chocolate filling, and chocolate craquelin."};
    String[] eklernarx = {"19,000", "23,000", "21,000", "21,000", "23,000", "20,000"};

    String[] makarons = {"Vanilla Macaron", "Handmade Pistachio Macaron", "Chocolate Macaron", "Exotic Macaron", "Fruit Mix Macaron", "Macaron Mix 10 pcs", "Macaron Mix 5 pcs", "⬅\uFE0F Back"};
    String[] makaronsphoto = {"https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/158", "https://t.me/safiapictures/159", "https://t.me/safiapictures/160"};
    String[] makaronscaption = {"Vanilla Macaron\n\nAlmond dough with vanilla filling.", "Handmade Pistachio Macaron\n\nAlmond dough with handmade pistachio filling.", "Chocolate Macaron\n\nAlmond dough with chocolate filling.", "Exotic Macaron\n\nAlmond dough with exotic filling.", "Fruit Mix Macaron\n\nAlmond dough with fruit mix filling.", "Macaron Mix 10 pcs\n\nAlmond dough with assorted fillings.", "Macaron Mix 5 pcs\n\nAlmond dough with assorted fillings."};
    String[] makaronsnarx = {"8 000", "8 000", "8 000", "8 000", "8 000", "75 000", "39 000"};

    String[] tayyotovqat = {"Beef Bowl", "Chicken Bowl", "Chicken Roll", "Greek Salad", "Caesar Salad", "Beef Sandwich", "Lentil Soup", "Chicken Sandwich", "Turkey Croissant Sandwich", "Chicken Fillet with Vegetables", "⬅\uFE0F Back"};
    String[] tayyorovqatphoto = {"https://t.me/safiapictures/161", "https://t.me/safiapictures/162", "https://t.me/safiapictures/163", "https://t.me/safiapictures/164", "https://t.me/safiapictures/165", "https://t.me/safiapictures/166", "https://t.me/safiapictures/167", "https://t.me/safiapictures/168", "https://t.me/safiapictures/169", "https://t.me/safiapictures/170"};
    String[] tayyorovqatcaption = {"Beef Bowl\n\nSoft beef, boiled rice, buckwheat, iceberg lettuce, sweet corn, fresh cherry tomatoes, beans, lemon, cucumbers, quail egg, and several sauces.", "Chicken Bowl\n\nChicken, boiled rice, buckwheat, iceberg lettuce, chuka seaweed, sweet corn, fresh cherry tomatoes, beans, lemon, cucumbers, quail egg, and several sauces.", "Chicken Roll\n\nSoft lavash with fresh tomato, cucumber, iceberg lettuce, and tartar sauce with chicken.", "Greek Salad\n\nFresh cucumber, cherry tomatoes, bell pepper, lemon, feta cheese, salad leaves, black and green olives, and Greek dressing.", "Caesar Salad\n\nChicken, iceberg lettuce, fresh cherry tomatoes, crispy croutons, Caesar dressing, and parmesan cheese.", "Beef Sandwich\n\nBeef bacon and smoked slices, soft cheese, iceberg, fresh cucumber, tomato, pattypan squash, and Caesar dressing on toasted bread.", "Lentil Soup\n\nHearty lentil soup with vegetables and spices.", "Chicken Sandwich\n\nChickpea, garlic, rosemary, and roasted chicken breast with dried tomatoes, iceberg leaves, and cucumber slices.", "Turkey Croissant Sandwich\n\nBrioche croissant with smoked turkey, cheddar cheese, mayonnaise, ginger, soy dressing, dill, lemon juice, iceberg leaves, and cucumber slices.", "Chicken Fillet with Vegetables\n\nEggplant, zucchini, bell pepper, cherry tomatoes, spices, garlic, and juicy chicken fillet."};
    String[] tayyorovqatnarx = {"50 000", "50 000", "26 000", "35 000", "36 000", "29 000", "23 000", "31 000", "31 000", "42 000"};

    String[] shirinlik = {"Sour Cherry Jam", "Berry Jam", "Apple Jam", "Cashew Chocolate Dragee", "Almond Chocolate Dragee", "Hazelnut Chocolate Dragee", "Orange Cake Slice", "Lollipop", "Toy Lollipop", "Rainbow Marshmallow", "Mishka Barni", "Nut Candy", "Caramel Popcorn", "Chocolate Popcorn", "Toy Sweet Batman", "Toy Sweet Captain America", "Condensed Milk Tube", "Mini Box Chak-Chak", "Turkish Chak-Chak", "Chupa-Chups", "Chupa-Chups with Fondant", "Safia Chocolate Caramel-Nut", "Safia Chocolate Coconut", "⬅\uFE0F Back"};
    String[] shirinlikphoto = {"https://t.me/safiapictures/171", "https://t.me/safiapictures/172", "https://t.me/safiapictures/173", "https://t.me/safiapictures/174", "https://t.me/safiapictures/175", "https://t.me/safiapictures/176", "https://t.me/safiapictures/177", "https://t.me/safiapictures/178", "https://t.me/safiapictures/179", "https://t.me/safiapictures/180", "https://t.me/safiapictures/181", "https://t.me/safiapictures/182", "https://t.me/safiapictures/183", "https://t.me/safiapictures/184", "https://t.me/safiapictures/185", "https://t.me/safiapictures/185", "https://t.me/safiapictures/186", "https://t.me/safiapictures/187", "https://t.me/safiapictures/188", "https://t.me/safiapictures/189", "https://t.me/safiapictures/190", "https://t.me/safiapictures/191", "https://t.me/safiapictures/191"};
    String[] shirinlikcaption = {"Sour Cherry Jam\n\nPitted sour cherries, sugar, citrus pectin, water, acidity regulator - citric acid.", "Berry Jam\n\nFrozen berries, sugar.", "Apple Jam\n\nPeeled apple puree, sugar, acidity regulator - citric acid.", "Cashew Chocolate Dragee\n\nCashews coated with white chocolate.", "Almond Chocolate Dragee\n\nAlmonds coated with dark chocolate.", "Hazelnut Chocolate Dragee\n\nHazelnuts coated with caramel chocolate.", "Orange Cake Slice\n\nSoft orange cake with candied orange pieces.", "Lollipop\n\nSugar powder, water.", "Toy Lollipop\n\nSugar powder, water, fondant.", "Rainbow Marshmallow\n\nApple juice, sugar, gelatin (halal), egg, glucose, natural flavor, natural coloring.", "Mishka Barni\n\nHigh-grade flour, sugar, eggs, vanilla, salt, chocolate.", "Nut Candy\n\nCondensed milk with nut shortcrust pastry.", "Caramel Popcorn\n\nCaramel-coated popcorn.", "Chocolate Popcorn\n\nChocolate-coated popcorn.", "Toy Sweet Batman\n\nSugar powder, water.", "Toy Sweet Captain America\n\nSugar powder, water.", "Condensed Milk Tube\n\nSweet waffle dough with cooked condensed milk.", "Mini Box Chak-Chak\n\nMini box with chopped chak-chak.", "Turkish Chak-Chak\n\nShortcrust dough with butter, chocolate ganache, sesame, and cooked condensed milk.", "Chupa-Chups\n\nNut cake with chocolate coating.", "Chupa-Chups with Fondant\n\nNut cake with chocolate coating and decorated with fondant.", "Safia Chocolate Caramel-Nut\n\nMilk chocolate, caramel, peanuts, raisins.", "Safia Chocolate Coconut\n\nMilk chocolate with coconut filling."};
    String[] shirinliknarx = {"32 000", "39 000", "32 000", "55 000", "49 000", "49 000", "9 000", "10 000", "16 000", "13 000", "8 000", "5 500", "35 000", "35 000", "13 000", "13 000", "14 000", "59 000", "69 000", "12 000", "17 000", "13 000", "13 000"};

    String[] pechenye = {"Classic Biskotti", "Mini Grissini", "Grissini", "Mini Bounty Cookie", "Mini Lochira Cookie", "Mini Oatmeal Cookie", "Mini Sushki Cookie", "Muraveynik", "Banana Cookies", "Bounty Cookie", "Biskotti Cookie", "Brownie Cookie", "Mini Star Cookie", "Star Cookie", "Caramel Cookie", "Keta Cookie", "Cookies", "Sesame Cookie", "Mini Kurabye Cookie", "Lemon Cookie", "Lochira Cookie", "Mini Luna Cookie", "Luna Cookie", "Mazurki Cookie", "Mezumi Cookie", "Nutella Cookie", "Oatmeal Cookie", "Cookies 'Sticks'", "Mini Seashell Cookie", "Seashell Cookie", "Mini Cherry Roll Cookie", "Cherry Roll Cookie", "Nut Roll Cookie", "Mini Condensed Milk Roll", "Condensed Milk Roll", "Sushki Cookie", "Shrek Cookie", "Turkish Baklava", "Gluten-Free Cakes", "Mini Buckwheat Cakes", "Rice Cakes", "⬅\uFE0F Back"};
    String[] pechenyephoto = {"https://t.me/safiapictures/192", "https://t.me/safiapictures/193", "https://t.me/safiapictures/194", "https://t.me/safiapictures/195", "https://t.me/safiapictures/196", "https://t.me/safiapictures/197", "https://t.me/safiapictures/198", "https://t.me/safiapictures/199", "https://t.me/safiapictures/200", "https://t.me/safiapictures/201", "https://t.me/safiapictures/202", "https://t.me/safiapictures/203", "https://t.me/safiapictures/204", "https://t.me/safiapictures/205", "https://t.me/safiapictures/206", "https://t.me/safiapictures/207", "https://t.me/safiapictures/208", "https://t.me/safiapictures/209", "https://t.me/safiapictures/210", "https://t.me/safiapictures/211", "https://t.me/safiapictures/212", "https://t.me/safiapictures/213", "https://t.me/safiapictures/214", "https://t.me/safiapictures/215", "https://t.me/safiapictures/216", "https://t.me/safiapictures/217", "https://t.me/safiapictures/218", "https://t.me/safiapictures/219", "https://t.me/safiapictures/220", "https://t.me/safiapictures/221", "https://t.me/safiapictures/222", "https://t.me/safiapictures/223", "https://t.me/safiapictures/224", "https://t.me/safiapictures/225", "https://t.me/safiapictures/226", "https://t.me/safiapictures/227", "https://t.me/safiapictures/228", "https://t.me/safiapictures/229", "https://t.me/safiapictures/230", "https://t.me/safiapictures/231", "https://t.me/safiapictures/232"};
    String[] pechenyecaption = {"Classic Biskotti\n\nShortcrust dough with nuts.", "Mini Grissini\n\nSesame breadsticks.", "Grissini\n\nSesame breadsticks.", "Mini Bounty Cookie\n\nShortcrust-coconut dough with milk chocolate pieces.", "Mini Lochira Cookie\n\nButter and milk dough with sesame.", "Mini Oatmeal Cookie\n\nShortcrust dough with oatmeal, nuts, and cinnamon.", "Mini Sushki Cookie\n\nButter and milk dough with sesame.", "Muraveynik\n\nHoney-caramel cream and condensed milk shortcrust dough.", "Banana Cookies\n\nShortcrust dough with decorated nut filling, condensed milk, and nuts.", "Bounty Cookie\n\nShortcrust-coconut dough with milk chocolate pieces.", "Biskotti Cookie\n\nShortcrust dough with nuts.", "Brownie Cookie\n\nRich chocolate flavor.", "Mini Star Cookie\n\nShortcrust dough with apple and lemon.", "Star Cookie\n\nShortcrust dough with apple and lemon.", "Caramel Cookie\n\nShortcrust dough with hazelnut caramel.", "Keta Cookie\n\nShortcrust dough with nuts and sugar.", "Cookies\n\nShortcrust dough with chocolate pieces and nuts.", "Sesame Cookie\n\nShortcrust dough with sesame.", "Mini Kurabye Cookie\n\nShortcrust dough with nuts.", "Lemon Cookie\n\nShortcrust dough with lemon filling.", "Lochira Cookie\n\nButter and milk dough with sesame.", "Mini Luna Cookie\n\nShortcrust dough prepared in butter.", "Luna Cookie\n\nShortcrust dough prepared in butter.", "Mazurki Cookie\n\nBiscuit base with raisins, nuts, and decorative leaves.", "Mezumi Cookie\n\nMeringue, nuts, and chocolate pieces.", "Nutella Cookie\n\nShortcrust dough with Nutella and milk chocolate pieces.", "Oatmeal Cookie\n\nShortcrust dough with oatmeal, nuts, and cinnamon.", "Cookies 'Sticks'\n\nDough with cream and sesame.", "Mini Seashell Cookie\n\nShortcrust dough, meringue, nuts.", "Seashell Cookie\n\nShortcrust dough, meringue, nuts.", "Mini Cherry Roll Cookie\n\nSour cream dough filled with cherries.", "Cherry Roll Cookie\n\nSour cream dough filled with cherries.", "Nut Roll Cookie\n\nShortcrust dough with grated nuts and sugar.", "Mini Condensed Milk Roll\n\nSour cream dough filled with condensed milk.", "Condensed Milk Roll\n\nSour cream dough filled with condensed milk.", "Sushki Cookie\n\nButter and milk dough decorated with sesame.", "Shrek Cookie\n\nButter and milk shortcrust dough.", "Turkish Baklava\n\nShortcrust dough with meringue, nuts, and raisins.", "Gluten-Free Cakes\n\nGluten-free rolls made from sunflower seeds, flaxseed, white sesame, vegetable oil, salt, and water.", "Mini Buckwheat Cakes\n\nDietary buckwheat cakes made from buckwheat flour, gluten-free mix, white sesame, oatmeal, flaxseed, honey, and raisins.", "Rice Cakes\n\nDigestible gluten-free rolls made from rice flour, flaxseed, oatmeal, white sesame, honey, and raisins."};
    String[] pechenyenarx = {"5 000", "12 000", "21 000", "20 000", "11 000", "13 000", "12 000", "5 500", "36 000", "49 000", "33 000", "19 000", "29 000", "50 000", "19 000", "37 000", "18 000", "24 000", "29 000", "33 000", "27 000", "26 000", "48 000", "29 000", "24 000", "19 000", "27 000", "14 000", "28 000", "62 000", "28 000", "55 000", "42 000", "26 000", "55 000", "21 000", "26 000", "35 000", "34 000", "35 000", "35 000"};

    String[] qadoqekler = {"Bushe Assorted", "Mini Bushe White Chocolate", "Mini Bushe Chocolate", "Mini Trubochka Mini", "Mini Trubochka", "Mini Eclair Assorted Mini", "Mini Eclair Assorted", "Mini Eclair Classic Mini", "Mini Eclair Classic", "Mini Eclair Colorful Mini", "Mini Eclair Colorful", "Mini Eclair Chocolate Mini", "Mini Eclair Chocolate", "⬅\uFE0F Back"};
    String[] qadoqeklerphoto = {"https://t.me/safiapictures/233", "https://t.me/safiapictures/234", "https://t.me/safiapictures/235", "https://t.me/safiapictures/236", "https://t.me/safiapictures/237", "https://t.me/safiapictures/238", "https://t.me/safiapictures/239", "https://t.me/safiapictures/240", "https://t.me/safiapictures/241", "https://t.me/safiapictures/242", "https://t.me/safiapictures/243", "https://t.me/safiapictures/244", "https://t.me/safiapictures/245"};
    String[] qadoqeklercaption = {"Bushe Assorted\n\nBiscuit cookie with vanilla cream and chocolate.", "Mini Bushe White Chocolate\n\nBiscuit cookie with vanilla cream and white chocolate.", "Mini Bushe Chocolate\n\nBiscuit cookie with vanilla cream and dark chocolate.", "Mini Trubochka Mini\n\nLayered pastry with creamy vanilla filling.", "Mini Trubochka\n\nLayered pastry with creamy vanilla filling.", "Mini Eclair Assorted Mini\n\nAssorted eclairs: Bounty, Apricot, Coffee. Filled with Bounty, apricot, and coffee cream.", "Mini Eclair Assorted\n\nAssorted eclairs: Bounty, Apricot, Coffee. Filled with Bounty, apricot, and coffee cream.", "Mini Eclair Classic Mini\n\nChoux pastry filled with buttercream.", "Mini Eclair Classic\n\nChoux pastry filled with buttercream.", "Mini Eclair Colorful Mini\n\nChoux pastry filled with cream and condensed milk (cherry/chocolate/vanilla).", "Mini Eclair Colorful\n\nChoux pastry filled with cream and condensed milk (cherry/chocolate/vanilla).", "Mini Eclair Chocolate Mini\n\nChoux pastry with buttercream, coated with chocolate glaze.", "Mini Eclair Chocolate\n\nChoux pastry with buttercream, coated with chocolate glaze."};
    String[] qadoqeklernarx = {"75 000", "39 000", "39 000", "25 000", "59 000", "45 000", "95 000", "25 000", "59 000", "39 000", "93 000", "31 000", "69 000"};

    String[] shirinpishiriq = {"Apricot-Almond Bun", "Vatrushka Bun", "Envelope Bun", "Cherry Bun", "Poppy Seed Bun", "Raspberry Bun", "Nut Bun", "Apple Bun", "Condensed Milk Bun", "Blackcurrant Bun", "Sochnik Bun", "Cottage Cheese-Banana Bun", "Apricot Donut / 2 pcs", "Chocolate Donut / 2 pcs", "⬅\uFE0F Back"};
    String[] shirinpishiriqphoto = {"https://t.me/safiapictures/246", "https://t.me/safiapictures/247", "https://t.me/safiapictures/248", "https://t.me/safiapictures/249", "https://t.me/safiapictures/250", "https://t.me/safiapictures/251", "https://t.me/safiapictures/252", "https://t.me/safiapictures/253", "https://t.me/safiapictures/254", "https://t.me/safiapictures/255", "https://t.me/safiapictures/256", "https://t.me/safiapictures/257", "https://t.me/safiapictures/258", "https://t.me/safiapictures/259"};
    String[] shirinpishiriqcaption = {"Apricot-Almond Bun\n\nYeast dough with apricot filling. Decorated with candied lemon and almond petals.", "Vatrushka Bun\n\nYeast dough filled with cottage cheese.", "Envelope Bun\n\nYeast dough filled with cottage cheese.", "Cherry Bun\n\nYeast dough filled with cherries.", "Poppy Seed Bun\n\nYeast dough filled with poppy seeds.", "Raspberry Bun\n\nYeast dough filled with raspberry. Decorated with crumble.", "Nut Bun\n\nYeast dough filled with nuts.", "Apple Bun\n\nYeast dough filled with apple slices.", "Condensed Milk Bun\n\nYeast dough filled with boiled condensed milk.", "Blackcurrant Bun\n\nYeast dough filled with blackcurrant. Decorated with almond petals and candied almond.", "Sochnik Bun\n\nShortcrust dough filled with cottage cheese.", "Cottage Cheese-Banana Bun\n\nShortcrust dough filled with cottage cheese and banana pieces.", "Apricot Donut / 2 pcs\n\nFried dough in sunflower oil, filled with apricot jam.", "Chocolate Donut / 2 pcs\n\nFried dough in sunflower oil, coated with chocolate."};
    String[] shirinpishiriqnarx = {"12 000", "9 000", "9 000", "12 000", "10 500", "12 500", "12 000", "9 000", "12 000", "12 500", "10 000", "12 000", "18 000", "20 000"};

    String[] keks = {"Orange Cake", "Cherry Cake", "Apple Cake", "⬅\uFE0F Back"};
    String[] keksphoto = {"https://t.me/safiapictures/260", "https://t.me/safiapictures/261", "https://t.me/safiapictures/262"};
    String[] kekscaption = {"Orange Cake\n\nSoft orange cake with candied orange pieces. Decorated with sugar glaze and candied orange slices.", "Cherry Cake\n\nChocolate and vanilla cake with fresh cherries. Decorated with soft chocolate candy and cherries.", "Apple Cake\n\nSoft cake with cinnamon, caramelized apple, and nuts."};
    String[] keksnarx = {"85 000", "85 000", "85 000"};

    String[] tartaletka = {"Mini Tartlet", "Mini Tartlet Volter", "Mini Chocolate Tartlet", "⬅\uFE0F Back"};
    String[] tartaletkaphoto = {"https://t.me/safiapictures/263", "https://t.me/safiapictures/264", "https://t.me/safiapictures/265"};
    String[] tartaletkacaption = {"Mini Tartlet\n\nShortcrust dough filled with chocolate ganache and whipped cream, topped with seasonal fresh fruits.", "Mini Tartlet Volter\n\nShortcrust-almond dough filled with caramel cream and nuts: almond, cashew, pistachio, hazelnut.", "Mini Chocolate Tartlet\n\nShortcrust chocolate dough filled with chocolate ganache and seasonal sliced fruits."};
    String[] tartaletkanarx = {"8 000", "8 500", "8 000"};

    String[] qatlamali = {"Poppy Braid", "Nut Braid", "Classic Croissant", "Almond Croissant", "Pistachio Croissant", "Chocolate Croissant", "Seasonal Fruit Croissant", "Danish Poppy Bun", "Danish Nut Bun", "Apple Layered Pastry", "Chocolate Pain", "⬅\uFE0F Back"};
    String[] qatlamaliphoto = {"https://t.me/safiapictures/266", "https://t.me/safiapictures/267", "https://t.me/safiapictures/268", "https://t.me/safiapictures/269", "https://t.me/safiapictures/270", "https://t.me/safiapictures/271", "https://t.me/safiapictures/272", "https://t.me/safiapictures/273", "https://t.me/safiapictures/274", "https://t.me/safiapictures/275", "https://t.me/safiapictures/276"};
    String[] qatlamalicaption = {"Poppy Braid\n\nLayered yeast dough filled with poppy. Drizzled with sugar syrup.", "Nut Braid\n\nLayered yeast dough filled with nuts. Drizzled with sugar syrup.", "Classic Croissant\n\nTraditional layered croissant dough.", "Almond Croissant\n\nCroissant dough with almond filling.", "Pistachio Croissant\n\nCroissant dough with pistachio filling.", "Chocolate Croissant\n\nLight layered dough with chocolate-hazelnut paste.", "Seasonal Fruit Croissant\n\nLayered croissant dough with seasonal fruit filling.", "Danish Poppy Bun\n\nLayered yeast dough with poppy filling. Drizzled with sugar syrup.", "Danish Nut Bun\n\nLayered yeast dough with nut filling. Drizzled with sugar syrup.", "Apple Layered Pastry\n\nLayered dough with pastry cream, apple, cinnamon, and sugar.", "Chocolate Pain\n\nLayered yeast dough with custard and two types of chocolate, soaked with honey syrup."};
    String[] qatlamalinarx = {"12 000", "12 000", "19 000", "29 000", "39 000", "26 000", "26 000", "4 500", "4 500", "19 000", "23 000"};

    String[] toyimli = {"Pie with Puree and Cheese", "Pie with Puree and Spinach", "Meat Blinchik", "Cottage Cheese Blinchik", "Sausage Bun", "Fried Dumpling with Meat (pack)", "Fried Dumpling with Meat (kg)", "Meat Obinon", "Paramach", "Parmoda with Meat and Chicken", "Pide", "Closed Pizza", "Open Pizza", "Caramel Rasstegay", "Potato Rasstegay", "Meat Rasstegay", "Egg Rasstegay", "Sausage Layered Pastry", "Sour Cream Chicken Somsa", "Sour Cream Meat Somsa", "Mini Chicken Somsa / 4 pcs", "Mini Meat Somsa / 4 pcs", "Herb Somsa", "Potato Somsa", "Chicken Somsa", "Meat Somsa", "Pumpkin Somsa", "Khachapuri with Sausage and Cheese", "Cheese Khachapuri", "Thin Dough", "⬅\uFE0F Back"};
    String[] toyimliphoto = {"https://t.me/safiapictures/277", "https://t.me/safiapictures/278", "https://t.me/safiapictures/279", "https://t.me/safiapictures/280", "https://t.me/safiapictures/281", "https://t.me/safiapictures/282", "https://t.me/safiapictures/283", "https://t.me/safiapictures/284", "https://t.me/safiapictures/285", "https://t.me/safiapictures/286", "https://t.me/safiapictures/287", "https://t.me/safiapictures/288", "https://t.me/safiapictures/289", "https://t.me/safiapictures/290", "https://t.me/safiapictures/291", "https://t.me/safiapictures/292", "https://t.me/safiapictures/293", "https://t.me/safiapictures/294", "https://t.me/safiapictures/295", "https://t.me/safiapictures/296", "https://t.me/safiapictures/297", "https://t.me/safiapictures/298", "https://t.me/safiapictures/299", "https://t.me/safiapictures/300", "https://t.me/safiapictures/301", "https://t.me/safiapictures/302", "https://t.me/safiapictures/303", "https://t.me/safiapictures/304", "https://t.me/safiapictures/305", "https://t.me/safiapictures/306"};
    String[] toyimlicaption = {"Pie with Puree and Cheese\n\nFat dough filled with puree and cheese.", "Pie with Puree and Spinach\n\nFat dough filled with spinach and cheese.", "Meat Blinchik\n\nDough brushed with cream, filled with minced beef.", "Cottage Cheese Blinchik\n\nDough brushed with cream, filled with cottage cheese.", "Sausage Bun\n\nFilled dough with sausage inside.", "Fried Dumpling with Meat (pack)\n\nDough filled with minced beef, pepper, salt, fried in butter.", "Fried Dumpling with Meat (kg)\n\nDumplings filled with minced beef, fried in butter.", "Meat Obinon\n\nFat dough filled with minced beef, onions, and spices.", "Paramach\n\nYeast dough filled with minced beef and onions.", "Parmoda with Meat and Chicken\n\nSour cream dough filled with meat and chicken.", "Pide\n\nFat dough filled with cheese and suluguni.", "Closed Pizza\n\nDough filled with chicken, cheese, mushrooms, and tomato.", "Open Pizza\n\nFat dough filled with smoked sausage, bell pepper, ketchup, olives, and cheese.", "Caramel Rasstegay\n\nDough filled with caramel.", "Potato Rasstegay\n\nDough filled with mashed potatoes.", "Meat Rasstegay\n\nDough filled with minced beef.", "Egg Rasstegay\n\nDough filled with egg and green onion.", "Sausage Layered Pastry\n\nYeast layered dough with sausage.", "Sour Cream Chicken Somsa\n\nDough with sour cream filled with chicken, onions, and spices.", "Sour Cream Meat Somsa\n\nDough with sour cream filled with meat and spices.", "Mini Chicken Somsa / 4 pcs\n\nLayered dough filled with chicken, onions, and spices.", "Mini Meat Somsa / 4 pcs\n\nLayered dough filled with minced meat, onions, and spices.", "Herb Somsa\n\nLayered dough filled with spinach and mint.", "Potato Somsa\n\nLayered dough filled with potato, onions, and spices.", "Chicken Somsa\n\nLayered dough filled with chicken, onions, and spices.", "Meat Somsa\n\nLayered dough filled with minced meat, onions, and spices.", "Pumpkin Somsa\n\nLayered dough filled with pumpkin, onions, and spices.", "Khachapuri with Sausage and Cheese\n\nLayered dough filled with smoked sausage and cheese.", "Cheese Khachapuri\n\nLayered dough filled with cheese.", "Thin Dough\n\nYeast dough filled with minced beef, onions, and red bell pepper."};
    String[] toyimlinarx = {"10 000", "10 000", "10 000", "7 000", "11 000", "39 000", "129 000", "10 000", "10 000", "9 000", "15 000", "12 000", "13 000", "7 500", "7 500", "10 500", "9 000", "17 000", "8 000", "8 500", "12 000", "18 000", "7 500", "7 500", "8 000", "9 500", "7 000", "14 000", "14 000", "11 500"};

    String[] praynik = {"Ginger Cupcake", "Ginger Prince", "Ginger Princess", "Gingerbread 'Safia'", "Gingerbread 'Muzyurak'", "Paintable Gingerbread Dino", "Paintable Gingerbread Train", "Paintable Gingerbread Pony", "⬅\uFE0F Back"};
    String[] zanjabilliphoto = {"https://t.me/safiapictures/307", "https://t.me/safiapictures/308", "https://t.me/safiapictures/309", "https://t.me/safiapictures/310", "https://t.me/safiapictures/311", "https://t.me/safiapictures/312", "https://t.me/safiapictures/313", "https://t.me/safiapictures/314"};
    String[] zanjabillicaption = {"Ginger Cupcake\n\nGingerbread with sugar icing.", "Ginger Prince\n\nGingerbread with sugar icing.", "Ginger Princess\n\nGingerbread with sugar icing.", "Gingerbread 'Safia'\n\nGingerbread with sugar icing.", "Gingerbread 'Muzyurak'\n\nGingerbread with sugar icing.", "Paintable Gingerbread Dino\n\nGingerbread intended for painting.", "Paintable Gingerbread Train\n\nGingerbread intended for painting.", "Paintable Gingerbread Pony\n\nGingerbread intended for painting."};
    String[] zanjabillinarx = {"27 000", "27 000", "27 000", "27 000", "27 000", "35 000", "35 000", "35 000"};

    String[] togriovqatlanish = {"PN Pies", "PN Semi-Prepared Products", "PN Cakes", "PN Pastries", "PN Desserts", "⬅\uFE0F Main Menu"};

    String[] topirog = {"PN Apple-Sour Cherry Pie", "PN Sour Cherry Pie", "PN Mishka Pie", "PN Cottage Cheese and Cranberry Pie", "Cottage Cheese Pie with Chia and Quince Seeds", "PN Apple Pie", "⬅\uFE0F Back PN"};
    String[] topirogphoto = {"https://t.me/safiapictures/315", "https://t.me/safiapictures/316", "https://t.me/safiapictures/317", "https://t.me/safiapictures/318", "https://t.me/safiapictures/319", "https://t.me/safiapictures/320"};
    String[] topirogcaption = {"PN Apple-Sour Cherry Pie\n\nGluten-free pie made with a juicy apple and sour cherry filling.", "PN Sour Cherry Pie\n\nGluten-free pie made with natural sour cherries and sugar substitutes.", "PN Mishka Pie\n\nGluten-free soft layered pie made from protein-rich flour and sugar substitute, similar to 'Ptichye Moloko'.", "PN Cottage Cheese and Cranberry Pie\n\nGluten-free pie with creamy cottage cheese and dried cranberries.", "Cottage Cheese Pie with Chia and Quince Seeds\n\nGluten-free pie with chia and quince seeds, made without added sugar.", "PN Apple Pie\n\nGluten-free pie made with fresh apples and no added sugar."};
    String[] topirognarx = {"27 000", "26 000", "43 000", "27 000", "28 000", "27 000"};

    String[] toyarimtayyor = {"PN Varenik with Potato and Mushrooms", "PN Somsa with Greens and Cheese / 3 pcs", "PN Chicken Somsa / 3 pcs", "PN Minced Meat Somsa / 4 pcs", "PN Meat and Onion Somsa / 3 pcs", "PN Meat Manti", "PN Beef Chuchvara", "⬅\uFE0F Back PN"};
    String[] toyarimtayyorphoto = {"https://t.me/safiapictures/321", "https://t.me/safiapictures/322", "https://t.me/safiapictures/323", "https://t.me/safiapictures/324", "https://t.me/safiapictures/325", "https://t.me/safiapictures/326", "https://t.me/safiapictures/327"};
    String[] toyarimtayyorcaption = {"PN Varenik with Potato and Mushrooms\n\nGluten-free varenik filled with potato and mushrooms.", "PN Somsa with Greens and Cheese / 3 pcs\n\nGluten-free somsa filled with seasonal greens and cheese.", "PN Chicken Somsa / 3 pcs\n\nGluten-free somsa filled with tender chicken.", "PN Minced Meat Somsa / 4 pcs\n\nGluten-free somsa filled with minced beef.", "PN Meat and Onion Somsa / 3 pcs\n\nGluten-free somsa filled with chopped meat and onions.", "PN Meat Manti\n\nGluten-free manti made from thin dough and minced beef.", "PN Beef Chuchvara\n\nGluten-free chuchvara filled with juicy beef, homemade style."};
    String[] toyarimtayyornarx = {"39 000", "46 000", "46 000", "72 000", "53 000", "41 000", "54 000"};

    String[] totortpp = {"PN Mini Fruit Cake (PP)", "Forest Berry PN Cake (PP)", "PN Snickers Cake", "PN Pistachio-Raspberry Cake", "Matcha Lemon Cake", "PN Chocolate-Cherry Cake", "⬅\uFE0F Back PN"};
    String[] totortppphoto = {"https://t.me/safiapictures/328", "https://t.me/safiapictures/329", "https://t.me/safiapictures/330", "https://t.me/safiapictures/331", "https://t.me/safiapictures/332", "https://t.me/safiapictures/333"};
    String[] totortppcaption = {"Mini Fruit Cake (PP)\n\nGluten-free cake made from classic white sponge soaked with natural orange juice, whipped cream, PP meringue, raspberry and banana. Decorated with cream cheese and fresh berries.", "Forest Berry PN Cake (PP)\n\nGluten-free cake with forest berry filling and karkade tea infusion, sweetened with stevia.", "PN Snickers Cake\n\nGluten-free cake made with peanuts, caramel, and sugar-free chocolate.", "PN Pistachio-Raspberry Cake\n\nGluten-free cake made with cottage cheese, condensed milk cream, natural berries, pistachios.", "Matcha Lemon Cake\n\nPP cake made with Japanese matcha, almond sponge, stevia-based lemon confiture and light matcha mousse.", "PN Chocolate-Cherry Cake\n\nGluten-free chocolate-cherry cake with cream and milk & dark chocolate."};
    String[] totortppnarx = {"196 000", "223 000", "247 000", "247 000", "223 000", "212 000"};

    String[] topishiriq = {"PN Meat Blinchik", "PN Chicken & Mushroom Quiche", "PN Vegetable Quiche", "PN Somsa with Greens and Cheese", "PN Chicken Somsa", "PN Minced Meat Somsa", "PN Meat & Onion Somsa", "⬅\uFE0F Back PN"};
    String[] topishiriqphoto = {"https://t.me/safiapictures/334", "https://t.me/safiapictures/335", "https://t.me/safiapictures/336", "https://t.me/safiapictures/337", "https://t.me/safiapictures/338", "https://t.me/safiapictures/339", "https://t.me/safiapictures/340"};
    String[] topishiriqcaption = {"PN Meat Blinchik\n\nGluten-free blinchik filled with minced beef.", "PN Chicken & Mushroom Quiche\n\nGluten-free quiche filled with chicken, mushrooms, and cheese.", "PN Vegetable Quiche\n\nGluten-free quiche with bell pepper, tomato, sweet corn, chickpeas and greens.", "PN Somsa with Greens and Cheese\n\nGluten-free somsa filled with seasonal greens and cheese.", "PN Chicken Somsa\n\nGluten-free somsa filled with tender chicken.", "PN Minced Meat Somsa\n\nGluten-free somsa filled with minced beef.", "PN Meat & Onion Somsa\n\nGluten-free somsa filled with chopped meat and onions."};
    String[] topishiriqnarx = {"15 000", "26 000", "37 000", "16 000", "16 000", "20 000", "20 000"};

    String[] topirojniypp = {"PN Classic Bar", "PN Chocolate Bar", "PN Mini Profiterole", "PN New York Cheesecake", "PN Cherry Dessert", "PN Potato Dessert", "PN Forest Berry Dessert", "PN 'Lesnaya Yagoda' Dessert", "PN Raspberry Dessert", "PN Malina Dessert", "PN Medovik Dessert", "PN Napoleon Dessert", "PN 'Ptichye Moloko' Dessert", "PN Skazka Dessert", "PN Matcha Tea Dessert", "PN Meringue Dessert", "PN San Sebastian Cheesecake", "PN Matcha-Lemon Tea", "PN Chia Pudding Lactose-Free", "PN Eclair", "⬅\uFE0F Back PN"};
    String[] topirojniyppphoto = {"https://t.me/safiapictures/341", "https://t.me/safiapictures/342", "https://t.me/safiapictures/343", "https://t.me/safiapictures/344", "https://t.me/safiapictures/345", "https://t.me/safiapictures/346", "https://t.me/safiapictures/347", "https://t.me/safiapictures/348", "https://t.me/safiapictures/349", "https://t.me/safiapictures/350", "https://t.me/safiapictures/351", "https://t.me/safiapictures/352", "https://t.me/safiapictures/353", "https://t.me/safiapictures/354", "https://t.me/safiapictures/355", "https://t.me/safiapictures/356", "https://t.me/safiapictures/357", "https://t.me/safiapictures/358", "https://t.me/safiapictures/359", "https://t.me/safiapictures/360"};
    String[] topirojniyppcaption = {"PN Classic Bar\n\nGluten-free bar with dried leaves, oats, Goji berries, natural peanut butter, dried dates, figs, nuts, pumpkin seeds, natural honey, and orange zest.", "PN Chocolate Bar\n\nGranola bar with oats, nuts, soy protein, natural hazelnut paste, dried black cherries, and 72% dark chocolate sweetened with stevia.", "PN Mini Profiterole\n\nGluten-free mini profiterole with sugar-free cream filling.", "PN New York Cheesecake\n\nGluten-free cheesecake with creamy taste.", "PN Cherry Dessert\n\nGluten-free chocolate sponge dessert with sugar substitutes.", "PN Potato Dessert\n\nGluten-free sponge dessert with nuts, granola, and dark chocolate.", "PN Forest Berry Dessert\n\nSponge dessert with fruit cream and raspberry confit.", "PN 'Lesnaya Yagoda' Dessert\n\nGluten-free dessert with raspberry, strawberry, blackcurrant, and cream without sugar.", "PN Raspberry Dessert\n\nGluten-free sponge dessert with cottage cheese and raspberry cream.", "PN Malina Dessert\n\nGluten-free dessert with sugar-free cream and fresh raspberries.", "PN Medovik Dessert\n\nGluten-free honey layer cake with cream and raspberry confit.", "PN Napoleon Dessert\n\nGluten-free dessert with creamy filling and fruit confit.", "PN 'Ptichye Moloko' Dessert\n\nGluten-free soft layered dessert made from protein-rich flour and sugar substitutes.", "PN Skazka Dessert\n\nGluten-free roll cake with sugar-free milk chocolate and almond cream.", "PN Matcha Tea Dessert\n\nAlmond sponge with Japanese Matcha, vanilla, lemon confiture, and light matcha mousse.", "PN Meringue Dessert\n\nGluten-free roll with cream, fresh raspberries, and red currants on meringue.", "PN San Sebastian Cheesecake\n\nGluten-free cheesecake with milk, dark chocolate, and creamy base.", "PN Matcha-Lemon Tea\n\nGluten-free sponge dessert with natural matcha, lemon, and sugar-free cream.", "PN Chia Pudding Lactose-Free\n\nChia pudding with lactose-free yogurt, mango, passion fruit, and coconut milk.", "PN Eclair\n\nGluten-free eclair with cream filling made from dark and milk chocolate."};
    String[] topirojniyppnarx = {"19 000", "17 000", "37 000", "37 000", "27 000", "15 000", "35 000", "33 000", "34 000", "23 000", "31 000", "37 000", "18 000", "37 000", "34 000", "19 000", "41 000", "33 000", "39 000", "17 000"};

    String[] yarimtayyor = {"Potato Varenik", "Cabbage Dolma", "Beef Dolma", "Beef Cutlet / 5 pcs", "Chicken Cutlet / 5 pcs", "Kiev Cutlet / 3 pcs", "Mini Colored Chuchvara", "Nuggets / 12 pcs", "Lamb Chuchvara", "Beef Chuchvara", "Cheesecake / 8 pcs", "Layered Dough", "Samosa Dough", "Meat Cheburek / 4 pcs", "⬅\uFE0F Asosiy Menyu"};
    String[] yarimtayyorphoto = {"https://t.me/safiapictures/361", "https://t.me/safiapictures/362", "https://t.me/safiapictures/363", "https://t.me/safiapictures/364", "https://t.me/safiapictures/365", "https://t.me/safiapictures/366", "https://t.me/safiapictures/367", "https://t.me/safiapictures/368", "https://t.me/safiapictures/369", "https://t.me/safiapictures/370", "https://t.me/safiapictures/371", "https://t.me/safiapictures/372", "https://t.me/safiapictures/373", "https://t.me/safiapictures/374"};
    String[] yarimtayyorcaption = {"Potato Varenik\n\nFlour, potato, onion, salt, pepper, butter, egg", "Cabbage Dolma\n\nBeef, onion, rice, salt, vegetable oil, Chinese salt, pepper, cumin, crushed, water, cabbage", "Beef Dolma\n\nBeef, grape leaves, rice, onion, salt, cilantro, cumin, pepper, vegetable oil, water", "Beef Cutlet / 5 pcs\n\nMinced beef, onion, spices (no preservatives)", "Chicken Cutlet / 5 pcs\n\nMinced chicken, onion, spices (no preservatives)", "Kiev Cutlet / 3 pcs\n\nChicken, butter, dill, salt, pepper, breading flour", "Mini Colored Chuchvara\n\nDough with beet, carrot, spinach juice; filling of beef, onion, spices (no preservatives)", "Nuggets / 12 pcs\n\nChicken, butter, salt, pepper, breading flour, oregano", "Lamb Chuchvara\n\nDough, minced lamb, onion, spices (no preservatives)", "Beef Chuchvara\n\nDough, minced beef, onion, spices (no preservatives)", "Cheesecake / 8 pcs\n\nCottage cheese, wheat flour, egg, sugar, softening dough", "Layered Dough\n\nWheat flour, butter, vegetable oil, sugar, salt, clean water", "Samosa Dough\n\nWheat flour, butter, vegetable oil, sugar, salt, clean water", "Meat Cheburek / 4 pcs\n\nWheat flour, egg, margarine, beef fat, salt, pepper, minced beef, onion"};
    String[] yarimtayyornarx = {"15 000", "39 000", "49 000", "70 000", "60 000", "49 000", "59 000", "29 000", "53 000", "53 000", "31 000", "24 000", "24 000", "29 000"};

    String[] non = {"'Borodinskiy' Non", "'Slavyanskiy Aromat' Non", "'Sport Aktiv' Non", "'Tartin' Non", "⬅\uFE0F Asosiy Menyu"};
    String[] nonphoto = {"https://t.me/safiapictures/375", "https://t.me/safiapictures/376", "https://t.me/safiapictures/377", "https://t.me/safiapictures/378"};
    String[] noncaption = {"'Borodinskiy' Non\n\nMade from wheat and bran flour with malt, yeast, and sourdough", "'Slavyanskiy Aromat' Non\n\nMade from wheat and rye flour, with a rich aroma of malt and spices, with grains and yeast", "'Sport Aktiv' Non\n\nMade with flax, oats, and carrot grains, prepared with yeast", "'Tartin' Non\n\nMade from wheat flour and flax grains, slowly fermented with sourdough and yeast"};
    String[] nonnarx = {"15 000", "15 000", "15 000", "15 000"};

    String[] barmenyu = {"Yangi siqilgan sharbatlar", "Milkshakes", "Limonadlar", "Qahva", "⬅\uFE0F Asosiy Menyu"};

    String[] yangisiqilgan = {"Apelsinli Fresh", "Sabzi-Olmali Fresh (Safia)", "Sabzili Fresh (Safia)", "Olmali Fresh (Safia)", "⬅\uFE0F Orqaga Bar"};
    String[] yangisiqilganphoto = {"https://t.me/safiapictures/379", "https://t.me/safiapictures/380", "https://t.me/safiapictures/381", "https://t.me/safiapictures/382"};
    String[] yangisiqilgancaption = {"Orange Fresh\n\n", "Carrot-Apple Fresh (Safia)\n\n", "Carrot Fresh (Safia)\n\n", "Apple Fresh (Safia)\n\n"};
    String[] yangisiqilgannarx = {"50 000", "30 000", "22 000", "30 000"};

    String[] milksheyk = {"Bananli Milkshake", "Vanilli Milkshake", "Shokoladli Milkshake", "Rezavor Milkshake", "⬅\uFE0F Orqaga"};
    String[] milksheykphoto = {"https://t.me/safiapictures/383", "https://t.me/safiapictures/384", "https://t.me/safiapictures/385", "https://t.me/safiapictures/386"};
    String[] milksheykcaption = {"Banana Milkshake\n\n", "Vanilla Milkshake\n\n", "Chocolate Milkshake\n\n", "Berry Milkshake\n\n"};
    String[] milksheyknarx = {"40 000", "40 000", "45 000", "45 000"};

    String[] limonad = {"Ko'k Ays-ti", "Lesnaya Yagoda Limonad", "Tarxun-Apelsin Limonad", "Mevali Ays-ti", "Sitrus Limonad", "Qora Ays-ti", "⬅\uFE0F Orqaga"};
    String[] limonadphoto = {"https://t.me/safiapictures/387", "https://t.me/safiapictures/388", "https://t.me/safiapictures/389", "https://t.me/safiapictures/390", "https://t.me/safiapictures/391", "https://t.me/safiapictures/392"};
    String[] limonadcaption = {"Blue Iced Tea\n\n", "Forest Berry Lemonade\n\n", "Tarragon-Orange Lemonade\n\n", "Fruit Iced Tea\n\n", "Citrus Lemonade\n\n", "Black Iced Tea\n\n"};
    String[] limonadnarx = {"29 000", "35 000", "35 000", "29 000", "29 000", "29 000"};

    String[] kofe = {"Karamelli Frappe", "Ays Amerikano", "Ays Latte", "Ays Kapuchino", "Shokoladli Frappe", "⬅\uFE0F Orqaga"};
    String[] kofephoto = {"https://t.me/safiapictures/393", "https://t.me/safiapictures/394", "https://t.me/safiapictures/395", "https://t.me/safiapictures/396", "https://t.me/safiapictures/397"};
    String[] kofecaption = {"Caramel Frappe\n\n", "Iced Americano\n\n", "Iced Latte\n\n", "Iced Cappuccino\n\n", "Chocolate Frappe\n\n"};
    String[] kofenarx = {"24 000", "33 000", "29 000", "37 000", "37 000"};

    String[] qahva = {"Qahva Abonementi - 15", "Qahva Abonementi - 30", "⬅\uFE0F Asosiy Menyu"};
    String[] qahvaphoto = {"https://t.me/safiapictures/398", "https://t.me/safiapictures/399"};
    String[] qahvacaption = {"Qahva Abonementi – 15\n\nIncludes 15 servings of coffee drinks: Americano (150 ml), Cappuccino (200 ml), Latte (200 ml), Espresso (50 ml), Iced Latte, Iced Americano, Iced Cappuccino, Double Americano, Double Cappuccino, Double Espresso, Double Latte. Valid for 15 calendar days (purchase day not included). After expiration, the subscription is cancelled. Choose any you like. Save time and money!", "Qahva Abonementi – 30\n\nIncludes 30 servings of coffee drinks: Americano (150 ml), Cappuccino (200 ml), Latte (200 ml), Espresso (50 ml), Iced Latte, Iced Americano, Iced Cappuccino, Double Americano, Double Cappuccino, Double Espresso, Double Latte. Valid for 30 calendar days (purchase day not included). After expiration, the subscription is cancelled. Choose any you like. Save time and money!"};
    String[] qahvanarx = {"200 000", "350 000"};

    public InlineKeyboardMarkup enmenu(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Welcome to Safia! Choose one option:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("About Us");
        button.setCallbackData("haqidaenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Menu");
        button.setCallbackData("menuenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Our Values");
        button.setCallbackData("qadriyatenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Locations");
        button.setCallbackData("manzilenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Catering");
        button.setCallbackData("keytingenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Change Language");
        button.setCallbackData("sozlamaenId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;
    }

    public SendMessage enmenu1(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Welcome to Safia! Choose one option:");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("About Us");
        button.setCallbackData("haqidaenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Menu");
        button.setCallbackData("menuenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Our Values");
        button.setCallbackData("qadriyatenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Locations");
        button.setCallbackData("manzilenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Catering");
        button.setCallbackData("keytingenId");
        row.add(button);
        rowList.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Change Language");
        button.setCallbackData("sozlamaenId");
        row.add(button);
        rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public InlineKeyboardMarkup shahar(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Select your destination city:");

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
        return inlineKeyboardMarkup;
    }

    public SendMessage haqida(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Choose the type of information you want to know about us:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Our History");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Our Achievements");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Safia Store (\uD83C\uDDEC\uD83C\uDDE7)");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Cancel");
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
        sendPhoto.setCaption("The history of Safia Cafe & Bakery is an inspiring story of love for baking that became a family legend and one of Uzbekistan's top confectionery brands.\n\nOver nine years, the company has grown from a local family business to an international brand. Today Safia Cafe & Bakery is:\n\n145 branches, including 4 cozy cafes in Kazakhstan, one of the largest confectionery factories in Central Asia,\nThousands of employees,\nAnd hundreds of thousands of satisfied customers whose days are made sweeter by our work.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytbizenId");
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
        sendPhoto.setCaption("Safia Cafe & Bakery is an example of a successful family business in Uzbekistan.\n\nThis is confirmed by numerous awards:\n\nIn 2024, Safia Cafe & Bakery received the “Brand of the Year” award for the 5th time, earning the love and recognition of our guests and clients.\n\nIn 2023, we were recognized in the Digital Innovator category at the TAF2023 marketing conference.\n\nFrom 2021 to 2023, Safia Cafe & Bakery repeatedly won the International Employer Brand Award.\n\nOur main achievement remains meeting guest expectations and providing an impressive experience.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytbizenId");
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
        sendPhoto.setCaption("To get closer to our guests, we launched a limited Safia Store collection.\n\nYou will find useful items with unique designs that will fill your life and home with warmth and care.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytbizenId");
        row.add(button);
        rowList.add(row);
        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage qadriyat(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our values:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⛰ Environment");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("👨‍👩‍👦‍👦 Family");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("👨‍🦽➡️ Inclusion");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Cancel");
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
        sendPhoto.setCaption("Caring for the environment, we ensure a sustainable and clean future for the next generations – this is our firm goal!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytqadrEnId");
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
        sendPhoto.setCaption("We love our work! Upholding family values, we develop our confectionery skills. We create a festive atmosphere for every individual and family, ensuring that our products are made with natural high-quality ingredients and sincere care for our guests.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytqadrEnId");
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
        sendPhoto.setCaption("We care for everyone, providing jobs and fair working conditions!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytqadrEnId");
        row.add(button);
        rowList.add(row);
        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage keytring(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Types of catering:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Safia Catering (\uD83C\uDDEC\uD83C\uDDE7)"); // EN flag 🇬🇧
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Our Advantages");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Our Partners");
        row.add(button);
        rowList.add(row);

        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("❌ Cancel");
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
        sendPhoto.setCaption("We organize this event especially for you! We offer our services to both individuals and companies.\n\nOur experienced chefs and confectioners have trained in the best culinary institutions in Tashkent and abroad. Based on rich experience, our experts will bring your ideas to reality and provide necessary consultations.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytkeyEnId");
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
        sendPhoto.setCaption("According to your tastes and preferences, we organize events from location selection to all stages of execution at a high level.\n\nOur decorators with limitless imagination create a unique design tailored to your event.\n\nQuality and delicate taste are the keys to our success. When choosing products, we always think of you and ensure your event runs perfectly.");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytkeyEnId");
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
        sendPhoto.setCaption("Over 6 years, we have successfully organized various events.\n\nWe have had the pleasure to cooperate with companies and brands such as: National Bank of Uzbekistan, AsiaAlliance Bank, World Bank, Uztelecom, OKMK, Coca-Cola Uzbekistan, British American Tobacco, Beeline Uzbekistan, Ucell, Humans, and more!");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("⬅️ Back");
        button.setCallbackData("qaytkeyEnId");
        row.add(button);
        rowList.add(row);
        inlineKeyboardMarkup.setKeyboard(rowList);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage filial(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("All our branches: \nPhone: +998 78 113 40 40 \nWorking hours: 08:00 to 23:00");
        return sendMessage;
    }

    public SendMessage filialone(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (1-10)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextoneEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < onetotwo.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(onetotwo[i]);
            button.setCallbackData(onetotwo[i] + "EnId");
            row.add(button);

            if (row.size() == 2) {
                rowList.add(row);
                row = new ArrayList<>();
            }
        }
        if (!row.isEmpty()) rowList.add(row);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public InlineKeyboardMarkup filialone1(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (1-10)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextoneEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < onetotwo.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(onetotwo[i]);
            button.setCallbackData(onetotwo[i] + "EnId");
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

    public InlineKeyboardMarkup filialtwo(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (11-20)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qayttwoEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nexttwoEnId");
        row1.add(next);

        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < twotothree.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(twotothree[i]);
            button.setCallbackData(twotothree[i] + "EnId");
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

    public InlineKeyboardMarkup filialthree(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (21-30)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytthreeEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextthreeEnId");
        row1.add(next);

        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < threetofour.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(threetofour[i]);
            button.setCallbackData(threetofour[i] + "EnId");
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

    public InlineKeyboardMarkup filialfour(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (31-40)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytfourEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextfourEnId");
        row1.add(next);

        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < fourtofive.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(fourtofive[i]);
            button.setCallbackData(fourtofive[i] + "EnId");
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

    public InlineKeyboardMarkup filialfive(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Our branches: 131 (41-50)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytfiveEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextfiveEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < fivetosix.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(fivetosix[i]);
            button.setCallbackData(fivetosix[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (51-60)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytsixEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextsixEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < sixtoseven.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(sixtoseven[i]);
            button.setCallbackData(sixtoseven[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (61-70)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytsevenEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextsevenEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < seventoeight.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(seventoeight[i]);
            button.setCallbackData(seventoeight[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (71-80)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qayteightEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nexteightEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < eighttonine.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(eighttonine[i]);
            button.setCallbackData(eighttonine[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (81-90)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytnineEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextnineEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < ninetoten.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(ninetoten[i]);
            button.setCallbackData(ninetoten[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (91-100)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qayttenEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nexttenEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < tentoeleven.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(tentoeleven[i]);
            button.setCallbackData(tentoeleven[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (101-110)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytelevenEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nextelevenEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < eleventotwelve.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(eleventotwelve[i]);
            button.setCallbackData(eleventotwelve[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (111-120)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qayttwelveEnId");
        row1.add(qayt);

        InlineKeyboardButton next = new InlineKeyboardButton();
        next.setText("➡ Next");
        next.setCallbackData("nexttwelveEnId");
        row1.add(next);
        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < twelvetothirteen.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(twelvetothirteen[i]);
            button.setCallbackData(twelvetothirteen[i] + "EnId");
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
        sendMessage.setText("Our branches: 131 (121-131)");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> rowe = new ArrayList<>();
        InlineKeyboardButton qaytf = new InlineKeyboardButton();
        qaytf.setText("⬅ Main Menu");
        qaytf.setCallbackData("qaytfEnId");
        rowe.add(qaytf);
        rowList.add(rowe);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton qayt = new InlineKeyboardButton();
        qayt.setText("⬅ Back");
        qayt.setCallbackData("qaytthirteenEnId");
        row1.add(qayt);

        rowList.add(row1);

        List<InlineKeyboardButton> row = new ArrayList<>();
        for (int i = 0; i < thirteentofourteen.length; i++) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(thirteentofourteen[i]);
            button.setCallbackData(thirteentofourteen[i] + "EnId");
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
        sendMessage.setText("Send your phone number");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        KeyboardButton mynum = new KeyboardButton();
        mynum.setText("\uD83D\uDCDE My number");
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
        sendMessage.setText("Choose a category:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton bir = new KeyboardButton();
        bir.setText("\uD83C\uDF70 Delicious sweets here");
        row.add(bir);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton ikki = new KeyboardButton();
        ikki.setText("\uD83E\uDD57 Proper nutrition desserts");
        row1.add(ikki);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton uch = new KeyboardButton();
        uch.setText("\uD83E\uDD5F Semi-prepared products");
        row2.add(uch);
        rowList.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton tort = new KeyboardButton();
        tort.setText("\uD83E\uDD56 Austrian bread");
        row3.add(tort);
        rowList.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton besh = new KeyboardButton();
        besh.setText("\uD83C\uDF79 Bar menu");
        row4.add(besh);
        rowList.add(row4);

        KeyboardRow row5 = new KeyboardRow();
        KeyboardButton olti = new KeyboardButton();
        olti.setText("\uD83E\uDDF8 Animators delivery");
        row5.add(olti);
        rowList.add(row5);

        KeyboardRow row6 = new KeyboardRow();
        KeyboardButton yetti = new KeyboardButton();
        yetti.setText("☕\uFE0F Coffee subscriptions");
        row6.add(yetti);
        rowList.add(row6);

        KeyboardRow row7 = new KeyboardRow();
        KeyboardButton sakkiz = new KeyboardButton();
        sakkiz.setText("❌ Cancel");
        row7.add(sakkiz);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Cart");
        row7.add(savat);
        rowList.add(row7);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage mazali(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Delicious sweets here");

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
        sendMessage.setText("Round cakes");

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
        sendMessage.setText("Square cakes");

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
        sendMessage.setText("Mini cakes");

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
        sendMessage.setText("Large pies");

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
        sendMessage.setText("Round pies");

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
        sendMessage.setText("Pastries");

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
        sendMessage.setText("Roulades");

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
        sendMessage.setText("Eclairs");

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
        sendMessage.setText("Macarons");

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
        sendMessage.setText("Prepared Meals");

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
        sendMessage.setText("Sweets");

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
        sendMessage.setText("Cookies");

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
        sendMessage.setText("Packaged Eclairs");

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
        sendMessage.setText("Sweet Pastries");

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
        sendMessage.setText("Cakes");

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
        sendMessage.setText("Tartlets");

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
        sendMessage.setText("Layered Pastries");

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
        sendMessage.setText("Hearty Pastries");

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
        sendMessage.setText("Ginger Pastries");

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
        sendMessage.setText("Healthy Eating Sweets");

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
        sendMessage.setText("PN Pies");

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
        sendMessage.setText("PN Semi-Prepared Products");

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
        sendMessage.setText("PN Cakes");

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
        sendMessage.setText("PN Pastries");

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
        sendMessage.setText("PN Mini Cakes");

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
        sendMessage.setText("Semi-Prepared Products");

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
        sendMessage.setText("Austrian Bread");

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
        sendMessage.setText("Bar Menu");

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
        sendMessage.setText("Freshly Squeezed Juices");

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
        sendMessage.setText("Milkshakes");

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
        sendMessage.setText("Lemonades");

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
        sendMessage.setText("Coffee");

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
        sendMessage.setText("Coffee Subscriptions");

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
        sendPhoto.setCaption(caption + "\n\nPrice: " + narx + " UZS");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        for (int i = 1; i < 10; i++) {
            KeyboardButton button = new KeyboardButton();
            button.setText(String.valueOf(i) + " pcs");
            row.add(button);

            if (row.size() == 3) {
                rowList.add(row);
                row = new KeyboardRow();
            }
        }

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton ortga = new KeyboardButton();
        ortga.setText("⬅\uFE0F Back to Main Menu");
        row1.add(ortga);
        rowList.add(row1);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Cart");
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
        sendPhoto.setCaption("Delivery with Animator Service\n\nImagine, the same cartoon character delivers the cake to you! ⭐\n\nPerfect for children's birthdays or any important holiday. We make your child's celebration magical and unforgettable.\n\nThe animator gives the cake with a traditional song. What could be more magical?\n\nPrice: 180,000 UZS");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton qosh = new KeyboardButton();
        qosh.setText("\uD83D\uDED2 Add to Cart");
        row.add(qosh);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton qayt = new KeyboardButton();
        qayt.setText("⬅\uFE0F Back to Main Menu");
        row1.add(qayt);
        rowList.add(row1);

        KeyboardButton savat = new KeyboardButton();
        savat.setText("\uD83D\uDED2 Cart");
        row1.add(savat);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        return sendPhoto;
    }

    public SendMessage savat(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDECD Your order is being processed...");

        return sendMessage;
    }

    public SendMessage tasdiqlash(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Do you want to confirm adding to the cart?");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Yes ✅");
        button.setCallbackData("yesenId");
        row.add(button);
        rowList.add(row);

        button = new InlineKeyboardButton();
        button.setText("No ❌");
        button.setCallbackData("noenId");
        row.add(button);

        inlineKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage yes(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Added to cart ✅");
        return sendMessage;
    }

    public SendMessage no(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Continue shopping \uD83D\uDECD");
        return sendMessage;
    }

}
