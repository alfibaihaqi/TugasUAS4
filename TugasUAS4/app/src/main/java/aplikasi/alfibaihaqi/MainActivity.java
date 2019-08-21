package aplikasi.alfibaihaqi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import aplikasi.alfibaihaqi.Halal;
import aplikasi.alfibaihaqi.MainMenuActivity;
import aplikasi.alfibaihaqi.R;
import aplikasi.alfibaihaqi.Sholat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Tugas UAS");

        findViewById(R.id.jadwalsholat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sholat.class));
            }
        });

        findViewById(R.id.produkhalal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Halal.class));
            }
        });

        findViewById(R.id.doaharian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
            }
        });
    }
}
