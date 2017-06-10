package com.rkpattanaik.democlean.home.domain;

import com.rkpattanaik.democlean.common.base.UseCase;
import com.rkpattanaik.democlean.common.executor.ExecutorThread;
import com.rkpattanaik.democlean.common.executor.PostExecutionThread;
import com.rkpattanaik.democlean.data.model.Item;
import com.rkpattanaik.democlean.data.repository.ItemsRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;


/**
 * @author Rajesh Pattanaik
 */

public class GetItemsUseCase extends UseCase<List<Item>> {
    private int currentJsonFile;
    private ItemsRepository itemsRepository;

    @Inject
    public GetItemsUseCase(ExecutorThread executorThread,
                           PostExecutionThread postExecutionThread,
                           ItemsRepository itemsRepository) {
        super(executorThread, postExecutionThread);
        this.itemsRepository = itemsRepository;
    }

    @Override
    public Observable<List<Item>> createObservable() {
        return itemsRepository.getAll(currentJsonFile);
    }

    public void setCurrentJsonFile(int currentJsonFile) {
        this.currentJsonFile = currentJsonFile;
    }
}
