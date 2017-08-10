package id.co.pln.plnweeeeew.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.pln.plnweeeeew.R;
import id.co.pln.plnweeeeew.model.Plnweeeeew;


/**
 * Created by ahm on 27/05/17.
 */

public class PlnweeeeewAdapter extends RecyclerView.Adapter<PlnweeeeewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Plnweeeeew> unitList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nomor_sertifikat, tv_judul_sertifikat;

        public MyViewHolder(View view) {
            super(view);
            tv_judul_sertifikat = (TextView) view.findViewById(R.id.tv_judul_sertifikat);
            tv_nomor_sertifikat = (TextView) view.findViewById(R.id.tv_nomor_sertifikat);


        }
    }


    public PlnweeeeewAdapter(Context mContext, List<Plnweeeeew> unitListP) {
        this.mContext = mContext;
        this.unitList = unitListP;
    }

    @Override
    public PlnweeeeewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_unit, parent, false);

        return new PlnweeeeewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PlnweeeeewAdapter.MyViewHolder holder, final int position) {
        final Plnweeeeew plnweeeeew  = unitList.get(position);

        holder.tv_judul_sertifikat.setText(plnweeeeew.getJudulsertifikat());
        holder.tv_nomor_sertifikat.setText(plnweeeeew.getNosertifikat());
    }


    @Override
    public int getItemCount() {
        return unitList.size();
    }
}
