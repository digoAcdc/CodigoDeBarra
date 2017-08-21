package br.com.barbosa.rodrigo.codigodebarra.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.barbosa.rodrigo.codigodebarra.R;
import br.com.barbosa.rodrigo.codigodebarra.model.Scanners;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodrigobarbosa on 21/08/17.
 */

public class ListScannerAdapter extends RecyclerView.Adapter<ListScannerAdapter.ScannerViewHolder> {

    public interface ScannerOnClickListener {
        public void OnClickScanner(View view, int index);

    }

    private List<Scanners> lst;
    private Context context;
    private final ScannerOnClickListener onClickListener;

    public ListScannerAdapter(Context context, ScannerOnClickListener onClickListener) {
        this.context = context;
        lst = new ArrayList<>();
        this.onClickListener = onClickListener;

    }



    public void addAll(List<Scanners> mLst){
        this.lst.addAll(mLst);
        notifyDataSetChanged();
    }

    @Override
    public ScannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_option_search, parent, false);
        ScannerViewHolder holder = new ScannerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ScannerViewHolder holder, final int position) {
        Scanners s = lst.get(position);

        holder.tvId.setText(String.valueOf(s.getId()));
        holder.tvTitulo.setText(s.getTitulo());


        if (onClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.OnClickScanner(holder.view, position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public class ScannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;

        @BindView(R.id.tvId)
        TextView tvId;

        @BindView(R.id.imvLogo)
        ImageView imvLogo;

        private View view;

        ScannerViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
