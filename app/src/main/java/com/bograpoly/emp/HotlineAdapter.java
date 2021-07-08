package com.bograpoly.emp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;


public class HotlineAdapter extends RecyclerView.Adapter<HotlineAdapter.MyViewHolder> {

    private List<Hotline> mDataset;
    private Activity mActivity;

    public HotlineAdapter(List<Hotline> hotlineList, FragmentActivity activity) {
        mDataset = hotlineList;
        mActivity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_hotline_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Hotline hotline = mDataset.get(position);
        holder.mTextTitle.setText("" + hotline.getTitleEn());
        holder.mTextDescriotion.setText("" + hotline.getDescriptionEn());

        if (position == 0) {
            Glide.with(holder.imageViewThumb.getContext()) // get context of Fragment
                    .load(R.drawable.aman)
                    .into(holder.imageViewThumb);
        } else if (position == 1) {
            Glide.with(holder.imageViewThumb.getContext()) // get context of Fragment
                    .load(R.drawable.ali)
                    .into(holder.imageViewThumb);
        } else if (position == 2) {
            Glide.with(holder.imageViewThumb.getContext()) // get context of Fragment
                    .load(R.drawable.reza)
                    .into(holder.imageViewThumb);
        } else if (position == 3) {
            Glide.with(holder.imageViewThumb.getContext()) // get context of Fragment
                    .load(R.drawable.mou)
                    .into(holder.imageViewThumb);
        }

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.linearLayout.getVisibility() == View.GONE) {
                    holder.linearLayout.setVisibility(View.VISIBLE);
                } else {
                    holder.linearLayout.setVisibility(View.GONE);
                }
            }
        });
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber(holder, hotline);
            }
        });
        holder.sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms(holder, hotline);
            }
        });
    }

    private void dialNumber(MyViewHolder holder, Hotline hotline) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(holder.mCardView.getContext());
        builder1.setMessage("Do you want to call this number");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + hotline.getNumberEn()));
                        holder.mCardView.getContext().startActivity(intent);

                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void sendSms(MyViewHolder holder, Hotline hotline) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(holder.mCardView.getContext());
        builder1.setMessage("Do you want to send SMS to this number");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("smsto:" + hotline.getNumberEn())); // This ensures only SMS apps respond
                        intent.putExtra("sms_body", "message");
                        holder.mCardView.getContext().startActivity(intent);


                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextTitle, mTextNumber, mTextDescriotion, mTextDescriotion2;
        public ImageView mImageView, imageViewThumb;
        public CardView mCardView;
        public LinearLayout linearLayout;
        public Button phone, sms;

        public MyViewHolder(View view) {
            super(view);
            mCardView = view.findViewById(R.id.cardview_content_title_list);
            mTextTitle = view.findViewById(R.id.txt_title);
            mTextDescriotion = view.findViewById(R.id.txt_description);
            imageViewThumb = view.findViewById(R.id.imageViewThumb);
            linearLayout = view.findViewById(R.id.layout_hidden);
            phone = view.findViewById(R.id.button);
            sms = view.findViewById(R.id.button2);
        }

    }

}
