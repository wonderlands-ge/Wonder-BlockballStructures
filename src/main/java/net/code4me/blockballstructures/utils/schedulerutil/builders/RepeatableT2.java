package net.code4me.blockballstructures.utils.schedulerutil.builders;

import lombok.Getter;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleBuilderBase;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleData;

public class RepeatableT2 implements ScheduleBuilderBase {

    @Getter
    private final ScheduleData data;

    RepeatableT2(ScheduleData data) {
        this.data = data;
    }

    public RepeatableBuilder run(Runnable runnable) {
        data.setRunnable(runnable);
        return new RepeatableBuilder(data);
    }
}
