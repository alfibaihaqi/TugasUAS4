package aplikasi.alfibaihaqi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportActionBar().setTitle("Lainnya");
    }

    public void clickDzikirPagi(View view) {
        Intent i = new Intent(MainMenuActivity.this, DzikirPagiActivity.class);
        startActivity(i);
    }

    public void clickNiatSholat(View view) {
        Intent i = new Intent(MainMenuActivity.this, NiatSholat.class);
        startActivity(i);
    }

    public  void clickAyatQuran (View view){
        Intent i = new Intent(MainMenuActivity.this, AyataQuran.class);
        startActivity(i);
    }
}

