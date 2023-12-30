package edu.praktikum.apiUserProfile;

public class TestUser {
    private static final String EMAIL = "tatasim_27@yandex.ru";
    private static final String PASSWORD = "qweqwe";
    private static final String NAME = "Sam Smith";
        public static UserCreate testUserCreate() {
            return new UserCreate()
                    .withEmail(EMAIL)
                    .withPassword(PASSWORD)
                    .withName(NAME);
        }
    }
