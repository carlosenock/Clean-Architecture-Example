package cleancore.dev.cenock.com.core.di.component;

import android.app.Activity;

/**
 * Created by carlosenock on 2/25/18.
 */

public interface ActivityComponent <T extends Activity>{
    /**
     * Indica que T requiere inyección desde este componente
     * @param target T
     */
    void inject(T target);
}
