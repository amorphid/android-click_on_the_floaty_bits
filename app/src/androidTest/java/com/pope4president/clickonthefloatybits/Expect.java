package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.view.View;

import static com.pope4president.clickonthefloatybits.Chinchilla.get_text_view;
import static com.pope4president.clickonthefloatybits.Chinchilla.get_view;

public class Expect {
    public Activity activity;

    public Expect(Activity activity) {
        this.activity = activity;
    }

    public void to_have_view_id(int view_id) throws Exception {
        View view = get_view(view_id);
        throw_exception_if_null(view);

    }

    public void to_have_text(String text) throws Exception {
        View view = get_text_view(text);
        throw_exception_if_null(view);
    }

    public void throw_exception_if_null (Object object) throws Exception {
        if (object == null) {
            throw new Exception();
        }
    }
}
