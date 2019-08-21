package aplikasi.alfibaihaqi;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AyataQuran extends AppCompatActivity {
    private ListAyatAdapter mAdapter;
    private ArrayList<Ayat> mListAyat;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayata_quran);

        getSupportActionBar().setTitle("Surat Alquran");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        mListAyat = new ArrayList<Ayat>();
        mAdapter = new ListAyatAdapter(mListAyat);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                mLayoutManager.getOrientation()));
        recyclerView.setAdapter(mAdapter);
        loadData();
    }
    private void loadData(){
        try {
            String url = "/surat";
            ClientAsyncTask1 task = new ClientAsyncTask1(this, url, new ClientAsyncTask1.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(String result) {
                            Log.d("Ayat Al-Quran", result);
                            try {
                                JSONObject jsonObject = new JSONObject(result);
                                JSONArray jsonArray = jsonObject.getJSONArray("hasil");

                                for (int i = 0; i < jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    Ayat ayat = new Ayat();
                                    ayat.nomor = object.getString("nomor");
                                    ayat.nama = object.getString("nama");
                                    ayat.asma = object.getString("asma");
                                    ayat.name = object.getString("name");
                                    ayat.start = object.getString("start");
                                    ayat.ayat = object.getString("ayat");
                                    ayat.type = object.getString("type");
                                    ayat.urut = object.getString("urut");
                                    ayat.rukuk = object.getString("rukuk");
                                    ayat.arti = object.getString("arti");
                                    mListAyat.add(ayat);
                                }
                                mAdapter.notifyDataSetChanged();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            task.setmProgress(this.progressBar);
            task.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
