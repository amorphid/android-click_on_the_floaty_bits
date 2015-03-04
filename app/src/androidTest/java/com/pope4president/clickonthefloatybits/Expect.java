package com.pope4president.clickonthefloatybits;

        import android.view.View;

public class Expect {
    public View view;

    public Expect(View view) {
        this.view = view;
    }

    public void toExist() throws Exception {
        if (view == null) {
            throw new Exception();
        }
    }
}
