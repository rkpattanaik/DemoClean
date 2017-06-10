package com.rkpattanaik.democlean.common.base;

import rx.Observable;
import rx.Subscriber;

/**
 * Interactors are the execution units of the system and they represent the use cases.
 * This interface will be used to abstract concrete use cases from the executor logic.
 *
 * @author Rajesh Pattanaik
 */

public interface Interactor<T> {

    void execute(Subscriber<T> subscriber);

    Observable<T> execute();

}
