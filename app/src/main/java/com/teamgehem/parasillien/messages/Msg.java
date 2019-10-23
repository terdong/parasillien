package com.teamgehem.parasillien.messages;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Msg {
    private static final String BUNDLE_NAME = "msg.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private Msg() {
    }

    public static String getStr(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
