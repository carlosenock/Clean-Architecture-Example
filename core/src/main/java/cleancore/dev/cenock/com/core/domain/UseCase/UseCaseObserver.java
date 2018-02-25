package cleancore.dev.cenock.com.core.domain.UseCase;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by carlosenock on 2/25/18.
 */

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {
    @Override public void onNext(T value) {}
    @Override public void onError(Throwable e) {}
    @Override public void onComplete() {}
}
