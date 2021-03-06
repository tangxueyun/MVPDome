package android.text;

import android.support.annotation.Nullable;

/**
 * Created by ${user} on 2017/10/12.
 */

public class TextUtils
{
    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(@Nullable CharSequence str)
    {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
