package cleancore.dev.cenock.com.core.di.component;

import android.support.v4.app.Fragment;

/**
 * Created by carlosenock on 2/25/18.
 */

public interface FragmentComponent <T extends Fragment>{
    /**
     * Indica que T requiere inyección desde este componente
     * @param target T
     */
    void inject(T target);
}
