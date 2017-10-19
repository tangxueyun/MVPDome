package cn.tanghaha.mvpDome.login.view;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.tanghaha.mvpDome.R;
import cn.tanghaha.mvpDome.activity.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ${user} on 2017/10/13.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest
{
    public static final String NAME = "123456";
    public static final String PASSWORD = "123456";

    //规定测试的activity类
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<LoginActivity>
            (LoginActivity.class);

    /**
     * 点击登录按钮---》显示用户名错误Toast
     */
    @Test
    public void clickLoginBtn()
    {
        onView(withId(R.id.login_btn)).perform(click());
    }

    /**
     * 输入用户名,点击登录按钮---》显示密码错误Toast
     */
    @Test
    public void inputNameClickLoginBtn()
    {
        onView(withId(R.id.login_username_et)).perform(typeText(NAME), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
    }

    /**
     * 输入密码，点击登录按钮---》显示用户名错误Toast
     */
    @Test
    public void inputPasswordClickLoginBtn()
    {
        onView(withId(R.id.login_pwd_et)).perform(typeText(PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
    }

    /**
     * 输入用户名，密码，点击登录按钮---》显示输入的用户名、密码Toast，并跳转到首页
     */
    @Test
    public void inputNameAndPasswordClickLoginBtn()
    {
        onView(withId(R.id.login_username_et)).perform(typeText(NAME), closeSoftKeyboard());
        onView(withId(R.id.login_pwd_et)).perform(typeText(PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
    }

}