package hyoromo.android.demointent.telephone;

import hyoromo.android.demointent.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TelephoneIntentActivity extends Activity {
    static final int REQUEST_PICTURE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_intent);

        intent();
    }

    /**
     * intentを投げて画像選択するActivityに遷移する
     */
    private void intent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "getpicture"), REQUEST_PICTURE);
    }

}
