package com.olu.recyclerview.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olu.recyclerview.R;
import com.olu.recyclerview.model.Cat;
import com.olu.recyclerview.util.DeviceUtils;
import com.olu.recyclerview.widget.CatsRecyclerAdapter;
import com.olu.recyclerview.widget.PreCachingLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovidiu.latcu on 12/4/2014.
 */
public class CatsListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cats_recycler_view);

        //Setup adapter
        List<Cat> cats = new ArrayList<Cat>();
        String[] catsUrls = getResources().getStringArray(R.array.cat_pics);
        for (int i = 0; i < catsUrls.length; i++) {
            cats.add(new Cat(catsUrls[i], "Cat at position " + i));
        }
        CatsRecyclerAdapter adapter = new CatsRecyclerAdapter(getActivity(), cats);

        //Setup layout manager
        PreCachingLayoutManager layoutManager = new PreCachingLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setExtraLayoutSpace(DeviceUtils.getScreenHeight(getActivity()));

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
