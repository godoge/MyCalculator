package net.lzzy.mycalculator;

/**
 * Created by Administrator on 2016/3/15.
 */
public class GainStringProperty {

    // 获取运算符之前的一组数字
    static String gain_back_number_by_string(String number, char sign) {
        return number.substring(gain_string_back_at_start_index(number, sign),
                gain_string_back_at_end_index(number, sign) + 1);
    }

    // 获取运算符之后的一组数字
    static String gain_front_number_by_string(String number, char sign) {
        return number.substring(gain_string_front_at_start_index(number, sign),
                gain_string_front_at_end_index(number, sign) + 1);
    }

    // 获取字符串里的运算符号后一组数字的最前的一位下标
    static int gain_string_front_at_start_index(String number, char sign) {
        int sign_position = number.indexOf(sign);
        if (sign_position + 1 < number.length() && number.charAt(sign_position + 1) > '0'
                && number.charAt(sign_position + 1) < '9')
            return sign_position + 1;
        return -1;

    }

    // 获取字符串里的运算符号后一组数字的最后的一位下标
    static int gain_string_front_at_end_index(String number, char sign) {
        int i = 1;
        int sign_position = number.indexOf(sign);

        if (sign_position + 1 > number.length())
            return number.length() - 1;
        while (sign_position + i < number.length() && number.charAt(sign_position + i) >= '0'
                && number.charAt(sign_position + i) <= '9' || number.charAt(sign_position + i) == '.') {
            i++;
            if (sign_position + i > number.length()-1)
                return number.length() - 1;

        }
        return sign_position + i - 1;
    }

    // 获取字符串里的运算符号前一组数字的最前的一位下标
    static int gain_string_back_at_start_index(String number, char sign) {
        int i = 1;
        int sign_position = number.indexOf(sign);
        if (sign_position - i < 0)
            return 0;
        while (number.charAt(sign_position - i) >= '0' && number.charAt(sign_position - i) <= '9'
                || number.charAt(sign_position - i) == '.') {
            i++;
            if (sign_position - i < 0)
                return 0;
        }
        // 检测到下标不为数字时就返回最前一位下标值
        if (number.charAt(sign_position - i) < 48 || number.charAt(sign_position - i) > 57)
            return sign_position - i + 1;
        return -1;
    }

    // 获取字符串里的运算符号前一组数字的最后一位下标
    static int gain_string_back_at_end_index(String number, char sign) {
        int sign_position = number.indexOf(sign);
        if (sign_position - 1 >= 0 && number.charAt(sign_position - 1) >= 48
                && number.charAt(sign_position - 1) <= 57) {
            return sign_position - 1;
        }
        return -1;
    }

}