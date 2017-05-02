package com.example.wind.smalldou.utils;

import android.widget.TextView;

import java.util.List;

/**
 * Created by Wind1129 on 17/4/17.
 */

public class StringUtil {
    public static void addViewString(List<String> list, TextView view) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                view.append(list.get(i));
            } else {
                view.append(list.get(i) + "/");
            }
        }
    }
}
