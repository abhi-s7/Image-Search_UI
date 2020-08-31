package com.abhi.imagesearch.ui.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class BrandData {

    public static final String[] brands = {"SUZUKI", "CHEVEORLET", "FORD", "HONDA","HYUNDAI","ISUZU", "JEEP", "Mahindra","NISSAN","RENAULT","SKODA","VOLKSWAGEN",
            "TATA", "TOYOTA"};

    public static final Set<String> brandSet = new HashSet<>(Arrays.asList(brands));

/*
    public static ArrayList<String[]> add(){
        ArrayList<String[]> allBrandNames = new ArrayList<>();

        allBrandNames.add(brands);
        allBrandNames.add(suzuki);
        allBrandNames.add(cheveorlet);
        allBrandNames.add(ford);
        allBrandNames.add(honda);
        allBrandNames.add(hyundai);
        allBrandNames.add(isuzu);
        allBrandNames.add(jeep);
        allBrandNames.add(mahindra);
        allBrandNames.add(nissan);
        allBrandNames.add(renault);
        allBrandNames.add(skoda);
        allBrandNames.add(volkswagen);
        allBrandNames.add(tata);
        allBrandNames.add(toyota);

        return allBrandNames;
    }
*/
    public static final String[] brandNames= {"SUZUKI", "CHEVEORLET", "FORD", "HONDA","HYUNDAI","ISUZU", "JEEP", "Mahindra","NISSAN","RENAULT","SKODA","VOLKSWAGEN",
            "TATA", "TOYOTA",
            "Suzuki Alto 800", "Suzuki Breeza" , "Suzuki Celerio", "Suzuki Ciaz", "Suzuki Ertiga NEW", "Suzuki Ignis", "Suzuki S-Cross",
            "Suzuki Swift 2015", "Suzuki Swift 2018", "Suzuki Swift OLD", "Suzuki SX-4" , "Suzuki Wagon R NEW", "Suzuki Wagon R OLD",

            "Cheveorlet Cruze",

            "Ford Ecosport NEW", "Ford Ecosport OLD", "Ford Endavour NEW", "Ford Endavour OLD", "Ford Figo Aspire / Freestyle",

            "Honda Accord New", "Honda Amaze NEW", "Honda BRV", "Honda City V-TEC", "Honda JAZZ OLD", "Honda City NEW", "Honda Civic NEW", "Honda Jazz NEW",
            "Honda WRV",

            "Hyundai Creta (OLD)", "Hyundai Elentra", "Hyundai EON", "Hyundai I 10 Grand", "Hyundai I 10 OLD", "Hyundai I 20 Elite (NEW)", "Hyundai I 20 Elite (OLD)",
            "Hyundai I 20 Automatic AC", "Hyundai I 20 Manual AC", "Hyundai New Santro", "Hyundai New Verna", "Hyundai SantaFe", "Hyundai Venue","Hyundai Verna Fludic",

            "ISUZU DMAX", "Jeep Compass",

            "Mahindra Bolero", "Mahindra Marrazo", "Mahindra Scorpio Knobs","Mahindra Scorpio New", "Mahindra TUV 300", "Mahindra XUV 300",
            "Nissan Sunny", "Renault Duster", "Renault Kwid", "Renault Triber",

            "Skoda Laura", "VolksWagen Polo", "Skoda Superb",

            "Tata Hexa", "Tata Nexon", "Tata Tiago",

            "Toytoa Corolla OLD", "Toyota Fortuner NEW", "Toyota Fortuner OLD", "Toyota Innova Crysta", "Toyota Innova OLD", "Toyota Universal", "Toyota Yaris"


    };

    public static final String[] suzuki = {
            "Suzuki Alto 800", "Suzuki Breeza" , "Suzuki Celerio", "Suzuki Ciaz", "Suzuki Ertiga NEW", "Suzuki Ignis", "Suzuki S-Cross",
            "Suzuki Swift 2015", "Suzuki Swift 2018", "Suzuki Swift OLD", "Suzuki SX-4" , "Suzuki Wagon R NEW", "Suzuki Wagon R OLD"
    };


    public static final String[] suzukiFileNames = {
            "alto800", "breeza", "celerio", "ciaz", "ertiganew", "ignis", "scross", "swift2015", "swift2018","swiftold","sx4","wagonrnew", "wagonrold"
    };


    public static final String[] cheveorlet = {"Cheveorlet Cruze"};

    public static final String[] cheveorletFileNames = {"cruze"};

    public static final String[] ford = {
            "Ford Ecosport NEW", "Ford Ecosport OLD", "Ford Endavour NEW", "Ford Endavour OLD", "Ford Figo Aspire / Freestyle"
    };

    public static final String[] fordFileNames = {
            "ecosportnew", "ecosportold", "endavournew", "endavourold", "figoaspirefreestyle"
    };

    public static final String[] honda = {
            "Honda Accord New", "Honda Amaze NEW", "Honda BRV", "Honda City V-TEC", "Honda JAZZ OLD", "Honda City NEW", "Honda Civic NEW", "Honda Jazz NEW",
            "Honda WRV"
    };
    public static final String[] hondaFileNames = {
            "accordnew", "amazenew", "brv", "cityvtec", "jazzold", "newcity", "newcivic", "newjazz", "wrv"
    };

    public static final String[] hyundai = {
            "Hyundai Creta (OLD)", "Hyundai Elentra", "Hyundai EON", "Hyundai I 10 Grand", "Hyundai I 10 OLD", "Hyundai I 20 Elite (NEW)", "Hyundai I 20 Elite (OLD)",
            "Hyundai I 20 Automatic AC", "Hyundai I 20 Manual AC", "Hyundai New Santro", "Hyundai New Verna", "Hyundai SantaFe", "Hyundai Venue","Hyundai Verna Fludic"
    };
    public static final String[] hyundaiFileNames = {
            "cretaold", "elentra", "eon", "i10grand", "i10old", "i20elitenew", "i20eliteold", "i20oldautomaticac",
            "i20oldmanualac", "newsantro", "newverna", "santafe", "venue", "vernafludic"
    };

    public static final String[] isuzu = { "ISUZU DMAX"};
    public static final String[] isuzuFileNames = { "dmax"};

    public static final String[] jeep = {"Jeep Compass"};
    public static final String[] jeepFileNames = {"compass"};

    public static final String[] mahindra = {
            "Mahindra Bolero", "Mahindra Marrazo", "Mahindra Scorpio Knobs","Mahindra Scorpio New", "Mahindra TUV 300", "Mahindra XUV 300"
    };
    public static final String[] mahindraFileNames = {
            "bolero", "marrazo", "scorpioknbs","scorpionew", "tuv300", "xuv300"
    };

    public static final String[] nissan = {"Nissan Sunny"};
    public static final String[] nissanFileNames = {"sunny"};

    public static final String[] renault = {"Renault Duster", "Renault Kwid", "Renault Triber"};
    public static final String[] renaultFileNames = {
            "duster", "kwid", "triber"
    };

    public static final String[] skoda = {
            "Skoda Laura", "Skoda Superb"
    };
    public static final String[] skodaFileNames = {
            "laura", "superb"
    };

    public static final String[] volkswagen = {
            "VolksWagen Polo"
    };
    public static final String[] volkswagenNames = {
            "polo"
    };

    public static final String[] tata = {
            "Tata Hexa", "Tata Nexon", "Tata Tiago"
    };
    public static final String[] tataFileNames = {
            "hexa", "nexon", "tiago"
    };

    public static final String[] toyota = {
            "Toytoa Corolla OLD", "Toyota Fortuner NEW", "Toyota Fortuner OLD", "Toyota Innova Crysta", "Toyota Innova OLD", "Toyota Universal", "Toyota Yaris"
    };
    public static final String[] toyotaFileNames = {
            "corollaold", "fortunernew", "fortunerold", "innovacrysta", "innovaold", "toyotauniversal", "yaris"
    };


    /*
    public static final String[] suzuki = {
            "Suzuki Alto 800", "Suzuki Alto 800" , "Suzkui Celerio", "Suzuki Ciaz", " Suzuki Ertiga NEW", "Suzuki Ignis", "Suzuki S-Cross",
            "Suzuki Swift 2015", "Suzuki Swift 2018", "Suzuki Swift OLD", "Suzuki SX-4" , "Suzuki Wagon R NEW", "Suzuki Wagon R OLD"
    };

    public static final String[] cheverolet = {"Cheveorlet Cruze"};

    public static final String[] ford = {
            "Ford Ecosport NEW", "Ford Ecosport OLD", "Ford Endavour NEW", "Ford Endavour OLD", "Ford Figo Aspire / Freestyle"
    };

    public static final String[] honda = {
            "Honda Accord New", "Honda Amaze NEW", "Honda BRV", "Honda City V-TEC", "Honda JAZZ OLD", "Honda City NEW", "Honda Civic NEW", "Honda Jazz NEW",
            "Honda WRV"
    };

    public static final String[] hyundai = {
            "Hyundai Creta (OLD)", "Hyundai Elentra", "Hyundai EON", "Hyundai I-10 Grand", "Hyundai I-10 OLD", "Hyundai I-20 Elite (NEW)", "Hyundai I-20 Elite (OLD)",
            "Hyundai I-20 Automatic AC", "Hyundai I-20 Manual AC", "Hyundai New Santro", "Hyundai New Verna", "Hyundai SantaFe", "Hyundai Venue","Hyundai Verna Fludic"
    };

    public static final String[] isuzu = { "ISUZU DMAX"};

    public static final String[] jeep = {"Jeep Compass"};

    public static final String[] mahindra = {
            "Mahindra Bolero", "Mahindra Marrazo", "Mahindra Scorpio", "Mahndra TUV 300", "Mahindra XUV 300"
    };

    public static final String[] nissan = {"Nissan Sunny"};

    public static final String[] renault = {"Renault Duster", "Renault Kwid", "Renault Triber"};

    public static final String[] skoda = {
            "Skoda Laura", "VolksWagen Polo", "Skoda Superb"
    };

    public static final String[] tata = {
            "Tata Hexa", "Tata Nexon", "Tata Tiago"
    };

    public static final String[] toyota = {
            "Toytoa Corolla OLD", "Toyota Fortuner NEW", "Toyota Fortuner OLD", "Toyota Innova Crysta", "Toyota Innova OLD", "Toyota Universal", "Toyota Yaris"
    };

     */

}
