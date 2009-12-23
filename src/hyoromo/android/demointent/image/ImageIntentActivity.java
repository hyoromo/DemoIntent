package hyoromo.android.demointent.image;

import hyoromo.android.demointent.Log;
import hyoromo.android.demointent.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Intentを使って画像選択画面を表示させる
 * 
 * @author hyoromo
 */
public class ImageIntentActivity extends Activity {
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

    /**
     * 画像選択画面から戻ってきた時に呼ばれ、選択された画像を画面に表示させる
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // 画像選択画面で何かが選択されて戻ってきた
            Log.v("ImageIntentActivity:RESULT_OK");
            if (requestCode == REQUEST_PICTURE && data != null) {
                // 画像が選択され、データが正常に受け渡された
                ImageView img = (ImageView) findViewById(R.id.image_img);
                img.setImageURI(data.getData());
            }
        } else if (resultCode == RESULT_CANCELED) {
            // 画像選択画面で[戻る]ボタンが押されて戻ってきた
            Log.v("ImageIntentActivity:RESULT_CANCELED");
            finish();
        }
    }
}
