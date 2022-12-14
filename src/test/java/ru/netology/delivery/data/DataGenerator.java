package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {

    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String generateDate(int daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] ArrayOfCities = {"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Владикавказ", "Владимир",
                "Екатеринбург", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Краснодар", "Красноярск", "Курган",
                "Махачкала", "Москва", "Нарьян-Мар", "Петропавловск-Камчатский", "Салехард", "Самара", "Санкт-Петербург",
                "Ставрополь", "Сыктывкар", "Тверь", "Удан-Удэ", "Чебоксары", "Хабаровск", "Якутск"};

        Random random = new Random();
        int i = random.nextInt(ArrayOfCities.length);
        return ArrayOfCities[i];
    }

    public static String generateName(String locale) {
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        return faker.phoneNumber().cellPhone();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(
                    generateCity("ru"),
                    generateName("ru"),
                    generatePhone("ru")
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}