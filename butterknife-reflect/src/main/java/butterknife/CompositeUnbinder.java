package butterknife;

import android.support.annotation.Nullable;
import java.util.List;

final class CompositeUnbinder implements Unbinder {
  private @Nullable List<Unbinder> unbinders;

  @SuppressWarnings("NullableProblems") // We do not allow null as an argument value.
  CompositeUnbinder(List<Unbinder> unbinders) {
    this.unbinders = unbinders;
  }

  @Override public void unbind() {
    if (unbinders == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    for (Unbinder unbinder : unbinders) {
      unbinder.unbind();
    }
    unbinders = null;
  }
}
