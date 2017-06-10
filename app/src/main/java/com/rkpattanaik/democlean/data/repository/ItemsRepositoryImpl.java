package com.rkpattanaik.democlean.data.repository;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rkpattanaik.democlean.data.model.Item;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * This is the actual implementation of {@link ItemsRepository}.
 * This class provides {@link Item} data to the domain layer
 *
 * @author Rajesh Pattanaik
 */

public class ItemsRepositoryImpl implements ItemsRepository {
    private Context mContext;
    private Gson mGson;

    @Inject
    public ItemsRepositoryImpl(Context context, Gson gson) {
        mContext = context;
        mGson = gson;
    }

    @Override
    public Observable<List<Item>> getAll(int fileNo) {
        String fileName = "dummy_json" + fileNo + ".json";
        return Observable.just(getItemsFromJson(fileName));
    }

    private List<Item> getItemsFromJson(String jsonFileName) {
        String json;
        List<Item> items = new ArrayList<>();

        try {
            InputStream is = mContext.getAssets().open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Type type = new TypeToken<List<Item>>(){}.getType();
        items.addAll(mGson.fromJson(json, type));
        return items;
    }
}
