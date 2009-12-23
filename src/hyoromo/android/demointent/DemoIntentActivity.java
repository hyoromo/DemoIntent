package hyoromo.android.demointent;

import hyoromo.android.demointent.image.ImageIntentActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Intentをテスト的に使う。
 * 
 * @author hyoromo
 */
public class DemoIntentActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickMainBtnImg(View v) {
        Intent intent = new Intent(this, ImageIntentActivity.class);
        startActivity(intent);
    }
}