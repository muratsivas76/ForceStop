package com.tigaliang.forcestop.staffs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by tigaliang on 2016/10/4.
 * <p>
 * BlackListDao:
 */

public final class BlackListDao {
    private static final String PREF_BLACK_LIST = "black_list";
    private static final String ITEM_PACKAGES = "packages";
    private static final String DELIMITER = ";";

    private BlackListDao() {
    }

    /**
     * Set black list to perform force stopping on
     *
     * @param blackList Array of package names
     */
    public static void setBlackList(@NonNull Context context, String[] blackList) {
        pref(context).edit().putString(ITEM_PACKAGES, TextUtils.join(DELIMITER, blackList)).apply();
    }

    /**
     * @return Array of package names
     */
    public static String[] getBlackList(@NonNull Context context) {
        return pref(context).getString(ITEM_PACKAGES, "").split(DELIMITER);
    }

    private static SharedPreferences pref(@NonNull Context context) {
        return context.getSharedPreferences(PREF_BLACK_LIST, Context.MODE_PRIVATE);
    }
}
