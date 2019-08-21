package aplikasi.alfibaihaqi;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DaftarNiatSholatService {
    @GET ("/bluohazard/doa-harian-muslim-server/dzikir_pagi")
    Call<List<DaftarNiatSholat>> getNiatSholat();
}
