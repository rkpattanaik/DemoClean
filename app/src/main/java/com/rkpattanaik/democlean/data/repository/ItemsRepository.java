package com.rkpattanaik.democlean.data.repository;

import java.util.List;

import rx.Observable;

/**
 * This is the repository for items.
 * All the CRUD operations for Item data are handled here.
 * This interface is the boundary between the domain layer and the data layer.
 *
 *
 * @author Rajesh Pattanaik
 */

public interface ItemsRepository {
    Observable<List<com.rkpattanaik.democlean.data.model.Item>> getAll(int fileNo);
}
