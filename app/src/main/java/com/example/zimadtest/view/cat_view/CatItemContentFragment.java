package com.example.zimadtest.view.cat_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimadtest.R;

public class CatItemContentFragment extends Fragment {
    private ImageView catItemImage;
    private TextView catItemInfo;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cat_item_content, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        catItemImage = v.findViewById(R.id.cat_item_image);
        catItemInfo = v.findViewById(R.id.cat_item_number);
    }
}
