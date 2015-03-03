package com.pope4president.clickonthefloatybits;

        import android.view.View;

public class Expect {
    public View view;

    public Expect(View view) {
        this.view = view;
    }

    public void toExist() {
        if (view == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
