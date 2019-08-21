package aplikasi.alfibaihaqi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NiatSholatAdapter extends RecyclerView.Adapter<NiatSholatAdapter.NiatViewHolder> {
    private List<DaftarNiatSholat> listDaftarNiatSholat = new ArrayList<>();

    public NiatSholatAdapter(List<DaftarNiatSholat>listDaftarNiatSholat){
        this.listDaftarNiatSholat=listDaftarNiatSholat;
    }
    private OnDaftarClickListener listener;
    public interface OnDaftarClickListener{
        void onClick(View view, int position);
    }
    public void setListener(OnDaftarClickListener listener) {this.listener = listener;}
    @NonNull
    @Override
    public NiatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup,false);
        NiatViewHolder viewHolder = new NiatViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NiatSholatAdapter.NiatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listDaftarNiatSholat.size();
    }

    public class NiatViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTittle, txtInstruction, txtArabdesc, txtLatinDesc;
        public NiatViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTittle = itemView.findViewById(R.id.txtTitle);
            txtInstruction = itemView.findViewById(R.id.txtInstruction);
            txtArabdesc = itemView.findViewById(R.id.txtArabDesc);
            txtLatinDesc = itemView.findViewById(R.id.txtLatinDesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v,getAdapterPosition());
                }
            });
        }
    }
}
