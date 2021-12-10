package com.example.chineseToPinyin.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @Author zhangle
 * @CreateTime 2021-12-10 13:28:00
 * @Description 中文转拼音
 */
public class ChineseToPinyinUtil {

    public static String chinese2Pinyin(String china){
        //汉字转换成拼音的格式
        HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
        formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);//字母小写
        formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//拼音没有音调
        formart.setVCharType(HanyuPinyinVCharType.WITH_V);//针对 '律师'-> lv shi   这种类型

        char[] arrays = china.trim().toCharArray();
        StringBuffer result = new StringBuffer();
        try {
            for (int i=0;i<arrays.length;i++) {
                char ti = arrays[i];
                //匹配是否是中文
                if(Character.toString(ti).matches("[\\u4e00-\\u9fa5]")){
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(ti,formart);
                    result.append(temp[0]);
                }else{
                    result.append(ti);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //String chinese = "Java律师123";
        String chinese = "刘晓靖";
        String pinyin = chinese2Pinyin(chinese);
        System.out.println("汉字 -> 拼音 ，pinyin = "+pinyin);
    }
}
