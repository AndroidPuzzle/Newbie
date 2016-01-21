package net.mingfei.android.puzzle.newbie.service.util;

import android.app.Activity;
import net.mingfei.android.puzzle.newbie.service.annotation.ContentView;
import net.mingfei.android.puzzle.newbie.service.annotation.ViewInject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author mingfei.net@Gmail.com
 *         18:14, 1/20/16.
 */
public class ViewInjectUtil {

    private static final String METHOD_SET_CONTENT_VIEW = "setContentView";
    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    private static void injectContentView(Activity activity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends Activity> clazz = activity.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView == null) {
            return;
        }
        int contentViewLayoutId = contentView.value();
        Method method = clazz.getMethod(METHOD_SET_CONTENT_VIEW, int.class);
        method.setAccessible(true); // TODO: 1/20/16 ?
        method.invoke(activity, contentViewLayoutId);
    }

    private static void injectViews(Activity activity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject == null) {
                continue;
            }
            int viewId = viewInject.value();
            Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
            field.setAccessible(true); // TODO: 1/20/16 ?
            field.set(activity, method.invoke(activity, viewId));
        }
    }

    public static void inject(Activity activity) {
        try {
            injectContentView(activity);
            injectViews(activity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
