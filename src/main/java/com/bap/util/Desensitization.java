package com.bap.util;


/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

/**
 * The type Desensitization.
 */
public class Desensitization {
        //匹配规则
        private static final String REGEX = "(^\\d{3})\\d.*(\\d{4}$)";
        //替换规则
        private static final String REPLACE = "$1****$2";

    /**
     * 手机号脱敏 153****8736
     *
     * @param phone the phone
     * @return the string
     */
    public static String phoneMasking(String phone){
            if(!(phone).equals("")){
                return phone.replaceAll(REGEX, REPLACE);
            }
            return null;
        }

    /**
     * 身份证号脱敏 511********9768
     *
     * @param id 身份证号
     * @return the string
     */
    public static String idMasking(String id){
        if(!(id).equals("")){
            return id.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    /**
     * Email masking string.
     *
     * @param email the email
     * @return the string
     */
    public static String emailMasking(String email){
        if(!(email).equals("")){
            return email.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    /**
     * We chat masking string.
     *
     * @param weChat the we chat
     * @return the string
     */
    public static String weChatMasking(String weChat){
        if(!(weChat).equals("")){
            return weChat.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    /**
     * Name masking string.
     *
     * @param name the name
     * @return the string
     */
    public static String nameMasking(String name){
        if(!(name).equals("")){
            return name.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    /**
     * Card masking string.
     *
     * @param card the card
     * @return the string
     */
    public static String cardMasking(String card){
        if(!(card).equals("")){
            return card.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

}
