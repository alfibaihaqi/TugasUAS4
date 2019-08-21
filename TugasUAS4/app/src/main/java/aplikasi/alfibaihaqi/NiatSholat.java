package aplikasi.alfibaihaqi;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NiatSholat extends AppCompatActivity implements DaftarDzikirPagiAdapter.OnDaftarClickListener {
    public RecyclerView recyclerView;
    public NiatSholatAdapter niatSholatAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<DaftarNiatSholat> listDaftarNiatSholat = new ArrayList<>();
    public DaftarNiatSholatService daftarNiatSholatService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niat_sholat);
        getSupportActionBar().setTitle("Niat Sholat");

        recyclerView = findViewById(R.id.recyclerview);

        daftarNiatSholatService = ServiceGenerator.createService(DaftarNiatSholatService.class);
        Call<List<DaftarNiatSholat>> daftarNiatSholatCall = daftarNiatSholatService.getNiatSholat();

        daftarNiatSholatCall.enqueue(new Callback<List<DaftarNiatSholat>>() {

            @Override
            public void onResponse(Call<List<DaftarNiatSholat>> call, Response<List<DaftarNiatSholat>> response) {
                listDaftarNiatSholat = response.body();
                niatSholatAdapter = new NiatSholatAdapter(listDaftarNiatSholat);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setAdapter(niatSholatAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<DaftarNiatSholat>> call, Throwable t) {
                Snackbar.make(recyclerView,"aduh!", Snackbar.LENGTH_SHORT).show();
            }
        });

        // Niat Sholat Shubuh
        listDaftarNiatSholat.add(new DaftarNiatSholat(
                "Niat Sholat Shubuh ",
                "( Di Baca Sebelum Takbir )",
                "اُصَلّى فَرْضَ الصُّبْحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ اَدَاءً مَأْمُوْمًا ِللهِ تَعَالَى ",
                "“USHOLLII FARDHOSH SHUBHI ROK'ATAINI MUSTAQBILAL QIBLATI ADAA-AN MA'MUUMAN LILLAAHI TA'AALA.”"));

        // Niat Sholat Dzuhur
        listDaftarNiatSholat.add(new DaftarNiatSholat(
                "Niat Sholat Dzuhur",
                "( Dibaca Sebelum Takbir )",
                "اُصَلّى فَرْضَ الظُّهْرِاَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ اَدَاءً مَأْمُوْمًا ِللهِ تَعَالَى\n" +
                        "\n" + "",
                "“USHOLLII FARDHODL DHUHRI ARBA'A RAKA'AATIM MUSTAQBILAL QIBLATI ADAA-AN MA'MUUMAN LILLAAHI TA'AALA.“"));

        // Niat Sholat Ashar
        listDaftarNiatSholat.add(new DaftarNiatSholat(
                "Niat Sholat Ashar",
                "( Dibaca Sebelum Takbir )",
                "اُصَلِّى فَرْضَ الْعَصْرِاَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ اَدَاءً مَأْمُوْمًا ِللهِ تَعَالَى\n" +
                        "\n" + "",
                "“Usholli fardhol 'ashri arba'a raka'aatim mustaqbilal qiblati adaa'an ma'muumal lillaahi ta'aala.“"));

        // Niat Sholat Maghrib
        listDaftarNiatSholat.add(new DaftarNiatSholat(
                "Niat Sholat Maghrib ",
                "( Di Baca Sebelum Takbir )",
                "اُصَلِّى فَرْضَ الْمَغْرِبِ ثَلاَثَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ اَدَاءً مَأْمُوْمًا ِللهِ تَعَالَى\n" +
                        "\n" + "",
                "“Usholli fardhol maghribi tsalaatsa raka'aatim mustaqbilal qiblati adaa'an ma'muumal lillaahi ta'aala.“"));

        // Niat Sholat Isya
        listDaftarNiatSholat.add(new DaftarNiatSholat(
                "Niat Sholat Isya ",
                "( Di Baca Sebelum Takbir )",
                "اُصَلِّى فَرْضَ الْعِشَاءِ اَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ اَدَاءً مَأْمُوْمًا ِللهِ تَعَالَى\n" +
                        "\n" +"",
                "“Usholli fardhol 'isyaa'i arba'a raka'aatim mustaqbilal qiblati adaa'an ma'muumal lillaahi ta'aala.“"));
    }

    @Override
    public void onClick(View view, int position) {
        DaftarNiatSholat daftarNiatSholat = listDaftarNiatSholat.get(position);
        Toast.makeText(this, daftarNiatSholat.getTittle(),Toast.LENGTH_LONG)
                .show();

    }
}
